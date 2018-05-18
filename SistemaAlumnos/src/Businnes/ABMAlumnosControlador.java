package Businnes;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import Dao.AlumnoDao;
import Dao.CarreraDao;
import Dao.InscripcionCarreraDao;
import Dao.InscripcionCursoDao;
import Dao.PersonaDao;
import Entities.Alumno;
import Entities.Carrera;
import Entities.InscripcionCarrera;
import Entities.InscripcionCurso;

public class ABMAlumnosControlador {
	private AlumnoDao aDao;
	private CarreraDao cDao;
	private PersonaDao pDao;
	private InscripcionCarreraDao icDao;
	private InscripcionCursoDao icuDao;
	private Collection<Alumno> coleccionAlumnos;
	public ABMAlumnosControlador() {
		aDao=new AlumnoDao();
		cDao=new CarreraDao();
		pDao=new PersonaDao();
		icDao=new InscripcionCarreraDao();
		icuDao=new InscripcionCursoDao();
		coleccionAlumnos=aDao.getAll().values();
	}
	
	public Collection<Carrera> listaCarreras(){
		HashMap<Integer,Carrera> tabla=cDao.getAll();
		return tabla.values();
	}
	
	public Collection<Alumno> listaAlumnos(){
		HashMap<Integer,Alumno> tabla=aDao.getAll();
		return tabla.values();
	}
	
	public boolean comprobarExistenciaAlumno(Alumno al) {
		return coleccionAlumnos.stream().filter(a->a.equals(al)).findFirst().isPresent();
	}
	
	public Alumno buscarAlumno(Alumno al) {
		return coleccionAlumnos.stream().filter(a->a.equals(al)).findFirst().get();
	}
	
	public int insertarAlumno(Alumno al,InscripcionCarrera inscar) {
		if(comprobarExistenciaAlumno(al)) {
			return -2;
		}
		if(al.getLegajo()==-1 || al.getPers().getNombre() == "" || al.getPers().getApellido()=="" || al.getPers().getFechaNac()==new Date()) {
			return -3;
		}
		int pE=pDao.insert(al.getPers());
		if(pE==-1) {
			return pE;
		}

		Alumno[] alArray=coleccionAlumnos.toArray(new Alumno[coleccionAlumnos.size()]);
		al.setIdentificador(alArray[alArray.length-1].getIdentificador());
		 
		int aE=aDao.insert(al);
		if(aE==-1) {
			return aE;
		}
		return icDao.insert(inscar);
	}
	
	public int modificarAlumno(Alumno al) {
		if(al.getLegajo()==-1 || al.getPers().getNombre() == "" || al.getPers().getApellido()=="" || al.getPers().getFechaNac()==new Date()) {
			return -3;
		}
		int pE=pDao.modify(al.getPers());
		if(pE==-1) {
			return pE;
		}
		return aDao.modify(al);
	}
	
	public int eliminarAlumno(Alumno al,InscripcionCarrera inscar,InscripcionCurso inscur) {
		int icE=icDao.delete(inscar);
		if(icE==-1) {
			return icE;
		}
		int icuE=icuDao.delete(inscur);
		if(icuE==-1) {
			return icuE;
		}
		int iaE=aDao.delete(al);
		if(iaE==-1) {
			return iaE;
		}
		return pDao.delete(al.getPers());
	}
}

package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;

import Entities.Alumno;
import Entities.Carrera;
import Entities.Curso;
import Entities.InscripcionCarrera;
import Entities.InscripcionCurso;

public class InscripcionCursoDao extends DaoBase<InscripcionCurso> {

	public InscripcionCursoDao() {
		super("BaseAlumnos","postgresql","5432","localhost","postgres","413616Ra","org.postgresql.Driver");
	}

@Override
public HashMap<Integer, InscripcionCurso> getAll() {
	try {
		Connection con=this.getConnection();
		Statement stateInscripcionCarrera=con.createStatement();
		ResultSet res=stateInscripcionCarrera.executeQuery("SELECT * FROM inscripciones_curso");
		HashMap<Integer,InscripcionCurso> tabla=new HashMap<Integer,InscripcionCurso>();
		int i=1;
		while(res.next()) {
			AlumnoDao alumn=new AlumnoDao();
			Alumno al=new Alumno();
			al.setIdentificador(res.getInt("idalumno"));
			al=alumn.getOne(al);
			CursoDao carDao=new CursoDao();
			Curso car=new Curso();
			car.setIdentificador(res.getInt("idcurso"));
			car=carDao.getOne(car);
			InscripcionCurso inscar=new InscripcionCurso();
			inscar.setFechaInscripcion(res.getDate("fechainscripcion"));
			inscar.setAlumno(al);
			inscar.setCurso(car);
			inscar.setNotaFinal(res.getDouble("notafinal"));
			tabla.put(i, inscar);
			i++;
		}
		return tabla;
	} catch (ClassNotFoundException | SQLException e) {
		return null;
	}
}

@Override
public int delete(InscripcionCurso aEliminar) {
	try {
		Connection con=this.getConnection();
		PreparedStatement stateElimina=con.prepareStatement("delete from inscripciones_curso where idalumno = ? and idcurso = ? and fechainscripcion = ?");
		stateElimina.setInt(1, aEliminar.getAlumno().getIdentificador());
		stateElimina.setInt(2, aEliminar.getCurso().getIdentificador());
		LocalDate lDate= LocalDate.of(aEliminar.getFechaInscripcion().getYear(), aEliminar.getFechaInscripcion().getMonth(), aEliminar.getFechaInscripcion().getDay());
		stateElimina.setDate(3, java.sql.Date.valueOf(lDate));
		stateElimina.executeUpdate();
		con.close();
		return 1;
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		return -1;
	}
}

@Override
public InscripcionCurso getOne(InscripcionCurso params) {
	try {
		Connection con=this.getConnection();
		PreparedStatement stateInscripcionCarrera=con.prepareStatement("SELECT * FROM inscripciones_curso where idalumno = ? and idcurso = ? and fechaInscripcion = ?");
		stateInscripcionCarrera.setInt(1, params.getAlumno().getIdentificador());
		stateInscripcionCarrera.setInt(2, params.getCurso().getIdentificador());
		LocalDate lDate= LocalDate.of(params.getFechaInscripcion().getYear(), params.getFechaInscripcion().getMonth(), params.getFechaInscripcion().getDay());

		stateInscripcionCarrera.setDate(3, Date.valueOf(lDate));
		ResultSet res=stateInscripcionCarrera.executeQuery();

		InscripcionCurso inscar=new InscripcionCurso();
		if(res.next()) {
			AlumnoDao alumn=new AlumnoDao();
			Alumno al=new Alumno();
			al.setIdentificador(res.getInt("idalumno"));
			al=alumn.getOne(al);
			CursoDao carDao=new CursoDao();
			Curso car=new Curso();
			car.setIdentificador(res.getInt("idcurso"));
			car=carDao.getOne(car);
			inscar.setFechaInscripcion(res.getDate("fechainscripcion"));
			inscar.setAlumno(al);
			inscar.setCurso(car);
			inscar.setNotaFinal(res.getDouble("notafinal"));
		}
		return inscar;
	} catch (ClassNotFoundException | SQLException e) {
		return null;
	}
}

@Override
public int modify(InscripcionCurso params) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public int insert(InscripcionCurso params) {
	// TODO Auto-generated method stub
	return 0;
}

}

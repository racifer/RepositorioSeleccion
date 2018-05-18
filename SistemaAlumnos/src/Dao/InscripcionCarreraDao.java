package Dao;

import Entities.Persona;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Hashtable;

import Entities.Alumno;
import Entities.Carrera;
import Entities.InscripcionCarrera;

public class InscripcionCarreraDao extends DaoBase<InscripcionCarrera> {

	public InscripcionCarreraDao() {
		super("BaseAlumnos","postgresql","5432","localhost","postgres","413616Ra","org.postgresql.Driver");
	}
	@Override
	public HashMap<Integer, InscripcionCarrera> getAll() {
		try {
			Connection con=this.getConnection();
			Statement stateInscripcionCarrera=con.createStatement();
			ResultSet res=stateInscripcionCarrera.executeQuery("SELECT * FROM inscripciones_carrera");
			HashMap<Integer,InscripcionCarrera> tabla=new HashMap<Integer,InscripcionCarrera>();
			int i=1;
			while(res.next()) {
				AlumnoDao alumn=new AlumnoDao();
				Alumno al=new Alumno();
				al.setIdentificador(res.getInt("idalumno"));
				al=alumn.getOne(al);
				CarreraDao carDao=new CarreraDao();
				Carrera car=new Carrera();
				car.setIdentificador(res.getInt("idcarrera"));
				car=carDao.getOne(car);
				InscripcionCarrera inscar=new InscripcionCarrera();
				inscar.setFechaInscripcion(res.getDate("fechainscripcion"));
				inscar.setAlumno(al);
				inscar.setCarrera(car);
				tabla.put(i, inscar);
				i++;
			}
			return tabla;
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	@Override
	public int delete(InscripcionCarrera aEliminar) {
		try {
			Connection con=this.getConnection();
			PreparedStatement stateElimina=con.prepareStatement("delete from inscripciones_carrera where idalumno = ? and idcarrera = ? and fechainscripcion = ?");
			stateElimina.setInt(1, aEliminar.getAlumno().getIdentificador());
			stateElimina.setInt(2, aEliminar.getCarrera().getIdentificador());
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
	public InscripcionCarrera getOne(InscripcionCarrera params) {
		try {
			Connection con=this.getConnection();
			PreparedStatement stateInscripcionCarrera=con.prepareStatement("SELECT * FROM inscripciones_carrera where idalumno = ? and idcarrera = ? and fechainscripcion = ?");
			stateInscripcionCarrera.setInt(1, params.getAlumno().getIdentificador());
			stateInscripcionCarrera.setInt(2, params.getCarrera().getIdentificador());
			LocalDate lDate= LocalDate.of(params.getFechaInscripcion().getYear(), params.getFechaInscripcion().getMonth(), params.getFechaInscripcion().getDay());
			stateInscripcionCarrera.setDate(3, Date.valueOf(lDate));
			ResultSet res=stateInscripcionCarrera.executeQuery();
			
			InscripcionCarrera inscar=new InscripcionCarrera();
			if(res.next()) {
				AlumnoDao alumn=new AlumnoDao();
				Alumno al=new Alumno();
				al.setIdentificador(res.getInt("idalumno"));
				al=alumn.getOne(al);
				CarreraDao carDao=new CarreraDao();
				Carrera car=new Carrera();
				car.setIdentificador(res.getInt("idcarrera"));
				car=carDao.getOne(car);
				inscar.setFechaInscripcion(res.getDate("fechainscripcion"));
				inscar.setAlumno(al);
				inscar.setCarrera(car);
			}
			return inscar;
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	@Override
	public int modify(InscripcionCarrera params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(InscripcionCarrera params) {
		try {
			Connection con=this.getConnection();
			PreparedStatement stateActualiza=con.prepareStatement("insert into inscripciones_carrera (idalumno,idcarrera,fechainscripcion) values (?,?,?)");
			stateActualiza.setInt(1, params.getAlumno().getIdentificador());
			stateActualiza.setInt(2, params.getCarrera().getIdentificador());
			LocalDate lDate= LocalDate.of(params.getFechaInscripcion().getYear(), params.getFechaInscripcion().getMonth(), params.getFechaInscripcion().getDay());
			
			stateActualiza.setDate(3,Date.valueOf(lDate));
			 int val=stateActualiza.executeUpdate();

			con.close();
			return val;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}


}

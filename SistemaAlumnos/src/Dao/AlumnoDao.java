package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import Entities.Alumno;
import Entities.Persona;

public class AlumnoDao extends DaoBase<Alumno> {

	public AlumnoDao() {
		super("BaseAlumnos","postgresql","5432","localhost","postgres","413616Ra","org.postgresql.Driver");
	}

	@Override
	public HashMap<Integer, Alumno> getAll() {
		try {
			Connection con=this.getConnection();
			Statement stateAlumno=con.createStatement();
			ResultSet resultAlumno=stateAlumno.executeQuery("SELECT * FROM alumno");
			HashMap<Integer,Alumno> tabla=new HashMap<Integer,Alumno>();
			while(resultAlumno.next()) {
				PreparedStatement statePersona=con.prepareStatement("SELECT * FROM persona where identificador = ?");
				statePersona.setInt(1, resultAlumno.getInt("idpersona"));
				ResultSet resultPersonaAlumno=statePersona.executeQuery();
				Persona per=new Persona();
				if(resultPersonaAlumno.next()) {
					per.setNombre(resultPersonaAlumno.getString("nombre"));
					per.setApellido(resultPersonaAlumno.getString("apellido"));
					per.setTipoDocumento(resultPersonaAlumno.getString("tipodoc"));
					per.setDocumento(resultPersonaAlumno.getLong("documento"));
					per.setDireccion(resultPersonaAlumno.getString("direccion"));
					per.setFechaNac(resultPersonaAlumno.getDate("fechanac"));
				}
				Alumno al=new Alumno();
				al.setIdentificador(resultAlumno.getInt("identificador"));
				al.setLegajo(resultAlumno.getInt("legajo"));
				al.setPers(per);
				tabla.put(al.getIdentificador(), al);
			}
			con.close();
			return tabla;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	@Override
	public  int delete(Alumno aEliminar) {
		// TODO Auto-generated method stub
		try {
			Connection con=this.getConnection();
			PreparedStatement stateElimina=con.prepareStatement("delete from alumno where identificador=?");
			stateElimina.setInt(1, aEliminar.getIdentificador());
			stateElimina.executeUpdate();
			con.commit();
			con.close();
			return 1;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	@Override
	public Alumno getOne(Alumno params) {
		try {
			Connection con=this.getConnection();
			PreparedStatement stateAlumno=con.prepareStatement("SELECT * FROM alumno where identificador=? ");
			stateAlumno.setInt(1, params.getIdentificador());
			ResultSet resultAlumno=stateAlumno.executeQuery();
			Alumno al=new Alumno();
			if(resultAlumno.next()) {
				PersonaDao perdao=new PersonaDao();
				Persona per=new Persona();
				per.setIdentificador(resultAlumno.getInt("idpersona"));
				per=perdao.getOne(per);
				al.setIdentificador(resultAlumno.getInt("identificador"));
				al.setLegajo(resultAlumno.getInt("legajo"));
				al.setPers(per);
			}
			con.close();
			return al;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	@Override
	public int modify(Alumno params) {
		try {
			Connection con=this.getConnection();
			PreparedStatement stateActualiza=con.prepareStatement("update alumno  set identificador=?,idpersona=?,legajo=? where identificador=?");
			stateActualiza.setInt(1, params.getIdentificador());
			stateActualiza.setInt(2, params.getPers().getIdentificador());
			stateActualiza.setInt(3,	params.getLegajo());
			stateActualiza.setInt(4, params.getIdentificador());
			 int val=stateActualiza.executeUpdate();

			con.commit();
			con.close();
			return val;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	@Override
	public int insert(Alumno params) {
		try {
			Connection con=this.getConnection();
			PreparedStatement stateActualiza=con.prepareStatement("insert into alumno (identificador,idpersona,legajo) values (?,?,?)");
			stateActualiza.setInt(1, params.getIdentificador());
			stateActualiza.setInt(2, params.getPers().getIdentificador());
			stateActualiza.setInt(3,	params.getLegajo());
			 int val=stateActualiza.executeUpdate();

			con.close();
			return val;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

}

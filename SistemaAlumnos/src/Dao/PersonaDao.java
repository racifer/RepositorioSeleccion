package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import Entities.Persona;

public class PersonaDao extends DaoBase<Persona> {

	public PersonaDao() {
		super("BaseAlumnos","postgresql","5432","localhost","postgres","413616Ra","org.postgresql.Driver");
	}
	@Override
	public HashMap<Integer, Persona> getAll() {
		Connection con;
		try {
			con = this.getConnection();
			Statement statePersona=con.createStatement();
			
			ResultSet resultPersonaAlumno=statePersona.executeQuery("SELECT * FROM persona");
			Persona per=new Persona();
			HashMap<Integer, Persona> tabla=new HashMap<Integer,Persona>();
			while(resultPersonaAlumno.next()) {
				per.setIdentificador(resultPersonaAlumno.getInt("identificador"));
				per.setNombre(resultPersonaAlumno.getString("nombre"));
				per.setApellido(resultPersonaAlumno.getString("apellido"));
				per.setTipoDocumento(resultPersonaAlumno.getString("tipodoc"));
				per.setDocumento(resultPersonaAlumno.getLong("documento"));
				per.setDireccion(resultPersonaAlumno.getString("direccion"));
				per.setFechaNac(resultPersonaAlumno.getDate("fechanac"));
				tabla.put(per.getIdentificador(), per);
			}
			con.close();
			return tabla;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
	}

	@Override
	public int delete(Persona aEliminar) {
		try {
			Connection con=this.getConnection();
			PreparedStatement stateElimina=con.prepareStatement("delete from persona where identificador=?");
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
	public Persona getOne(Persona params) {
		Connection con;
		try {
			con = this.getConnection();
			PreparedStatement statePersona=con.prepareStatement("SELECT * FROM persona where identificador = ?");
			statePersona.setInt(1, params.getIdentificador());
			ResultSet resultPersonaAlumno=statePersona.executeQuery();
			Persona per=new Persona();
			HashMap<Integer, Persona> tabla=new HashMap<Integer,Persona>();
			if(resultPersonaAlumno.next()) {
				per.setIdentificador(resultPersonaAlumno.getInt("identificador"));
				per.setNombre(resultPersonaAlumno.getString("nombre"));
				per.setApellido(resultPersonaAlumno.getString("apellido"));
				per.setTipoDocumento(resultPersonaAlumno.getString("tipodoc"));
				per.setDocumento(resultPersonaAlumno.getLong("documento"));
				per.setDireccion(resultPersonaAlumno.getString("direccion"));
				per.setFechaNac(resultPersonaAlumno.getDate("fechanac"));
				
			}
			con.close();
			return per;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	@Override
	public int modify(Persona params) {
		try {
			Connection con=this.getConnection();
			PreparedStatement stateActualiza=con.prepareStatement("update persona  set identificador=?,tipodoc=?,documento=?,nombre=?,apellido=?,fechanac=?,direccion=? where identificador=?");
			stateActualiza.setInt(1, params.getIdentificador());
			stateActualiza.setString(2, params.getTipoDocumento());
			stateActualiza.setLong(3,	params.getDocumento());			
			stateActualiza.setString(4, params.getNombre());
			stateActualiza.setString(5, params.getApellido());
			stateActualiza.setDate(6, (Date) params.getFechaNac());
			stateActualiza.setInt(7, params.getIdentificador());
			 int val=stateActualiza.executeUpdate();
			con.close();
			return val;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	@Override
	public int insert(Persona params) {
		try {
			Connection con=this.getConnection();
			PreparedStatement stateIngresa=con.prepareStatement("insert into persona (identificador,tipodoc,documento,nombre,apellido,fechanac,direccion) values (?,?,?,?,?,?)");
			stateIngresa.setInt(1, params.getIdentificador());
			stateIngresa.setString(2, params.getTipoDocumento());
			stateIngresa.setLong(3,	params.getDocumento());			
			stateIngresa.setString(4, params.getNombre());
			stateIngresa.setString(5, params.getApellido());
			stateIngresa.setDate(6, (Date) params.getFechaNac());
			 int val=stateIngresa.executeUpdate();
			con.close();
			return val;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	

}

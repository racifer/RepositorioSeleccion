package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import Entities.Carrera;

public class CarreraDao extends DaoBase<Carrera>{
	public CarreraDao() {
		super("BaseAlumnos","postgresql","5432","localhost","postgres","413616Ra","org.postgresql.Driver");
	}
	@Override
	public HashMap<Integer, Carrera> getAll() {
		try {
			Connection con=this.getConnection();
			Statement stateCarr=con.createStatement();
			ResultSet setCarr=stateCarr.executeQuery("SELECT * FROM carrera Order by identificador");
			HashMap<Integer, Carrera> tabla=new HashMap<Integer,Carrera>();
			
			while(setCarr.next()) {
				
				Carrera car=new Carrera();
				car.setIdentificador(setCarr.getInt("identificador"));
				car.setNombre(setCarr.getString("nombre"));
				car.setDescripcion(setCarr.getString("descripcion"));
				car.setFechaDesde(setCarr.getDate("fechadesde"));
				car.setFechaHasta(setCarr.getDate("fechahasta"));
				tabla.put(car.getIdentificador(), car);
			}
			return tabla;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	@Override
	public int delete(Carrera aEliminar) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Carrera getOne(Carrera params) {
		try {
			Connection con=this.getConnection();
			PreparedStatement stateCarr=con.prepareStatement("SELECT * FROM carrera where identificador = ? Order by identificador");
			stateCarr.setInt(1,params.getIdentificador());
			ResultSet setCarr=stateCarr.executeQuery();
			Carrera car=new Carrera();
			
			if(setCarr.next()) {
				
				car.setIdentificador(setCarr.getInt("identificador"));
				car.setNombre(setCarr.getString("nombre"));
				car.setDescripcion(setCarr.getString("descripcion"));
				car.setFechaDesde(setCarr.getDate("fechadesde"));
				car.setFechaHasta(setCarr.getDate("fechahasta"));
			}
			return car;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	@Override
	public int modify(Carrera params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Carrera params) {
		// TODO Auto-generated method stub
		return 0;
	}

}

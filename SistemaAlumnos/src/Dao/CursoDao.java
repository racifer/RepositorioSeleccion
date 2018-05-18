package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import Entities.Alumno;
import Entities.Carrera;
import Entities.Curso;

public class CursoDao extends DaoBase<Curso>{

	public CursoDao() {
		super("BaseAlumnos","postgresql","5432","localhost","postgres","413616Ra","org.postgresql.Driver");
	}

	@Override
	public HashMap<Integer, Curso> getAll() {
		try {
			Connection con=this.getConnection();
			Statement stateCurr=con.createStatement();
			ResultSet setCurr=stateCurr.executeQuery("SELECT * FROM curso Order by identificador");
			HashMap<Integer, Curso> tabla=new HashMap<Integer,Curso>();
			
			while(setCurr.next()) {
				
				Curso cur=new Curso();
				cur.setIdentificador(setCurr.getInt("identificador"));
				cur.setNombre(setCurr.getString("nombre"));
				cur.setDescripcion(setCurr.getString("descripcion"));
				cur.setCupoMaximo(setCurr.getInt("cupomaximo"));
				cur.setAnio(setCurr.getInt("anio"));
				Carrera car=new Carrera();
				CarreraDao cardao=new CarreraDao();
				car.setIdentificador(setCurr.getInt("idalumno"));
				car=cardao.getOne(car);
				cur.setCarrera(car);
				tabla.put(cur.getIdentificador(), cur);
			}
			return tabla;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	@Override
	public int delete(Curso aEliminar) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Curso getOne(Curso params) {
		try {
			Connection con=this.getConnection();
			Statement stateCurr=con.createStatement();
			ResultSet setCurr=stateCurr.executeQuery("SELECT * FROM curso where identificador = ?");
			Curso cur=new Curso();
			
			if(setCurr.next()) {
				
				
				cur.setIdentificador(setCurr.getInt("identificador"));
				cur.setNombre(setCurr.getString("nombre"));
				cur.setDescripcion(setCurr.getString("descripcion"));
				cur.setCupoMaximo(setCurr.getInt("cupomaximo"));
				cur.setAnio(setCurr.getInt("anio"));
				Carrera car=new Carrera();
				CarreraDao cardao=new CarreraDao();
				car.setIdentificador(setCurr.getInt("idAlumno"));
				car=cardao.getOne(car);
				cur.setCarrera(car);
			}
			return cur;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	@Override
	public int modify(Curso params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Curso params) {
		// TODO Auto-generated method stub
		return 0;
	}

}

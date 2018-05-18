package arquitectura.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.HashMap;
public abstract class DaoBase<T> {
	private String database;
	private String port;
	private String dir;
	private Properties props;
	public DaoBase(String database, String port, String dir,Properties props) {
		this.database=database;
		this.port=port;
		this.dir=dir;
		this.props=props;
	}
	public static Connection getConnection(String database,String port,String dir, Properties props) throws SQLException {
		String conString="jdbc:mysql://"+dir+":"+port+"/"+database;
		Connection conn=DriverManager.getConnection(conString,props);
		return conn;
	}
	public abstract HashMap<Integer,T> getAll();
	public abstract int delete(T aEliminar);
	public abstract T getOne(T params);
	public abstract HashMap<Integer,T> modify(T params);
	public abstract HashMap<Integer,T> insert(T params);
	
}

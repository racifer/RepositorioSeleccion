package arquitectura.Dao;

import java.util.HashMap;
import java.util.Properties;

import arquitectura.Entities.UsuarioRol;

public class UsuarioRolCatalogo extends DaoBase<UsuarioRol> {

	public UsuarioRolCatalogo() {
		Properties props;
		super("BaseDeSeguridad","3306","localhost",Properties);
	}

	@Override
	public HashMap<Integer, UsuarioRol> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(UsuarioRol aEliminar) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UsuarioRol getOne(UsuarioRol params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<Integer, UsuarioRol> modify(UsuarioRol params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<Integer, UsuarioRol> insert(UsuarioRol params) {
		// TODO Auto-generated method stub
		return null;
	}

}

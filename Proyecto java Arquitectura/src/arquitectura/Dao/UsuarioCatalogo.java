package arquitectura.Dao;

import java.util.HashMap;

import arquitectura.Entities.Usuario;

public class UsuarioCatalogo extends DaoBase<Usuario> {

	public UsuarioCatalogo() {
		
	}

	@Override
	public HashMap<Integer, Usuario> getAll() {
		return null;
	}

	@Override
	public int delete(Usuario aEliminar) {
		return 0;
	}

	@Override
	public Usuario getOne(Usuario params) {
		return null;
	}

	@Override
	public HashMap<Integer, Usuario> modify(Usuario params) {
		return null;
	}

	@Override
	public HashMap<Integer, Usuario> insert(Usuario params) {
		return null;
	}

}

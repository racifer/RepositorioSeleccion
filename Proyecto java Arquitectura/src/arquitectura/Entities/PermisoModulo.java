package arquitectura.Entities;

import java.util.ArrayList;

public class PermisoModulo {
	private Permiso permiso;
	private ArrayList<Modulo> modulos;
	public Permiso getPermiso() {
		return permiso;
	}
	public void setPermiso(Permiso permiso) {
		this.permiso = permiso;
	}
	public ArrayList<Modulo> getModulos() {
		return modulos;
	}
	public void setModulos(ArrayList<Modulo> modulos) {
		this.modulos = modulos;
	}
	
	
}

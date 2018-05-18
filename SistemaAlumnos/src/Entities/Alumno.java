package Entities;

public class Alumno {
	private Persona pers;
	
	private int legajo;
	private int identificador;
	public Alumno() {
		setIdentificador(-1);
		setLegajo(-1);
		setPers(new Persona());
	}
	public Persona getPers() {
		return pers;
	}
	public void setPers(Persona pers) {
		this.pers = pers;
	}
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	public boolean equals(Alumno al) {
		return al.legajo==getLegajo()&&al.getPers().equals(getPers());
	}
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
}

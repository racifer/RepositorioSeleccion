package Entities;

import java.util.Date;

public class Persona {
	private int identificador;
	private String tipoDocumento;
	private long documento;
	private String nombre;
	private String apellido;
	private Date fechaNac;
	private String direccion;
	public Persona() {
		setIdentificador(-1);
		setApellido("");
		setNombre("");
		setDireccion("");
		setDocumento(-1);
		setFechaNac(new Date());
		setTipoDocumento("");
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public long getDocumento() {
		return documento;
	}
	public void setDocumento(long documento) {
		this.documento = documento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public boolean equals(Persona per) {
		return per.getDocumento()==getDocumento();
	}
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
}

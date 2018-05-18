package Entities;

import java.util.Date;

public class InscripcionCarrera {
	private Carrera carrera;
	private Alumno alumno;
	private Date fechaInscripcion;
	public InscripcionCarrera() {
		setCarrera(new Carrera());
		setAlumno(new Alumno());
		setFechaInscripcion(new Date());
	}
	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}
	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}
	public Carrera getCarrera() {
		return carrera;
	}
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public boolean equals(InscripcionCarrera icar) {
		return icar.getCarrera().equals(getCarrera())&&icar.getAlumno().equals(getAlumno())&&icar.getFechaInscripcion()==getFechaInscripcion();
	}
}

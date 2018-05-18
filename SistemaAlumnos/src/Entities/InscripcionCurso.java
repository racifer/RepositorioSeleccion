package Entities;

import java.util.Date;

public class InscripcionCurso {
	private Curso curso;
	private Alumno alumno;
	private Date fechaInscripcion;
	private Double notaFinal;
	public InscripcionCurso() {
		setAlumno(new Alumno());
		setCurso(new Curso());
		setFechaInscripcion(new Date());
		setNotaFinal((double) -1);
	}
	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}
	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}
	public Double getNotaFinal() {
		return notaFinal;
	}
	public void setNotaFinal(Double notaFinal) {
		this.notaFinal = notaFinal;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public boolean equals(InscripcionCurso icar) {
		return icar.getAlumno().equals(getAlumno())&&icar.getCurso().equals(getCurso());
	}
}

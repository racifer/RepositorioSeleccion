
package ejercicios;
import ejercicios.Persona;
/**
 * A. Crear una clase Alumnno con los siguientes campos
 * (con sus respectivos getters, setters y constructor)
 * 
 * Persona
 * Legajo - Integer
 * 
 *  
 * @author examen
 *
 */
class Alumno{
	private Persona persona;
	
	private int Legajo;
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona pers) {
		this.persona = pers;
	}
	public int getLegajo() {
		return Legajo;
	}
	public void setLegajo(int legajo) {
		Legajo = legajo;
	}
	public Alumno() {
		setPersona(new Persona());
		setLegajo(0);
	}
	public Alumno(Persona pers,int legajo) {
		setPersona(pers);
		setLegajo(legajo);
	}
}

public class Ejercicio3 {

	/**
	 * 
	 */
	public Ejercicio3() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

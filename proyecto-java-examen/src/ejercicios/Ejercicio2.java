package ejercicios;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ejercicios.Enumerables.TIPO_DOC;
import ejercicios.Persona;
/**
 * A. Crear una clase Persona con los siguientes campos
 * (con sus respectivos getters, setters y constructor)
 * 
 * TipoDocumento - enum (dni/libretacivica) 
 * NroDocumento - Integer
 * Nombre - String
 * Apellido - String
 * FechaNacimiento - Date
 * 
 * B. En el método main de la clase "Ejercicio2" crear una nueva instancia
 * de la clase persona y settearle valores reales con tus datos
 * 
 * 
 * C. En el método main de la clase "Ejercicio 2" imprimir los valores en 
 * consola 
 * (crear método main e imprimir valores) 
 *  
 * @author examen
 *
 */
public class Ejercicio2 {

	/**
	 * 
	 */
	public Ejercicio2() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Persona pers=new Persona();
		pers.setApellido("Ubillos");
		pers.setNombre("Raul");
		SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
		Date fechaNacimiento = new Date();
		try {
			fechaNacimiento=formatter.parse("20/11/1995");
		} catch (ParseException e) {
			System.out.println("Ocurrio un error al convertir la fecha de nacimiento");
		}
		pers.setFechaNacimiento(fechaNacimiento);
		pers.setNroDocumento(39342985);
		pers.setTipoDocumento(TIPO_DOC.DNI);
		System.out.println(String.format("Nombre: %1s \nApellido:%2s\nFecha Nacimiento:%3s\nTipo Documento:%4s\nNro Documento:%5d\n",pers.getNombre(),pers.getApellido(),formatter.format(pers.getFechaNacimiento()),pers.getTipoDocumento().toString(),pers.getNroDocumento()));
	}

}

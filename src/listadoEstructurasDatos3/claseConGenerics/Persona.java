package listadoEstructurasDatos3.claseConGenerics;

/**
 * Reproduce  una  clase  con  Generics.  Llámala  ClaseConGenerics.
 * Entrega  su  esqueleto donde:
 * 
 * a. Definas  una variable  de objeto. Ha  de  ser  una  colección  
 * homogénea  (del  tipo parametrizado de la clase)
 * 
 * b. Definas un constructor donde instancies el atributo anterior
 * 
 * c. Definas un método metodo1 cuyo parámetro sea del tipo parametrizado
 * 
 * d. Definas un método metodo2 cuyo valor devuelto se a del tipo parametrizado
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class Persona {
	/**
	 * DNI de la persona
	 */
	private String dni;
	
	/**
	 * Nombre de la persona
	 */
	private String nombre;
	
	/**
	 * Apellidos de la persona
	 */
	private String apellidos;
	
	/**
	 * Edad de la persona
	 */
	private int edad;
	
	Persona(String dni,String nombre,String apellidos,int edad){
		setDni(dni);
		setNombre(nombre);
		setApellidos(apellidos);
		setEdad(edad);
	}

	public String getDni() {
		return dni;
	}

	private void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	private void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	private void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "DNI: " + dni + "\nNombre: " + nombre + "\nApellidos: " + apellidos + "\nEdad: " + edad + "\n";
	}
	
	
}

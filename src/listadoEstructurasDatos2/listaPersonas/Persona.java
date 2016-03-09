package listadoEstructurasDatos2.listaPersonas;

/**
 * Entrega la clase TestListaPersonas que haga lo siguiente:
 *
 * a. Cree una lista (ArrayList) de personas.
 * 
 * ArrayList<Persona> listaPersonas = new ArrayList<Persona>();//Generics
 * b. Añada tres personas a la lista (3 elementos).
 * c. Muestre la lista.(implementa toString() en Persona)
 * d. Elimine el último elemento.
 * e. Muestre la lista.
 * f. Elimine el primer elemento.
 * g. Muestre la lista.
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

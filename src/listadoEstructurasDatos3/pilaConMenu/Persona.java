package listadoEstructurasDatos3.pilaConMenu;

/**
 * Crea una clase genérica Pila (debe de aceptar cualquier tipo de objeto
 * concreto, utiliza generics). Recuerda  que  has  de  evitar  la 
 * interacción  con  el  usuario  dentro  de Pila. Implementa  las  
 * operaciones  básicas  de  una  estructura  de  datos  pila. Una  pila
 * es  una estructura LIFO donde el último elemento en entrar es el primero
 * en salir. Un ejemplo básico  de  pila  es  la  forma  de  almacenamiento 
 * de  procesos  en  la  memoria.  Las operaciones a implementar son:
 * 
 * a. Crear una pila.
 * b.Introducir elemento en la pila (apilar o push)
 * c. Sacar elemento de la pila (extraer o pop)
 * d. Cima de la pila (devuelve el elemento de la cima de la pila o top)
 * 
 * Implementa los métodos necesarios, y recuerda hacer las pruebas precisas
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
	
	public Persona(String dni,String nombre,String apellidos,int edad) throws Exception{
		setDni(dni);
		setNombre(nombre);
		setApellidos(apellidos);
		setEdad(edad);
	}

	public String getDni() {
		return dni;
	}

	private void setDni(String dni) throws DniNoValidoException{
		if(dni.length()!=0)
			this.dni = dni;
		else
			throw new DniNoValidoException("El DNI no es válido.");
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) throws NombreNoValidoException {
		if(nombre.length()!=0)
			this.nombre = nombre;
		else
			throw new NombreNoValidoException("El nombre no es válido.");
	}

	public String getApellidos() {
		return apellidos;
	}

	private void setApellidos(String apellidos) throws ApellidosNoValidosException{
		if(apellidos.length()!=0)
			this.apellidos = apellidos;
		else
			throw new ApellidosNoValidosException("Los apellidos no son válidos");
	}

	public int getEdad() {
		return edad;
	}

	private void setEdad(int edad) throws EdadNoValidaException {
		if(edad>0)
			this.edad = edad;
		else
			throw new EdadNoValidaException("La edad no es válida");
	}

	@Override
	public String toString() {
		return "DNI: " + dni + "\nNombre: " + nombre + "\nApellidos: " + apellidos + "\nEdad: " + edad + "\n";
	}
}


package cuentasYTitulares;
import utiles.RegEx;

/**
 * Programa que gestiona las cuentas de un banco. El programa debe permitir:
 * 
 * - Crear una cuenta
 * - Eliminar una cuenta
 * - Realizar ingresos
 * - Realizar reintegros
 * - Realizar transferencias
 * - Mostrar todas las cuentas
 * - Mostrar todas las cuentas de un cliente
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class Persona {
	/**
	 * Nombre del titular
	 */
	private String nombre;
	
	/**
	 * DNI del titular
	 */
	private String dni;
	
	/**
	 * Dirección del titular
	 */
	private String direccion;
	
	Persona(String dni) throws DniNoValidoException{
		setDni(dni);
	}
	
	/**
	 * Constructor al que se le pasa el nombre, el DNI y la dirección
	 * @param nombre
	 * @param dni
	 * @param direccion
	 * @throws NombreNoValidoException 
	 * @throws DniNoValidoException 
	 */
	Persona(String nombre,String dni,String direccion) throws NombreNoValidoException, DniNoValidoException{
		setNombre(nombre);
		setDni(dni);
		setDireccion(direccion);
	}

	public String getNombre() {
		return nombre;
	}

	/**
	 * Escribe el nombre siempre que éste sea válido
	 * @param nombre
	 * @throws NombreNoValidoException
	 */
	private void setNombre(String nombre) throws NombreNoValidoException {
		if(!RegEx.NOMBRE.comprobar(nombre))
			throw new NombreNoValidoException("Nombre no válido");
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	/**
	 * Escribe el DNI siempre que éste sea válido
	 * @param dni
	 * @throws DniNoValidoException
	 */
	private void setDni(String dni) throws DniNoValidoException {
		if(!RegEx.DNI.comprobar(dni))
			throw new DniNoValidoException("DNI no válido");
		if(!RegEx.DNI.comprobarLetraDni(dni))
			throw new DniNoValidoException("Letra del DNI no válida");
		this.dni=dni;
	}

	public String getDireccion() {
		return direccion;
	}

	private void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return dni+", "+nombre+", "+direccion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}
}

package listadoEstructurasDatos2.lista;

/**
 * Entrega la clase Lista que:
 * 
 * a. Añada al final de la lista
 * b. Inserte un elemento en una determinada posición
 * c. Modifique un elemento reemplazándolo por otro
 * d. Conozca el tamaño de la lista
 * e. Elimine elementos de la lista
 * f. Busque elementos en la lista
 * g. Copie la lista
 *
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class Jugador {
	/**
	 * Nombre del jugador
	 */
	String nombre;
	
	/**
	 * Constructor que recibe como parámetro el nombre del jugador
	 * @param nombre del jugador
	 */
	Jugador(String nombre){
		this.nombre=nombre;
	}

	/**
	 * Lee el nombre del jugador
	 * @return nombre del jugador
	 */
	String getNombre() {
		return nombre;
	}

	/**
	 * Escribe el nombre del jugador
	 * @param nombre del jugador
	 */
	void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve un mensaje y el nombre del jugador
	 */
	@Override
	public String toString() {
		return "Jugador: " + nombre + "\n";
	}
}

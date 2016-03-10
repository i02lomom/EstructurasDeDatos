package listadoEstructurasDatos3.topMusic;

import java.util.ArrayList;

/**
 * Implementa  un  programa  que  gestione  una  lista  de  las  canciones  más 
 * escuchadas. El usuario podrá:
 * 
 * a. Añadir una canción (en una posición) al TopMusic.
 * b. Sacar un elemento del TopMusic.
 * c. Subir un puesto en el TopMusic.
 * d. Bajar un puesto en el TopMusic.
 * e. Mostrar la lista TopMusic.
 * f. Mostrar la canción más escuchada.
 *
 * Sobre la canción se almacenará el título, artista o grupo y año de grabación
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class TopMusic {
	/**
	 * ArrayList
	 */
	private ArrayList<Cancion> lista=null;
	
	/**
	 * Constructor
	 */
	public TopMusic(){
		lista=new ArrayList<Cancion>();
	}
	
	/**
	 * Añade un elemento en la posición
	 * @param elemento que se añadirá
	 * @param posición en la que se añadirá
	 * @throws PosicionNoValidaException 
	 */
	void anadirEnPosicion(Cancion elemento,int posicion) throws PosicionNoValidaException{
		try {
			lista.add(posicion,elemento);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new PosicionNoValidaException("Posición no válida.");
		}
	}
	
	/**
	 * Saca el elemento de la posición indicada
	 * @param posicion
	 * @return elemento
	 * @throws PosicionNoValidaException 
	 */
	Cancion sacarElementoPosicion(int posicion) throws PosicionNoValidaException{
		try {
			return lista.remove(posicion);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new PosicionNoValidaException("Posición no válida.");
		}
	}
	
	/**
	 * Devuelve el taño de la lista
	 * @return
	 */
	int size(){
		return lista.size();
	}
	
	/**
	 * Devuelve el primer elemento
	 * @return elemento
	 * @throws ListaVaciaException 
	 */
	Cancion cabezaLista() throws ListaVaciaException{
		try {
			return lista.get(0);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ListaVaciaException("La lista está vacía.");
		}
	}
	
	/**
	 * Sube un puesto al elemento de la posición indicada, a la vez
	 * que bajamos la posición del elemento que estaba ahí anteriormente
	 * @param posicion
	 * @throws PosicionNoValidaException 
	 */
	void subirPuestoPosicion(int posicion) throws PosicionNoValidaException{
		try {
			Cancion elemento=lista.get(posicion);
			Cancion elementoAntiguo=lista.set(posicion-1, elemento);
			lista.set(posicion,elementoAntiguo);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new PosicionNoValidaException("Posición no válida.");
		}
	}
	
	void bajarPuestoPosicion(int posicion) throws PosicionNoValidaException{
		try {
			Cancion elemento=lista.get(posicion);
			Cancion elementoAntiguo=lista.set(posicion+1, elemento);
			lista.set(posicion,elementoAntiguo);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new PosicionNoValidaException("Posición no válida.");
		}
	}
	

	@Override
	public String toString() {
		return lista + "\n";
	}
}

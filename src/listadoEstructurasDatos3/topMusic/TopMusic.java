package listadoEstructurasDatos3.topMusic;

import java.util.ArrayList;

/**
 * Implementa  un  programa  que  gestione  una  lista  de  las  canciones  m�s 
 * escuchadas. El usuario podr�:
 * 
 * a. A�adir una canci�n (en una posici�n) al TopMusic.
 * b. Sacar un elemento del TopMusic.
 * c. Subir un puesto en el TopMusic.
 * d. Bajar un puesto en el TopMusic.
 * e. Mostrar la lista TopMusic.
 * f. Mostrar la canci�n m�s escuchada.
 *
 * Sobre la canci�n se almacenar� el t�tulo, artista o grupo y a�o de grabaci�n
 * 
 * @author Miguel Angel L�pez Moyano
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
	 * A�ade un elemento en la posici�n
	 * @param elemento que se a�adir�
	 * @param posici�n en la que se a�adir�
	 * @throws PosicionNoValidaException 
	 */
	void anadirEnPosicion(Cancion elemento,int posicion) throws PosicionNoValidaException{
		try {
			lista.add(posicion,elemento);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new PosicionNoValidaException("Posici�n no v�lida.");
		}
	}
	
	/**
	 * Saca el elemento de la posici�n indicada
	 * @param posicion
	 * @return elemento
	 * @throws PosicionNoValidaException 
	 */
	Cancion sacarElementoPosicion(int posicion) throws PosicionNoValidaException{
		try {
			return lista.remove(posicion);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new PosicionNoValidaException("Posici�n no v�lida.");
		}
	}
	
	/**
	 * Devuelve el ta�o de la lista
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
			throw new ListaVaciaException("La lista est� vac�a.");
		}
	}
	
	/**
	 * Sube un puesto al elemento de la posici�n indicada, a la vez
	 * que bajamos la posici�n del elemento que estaba ah� anteriormente
	 * @param posicion
	 * @throws PosicionNoValidaException 
	 */
	void subirPuestoPosicion(int posicion) throws PosicionNoValidaException{
		try {
			Cancion elemento=lista.get(posicion);
			Cancion elementoAntiguo=lista.set(posicion-1, elemento);
			lista.set(posicion,elementoAntiguo);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new PosicionNoValidaException("Posici�n no v�lida.");
		}
	}
	
	void bajarPuestoPosicion(int posicion) throws PosicionNoValidaException{
		try {
			Cancion elemento=lista.get(posicion);
			Cancion elementoAntiguo=lista.set(posicion+1, elemento);
			lista.set(posicion,elementoAntiguo);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new PosicionNoValidaException("Posici�n no v�lida.");
		}
	}
	

	@Override
	public String toString() {
		return lista + "\n";
	}
}

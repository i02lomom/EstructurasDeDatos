package listadoEstructurasDatos2.lista;

import java.util.ArrayList;
import java.util.Iterator;

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
public class Lista {
	ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();
	ArrayList<Jugador> copia;
	
	/**
	 * Añade al final de la lista un jugador
	 * @param nombre del jugador
	 */
	public void anadirJugador(String nombre){
		listaJugadores.add(new Jugador(nombre));
	}
	
	/**
	 * Añade al final de la lista un jugador
	 * @param nombre del jugador
	 * @param posiscion en la que se debe insertar el jugador
	 */
	public void anadirJugador(String nombre,int posicion){
		listaJugadores.add(posicion,new Jugador(nombre));
	}
	
	/**
	 * Reemplaza el elemento de la posición indicada por uno
	 * cuyo nombre sea el pasado como parámetro
	 * @param nombre del jugador
	 * @param posicion del elemento a modificar
	 */
	public void modificarJugador(String nombre,int posicion){
		listaJugadores.set(posicion,new Jugador(nombre));
	}
	
	/**
	 * Busca en la lista a un jugador que tenga el mismo nombre
	 * que el indicado (pasado por parámetro)
	 * @param nombre del jugador
	 */
	public void buscarJugador(String nombre){
		boolean encontrado=false;
		for(Iterator<Jugador> it=listaJugadores.iterator();it.hasNext();){
			if(it.next().nombre.equals(nombre)){
				System.out.print("Jugador encontrado.\nJugador: "+nombre+"\n");
				encontrado=true;
			}
		}
		if(encontrado==false)
			System.out.println("Jugador no encontrado.");
	}
	
	/**
	 * Elinima al jugador de la posición indicada
	 * @param posicion
	 */
	public void eliminarJugador(int posicion){
		listaJugadores.remove(posicion);
	}
	
	/**
	 * Devuelve el tamaño actual de la lista
	 * @return
	 */
	public int devolverTamano(){
		return listaJugadores.size();
	}
	
	/**
	 * Crea una copia de la lista actual
	 */
	public void copiarLista(){
		copia=new ArrayList<Jugador>(listaJugadores);
		System.out.println("\nCopia guardada");		
	}
	
	/**
	 * Muestra los elementos de la lista
	 */
	public void mostrarLista(){
		System.out.println("\nListado de Jugadores");
		for(Iterator<Jugador> it=listaJugadores.iterator();it.hasNext();)
			System.out.print(it.next());
		System.out.println();
	}
	
	/**
	 * Muestra los elementos de la copia siempre que ésta se haya creado
	 */
	public void mostrarCopia(){
		if(copia==null){
			System.out.println("Error. No se ha creado una copia.\n");
		}
		else{
			System.out.println("\nListado de Jugadores");
			for(Iterator<Jugador> it=copia.iterator();it.hasNext();)
				System.out.print(it.next());
			System.out.println();
		}
	}
}

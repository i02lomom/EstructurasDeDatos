package concesionario;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Queremos modelar un concesionario de coches en Java. Nos limitaremos a las  siguientes opciones:
 *
 * - Alta de un coche (se pedirá matricula, color y modelo),
 * - Baja de  un coche (por matrícula),
 * - Mostrar un coche (por matrícula),
 * - Mostrar concesionario (todos los coches del concesionario)
 * - Contar el número de coches en el concesionario
 * - Mostrar coches de un color
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class Concesionario {
	private ArrayList<Coche> concesionario=null;
	
	/**
	 * Constructor
	 */
	Concesionario(){
		concesionario=new ArrayList<Coche>();
	}
	
	/**
	 * Busca el coche que se le pasa por parámetro (por matrícula)
	 * @param coche que contiene la matrícula a buscar
	 * @return coche (si se encuentra, si no salta la excepción)
	 * @throws MatriculaNoValidaException
	 * @throws CocheNoExisteException
	 */
	Coche buscarCoche(Coche coche) throws MatriculaNoValidaException, CocheNoExisteException{
		try {
			return concesionario.get(concesionario.indexOf(coche));
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new CocheNoExisteException("No existe ese coche.");
		}
	}
	
	/**
	 * Añade un coche siempre que este no exista previamente
	 * @param coche a añadir
	 * @throws Exception
	 */
	void anadir(Coche coche) throws Exception{
		if(concesionario.contains(coche))
			throw new CocheYaExisteException("El coche ya existe.");
		concesionario.add(coche);		
	}
	
	/**
	 * Elimina el coche pasado por parámetro de la lista
	 * @param coche a borrar
	 * @return true si lo borra
	 */
	boolean eliminar(Coche coche){
		return concesionario.remove(coche);
	}
	
	/**
	 * Busca coches de un color y los almacena en otra lista
	 * @param color
	 * @return arrayList con los coches del color pasado como parámetro
	 */
	ArrayList<Coche> buscarCochesColor(Color color){
		ArrayList<Coche> arrayColor = new ArrayList<Coche>();
		Iterator<Coche> iterator=concesionario.iterator();
		while(iterator.hasNext()){
			Coche coche=iterator.next();
			if(coche.getColor()==color)
				arrayColor.add(coche);
		}
		return arrayColor;
	}
	
	/**
	 * Devuelve el tamaño de la lista
	 * @return
	 */
	int size(){
		return concesionario.size();
	}

	@Override
	public String toString() {
		return concesionario.toString();
	}
}

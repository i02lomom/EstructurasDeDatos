package listadoEstructurasDatos3.listaDeLaCompra;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Implementa  un  programa  que  gestione  una  lista  de  la  compra  de 
 * forma  automática.  Se  dispondrá  de  una  lista  de  artículos  y  de
 * sus  existencias.  En  el momento  en  el  que  la  cantidad  de  artículos
 * llegue  a  un  límite  mínimo,  dicho  artículo aparecerá en la lista de la 
 * compra. Cada vez que el usuario utilice uno de los artículos se 
 * decrementarán  las  existencias  de  dicho  artículo.  De  igual  forma, 
 * cada  vez  que  el usuario compre el artículo, se incrementarán las 
 * existencias de dicho artículo. 
 * 
 * Quizás sea interesante añadir un campo código del artículo para facilitar
 * la gestión de la lista. Este código ha de ser único (static...)
 * Para ello, genera un interfaz con el usuario que permita entre otras 
 * acciones:
 * 
 * e. Añadir un producto nuevo a la lista.
 * f. Eliminar un elemento de la lista.
 * g. Incrementar las existencias de un artículo.
 * h. Decrementar las existencias de un artículo.
 * i. Modificar la cantidad mínima del artículo.
 * j. Mostrar la lista de todos los artículos.
 * k. Mostrar la lista de la compra
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class ListaDeLaCompra {
	/**
	 * Lista de artículos
	 */
	private ArrayList<Articulo> lista=null;
	
	/**
	 * Constructor
	 */
	ListaDeLaCompra(){
		lista=new ArrayList<Articulo>();
	}
	
	/**
	 * Añade un artículo a la lista si no existe previamente
	 * @param articulo
	 * @return true si se añade y false si no se añade
	 * @throws YaExisteArticuloException 
	 */
	boolean anadir(Articulo articulo) throws YaExisteArticuloException{
		if(lista.contains(articulo))
			throw new YaExisteArticuloException("Ya existe ese artículo");
		
		lista.add(articulo);
		return true;
	}
	
	/**
	 * Elimina un artículo de la lista
	 * @param articulo
	 * @return true si se elimina
	 */
	boolean eliminar(Articulo articulo){
		return lista.remove(articulo);
	}
	
	/**
	 * Modifica la cantidad mínima de un artículo
	 * @param articulo
	 * @param cantidad
	 * @return true si se modifica y false si no
	 * @throws MinimoNoValidoException 
	 * @throws NoExisteArticuloException 
	 */
	boolean setCantidadMinima(Articulo articulo,int cantidad) throws MinimoNoValidoException, NoExisteArticuloException{
		try {
			articulo = lista.get(lista.indexOf(articulo));
			articulo.setMinimo(cantidad);
			return true;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new NoExisteArticuloException("No existe ese artículo.");
		}
	}
	
	/**
	 * Incrementa el número de existencias del artículo en la
	 * cantidad que se le indica (siempre que exista el artículo
	 * en la lista)
	 * @param articulo
	 * @param incremento
	 * @return true si se incrementa y false si no
	 * @throws ExistenciasNoValidasException 
	 * @throws IncrementoNoValidoException 
	 * @throws NoExisteArticuloException 
	 */
	boolean incrementarExistencias(Articulo articulo, int incremento) throws IncrementoNoValidoException, 
	ExistenciasNoValidasException, NoExisteArticuloException{
		
		try {
			articulo = lista.get(lista.indexOf(articulo));
			articulo.incrementar(incremento);
			return true;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new NoExisteArticuloException("No existe ese artículo.");
		}
	}
	
	/**
	 * Decrementa el número de existencias del artículo en la
	 * cantidad que se le indica (siempre que exista el artículo
	 * en la lista)
	 * @param articulo
	 * @param decremento
	 * @return true si se decrementa y false si no
	 * @throws DecrementoNoValidoException 
	 * @throws ExistenciasNoValidasException 
	 * @throws NoExisteArticuloException 
	 */
	boolean decrementarExistencias(Articulo articulo, int decremento) throws ExistenciasNoValidasException, DecrementoNoValidoException, NoExisteArticuloException{
		
		try {
			articulo = lista.get(lista.indexOf(articulo));
			articulo.decrementar(decremento);
			return true;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new NoExisteArticuloException("No existe ese artículo.");
		}
	}
	
	/**
	 * Genera la lista a partir de los artículos que no tienen la cantidad mínima
	 * @return cadena
	 */
	String generarListaDeLaCompra() {
		String cadena = new String();
		Iterator<Articulo> iterator=lista.iterator();
		while (iterator.hasNext()) {
			Articulo articulo = (Articulo) iterator.next();
			if(articulo.porDebajoDelMinimo())
				cadena+="\n("+(articulo.getExistencias()
								- articulo.getMinimo())
								+ ") " + articulo.getNombre();		
		}
		return cadena;
	}

	@Override
	public String toString() {
		return lista.toString();
	}
}

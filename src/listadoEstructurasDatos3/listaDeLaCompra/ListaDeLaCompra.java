package listadoEstructurasDatos3.listaDeLaCompra;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Implementa  un  programa  que  gestione  una  lista  de  la  compra  de 
 * forma  autom�tica.  Se  dispondr�  de  una  lista  de  art�culos  y  de
 * sus  existencias.  En  el momento  en  el  que  la  cantidad  de  art�culos
 * llegue  a  un  l�mite  m�nimo,  dicho  art�culo aparecer� en la lista de la 
 * compra. Cada vez que el usuario utilice uno de los art�culos se 
 * decrementar�n  las  existencias  de  dicho  art�culo.  De  igual  forma, 
 * cada  vez  que  el usuario compre el art�culo, se incrementar�n las 
 * existencias de dicho art�culo. 
 * 
 * Quiz�s sea interesante a�adir un campo c�digo del art�culo para facilitar
 * la gesti�n de la lista. Este c�digo ha de ser �nico (static...)
 * Para ello, genera un interfaz con el usuario que permita entre otras 
 * acciones:
 * 
 * e. A�adir un producto nuevo a la lista.
 * f. Eliminar un elemento de la lista.
 * g. Incrementar las existencias de un art�culo.
 * h. Decrementar las existencias de un art�culo.
 * i. Modificar la cantidad m�nima del art�culo.
 * j. Mostrar la lista de todos los art�culos.
 * k. Mostrar la lista de la compra
 * 
 * @author Miguel Angel L�pez Moyano
 * @version 1.0
 */
public class ListaDeLaCompra {
	/**
	 * Lista de art�culos
	 */
	private ArrayList<Articulo> lista=null;
	
	/**
	 * Constructor
	 */
	ListaDeLaCompra(){
		lista=new ArrayList<Articulo>();
	}
	
	/**
	 * A�ade un art�culo a la lista si no existe previamente
	 * @param articulo
	 * @return true si se a�ade y false si no se a�ade
	 * @throws YaExisteArticuloException 
	 */
	boolean anadir(Articulo articulo) throws YaExisteArticuloException{
		if(lista.contains(articulo))
			throw new YaExisteArticuloException("Ya existe ese art�culo");
		
		lista.add(articulo);
		return true;
	}
	
	/**
	 * Elimina un art�culo de la lista
	 * @param articulo
	 * @return true si se elimina
	 */
	boolean eliminar(Articulo articulo){
		return lista.remove(articulo);
	}
	
	/**
	 * Modifica la cantidad m�nima de un art�culo
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
			throw new NoExisteArticuloException("No existe ese art�culo.");
		}
	}
	
	/**
	 * Incrementa el n�mero de existencias del art�culo en la
	 * cantidad que se le indica (siempre que exista el art�culo
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
			throw new NoExisteArticuloException("No existe ese art�culo.");
		}
	}
	
	/**
	 * Decrementa el n�mero de existencias del art�culo en la
	 * cantidad que se le indica (siempre que exista el art�culo
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
			throw new NoExisteArticuloException("No existe ese art�culo.");
		}
	}
	
	/**
	 * Genera la lista a partir de los art�culos que no tienen la cantidad m�nima
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

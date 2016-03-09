package listadoEstructurasDatos3.claseConGenerics;
import java.util.ArrayList;

/**
 * Reproduce  una  clase  con  Generics.  Llámala  ClaseConGenerics.
 * Entrega  su  esqueleto donde:
 * 
 * a. Definas  una variable  de objeto. Ha  de  ser  una  colección  
 * homogénea  (del  tipo parametrizado de la clase)
 * 
 * b. Definas un constructor donde instancies el atributo anterior
 * 
 * c. Definas un método metodo1 cuyo parámetro sea del tipo parametrizado
 * 
 * d. Definas un método metodo2 cuyo valor devuelto se a del tipo parametrizado
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 * @param <T>
 */
public class ClaseConGenerics<T> {
	/**
	 * ArrayList de tipo T
	 */
	private ArrayList<T> lista=null;
	
	/**
	 * Constructor
	 */
	public ClaseConGenerics(){
		this.lista=new ArrayList<T>();
	}
	
	/**
	 * Añade el elemento pasado al final
	 * @param elemento de tipo T
	 */
	void método1(T elemento){
		lista.add(elemento);
	}
	
	/**
	 * Borra el elemento de la posición indicada
	 * @param posicion
	 * @return elemento que se borra
	 */
	T metodo2(int posicion){
		return lista.remove(posicion);
	}
}

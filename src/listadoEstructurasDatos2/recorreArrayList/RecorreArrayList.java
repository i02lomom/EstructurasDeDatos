package listadoEstructurasDatos2.recorreArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * A continuación se muestra parte de una clase denominada RecorreArrayList:
 * 
 * a. Compila  y  entrega  el  código  donde  se  invoquen  cada  uno  de  los 
 * métodos anteriores. Utiliza una lista de String. 
 * 
 * b.Implementa cómo recorrer una lista al revés en la misma clase 
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class RecorreArrayList {
	ArrayList<String> arrayList = new ArrayList<String>();

	void show(){
		System.out.println(arrayList);
	}
	
	/**
	 * Muestra el ArrayList mediante un iterador con el bucle while
	 */
	void showWithIterator(){
		Iterator<String> it=arrayList.iterator();
		
		while(it.hasNext())
			System.out.print(it.next()+"\t");
	}
	
	/**
	 * Muestra el ArrayList mediante un iterador con el bucle for
	 */
	void showWithIterator2(){
		for(Iterator<String> it=arrayList.iterator();it.hasNext();)
			System.out.print(it.next()+"\t");
	}
	
	/**
	 * Muestra el ArrayList al revés mediante ListIterator
	 */
	void mostrarAlRevesConListIterator(){
		for(ListIterator<String> it=arrayList.listIterator(arrayList.size());it.hasPrevious();)
			System.out.print(it.previous()+"\t");
	}
	
	/**
	 * Muestra el ArrayList mediante un for clásico, accediendo mediante índices
	 */
	void showWithGet(){
		for(int i=0;i<arrayList.size();i++)
			System.out.print(arrayList.get(i)+"\t");
	}
	
	/**
	 * Muestra el ArrayList al revés mediante índices
	 */
	void mostrarAlRevesConGet(){
		for(int i=arrayList.size()-1;i>=0;i--)
			System.out.print(arrayList.get(i)+"\t");
	}
	
	/**
	 * Muestra el ArrayList mediante un for mejorado
	 */
	void showWithForEach(){
		for(String elemento:arrayList)
			System.out.print(elemento+"\t");
	}
}

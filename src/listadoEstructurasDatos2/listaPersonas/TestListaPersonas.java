package listadoEstructurasDatos2.listaPersonas;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Entrega la clase TestListaPersonas que haga lo siguiente:
 *
 * a. Cree una lista (ArrayList) de personas.
 * 
 * ArrayList<Persona> listaPersonas = new ArrayList<Persona>();//Generics
 * b. Añada tres personas a la lista (3 elementos).
 * c. Muestre la lista.(implementa toString() en Persona)
 * d. Elimine el último elemento.
 * e. Muestre la lista.
 * f. Elimine el primer elemento.
 * g. Muestre la lista.
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class TestListaPersonas {

	public static void main(String[] args) {
		//Creamos el arraylist listaPersonas
		ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
		
		//Añadimos tres personas
		listaPersonas.add(new Persona("11111111A","Jose","Sánchez Pérez",22));
		listaPersonas.add(new Persona("22222222B","Manuel","Luque Castillo",26));
		listaPersonas.add(new Persona("33333333C","María","López Montilla",24));
		
		mostrarLista(listaPersonas);
		listaPersonas.remove(listaPersonas.size()-1);
		mostrarLista(listaPersonas);		
		listaPersonas.remove(0);
		mostrarLista(listaPersonas);
		
	}
	
	static void mostrarLista(ArrayList<Persona> listaPersonas){
		Iterator<Persona> iterator=listaPersonas.iterator();
		
		while(iterator.hasNext()){
			Persona elemento=iterator.next();
			System.out.println(elemento.toString());
		}
	}

}

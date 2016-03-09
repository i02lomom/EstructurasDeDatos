package listadoEstructurasDatos2.recorreArrayList;

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
public class TestRecorreArrays {

	public static void main(String[] args) {
		RecorreArrayList r=new RecorreArrayList();
		
		r.arrayList.add("Hola");
		r.arrayList.add("soy");
		r.arrayList.add("Miguel Angel");
		
		System.out.println("Mostrando con show(): ");
		r.show();

		System.out.println("\nMostrando con showWithIterator(): ");
		r.showWithIterator();
		
		System.out.println("\n\nMostrando con showWithIterator2(): ");
		r.showWithIterator2();
		
		System.out.println("\n\nMostrando con showWithGet(): ");
		r.showWithGet();
		
		System.out.println("\n\nMostrando con showWithForEach(): ");
		r.showWithForEach();
		
		System.out.println("\n\nMostrando al revés con ListIterator: ");
		r.mostrarAlRevesConListIterator();
		
		System.out.println("\n\nMostrando al revés con get: ");
		r.mostrarAlRevesConGet();
	}

}

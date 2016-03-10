package listadoEstructurasDatos3.listaDeLaCompra;

import utiles.Menu;
import utiles.Teclado;

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
public class TestListaDeLaCompra {
	static ListaDeLaCompra lista=new ListaDeLaCompra();
	static Menu menu=new Menu("\nLista de la compra",new String[]{
			"A�adir elemento",
			"Eliminar elemento",
			"Incrementar existencias",
			"Decrementar existencias",
			"Modificar cantidad m�nima",
			"Mostrar todos los art�culos",
			"Mostrar lista de la compra"});
	
	public static void main(String[] args) {
		int opcion;
		
		do{
			opcion=menu.gestionarMenu();
			
			switch(opcion){
			case 1:
				anadirArticulo();
				break;
			case 2:
				eliminarArticulo();
				break;
			case 3:
				incrementarExistencias();
				break;
			case 4:
				decrementarExistencias();
				break;
			case 5:
				modificarCantidadMinima();
				break;
			case 6:
				System.out.println(lista);
				break;
			case 7:
				System.out.println(lista.generarListaDeLaCompra());
				break;
			case 8:
				break;
			default:
				System.out.println("\nError. Opcion incorrecta");
			}		
		}while(opcion!=menu.getNumeroOpciones());
	}
	
	private static void anadirArticulo(){
		Articulo articulo=null;
		try {
			articulo = new Articulo(Teclado.leerCadena("Introduzca el nombre del art�culo: ")
					,Teclado.leerEntero("Introduzca las existencias del art�culo: ")
					,Teclado.leerEntero("Introduzca la cantidad m�nima: "));
			
			lista.anadir(articulo);
		} catch (Exception e) {
			System.out.println("No se ha podido a�adir el art�culo."+e.getMessage());
		}
	}
	
	private static void eliminarArticulo(){	
		Articulo articulo=null;
		try {
			articulo = new Articulo(Teclado.leerCadena("Introduzca el nombre del art�culo: "));
			
			lista.eliminar(articulo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}
	
	private static void incrementarExistencias(){
		Articulo articulo=null;
		try {
			articulo = new Articulo(Teclado.leerCadena("Introduzca el nombre del art�culo: "));
		} catch (NombreNoValidoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			try {
				lista.incrementarExistencias(articulo,Teclado.leerEntero("Introduzca el incremento del art�culo: "));
			} catch (NoExisteArticuloException e) {
				System.out.println(e.getMessage());
			}
		} catch (IncrementoNoValidoException e) {
			System.out.println("No se ha podido incrementar las existencias."+e.getMessage());
		} catch (ExistenciasNoValidasException e) {
			System.out.println("No se ha podido incrementar las existencias."+e.getMessage());
		}
	}
	
	private static void decrementarExistencias(){
		Articulo articulo=null;
		try {
			articulo = new Articulo(Teclado.leerCadena("Introduzca el nombre del art�culo: "));
		} catch (NombreNoValidoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			try {
				lista.decrementarExistencias(articulo,Teclado.leerEntero("Introduzca el decremento del art�culo: "));
			} catch (NoExisteArticuloException e) {
				System.out.println(e.getMessage());
			}
		} catch (ExistenciasNoValidasException e) {
			System.out.println("No se ha podido decrementar las existencias."+e.getMessage());
		} catch (DecrementoNoValidoException e) {
			System.out.println("No se ha podido decrementar las existencias."+e.getMessage());
		}
	}
	
	private static void modificarCantidadMinima(){
		Articulo articulo=null;
		try {
			articulo = new Articulo(Teclado.leerCadena("Introduzca el nombre del art�culo: "));
		} catch (NombreNoValidoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			try {
				lista.setCantidadMinima(articulo,Teclado.leerEntero("Introduzca la cantidad m�nima del art�culo: "));
			} catch (NoExisteArticuloException e) {
				System.out.println(e.getMessage());
			}
		} catch (MinimoNoValidoException e) {
			System.out.println("No se ha podido modificar la cantidad m�nima."+e.getMessage());
		}
	}

}

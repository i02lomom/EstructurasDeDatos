package listadoEstructurasDatos3.listaDeLaCompra;

import utiles.Menu;
import utiles.Teclado;

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
public class TestListaDeLaCompra {
	static ListaDeLaCompra lista=new ListaDeLaCompra();
	static Menu menu=new Menu("\nLista de la compra",new String[]{
			"Añadir elemento",
			"Eliminar elemento",
			"Incrementar existencias",
			"Decrementar existencias",
			"Modificar cantidad mínima",
			"Mostrar todos los artículos",
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
			articulo = new Articulo(Teclado.leerCadena("Introduzca el nombre del artículo: ")
					,Teclado.leerEntero("Introduzca las existencias del artículo: ")
					,Teclado.leerEntero("Introduzca la cantidad mínima: "));
			
			lista.anadir(articulo);
		} catch (Exception e) {
			System.out.println("No se ha podido añadir el artículo."+e.getMessage());
		}
	}
	
	private static void eliminarArticulo(){	
		Articulo articulo=null;
		try {
			articulo = new Articulo(Teclado.leerCadena("Introduzca el nombre del artículo: "));
			
			lista.eliminar(articulo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}
	
	private static void incrementarExistencias(){
		Articulo articulo=null;
		try {
			articulo = new Articulo(Teclado.leerCadena("Introduzca el nombre del artículo: "));
		} catch (NombreNoValidoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			try {
				lista.incrementarExistencias(articulo,Teclado.leerEntero("Introduzca el incremento del artículo: "));
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
			articulo = new Articulo(Teclado.leerCadena("Introduzca el nombre del artículo: "));
		} catch (NombreNoValidoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			try {
				lista.decrementarExistencias(articulo,Teclado.leerEntero("Introduzca el decremento del artículo: "));
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
			articulo = new Articulo(Teclado.leerCadena("Introduzca el nombre del artículo: "));
		} catch (NombreNoValidoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			try {
				lista.setCantidadMinima(articulo,Teclado.leerEntero("Introduzca la cantidad mínima del artículo: "));
			} catch (NoExisteArticuloException e) {
				System.out.println(e.getMessage());
			}
		} catch (MinimoNoValidoException e) {
			System.out.println("No se ha podido modificar la cantidad mínima."+e.getMessage());
		}
	}

}

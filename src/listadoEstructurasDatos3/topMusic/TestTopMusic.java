package listadoEstructurasDatos3.topMusic;

import utiles.Menu;
import utiles.Teclado;

/**
 * Implementa  un  programa  que  gestione  una  lista  de  las  canciones  más 
 * escuchadas. El usuario podrá:
 * 
 * a. Añadir una canción (en una posición) al TopMusic.
 * b. Sacar un elemento del TopMusic.
 * c. Subir un puesto en el TopMusic.
 * d. Bajar un puesto en el TopMusic.
 * e. Mostrar la lista TopMusic.
 * f. Mostrar la canción más escuchada.
 *
 * Sobre la canción se almacenará el título, artista o grupo y año de grabación
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class TestTopMusic {
	static TopMusic lista=new TopMusic();
	static Menu menu=new Menu("\nTop Music",new String[]{
			"Añadir canción",
			"Sacar elemento",
			"Subir un puesto",
			"Bajar un puesto",
			"Mostrar lista",
			"Mostrar la canción más escuchada"});
	
	public static void main(String[] args) {
		int opcion;
		
		do{
			opcion=menu.gestionarMenu();
			
			switch(opcion){
			case 1:
				anadirElemento();
				break;
			case 2:
				sacarElemento();
				break;
			case 3:
				subirElemento();
				break;
			case 4:
				bajarElemento();
				break;
			case 5:
				System.out.println(lista.toString());
				break;
			case 6:
				try {
					System.out.println(lista.cabezaLista());
				} catch (ListaVaciaException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 7:
				break;
			default:
				System.out.println("\nError. Opcion incorrecta");
			}		
		}while(opcion!=menu.getNumeroOpciones());
	}
	
	static void anadirElemento(){
		try {
			lista.anadirEnPosicion(pedirDatos(),Teclado.leerEntero("Introduzca la posición: "));
		} catch (PosicionNoValidaException e) {
			System.out.println(e.getMessage());
		}	
	}

	static void sacarElemento(){
		try {
			lista.sacarElementoPosicion(Teclado.leerEntero("Introduzca la posición: "));
		} catch (PosicionNoValidaException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	static void subirElemento(){
		try {
			lista.subirPuestoPosicion(Teclado.leerEntero("Introduzca la posición: "));
		} catch (PosicionNoValidaException e) {
			System.out.println(e.getMessage());
		}
	}
	
	static void bajarElemento(){
		try {
			lista.bajarPuestoPosicion(Teclado.leerEntero("Introduzca la posición: "));
		} catch (PosicionNoValidaException e) {
			System.out.println(e.getMessage());
		}
	}
	
	static Cancion pedirDatos(){
		String titulo=Teclado.leerCadena("Introduzca el título : ");
		String artista=Teclado.leerCadena("Introduzca el artista: ");
		int anno=Teclado.leerEntero("Introduzca el año: ");
		
		return new Cancion(titulo,artista,anno);
	}
}

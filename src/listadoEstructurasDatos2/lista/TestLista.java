package listadoEstructurasDatos2.lista;
import utiles.Menu;
import utiles.Teclado;

/**
 * Entrega la clase Lista que:
 * 
 * a. Añada al final de la lista
 * b. Inserte un elemento en una determinada posición
 * c. Modifique un elemento reemplazándolo por otro
 * d. Conozca el tamaño de la lista
 * e. Elimine elementos de la lista
 * f. Busque elementos en la lista
 * g. Copie la lista
 *
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class TestLista {

	public static void main(String[] args) {
		int opcion,posicion;
		String nombreJugador;
		Menu menu=new Menu("Lista",new String[]{"Añadir al final","Insertar en posición",
				"Modificar elemento","Mostrar tamaño lista","Eliminar elementos",
				"Buscar elementos","Copiar lista","Mostrar lista","Mostrar copia"});
		Lista listaJugadores=new Lista();
		
		do{
			opcion=menu.gestionarMenu();
			
			switch(opcion){
			case 1:
				nombreJugador=pedirNombreJugador();
				listaJugadores.anadirJugador(nombreJugador);	
				break;
			case 2:
				posicion=pedirPosicion();
				if(posicion<0||posicion>listaJugadores.devolverTamano()-1)
					System.out.println("Error. Posición incorrecta");
				else{
					nombreJugador=pedirNombreJugador();
					listaJugadores.anadirJugador(nombreJugador,posicion);	
				}
				break;
			case 3:
				posicion=pedirPosicion();
				if(posicion<0||posicion>listaJugadores.devolverTamano()-1)
					System.out.println("Error. Posición incorrecta");
				else{
					nombreJugador=pedirNombreJugador();
					listaJugadores.modificarJugador(nombreJugador,posicion);	
				}
				break;
			case 4:
				System.out.println("Tamano de la lista: " + listaJugadores.devolverTamano());
				break;
			case 5:
				posicion=pedirPosicion();
				if(posicion<0||posicion>listaJugadores.devolverTamano()-1)
					System.out.println("Error. Posición incorrecta");
				else{
					nombreJugador=pedirNombreJugador();
					listaJugadores.eliminarJugador(posicion);
				}
				break;
			case 6:
				nombreJugador=pedirNombreJugador();
				listaJugadores.buscarJugador(nombreJugador);
				break;
			case 7:
				listaJugadores.copiarLista();
				break;
			case 8:
				listaJugadores.mostrarLista();
				break;
			case 9:
				listaJugadores.mostrarCopia();
				break;
			case 10:
				break;
			default:
				System.out.println("\nError. Opcion incorrecta");
			}		
		}while(opcion!=menu.getNumeroOpciones());
	}
	
	/**
	 * Pide al usuario el nombre del jugador
	 * @return nombre del jugador
	 */
	static String pedirNombreJugador(){
		return Teclado.leerCadena("Nombre del jugador: ");
	}
	
	/**
	 * Pide al usuario la posición
	 * @return posición
	 */
	static int pedirPosicion(){
		return Teclado.leerEntero("Introduzca la posición: ");
	}
}

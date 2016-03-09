package listadoEstructurasDatos3.colaConMenu;

import utiles.Menu;
import utiles.Teclado;

/**
 * Crea  una  clase  genérica  Cola (debe  de  aceptar  cualquier  tipo  de 
 * objeto  concreto, utiliza  generics). Recuerda  que  has  de  evitar  la 
 * interacción  con  el usuario  dentro  de Cola. Utilizando  generics,  
 * implementa  las  operaciones  básicas  de  una  estructura  de datos cola.
 * Recuerda que una cola es una estructura FIFO donde el primer elemento en 
 * entrar es el primero en salir. Un ejemplo básico de cola es la de la 
 * taquilla de un cine. Las operaciones a implementar son:
 * 
 * a. Crear una cola.
 * b. Introducir elemento en la cola (añadir/enqueue)
 * c. Sacar elemento de la cola (extraer/dequeue)
 * d. Cabeza de la cola. (devuelve el primer elemento de la cola, cabeza o front) 
 * 
 * Implementa los métodos necesarios, y recuerda hacer las pruebas precisas
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class TestCola {
	static Cola<Persona> cola=null;
	static Menu menu=new Menu("\nCola",new String[]{
			"Crear cola",
			"Añadir a la cola",
			"Sacar elemento",
			"Cabeza de la cola"});
	
	public static void main(String[] args) {
		int opcion;
		boolean colaCreada=false;
		
		do{
			opcion=menu.gestionarMenu();
			
			switch(opcion){
			case 1:
				crearCola();
				colaCreada=true;
				break;
			case 2:
				if(!colaCreada)
					System.out.println("No se ha creado la cola.");
				else
					anadirElemento();
				break;
			case 3:
				if(!colaCreada)
					System.out.println("No se ha creado la cola.");
				else
					sacarElemento();
				break;
			case 4:
				if(!colaCreada)
					System.out.println("No se ha creado la cola.");
				else
					try {
						System.out.println(cola.cabeza());
					} catch (ColaVaciaException e) {
						System.out.println(e.getMessage()+ "No se puede mostrar la cabeza.");
					}		
				break;
			case 5:
				break;
			default:
				System.out.println("\nError. Opcion incorrecta");
			}		
		}while(opcion!=menu.getNumeroOpciones());
	}
	
	static void crearCola(){
		cola=new Cola<Persona>();
		System.out.println("Cola creada.");
	}
	
	static void anadirElemento(){
		try {
			cola.anadir(pedirDatos());
		} catch (Exception e) {
			System.out.println(e.getMessage()
					+ "No se ha podido añadir el elemento");
		}
	}
	
	static void sacarElemento(){
		try {
			cola.extraer();
		} catch (ColaVaciaException e) {
			System.out.println(e.getMessage()
					+ "No se ha podido sacar ningún elemento");
		}
	}
	
	static Persona pedirDatos() throws Exception{
		return new Persona(Teclado.leerCadena("Introduzca el D.N.I. : ")
				,Teclado.leerCadena("Introduzca el nombre: ")
				,Teclado.leerCadena("Introduzca los apellidos: ")
				,Teclado.leerEntero("Introduzca la edad: "));
	}
}

package listadoEstructurasDatos3.pilaConMenu;
import utiles.Menu;
import utiles.Teclado;

/**
 * Crea una clase genérica Pila (debe de aceptar cualquier tipo de objeto
 * concreto, utiliza generics). Recuerda  que  has  de  evitar  la 
 * interacción  con  el  usuario  dentro  de Pila. Implementa  las  
 * operaciones  básicas  de  una  estructura  de  datos  pila. Una  pila
 * es  una estructura LIFO donde el último elemento en entrar es el primero
 * en salir. Un ejemplo básico  de  pila  es  la  forma  de  almacenamiento 
 * de  procesos  en  la  memoria.  Las operaciones a implementar son:
 * 
 * a. Crear una pila.
 * b.Introducir elemento en la pila (apilar o push)
 * c. Sacar elemento de la pila (extraer o pop)
 * d. Cima de la pila (devuelve el elemento de la cima de la pila o top)
 * 
 * Implementa los métodos necesarios, y recuerda hacer las pruebas precisas
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class TestPila {
	static Pila<Persona> pila=null;
	static Menu menu=new Menu("\nPila",new String[]{"Crear pila","Añadir a la pila","Sacar elemento","Cima de la pila"});
	
	public static void main(String[] args){
		int opcion;
		boolean pilaCreada=false;
		
		do{
			opcion=menu.gestionarMenu();
			
			switch(opcion){
			case 1:
				crearPila();
				pilaCreada=true;
				break;
			case 2:
				if(!pilaCreada)
					System.out.println("No se ha creado la pila.");
				else
					anadirElemento();
				break;
			case 3:
				if(!pilaCreada)
					System.out.println("No se ha creado la pila.");
				else 
					sacarElemento();
				break;
			case 4:
				if(!pilaCreada)
					System.out.println("No se ha creado la pila.");
				else{
					try {
						System.out.println(pila.top());
					} catch (PilaVaciaException e) {
						System.out.println(e.getMessage()+ "No se puede mostrar la cima.");
					}
				}
				break;
			case 5:
				break;
			default:
				System.out.println("\nError. Opcion incorrecta");
			}		
		}while(opcion!=menu.getNumeroOpciones());
	}
	
	static void crearPila(){
		pila=new Pila<Persona>();
		System.out.println("Pila creada.");
	}
	
	static void anadirElemento(){
		try {
			pila.push(pedirDatos());
		} catch (Exception e) {
			System.out.println(e.getMessage()
					+ "No se ha podido añadir el elemento");
		}
	}
	
	static void sacarElemento(){
		try {
			pila.pop();
		} catch (PilaVaciaException e) {
			System.out.println(e.getMessage()+ "No se ha podido sacar ningún elemento");
		}
	}
	
	static Persona pedirDatos() throws Exception{
		return new Persona(Teclado.leerCadena("Introduzca el D.N.I. : ")
				,Teclado.leerCadena("Introduzca el nombre: ")
				,Teclado.leerCadena("Introduzca los apellidos: ")
				,Teclado.leerEntero("Introduzca la edad: "));
	}
}

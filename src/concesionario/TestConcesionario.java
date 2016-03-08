package concesionario;
import utiles.Menu;
import utiles.Teclado;

/**
 * Queremos modelar un concesionario de coches en Java. Nos limitaremos a las  siguientes opciones:
 *
 * - Alta de un coche (se pedirá matricula, color y modelo),
 * - Baja de  un coche (por matrícula),
 * - Mostrar un coche (por matrícula),
 * - Mostrar concesionario (todos los coches del concesionario)
 * - Contar el número de coches en el concesionario
 * - Mostrar coches de un color
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class TestConcesionario {
	// Menú de colores
	static Menu menuColores=new Menu("Colores",Color.AZUL.OpcionesMenu());
			
	// Menú de modelos
	static Menu menuModelos=new Menu("Modelos",Modelo.CORDOBA.OpcionesMenu());
	static Concesionario concesionario=new Concesionario();
	
	public static void main(String[] args) {
		int opcion;
		Menu menu=new Menu("Concesionario",new String[]{
				"Añadir coche",
				"Eliminar coche",
				"Buscar coche",
				"Mostrar lista",
				"Contar coches",
				"Buscar coches por color"});
		
		do{
			opcion=menu.gestionarMenu();
			
			switch(opcion){
			case 1:
				anadirCoche();
				break;
			case 2:
				eliminarCoche();
				break;
			case 3:
				buscarCoche();
				break;
			case 4:
				System.out.println(concesionario);
				break;
			case 5:
				System.out.println("\nNúmero de coches: "+concesionario.size());
				break;
			case 6:
				System.out.println(concesionario.buscarCochesColor(pedirColor()));
				break;
			case 7:
				return;
			default:
				System.out.println("\nError. Opcion incorrecta");
			}		
		}while(opcion!=menu.getNumeroOpciones());
	}
	
	/**
	 * Añade un coche siempre que este no exista previamente
	 */
	static void anadirCoche(){
		try {
			Coche coche=new Coche(Teclado.leerCadena("Introduzca la matrícula: "),
					pedirColor(),pedirModelo());
			
			concesionario.anadir(coche);
			System.out.println("Coche añadido.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Elimina el coche siempre que éste exista
	 */
	static void eliminarCoche(){
		try {
			Coche coche = new Coche(Teclado.leerCadena("Introduzca la matrícula: "));
		
			if(concesionario.eliminar(coche))
				System.out.println("Coche eliminado.");
			else
				System.out.println("No se ha podido eliminar coche.");
			} catch (MatriculaNoValidaException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Busca un coche a través de la matrícula
	 */
	static void buscarCoche(){
		try {
			Coche coche = new Coche(Teclado.leerCadena("Introduzca la matrícula (sin espacios ni guiones): "));
			
			coche=concesionario.buscarCoche(coche);
			System.out.println(coche.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Muestra el menú de colores y pide al usuario que elija uno.
	 * @return color elegido
	 */
	static Color pedirColor(){
		int opcion=menuColores.gestionarMenu();
		
		Color[] array=Color.AZUL.getValues();
		if(opcion==array.length+1)
			return null;
		return array[opcion-1];
	}
	
	/**
	 * Muestra el menú de modelos y pide al usuario que elija uno
	 * @return modelo elegido
	 */
	static Modelo pedirModelo(){
		int opcion=menuModelos.gestionarMenu();
		
		Modelo[] array=Modelo.CORDOBA.getValues();
		if(opcion==array.length+1)
			return null;
		return array[opcion-1];
	}
}

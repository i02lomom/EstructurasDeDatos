package utiles;
import utiles.Teclado;

public class Menu {
	/**
	 * Título del menú
	 */
	private String titulo;
	
	/**
	 * Array de opciones
	 */
	private String [] opciones;
	
	/**
	 * Número de opciones
	 */
	private int numeroOpciones;
	
	/**
	 * Constructor que recibe el título y un array con las opciones
	 * @param titulo cadena con el título del menú
	 * @param opciones array que contiene las opciones
	 */
	public Menu(String titulo, String[] opciones){
		this.titulo=titulo;
		setOpciones(opciones);
		setNumeroOpciones(opciones);
	}
	
	/**
	 * Escribe el array opciones añadiendo al final la opción Salir
	 * @param opciones array de cadenas con las opciones (sin la opción Salir)
	 */
	private void setOpciones(String [] opciones){
		int i=0;
		this.opciones= new String[opciones.length+1]; // Creamos un vector para las opciones
		for(String opcion:opciones){				  // Recorremos el vector opciones para aignarlo a this.opciones
			this.opciones[i++]=opcion;
		}
		this.opciones[i]="Salir";					  // Añadimos a this.opciones la opción Salir
	}
	
	/**
	 * Escribe el número de opciones (se suma uno más por la opción Salir)
	 * @param opciones array de cadenas con las opciones (sin la opción Salir)
	 */
	private void setNumeroOpciones(String [] opciones){
		this.numeroOpciones=opciones.length+1;
	}
	
	/**
	 * Lee el número de opciones del menú
	 * @return
	 */
	public int getNumeroOpciones() {
		return numeroOpciones;
	}

	/**
	 * Muestra el menú
	 */
	public void mostrarMenu(){
		System.out.println(titulo+"\n");
		for(int i=0;i<numeroOpciones;i++){
			System.out.println("("+(i+1)+") "+opciones[i]);
		}
	}
	
	/**
	 * Lee la opción introducida por el usuario
	 * @return opcion
	 */
	public int recogeOpcionValida(){
		int opcion;
		do{
			opcion=Teclado.leerEntero("\nIntroduzca una opción: ");
			if(opcion<1 || opcion>numeroOpciones)
				System.out.println("Error. Opción incorrecta");
		}while(opcion<1 || opcion>numeroOpciones);
		return opcion;
	}
	
	/**
	 * Muestra el menú y recoge una opción válida
	 * @return opción válida escogida
	 */
	public int gestionarMenu(){
		mostrarMenu();
		return recogeOpcionValida();
		
	}
}

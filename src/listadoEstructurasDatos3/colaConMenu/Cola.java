package listadoEstructurasDatos3.colaConMenu;
import java.util.ArrayList;

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
 * @param <T>
 */
public class Cola<T> {
	/**
	 * ArrayList
	 */
	ArrayList<T> cola=null;
	
	/**
	 * Constructor
	 */
	public Cola(){
		this.cola=new ArrayList<T>();
	}
	
	/**
	 * Añade un elemento al final de la cola
	 * @param elemento que va a añadir
	 */
	void anadir(T elemento){
		cola.add(elemento);
	}
	
	/**
	 * Extrae el primer elemento de la cola
	 * @return elemento que se extrae
	 * @throws ColaVaciaException 
	 */
	T extraer() throws ColaVaciaException{
		try {
			return cola.remove(0);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ColaVaciaException("La cola está vacía.");
		}
		
	}

	/**
	 * Devuelve el primer elemento de la cola
	 * @return elemento
	 * @throws ColaVaciaException 
	 */
	T cabeza() throws ColaVaciaException{
		try {
			return cola.get(0);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ColaVaciaException("La cola está vacía.");
		}
	}
}

package listadoEstructurasDatos3.pilaConMenu;
import java.util.ArrayList;

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
public class Pila<T> {
	/**
	 * ArrayList
	 */
	ArrayList<T> pila=null;
	
	/**
	 * Constructor
	 */
	public Pila(){
		pila=new ArrayList<T>();
	}
	
	/**
	 * Añade un elemento al final
	 * @param elemento que se añadirá
	 */
	void push(T elemento){
		pila.add(elemento);
	}
	
	/**
	 * Elimina el último elemento
	 * @return elemento que se borrará
	 * @throws PilaVaciaException 
	 */
	T pop() throws PilaVaciaException{
		try {
			return pila.remove(pila.size()-1);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new PilaVaciaException("La pila está vacía.");
		}
		
	}
	
	/**
	 * Devuelve el último elemento
	 * @return elemento
	 * @throws PilaVaciaException 
	 */
	T top() throws PilaVaciaException{
		try {
			return pila.get(pila.size()-1);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new PilaVaciaException("La pila está vacía.");
		}
		
	}
}
package listadoEstructurasDatos3.pilaConMenu;
import java.util.ArrayList;

/**
 * Crea una clase gen�rica Pila (debe de aceptar cualquier tipo de objeto
 * concreto, utiliza generics). Recuerda  que  has  de  evitar  la 
 * interacci�n  con  el  usuario  dentro  de Pila. Implementa  las  
 * operaciones  b�sicas  de  una  estructura  de  datos  pila. Una  pila
 * es  una estructura LIFO donde el �ltimo elemento en entrar es el primero
 * en salir. Un ejemplo b�sico  de  pila  es  la  forma  de  almacenamiento 
 * de  procesos  en  la  memoria.  Las operaciones a implementar son:
 * 
 * a. Crear una pila.
 * b.Introducir elemento en la pila (apilar o push)
 * c. Sacar elemento de la pila (extraer o pop)
 * d. Cima de la pila (devuelve el elemento de la cima de la pila o top)
 * 
 * Implementa los m�todos necesarios, y recuerda hacer las pruebas precisas
 * 
 * @author Miguel Angel L�pez Moyano
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
	 * A�ade un elemento al final
	 * @param elemento que se a�adir�
	 */
	void push(T elemento){
		pila.add(elemento);
	}
	
	/**
	 * Elimina el �ltimo elemento
	 * @return elemento que se borrar�
	 * @throws PilaVaciaException 
	 */
	T pop() throws PilaVaciaException{
		try {
			return pila.remove(pila.size()-1);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new PilaVaciaException("La pila est� vac�a.");
		}
		
	}
	
	/**
	 * Devuelve el �ltimo elemento
	 * @return elemento
	 * @throws PilaVaciaException 
	 */
	T top() throws PilaVaciaException{
		try {
			return pila.get(pila.size()-1);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new PilaVaciaException("La pila est� vac�a.");
		}
		
	}
}
package listadoEstructurasDatos3.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Busca en la API de Java la collection Stack. Indica  su  nombre  completo,
 * explica  su utilidad y entrega un código donde demuestres su uso.
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class Stack {

	public static void main(String[] args) {
		Deque<Integer> stack = new ArrayDeque<Integer>();

		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		System.out.println("Cima de la pila: "+stack.peek());
		
		while(!stack.isEmpty()){
			System.out.println(stack.peek());
			System.out.println("Desapilo de la pila: " + stack.pop());
		}	
	}
}

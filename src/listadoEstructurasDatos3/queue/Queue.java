package listadoEstructurasDatos3.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Busca en la API de Java la collection Queue. Indica  su  nombre  completo, 
 * explica  su utilidad y entrega un código donde demuestres su uso.
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class Queue {

	public static void main(String[] args) {
		Deque<Integer> queue = new ArrayDeque<Integer>();
		
		queue.add(1);
		queue.add(2);
		queue.add(3);
		
		System.out.println("Primer elemento: "+queue.peek());
		
		while(!queue.isEmpty()){
			System.out.println(queue.peek());
			System.out.println("Saco de la cola: " + queue.poll());
		}	

	}
}

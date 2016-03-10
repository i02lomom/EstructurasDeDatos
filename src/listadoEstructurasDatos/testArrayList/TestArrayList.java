package listadoEstructurasDatos.testArrayList;
import java.util.ArrayList;
import java.util.Date;

/**
 * Implementa el siguiente trozo de código y contesta:
 * 
 * a. ¿Qué estructura de datos se instancia en este código? 
 * b. ¿En qué paquete se encuentra? 
 * c. Localiza el interfaz java.util.Collection que implementa e indica al 
 * menos  tres métodos implementados por la clase (signatura y descripción)
 * d. ¿Se permiten elementos duplicados? 
 * e. ¿Hay que saber su tamaño en su creación? 
 * f. ¿Es una estructura dinámica o estática? 
 * g. ¿Es una estructura homogénea o heterogénea? 
 * h. ¿Se utiliza el autoboxing?
 * i. ¿Existe algún Wrapper?
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class TestArrayList {

	public static void main(String[] args) {
		creación de una lista vacía
		ArrayList arrayList=new ArrayList();
		System.out.println("arrayList.isEmpty(): " +arrayList.isEmpty());
		
		//Se añaden distintos elementos de distintos tipos
		arrayList.add(1);
		arrayList.add(new String("hola"));
		arrayList.add(new String("hola"));
		arrayList.add(new Double(0));
		arrayList.add(new Date());

	}

}

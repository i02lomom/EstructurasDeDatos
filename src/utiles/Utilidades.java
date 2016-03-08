package utiles;

public class Utilidades{

	/**
	 * Genera un número entero aleatorio entre un mínimo y un máximo.
	 * 
	 * @param min valor mínimo que debe tomar el número generado
	 * @param max valor máximo que debe tomar el número generado
	 * @return número aleatorio generado
	 */
	public static int generarEnteroAleatorio(int min, int max){
		return (int)Math.round(Math.random()*(min-max)+max);
	}

	/**
	 * Genera un número decimal aleatorio entre un mínimo y un máximo.
	 * 
	 * @param min valor mínimo que debe tomar el número generado
	 * @param max valor máximo que debe tomar el número generado
	 * @return número aleatorio generado
	 */
	public static double generarDecimalAleatorio(int min, int max){
		return (Math.random()*(min-max)+max);
	}

	/**
	 * Pregunta al usuario si desea continuar pidiéndole un caracter (s/n)
	 * 
	 * @return true si la respuesta es 's' y false si es 'n'
	 */
	public static boolean deseaContinuar(){
		char respuesta;

        do{
            respuesta=Character.toLowerCase(Teclado.leerCaracter("\n¿Desea continuar? (s/n) "));
            if(respuesta!='s' && respuesta!='n')
            	System.out.println("\nError. Respuesta incorrecta.\n");
        }while (respuesta!='s' && respuesta!='n');

        if (respuesta=='s')
            return true;
        return false;
	}

	/**
	 * Crea un vector de enteros
	 * 
	 * @param tamano del vector
	 * @return vector creado
	 */
	static int [] crearVectorEnteros(int tamano){
		return new int [tamano];
	}

	/**
	 * Crea un vector de decimales
	 * 
	 * @param tamano del vector
	 * @return vector creado
	 */
	static double [] crearVectorDecimales(int tamano){
		return new double [tamano];
	}

	/**
	 * Muestra los elementos del vector desde el primero hasta el último
	 * 
	 * @param vector vector de enteros
	 */
	public static void mostrarVectorEnteros(int[] vector){
		System.out.print("\n");
		for(int i=0;i<vector.length;i++){
			System.out.println("a["+i+"] = "+vector[i]);
		}
	}
	/**
	 * Muestra los elementos de la matriz desde el principio hasta el final
	 * 
	 * @param matriz matriz de números enteros
	 */
	public static void mostrarMatrizEnteros(int[][] matriz){
		for(int i=0;i<matriz.length;i++){
			for(int j=0;j<matriz[i].length;j++){
				System.out.print("m["+i+"]["+j+"] = "+matriz[i][j]+"\t");
			}
			System.out.println("\n");
		}
	}

	/**
	 * Muestra los elementos de la matriz desde el principio hasta el final
	 * 
	 * @param matriz matriz de números decimales
	 */
	public static void mostrarMatrizDecimales(double[][] matriz){
		System.out.print("\n");
		for(int i=0;i<matriz.length;i++){
			for(int j=0;j<matriz[i].length;j++){
				System.out.printf("%s %d %s %d %s %.2f %s","m[",i,"][",j,"] = ",matriz[i][j],"\t");
			}
			System.out.print("\n");
		}
	}
}

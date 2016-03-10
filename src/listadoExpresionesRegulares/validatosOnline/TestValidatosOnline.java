package listadoExpresionesRegulares.validatosOnline;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import utiles.Teclado;

/**
 * Entrega TestValidatorOnline y compruébalo con las expresiones regulares:
 * 
 * a. hola
 * b. \sHola
 * c. hola{3}
 * d. (hola){3}
 * e. [hola]{3}
 * f. .bat
 * g. \.bat
 * h. \\.bat
 * i. \\hola
 * j. \whola
 * k. \Whola
 * l. ([A-Z][a-zA-Z]*)\s\1
 * m. \d\d
 * n. \b
 * o. \\b 
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class TestValidatosOnline {

	public static void main(String[] args) {
		while(true){
			Pattern pattern=Pattern.compile(Teclado
					.leerCadena("Introduzca la expresión regular: "));
			
			Matcher matcher=pattern.matcher(Teclado.
					leerCadena("Introduzca la cadena donde buscar: "));
			boolean found=false;
			while(matcher.find()){
				System.out.println("Se encontró el texto "+matcher.group()
						+ " que comienza en el índice " +matcher.start()
						+ " y finaliza en "+matcher.end());
				found=true;
			}
			if(!found)
				System.out.println("No se encuentra coincidencia.");
		}
	}
}

package listadoExpresionesRegulares.contrasena;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utiles.*;

/**
 * Diseña una aplicación en Java que reconozca una contraseña robusta(tantas 
 * veces como el usuario quiera).Según las directivas de nivel de dominio de 
 * Microsoft, para que una contraseña sea considerada segura, ha de cumplir 
 * una serie de instrucciones:
 * 
 * a. La contraseña tendrá una longitud de al menos seis caracteres.
 * b. La contraseña contendrá caracteres de tres de las cuatro categorías 
 * siguientes:
 * 
 * i. Caracteres en mayúsculas (A–Z)
 * ii. Caracteres en minúsculas (a–z)
 * iii. Base de 10 dígitos (0–9)
 * iv. Caracteres no alfanuméricos (por ejemplo: !, $, #, o %
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class TestContrasena {

	public static void main(String[] args) {
		Pattern pattern;
		Matcher matcher;
		boolean encontrado=false;
		
		do{
			pattern=Pattern.compile("(?=^.{6,}$)(?=.*\\d)(?=.*\\W+)(?=.*[A-Z])(?=.*[a-z]).*$");
			
			System.out.println("Una contraseña debe tener:\n"
					+ "Al menos seis caracteres\n"
					+ "Algún carácter en mayúsculas\n"
					+ "Algún dígito\n"
					+ "Algún caracter especial\n");
			matcher=pattern.matcher(Teclado
					.leerCadena("Introduzca una contraseña: "));
			while(matcher.find()){
				System.out.println("Contraseña correcta. "+matcher.group());
				encontrado=true;
			}
			if(!encontrado)
				System.out.println("Contraseña incorrecta.");
		}while(Utilidades.deseaContinuar());
	}
}

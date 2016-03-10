package listadoExpresionesRegulares.compruebaDatos;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utiles.*;

/**
 * Implementa un programa que permita comprobar cada uno de estos datos 
 * mediante expresiones regulares:
 * 
 * a. Dirección MAC
 * b. Dirección IP
 * c. Correo electrónico
 * d. Código postal
 * e. Número de cuenta corriente
 * f. DNI
 * 
 * Para  ello, solicita al usuario tres entradas distintas, dejando claro 
 * el  patrón que  vas a utilizar. Por ejemplo: 
 * 
 * Introduce una dirección MAC (XX:XX:XX:XX:XX:XX)
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class TestCompruebaDatos {
	static Pattern pattern;
	static Matcher matcher;
	
	public static void main(String[] args) {
		int opcion;
		Menu menu=new Menu("Comprueba datos",new String[]{
				"Dirección MAC",
				"Dirección IP",
				"Correo electrónico",
				"Código postal",
				"Número de cuenta corriente",
				"DNI"});
		
		do{
			opcion=menu.gestionarMenu();
			
			switch(opcion){
			case 1:
				direccionMac();
				break;
			case 2:
				direccionIp();
				break;
			case 3:
				correoElectronico();
				break;
			case 4:
				codigoPostal();
				break;
			case 5:
				cuentaCorriente();
				break;
			case 6:
				Dni();
				break;
			case 7:
				return;
			default:
				System.out.println("\nError. Opcion incorrecta");
			}		
		}while(opcion!=menu.getNumeroOpciones());
	}
	
	static void direccionMac(){
		boolean encontrado=false;
		pattern=Pattern.compile("^([0-9a-fA-F][0-9a-fA-F]:){5}([0-9a-fA-F][0-9a-fA-F])$");
		
		matcher=pattern.matcher(Teclado
				.leerCadena("Introduzca una dirección MAC(XX:XX:XX:XX:XX:XX): "));
		while(matcher.find()){
			System.out.println("Dirección MAC correcta. "+matcher.group());
			encontrado=true;
		}
		if(!encontrado)
			System.out.println("Dirección incorrecta.");
	}
	
	static void direccionIp(){
		boolean encontrado=false;
		
		pattern=Pattern.compile("^(([1-9]?[0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5]).){3}"
				+ "([1-9]?[0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");
		matcher=pattern.matcher(Teclado
				.leerCadena("Introduzca una dirección IP(XXX.XXX.XXX.XXX): "));
		while(matcher.find()){
			System.out.println("Dirección IP correcta. "+matcher.group());
			encontrado=true;
		}
		if(!encontrado)
			System.out.println("Dirección incorrecta.");
	}
	
	static void correoElectronico(){
		boolean encontrado=false;
		
		pattern=Pattern.compile("^[a-z0-9]+([\\._a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})$");
		matcher=pattern.matcher(Teclado
				.leerCadena("Introduzca una dirección de correo(XXX@XXX.XXX): "));
		while(matcher.find()){
			System.out.println("Dirección de correo correcta. "+matcher.group());
			encontrado=true;
		}
		if(!encontrado)
			System.out.println("Dirección incorrecta.");
	}
	
	static void codigoPostal(){
		boolean encontrado=false;
		
		pattern=Pattern.compile("([0-4][1-9][0-9][0-9][1-9])|([0-4][1-9][0-9][1-9][0-9])|([0-4][1-9][1-9][0-9][0-9])"
				+ "|(5[0-2][0-9][0-9][1-9])|(5[0-2][0-9][1-9][0-9])|(5[0-2][1-9][0-9][0-9])");
		matcher=pattern.matcher(Teclado
				.leerCadena("Introduzca un código postal(XXXXX): "));
		while(matcher.find()){
			System.out.println("Código postal correcto. "+matcher.group());
			encontrado=true;
		}
		if(!encontrado)
			System.out.println("Código postal incorrecta.");
	}
	
	static void cuentaCorriente(){
		boolean encontrado=false;
		
		pattern=Pattern.compile("");
		matcher=pattern.matcher(Teclado
				.leerCadena("Introduzca una cuenta corriente (ESXX XXXX XXXX XXXX XXXX XXXX): "));
		while(matcher.find()){
			System.out.println("Cuenta corriente correcta. "+matcher.group());
			encontrado=true;
		}
		if(!encontrado)
			System.out.println("Cuenta corriente incorrecta.");
	}
	
	static void Dni(){
		boolean encontrado=false;
		
		pattern=Pattern.compile("(\\d{8})([-]?)([A-Z]{1})");
		matcher=pattern.matcher(Teclado
				.leerCadena("Introduzca un DNI(11223344A): "));
		while(matcher.find()){
			System.out.println("DNI correcto. "+matcher.group());
			encontrado=true;
		}
		if(!encontrado)
			System.out.println("DNI incorrecto.");
	}
	
}

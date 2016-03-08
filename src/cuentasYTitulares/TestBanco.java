package cuentasYTitulares;
import utiles.*;

/**
 * Programa que gestiona las cuentas de un banco. El programa debe permitir:
 * 
 * - Crear una cuenta
 * - Eliminar una cuenta
 * - Realizar ingresos
 * - Realizar reintegros
 * - Realizar transferencias
 * - Mostrar todas las cuentas
 * - Mostrar todas las cuentas de un cliente
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class TestBanco {
	static Banco banco=new Banco();
	
	public static void main(String[] args) {
		int opcion;
		Menu menu=new Menu("Banco",new String[]{
				"Crear cuenta",
				"Eliminar cuenta",
				"Realizar ingreso",
				"Sacar dinero",
				"Transferencia",
				"Mostrar lista",
				"Mostrar cuentas de cliente"});

		do{
			opcion=menu.gestionarMenu();
			
			switch(opcion){
			case 1:
				crearCuenta();
				break;
			case 2:
				eliminarCuenta();
				break;
			case 3:
				ingresarDinero();
				break;
			case 4:
				sacarDinero();
				break;
			case 5:
				realizarTransferencia();
				break;
			case 6:
				System.out.println(banco);
				break;
			case 7:
				mostrarCuentasCliente();
				break;
			case 8:
				return;
			default:
				System.out.println("\nError. Opcion incorrecta");
			}		
		}while(opcion!=menu.getNumeroOpciones());
	}

	/**
	 * Crea una cuenta siempre que los datos sean correctos
	 */
	static void crearCuenta(){
		char respuesta;
		Cuenta cuenta=null;
		Persona persona=null;
		try {
			String dni=Teclado.leerCadena("Introduzca el DNI: ");
			persona=banco.comprobarCliente(new Persona(dni));
				
			if(persona!=null){
				System.out.println("\n"+persona.toString());
				System.out.println("\nSe ha encontrado un cliente con ese DNI.");
				respuesta=Teclado.leerCaracter("\n¿Desea utilizar esos mismos datos? (s/n): ");
				if(respuesta=='s'|| respuesta=='S'){
					cuenta=new Cuenta(Teclado.leerDecimal("Introduzca el saldo: "),
							persona);
						
					if(banco.anadir(cuenta)){
						System.out.println("Cuenta añadida.");
					}
					else
						System.out.println("No se ha podido añadir la cuenta.");
					return;
				}
			}
			
			cuenta=new Cuenta(Teclado.leerDecimal("Introduzca el saldo: "),
					new Persona(Teclado.leerCadena("Introduzca el nombre: "),
							dni,
							Teclado.leerCadena("Introduzca la dirección: ")));
				
			if(banco.anadir(cuenta))
				System.out.println("Cuenta añadida.");
				
			else
				System.out.println("No se ha podido añadir la cuenta.");
		} catch (SaldoNegativoException | NombreNoValidoException | DniNoValidoException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Elimina una cuenta
	 */
	static void eliminarCuenta(){
		Cuenta cuenta=null;
		
		cuenta= new Cuenta(Teclado.leerEntero("Introduzca el número de cuenta: "));
		banco.eliminar(cuenta);
	}
	
	/**
	 * Realiza un ingreso siempre y cuando exista la cuenta
	 */
	static void ingresarDinero(){
		Cuenta cuenta= new Cuenta(Teclado.leerEntero("Introduzca el número de cuenta: "));
		double cantidad=Teclado.leerDecimal("Introduzca el importe a ingresar: ");
		
		try {
			banco.ingresar(cuenta,cantidad);
			System.out.println("Ingreso realizado.");
		} catch (NoExisteEsaCuentaException | SaldoNegativoException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Saca dinero de una cuenta siempre que exista la cuenta
	 */
	static void sacarDinero(){
		Cuenta cuenta= new Cuenta(Teclado.leerEntero("Introduzca el número de cuenta: "));
		double cantidad=Teclado.leerDecimal("Introduzca el importe a sacar: ");
		
		try {
			banco.sacar(cuenta,cantidad);
			System.out.println("Reintegro realizado.");
		} catch (ReintegroNoValidoException | NoExisteEsaCuentaException | SaldoNegativoException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Realiza una transferencia entre dos cuentas
	 */
	static void realizarTransferencia(){
		int origen=Teclado.leerEntero("Introduzca el número de cuenta de origen: ");
		int destino=Teclado.leerEntero("Introduzca el número de cuenta de destino: ");
		
		if(origen==destino)
			System.out.println("ERROR. No se puede realizar la transferencia.\n"
					+ "La cuenta origen y la cuenta destino son la misma.");
		else{
			Cuenta cuentaOrigen=new Cuenta(origen);
			Cuenta cuentaDestino=new Cuenta(destino);
			
			double cantidad=Teclado.leerDecimal("Introduzca el importe a transferir: ");
			
			try {
				if(banco.transferir(cuentaOrigen, cuentaDestino, cantidad))
					System.out.println("Transferencia realizada.");
			} catch (TransferenciaNoValidaException | SaldoNegativoException | NoExisteEsaCuentaException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	/**
	 * Muestra las cuentas de un cliente siempre que exista el cliente
	 */
	static void mostrarCuentasCliente(){
		try {
			String dni=Teclado.leerCadena("Introduzca el DNI: ");
			banco.mostrarCuentas(new Persona(dni));
		} catch (DniNoValidoException e) {
			System.out.println(e.getMessage());
		}
	}
}

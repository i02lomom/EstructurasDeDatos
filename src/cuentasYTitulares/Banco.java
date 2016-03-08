package cuentasYTitulares;
import java.util.ArrayList;
import java.util.Iterator;

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
public class Banco {
	/**
	 * Lista de cuentas
	 */
	private ArrayList<Cuenta> banco=null;
	
	/**
	 * Constructor
	 */
	Banco(){
		banco=new ArrayList<Cuenta>();
	}
	
	/**
	 * Añade una cuenta a la lista si no existe previamente
	 * @param cuenta a añadir
	 * @return true si se añade la cuenta y false si no la añade por existir previamente
	 */
	boolean anadir(Cuenta cuenta){
		if(banco.contains(cuenta))
			return false;
		banco.add(cuenta);
		return true;
	}
	
	/**
	 * Elimina una cuenta
	 * @param cuenta
	 * @return true si la elimina, false si no existe esa cuenta
	 */
	boolean eliminar(Cuenta cuenta){
		return banco.remove(cuenta);
	}
	
	/**
	 * Realiza un ingreso en la cuenta indicada siempre que esta exista
	 * @param cuenta
	 * @param cantidad
	 * @return true si se realiza correctamente el ingreso
	 * @throws NoExisteEsaCuentaException
	 * @throws SaldoNegativoException 
	 */
	void ingresar(Cuenta cuenta,double cantidad) throws NoExisteEsaCuentaException, SaldoNegativoException{
		try {
			cuenta = banco.get(banco.indexOf(cuenta));
			cuenta.ingresar(cantidad);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new NoExisteEsaCuentaException("No existe esa cuenta.");
		}
	}
	
	/**
	 * Saca dinero de la cuenta indicada siempre que esta exista y tenga saldo suficiente
	 * @param cuenta
	 * @param cantidad
	 * @return true si se saca correctamente la cantidad
	 * @throws ReintegroNoValidoException
	 * @throws NoExisteEsaCuentaException
	 * @throws SaldoNegativoException 
	 */
	void sacar(Cuenta cuenta,double cantidad) throws ReintegroNoValidoException, NoExisteEsaCuentaException, SaldoNegativoException{
		try {
			cuenta = banco.get(banco.indexOf(cuenta));
			cuenta.sacar(cantidad);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new NoExisteEsaCuentaException("No existe esa cuenta.");
		}
	}
	
	/**
	 * Realiza una transferencia entre dos cuentas siempre que existan las cuentas y
	 * el saldo sea suficiente
	 * @param cuentaOrigen
	 * @param cuentaDestino
	 * @param cantidad
	 * @return true si se realiza correctamente la transferencia
	 * @throws TransferenciaNoValidaException
	 * @throws SaldoNegativoException
	 * @throws NoExisteEsaCuentaException
	 */
	boolean transferir(Cuenta cuentaOrigen,Cuenta cuentaDestino,double cantidad) throws TransferenciaNoValidaException, SaldoNegativoException, NoExisteEsaCuentaException{
		try {
			cuentaOrigen = banco.get(banco.indexOf(cuentaOrigen));
			cuentaDestino = banco.get(banco.indexOf(cuentaDestino));
			cuentaOrigen.transferir(cantidad, cuentaDestino);
			return true;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new NoExisteEsaCuentaException("No existe esa cuenta.");
		}
	}
	
	/**
	 * Comprueba si exsite en la lista de cuentas el cliente con el DNI indicado
	 * @param persona
	 * @return titular si encuentra el cliente, null si no se encuentra
	 */
	Persona comprobarCliente(Persona persona){
		Cuenta cuenta=null;
		Iterator<Cuenta> iterator=banco.iterator();
		while (iterator.hasNext()) {
			cuenta = (Cuenta) iterator.next();
			if(cuenta.getTitular().equals(persona))
				return cuenta.getTitular();
		}
		return null;
	}
	
	/**
	 * Muestra las cuentas de un cliente
	 * @param persona
	 */
	void mostrarCuentas(Persona persona){
		boolean encontrado=false;
		Cuenta cuenta=null;
		Iterator<Cuenta> iterator=banco.iterator();
		while (iterator.hasNext()) {
			cuenta = (Cuenta) iterator.next();
			if(cuenta.getTitular().equals(persona)){
				encontrado=true;
				System.out.println(cuenta);
			}
		}
		if(!encontrado)
			System.out.println("No se ha encontrado un cliente con ese DNI.");
	}

	@Override
	
	public String toString() {
		return banco.toString();
	}
}

package cuentaYTitulares;

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

public class Cuenta {
	/**
	 * Número de identificación de la cuenta
	 */
	private int id;
	
	/**
	 * Saldo de la cuenta
	 */
	private double saldo;
	
	/**
	 * Titular de la cuenta
	 */
	private Persona titular;
	
	private static int contador;
	
	/**
	 * Constructor al que se la pasa la id
	 * @param id
	 */
	Cuenta(int id){
		setId(id);
	}
	
	/**
	 * Constructor al que se le pasa un titular (persona)
	 * @param titular
	 */
	Cuenta(Persona titular){
		setTitular(titular);
	}
	
	/**
	 * Constructor al que se le pasa la id, el saldo y el titular
	 * @param id
	 * @param saldo
	 * @param titular
	 * @throws SaldoNegativoException
	 */
	Cuenta(double saldo,Persona titular) throws SaldoNegativoException{
		setId();
		setSaldo(saldo);
		setTitular(titular);
	}

	public int getId() {
		return id;
	}

	private void setId() {
		this.id = ++contador;
	}
	
	private void setId(int id){
		this.id=id;
	}

	public double getSaldo() {
		return saldo;
	}

	/**
	 * Escribe el saldo siempre que sea positivo
	 * @param saldo
	 * @throws SaldoNegativoException
	 */
	private void setSaldo(double saldo) throws SaldoNegativoException {
		if(saldo<0)
			throw new SaldoNegativoException("Saldo no válido");
		this.saldo = saldo;
	}

	public Persona getTitular() {
		return titular;
	}

	private void setTitular(Persona titular) {
		this.titular = titular;
	}

	@Override
	public String toString() {
		return "\nCuenta: " + id + ", " + saldo + ", " + titular;
	}
	
	/**
	 * Añade una cantidad al saldo de la cuenta
	 * @param cantidad
	 * @throws SaldoNegativoException 
	 */
	public void ingresar(double cantidad) throws SaldoNegativoException{
		setSaldo(getSaldo()+cantidad);
	}
	
	/**
	 * Resta una cantidad al saldo de la cuenta
	 * @param cantidad
	 * @throws ReintegroNoValidoException
	 * @throws SaldoNegativoException 
	 */
	public void sacar(double cantidad) throws ReintegroNoValidoException, SaldoNegativoException{
		if(cantidad>saldo)
			throw new ReintegroNoValidoException("ERROR. No se ha podido realizar el reintegro. Saldo insuficiente.");
		setSaldo(getSaldo()-cantidad);
	}
	
	/**
	 * Transfiere una cantidad a otra cuenta. Se resta la cantidad de la cuenta origen y se suma a la
	 * cuenta destino siempre y cuando el saldo de la cuenta origen no quede en números rojos.
	 * @param cantidad
	 * @param cuentaDestino
	 * @throws TransferenciaNoValidaException
	 * @throws SaldoNegativoException
	 */
	public void transferir(double cantidad,Cuenta cuentaDestino) throws TransferenciaNoValidaException, SaldoNegativoException{
		if(cantidad>saldo)
			throw new TransferenciaNoValidaException("ERROR. No se ha podido realizar la transferencia. Saldo insuficiente.");
		setSaldo(this.saldo - cantidad);
		cuentaDestino.setSaldo(cuentaDestino.getSaldo() + cantidad);
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public String mostrar(){
		return toString();
	}
}

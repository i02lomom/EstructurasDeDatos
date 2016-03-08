package cuentasYTitulares;

public class TransferenciaNoValidaException extends Exception {
	private static final long serialVersionUID = 1L;

	public TransferenciaNoValidaException(String string){
		super(string);
	}
}

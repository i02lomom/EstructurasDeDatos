package cuentasYTitulares;

public class SaldoNegativoException extends Exception {
	private static final long serialVersionUID = 1L;

	public SaldoNegativoException(String string){
		super(string);
	}
}

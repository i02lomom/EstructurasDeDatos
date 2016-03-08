package cuentasYTitulares;

public class NoExisteEsaCuentaException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public NoExisteEsaCuentaException(String string){
		super(string);
	}
}

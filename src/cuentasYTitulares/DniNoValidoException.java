package cuentasYTitulares;

public class DniNoValidoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public DniNoValidoException(String string){
		super(string);
	}
}

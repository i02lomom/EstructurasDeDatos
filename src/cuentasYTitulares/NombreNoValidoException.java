package cuentasYTitulares;

public class NombreNoValidoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public NombreNoValidoException(String string){
		super(string);
	}
}

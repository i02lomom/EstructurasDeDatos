package listadoEstructurasDatos3.listaDeLaCompra;

public class NoExisteArticuloException extends Exception {
	private static final long serialVersionUID = 1L;

	public NoExisteArticuloException(String string) {
		super(string);
	}
}

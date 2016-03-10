package listadoEstructurasDatos3.listaDeLaCompra;

/**
 * Implementa  un  programa  que  gestione  una  lista  de  la  compra  de 
 * forma  automática.  Se  dispondrá  de  una  lista  de  artículos  y  de
 * sus  existencias.  En  el momento  en  el  que  la  cantidad  de  artículos
 * llegue  a  un  límite  mínimo,  dicho  artículo aparecerá en la lista de la 
 * compra. Cada vez que el usuario utilice uno de los artículos se 
 * decrementarán  las  existencias  de  dicho  artículo.  De  igual  forma, 
 * cada  vez  que  el usuario compre el artículo, se incrementarán las 
 * existencias de dicho artículo. 
 * 
 * Quizás sea interesante añadir un campo código del artículo para facilitar
 * la gestión de la lista. Este código ha de ser único (static...)
 * Para ello, genera un interfaz con el usuario que permita entre otras 
 * acciones:
 * 
 * e. Añadir un producto nuevo a la lista.
 * f. Eliminar un elemento de la lista.
 * g. Incrementar las existencias de un artículo.
 * h. Decrementar las existencias de un artículo.
 * i. Modificar la cantidad mínima del artículo.
 * j. Mostrar la lista de todos los artículos.
 * k. Mostrar la lista de la compra
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class Articulo {
	/**
	 * Nombre del artículo
	 */
	private String nombre;
	
	/**
	 * Cantidad de artículos 
	 */
	private int existencias;
	
	/**
	 * Cantidad mínima de artículos
	 */
	private int minimo;
	
	/**
	 * Constructor que recibe el nombre, las existencias y el mínimo
	 * @param nombre del artículo
	 * @param existencias cantidad de artículos
	 * @param minimo cantidad mínima
	 */
	public Articulo(String nombre,int existencias,int minimo) throws Exception{
		setNombre(nombre);
		setExistencias(existencias);
		setMinimo(minimo);
	}
	
	/**
	 * Constructor que recibe el nombre del artículo
	 * @param nombre
	 * @throws NombreNoValidoException 
	 */
	public Articulo(String nombre) throws NombreNoValidoException{
		setNombre(nombre);
	}
	
	/**
	 * Incrementa las existencias del artículo en la cantidad indicada
	 * @param incremento
	 * @throws ExistenciasNoValidasException 
	 */
	void incrementar(int incremento) throws IncrementoNoValidoException, ExistenciasNoValidasException{
		if(incremento>=0)
			setExistencias(getExistencias() + incremento);
		else
			throw new IncrementoNoValidoException("El incremento no puede ser negativo.");
	}
	
	/**
	 * Decrementa las existencias del artículo en la cantidad indicada
	 * @param decremento
	 * @throws ExistenciasNoValidasException 
	 * @throws DecrementoNoValidoException 
	 */
	void decrementar(int decremento) throws ExistenciasNoValidasException, DecrementoNoValidoException{
		if(decremento>=0)
			setExistencias(getExistencias() - decremento);
		else
			throw new DecrementoNoValidoException("El decremento no puede ser negativo.");
	}
	
	/**
	 * Devuelve true si el artículo tiene el número de existencias por
	 * debajo del mínimo y false en caso contrario
	 * @return true o false
	 */
	public boolean porDebajoDelMinimo() {
		if(getExistencias()<getMinimo())
			return true;
		return false;
	}

	/**
	 * Lee el nombre del artículo
	 * @return nombre
	 */
	String getNombre() {
		return nombre;
	}

	/**
	 * Escribe el nombre del artículo
	 * @param nombre
	 * @throws NombreNoValidoException 
	 */
	private void setNombre(String nombre) throws NombreNoValidoException {
		if(nombre.length()!=0)
			this.nombre = nombre;
		else
			throw new NombreNoValidoException("El nombre no es válido.");
	}

	/**
	 * Lee el número de existencias del artículo
	 * @return
	 */
	int getExistencias() {
		return existencias;
	}

	/**
	 * Escribe el número de existencias
	 * @param existencias
	 * @throws ExistenciasNoValidasException 
	 */
	private void setExistencias(int existencias) throws ExistenciasNoValidasException {
		if(existencias>=0)
			this.existencias = existencias;
		else
			throw new ExistenciasNoValidasException("Las existencias no pueden ser negativas");
	}

	/**
	 * Lee el mínimo
	 * @return minimo
	 */
	int getMinimo() {
		return minimo;
	}

	/**
	 * Escribe el mínimo
	 * @param minimo
	 * @throws MinimoNoValidoException 
	 */
	void setMinimo(int minimo) throws MinimoNoValidoException {
		if(minimo>=0)
			this.minimo = minimo;
		else
			throw new MinimoNoValidoException("El mínimo no puede ser negativo.");
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + "\nExistencias: " + existencias + "\nMinimo: " + minimo + "\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Articulo other = (Articulo) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
}

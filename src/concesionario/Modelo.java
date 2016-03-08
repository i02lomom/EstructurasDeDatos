package concesionario;

public enum Modelo {
	SERIE1(Marca.BMV),
	SERIE2(Marca.BMV),
	SERIE3(Marca.BMV),
	SERIE5(Marca.BMV),
	
	CORDOBA(Marca.SEAT),
	IBIZA(Marca.SEAT),
	TOLEDO(Marca.SEAT);
	
	/**
	 * Atributo que indica la marca del modelo
	 */
	private Marca marca;
	
	/**
	 * Array que contiene los modelos
	 */
	private static final Modelo[] VALUES=values();
	
	/**
	 * Constructor que recibe la marca
	 * @param marca
	 */
	private Modelo(Marca marca){
		this.marca=marca;
	}

	public Marca getMarca(){
		return marca;
	}
	
	/**
	 * Genera las opciones del menú de modelos y añade la opción salir
	 * @return array de opciones
	 */
	public String[] OpcionesMenu(){
		int i=0;
		String[] opcionesMenu=new String[VALUES.length];
		
		for(Modelo modelo:VALUES)
			opcionesMenu[i++]=modelo.name();
		
		return opcionesMenu;
	}
	
	/**
	 * Devuelve un array con los posibles modelos
	 * @return array de modelos
	 */
	public Modelo[] getValues(){
		return VALUES;
	}
}

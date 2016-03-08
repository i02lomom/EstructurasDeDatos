package concesionario;

public enum Color {
	AZUL,
	ROJO,
	PLATA;
	
	/**
	 * Array que contiene los colores
	 */
	private static final Color[] VALUES=Color.values();
	
	/**
	 * Genera las opciones del menú de colores y añade la opción salir
	 * @return array de opciones
	 */
	public String[] OpcionesMenu(){
		int i=0;
		String[] opcionesMenu=new String[VALUES.length];
		
		for(Color color:VALUES)
			opcionesMenu[i++]=color.name();
		
		return opcionesMenu;
	}
	
	/**
	 * Devuelve un array con los posibles colores
	 * @return array de modelos
	 */
	public Color[] getValues(){
		return VALUES;
	}
}

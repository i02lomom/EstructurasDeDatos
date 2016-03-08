package concesionario;

import java.util.regex.Pattern;

public class Coche {
	/**
	 * Matrícula del coche
	 */
	private String matricula;
	
	/**
	 * Color del coche
	 */
	private Color color;
	
	/**
	 * Modelo del coche
	 */
	private Modelo modelo;
	
	/**
	 * Constructor que recibe la matrícula
	 * @param matricula
	 * @throws MatriculaNoValidaException
	 */
	Coche(String matricula) throws MatriculaNoValidaException{
		setMatricula(matricula);
	}
	
	/**
	 * Constructor que recibe la matrícula, el color y el 
	 * @param matricula
	 * @param color
	 * @param modelo
	 */
	Coche(String matricula,Color color,Modelo modelo) throws Exception{
		setMatricula(matricula);
		setColor(color);
		setModelo(modelo);
	}

	/**
	 * Escribe la matrícula siempre que sea válida
	 * @param matricula
	 * @throws MatriculaNoValidaException
	 */
	private void setMatricula(String matricula) throws MatriculaNoValidaException {
		if(!comprobarMatricula(matricula))
			throw new MatriculaNoValidaException("Matrícula no válida.");
		this.matricula = estandarizarMatricula(matricula);
	}

	/**
	 * Lee el color del coche
	 * @return color del coche
	 */
	Color getColor(){
		return color;
	}
	
	/**
	 * Escribe el color siempre que sea válido
	 * @param color
	 * @throws ColorNoValidoException
	 */
	private void setColor(Color color) throws ColorNoValidoException {
		if(color==null)
			throw new ColorNoValidoException("Color no válido.");
		this.color = color;
	}

	/**
	 * Escribe el modelo siempre que éste sea válido
	 * @param modelo
	 * @throws ModeloNoValidoException
	 */
	private void setModelo(Modelo modelo) throws ModeloNoValidoException {
		if(modelo==null)
			throw new ModeloNoValidoException("Modelo no válido");
		this.modelo = modelo;
	}
	
	@Override
	public String toString() {
		return "\nMatricula: " + matricula + "\nColor: " + color + "\nModelo: " + modelo + "\n";
	}

	/**
	 * Comprueba el patrón de la matrícula
	 * @param matricula
	 * @return true si cumple el patrón y false si no
	 */
	private boolean comprobarMatricula(String matricula){
		Pattern pattern=Pattern.compile("^\\d{4}[ -]?[[B-Z]&&[^QEIOU]]{3}$");
		return pattern.matcher(matricula).matches();
	}
	
	/**
	 * Elimina los espacios y los guiones a la matrícula para almacenarla
	 * @param matricula
	 * @return
	 */
	private String estandarizarMatricula(String matricula) {
		assert comprobarMatricula(matricula);
		return matricula.replaceAll("[ -]", "");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
		Coche other = (Coche) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
}

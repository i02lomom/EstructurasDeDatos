package utiles;
import java.util.regex.Pattern;

public enum RegEx {
	NOMBRE(
		"(?i)"
		+ "^[a-záéíóú ,.'-]+$",
		"Puede contener letras, guión alto, espacio, coma y punto"),
	
	DIRECCION_MAC(
		"(?i)"
		+ "^(([0-9a-f]{2}:){5}"
		+ "[0-9a-f]{2})$",
		"XX:XX:XX:XX:XX:XX (X=números hexadecimales, números y letras de a A a la F)"),
	
	DNI(
		"(?i)(\\d{8})([A-Z&&[^IOU]])",
		"XXXXXXXXA (X=números, sin guiones o espacio)"),
	
	MATRICULA(
		"(?i)^\\d{4}[ -]?[[B-Z]&&[^QEIOU]]{3}$",
		"XXXXBCD (X=números, admite guión o espacio antes de las letras");
	
	public static final String LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";
	
	/**
	 * Expresión regular
	 */
	private String regEx;
	
	/**
	 * Comentario
	 */
	private String comentario;
	
	/**
	 * Patrón
	 */
	private Pattern pattern;

	/**
	 * Constructor al que se le pasa la expresión regular y el comentario
	 * @param regEx
	 * @param comentario
	 */
	RegEx(String regEx, String comentario) {
		this.setRegEx(regEx);
		this.setComentario(comentario);
		this.pattern = Pattern.compile(regEx);
	}

	public String getRegEx() {
		return regEx;
	}

	private void setRegEx(String regEx) {
		this.regEx = regEx;
	}

	public String getComentario() {
		return comentario;
	}

	private void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Pattern getPattern() {
		return pattern;
	}
	
	public boolean comprobarLetraDni(String dni){
		char letra = dni.charAt(8);
		int numero = Integer.parseInt(dni.substring(0,8));
		if(letra!=LETRAS_DNI.charAt(numero%23))
			return false;
		return true;
	}
	
	/**
	 * Comprueba si la cadena coincide
	 * @param string
	 * @return true si coincide y false si no coincide
	 */
	public boolean comprobar(String string) {
		return pattern.matcher(string).matches();
	}
}

package listadoEstructurasDatos3.topMusic;

public class Cancion {
	/**
	 * Título de la canción
	 */
	private String titulo;
	
	/**
	 * Nombre del artista
	 */
	private String artista;
	
	/**
	 * Año de grabación
	 */
	private int anno;
	
	/**
	 * Constructor que recibe el título, el artista y el año
	 * @param titulo de la canción
	 * @param artista
	 * @param anno de grabación
	 */
	public Cancion(String titulo,String artista,int anno){
		setTitulo(titulo);
		setArtista(artista);
		setAnno(anno);
	}

	/**
	 * Lee el título de la canción
	 * @return titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Escribe el título de la canción
	 * @param titulo
	 */
	private void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Lee el nombre del artista
	 * @return artista
	 */
	public String getArtista() {
		return artista;
	}

	/**
	 * Escribe el nombre del artista
	 * @param artista
	 */
	private void setArtista(String artista) {
		this.artista = artista;
	}

	/**
	 * Lee el año de grabación
	 * @return anno
	 */
	public int getAnno() {
		return anno;
	}

	/**
	 * Escribe al año de grabación
	 * @param anno
	 */
	private void setAnno(int anno) {
		this.anno = anno;
	}

	@Override
	public String toString() {
		return "Titulo: " + titulo + "\nArtista: " + artista + "\nAño: " + anno + "\n";
	}
}

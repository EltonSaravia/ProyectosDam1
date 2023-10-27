package modelo;

public class Pelicula {

	private String titulo;
	private Genero genero;
	private boolean prestada;
	
	
	protected Pelicula(String titulo,Genero genero) {
		
		this.titulo = titulo;
		this.genero = genero;
		this.prestada = false;
	}
}

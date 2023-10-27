package practica_herencia_ej1;

public class Disco extends Multimedia {
	
	/*
	 * atributos
	 */
	private String genre ;
	/*
	 * constructor 
	 */
	public Disco (String genre,String tittle,String author, double duration, Format format) {
		super( tittle, author,  duration,  format);
		this.genre = genre;
		
	}
	/*
	 * metodo para devolver el  genero de musica del cd 
	 */
	@Override
	public String getGenre() {
		return this.genre;
	}
	
	/*
	 * metodos tostring para ver los atributos de multimedia y ademas el  atributo
	 * genero
	 */
	@Override
	public String toString() {
		return super.toString() + "\ngenre: " + genre ;
	}

	
	
}

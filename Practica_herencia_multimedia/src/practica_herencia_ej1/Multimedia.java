package practica_herencia_ej1;

import java.util.Objects;

public abstract class Multimedia {
	
	/*
	 * atributos
	 */
	private String tittle ;
	private String author ;
	private double duration ;
	private Format format;
	/*
	 * CONSTRUCTOR
	 */
	public Multimedia (String tittle,String author, double duration, Format format) {
		this.tittle = tittle;
		this.author = author;
		this.duration = duration;
		this.format = format;
	}
	
	public Multimedia () {
		this.tittle = "no hay titulo insertado";
		this.author = "no hay autor insertado";
		this.duration = 0;
		this.format = format.MP3;
	}
	/*
	 * METODOS PARA DEVOLVER LOS VALORES 
	 */
	public String getTittle() {
		return tittle;
	}
	public String getAuthor() {
		return author;
	}
	public double getDuration() {
		return duration;
	}
	public Format getFormat() {
		return format;
	}
	@Override
	public String toString() {
		return "\n\nTittle: " + tittle + "\nAuthor: " + author + "\nDuration:" + duration + "\nFormat:" + format;
	}

	
	/*
	 * metodo wquals para comparar dos objetos multimedia por su autor y titulo
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Multimedia other = (Multimedia) obj;
		return Objects.equals(author, other.author) && Objects.equals(tittle, other.tittle);
	}

	public String getGenre() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getActriz_principal() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}















































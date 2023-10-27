package practica_herencia_ej1;
import java.util.*;

public  class ListaMultimedia {
	/*
	 * atributos
	 */
	private ArrayList<Multimedia> listaCompleta ; 
	/*
	 * constructor 
	 */
	public ListaMultimedia() {
		this.listaCompleta = new ArrayList<Multimedia>();
	}
	/*
	 * metodo para añadir objetos a la lista
	 */
	 public void addMultimediaALista (Multimedia nuevaMultimedia) {
		 this.listaCompleta.add(nuevaMultimedia);
	 } 
	 /*
	  * metodo para añadir disco
	  */
	 public void createDisk (String genre,String tittle,String author, double duration, Format format) {
		 Disco newDisk = new Disco( genre, tittle, author,  duration,  format);
		 addMultimediaALista(newDisk);
	 }
	 /*
	  * metodo para añadir una pelicula
	  */
	 public void createFilm (String actor_principal, String actriz_principal,String tittle,String author, double duration, Format format) {
		 Pelicula newFilm = new Pelicula( actor_principal,  actriz_principal, tittle, author,  duration,  format);
		 addMultimediaALista(newFilm);
	 }
	 /*
	  * suma la duracion de los elmentos multimedia de la lista 
	  */
	 public double sumElemt() {
		 double total  = 0;
		 for(Multimedia objeto : this.listaCompleta) {
			 total += objeto.getDuration();
			}
		 return total;
	 }
	 /*
	  * busca todos los elementos con genero rock, por lo cual solo debe encontrar cds
	  */
	 
	 public int sumaGenre(String searching) {
		 int sumGenre = 0;
		 for(Multimedia objeto : this.listaCompleta) {
			 if (objeto.getGenre() == searching) {
				 sumGenre++;
			 }	 
			}
		 return sumGenre;
	 }
	 
	 /*
	  * este metodo busca si las pelicula tiene actriz principal 
	  * y si no la tiene muestra el titulo multimedia
	  */
	 public int  moviesNoActress() {
		 int totalMoviesWithoutActress = 0;
		 ArrayList<Multimedia> listaAux =  new ArrayList<Multimedia>();
		 for(Multimedia objeto : this.listaCompleta) {
			 if (objeto instanceof Pelicula){
				 listaAux.add(objeto);
			    }
		 }
		 for(Multimedia movieFind : listaAux) {
			 if (movieFind.getActriz_principal() == null) {
				 totalMoviesWithoutActress++; 
			 }
		 }
		 return totalMoviesWithoutActress ;
	 }
	 

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListaMultimedia other = (ListaMultimedia) obj;
		return Objects.equals(listaCompleta, other.listaCompleta);
	}

	@Override
	public String toString() {
		return "List of my multimedia: " + listaCompleta ;
	}
	 
	
	 
	 
	 
}

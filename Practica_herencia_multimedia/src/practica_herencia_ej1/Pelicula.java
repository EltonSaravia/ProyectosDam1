package practica_herencia_ej1;

public class Pelicula extends Multimedia {
 /*
  * atributos
  */
	private String actor_principal;
	private String actriz_principal;
	
	/*
	 * contructor 
	 */
	public Pelicula (String actor_principal, String actriz_principal,String tittle,String author, double duration, Format format) {
		super( tittle, author,  duration,  format);
		 if (actor_principal == null && actriz_principal == null) {
	            throw new IllegalArgumentException("Ambos valores no pueden ser nulos");
		 }else {
				this.actor_principal = actor_principal;	
				this.actriz_principal =  actriz_principal;
		 }
	}
	/*
	 * metodos para obtener los datos 
	 */

	public String getActor_principal() {
		return actor_principal;
	}

	public String getActriz_principal() {
		return actriz_principal;
	}
	
	/*
	 * metodo para mostrar la informacion 
	 */
	@Override
	public String toString() {
		return super.toString() + "\nActor principal: " + this.actor_principal
				+	"\nActriz: " + this.actriz_principal;
	}


	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

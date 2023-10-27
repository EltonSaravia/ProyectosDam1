package modelo;

import java.util.ArrayList;

public class Cliente {

	private String dni;
	private String nombre;
	ArrayList<Pelicula> peliculasTiene;
	
	public Cliente (String dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
		this.peliculasTiene = new ArrayList <Pelicula>();
	}

}

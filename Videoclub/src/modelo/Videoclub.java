package modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Videoclub {
	
	LinkedList <Pelicula> terror;	
	LinkedList <Pelicula> accion;
	LinkedList <Pelicula> drama;
	LinkedList <Pelicula> comedia;
	HashSet<Cliente> listadoClientes;
	
	public Videoclub() {
		this.accion = new LinkedList <Pelicula>();
		this.drama = new LinkedList <Pelicula>();
		this.terror = new LinkedList <Pelicula>();
		this.comedia = new LinkedList <Pelicula>();
		this.listadoClientes = new HashSet<Cliente>();
	}

	
}

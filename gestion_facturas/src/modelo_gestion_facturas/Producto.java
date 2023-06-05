package modelo_gestion_facturas;

import java.util.Objects;

public class Producto {

	private String nombre;
	private double precio;
	
	protected Producto(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	protected Producto(String nombre) {
		this.nombre = nombre;
	}
	
	
 protected String getNombre() {
		return this.nombre;
	}

 protected double getPrecio() {
		return this.precio;
	}
	/*
  * Metodo equals que determina que un producto es el mismo si tiene el mismo nombre
  * 
  */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(nombre, other.nombre);
	}

	

	@Override
	public String toString() {
		//return "\n" + this.nombre + "		" + this.precio + "		";
		return String.format("%10s %10.2f ", this.nombre,this.precio);
	}
	
	
	
	
}

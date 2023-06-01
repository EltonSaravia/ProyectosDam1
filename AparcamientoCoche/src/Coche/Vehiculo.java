package Coche;

import java.time.LocalTime;
import java.util.Objects;

public abstract class Vehiculo {

	// ATRIBUTOS
	
	private String matricula;
	private double precio;
	private Registro nuevoRegistro;
	
	
	// CONSTRUCTOR
	
	protected Vehiculo(String matricula) {
		this.matricula = matricula;
	}
	
	// GET Y SET
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	// METODOS
	
	// este metodo calcula el precio de todos los vehiculos
	protected abstract double calcularPrecio();

	// EQUALS
	
	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(matricula, other.matricula);
	}
	
	

	
	
	
	
}

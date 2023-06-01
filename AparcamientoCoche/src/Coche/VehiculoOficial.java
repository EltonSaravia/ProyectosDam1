package Coche;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.TreeSet;

public class VehiculoOficial extends Vehiculo{

	// ATRIBUTOS

	private TreeSet<Registro> nuevoRegistro;
	
	// CONSTRUCTOR
	
	protected VehiculoOficial(String matricula) {
		super(matricula);
		this.nuevoRegistro = new TreeSet<Registro>();
	}
	
	// METODOS
	
	protected double calcularPrecio() {
		
		double valor = 0;
		
		Duration duracion = Duration.between(this.entrada, salida);
        long minutos = duracion.toMinutes();
        double precio = 0;
        
        valor = minutos * precio;
	
	return valor;
	}
	
	protected void registrarEntrada() {
		
		Registro nuevoRegistro = new Registro(LocalDateTime.now());

		this.nuevoRegistro.add(nuevoRegistro);
	}

	
}

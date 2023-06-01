package Coche;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;

public class VehiculoResidente extends Vehiculo{

	// ATRIBUTOS
	
	private long minutosAcumulados;
	private HashSet<Registro> nuevoRegistro;
	
	// CONSTRUCTOR

	protected VehiculoResidente(String matricula) {
		super(matricula);
		this.nuevoRegistro = new HashSet<Registro>();
	}
	
	public double calcularPrecio() {
		
		double valor = 0;
		
		Duration duracion = Duration.between();
        long minutos = duracion.toSeconds();
        this.minutosAcumulados = tiempoTotal(minutos);
        double precio = 0.002;
        
        valor = minutos * precio;
	
	return valor;
	}
	
	public long tiempoTotal(long minutos) {
		
		long minutosAcumulado = 0;
		
		minutosAcumulado = minutos + minutosAcumulado;
		
		
		return minutosAcumulado;
	}
	
	protected void registrarEntrada() {
		
		Registro nuevoRegistro = new Registro(LocalDateTime.now());

		this.nuevoRegistro.add(nuevoRegistro);
	}
	
	protected void registrarSalida() {
		
		Registro aux = new Registro(LocalDateTime.now());

		
		for(Registro lis: this.nuevoRegistro) {
			if(!lis.equals(aux)) {
				aux = (Registro) lis;
				aux.setSalida();
			}
		}
	}

		
		
		
	}

	
	
}

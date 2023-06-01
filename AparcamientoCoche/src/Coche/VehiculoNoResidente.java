package Coche;
import java.time.Duration;
import java.time.LocalDateTime;

public class VehiculoNoResidente extends Vehiculo{

	// ATRIBUTOS
	
	private Registro nuevoRegistro;
	
	// CONSTRUCTOR
	
	protected VehiculoNoResidente(String matricula) {
		super(matricula);
		this.nuevoRegistro = new Registro(LocalDateTime.now());
	}
	
	
	// devuelve el precio calculado 
	protected double calcularPrecio() {
		
		double valor = 0;
		
		nuevoRegistro.setSalida();
		
		Duration duracion = Duration.between(nuevoRegistro.getEntrada(), nuevoRegistro.getSalida());
        long segundos = duracion.toSeconds();
        this.setPrecio(0.02);
        
        valor = segundos * this.getPrecio();
	
	return valor;
	}

	
	
}

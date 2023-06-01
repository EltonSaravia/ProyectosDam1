package Coche;

import java.time.LocalDateTime;

public class Registro {

	LocalDateTime entrada;
	LocalDateTime salida;
	
	public Registro(LocalDateTime entrada) {
		this.entrada = entrada;
		this.salida = null;
	}

	public LocalDateTime getSalida() {
		return salida;
	}

	public void setSalida() {
		this.salida = LocalDateTime.now();
	}

	public LocalDateTime getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalDateTime entrada) {
		this.entrada = entrada;
	}
	
	
	
	
	
	
	
}

package Coche;

import java.time.LocalTime;
import java.util.HashSet;

public class Aparcamiento {

	// ATRIBUTOS
	
	private HashSet<Vehiculo> listaVehiculos;
	private HashSet<VehiculoOficial> listaVehiculoOficial;
	private HashSet<VehiculoResidente> listaVehiculoResidente;
	
	// CONSTRUCTOR

	public Aparcamiento(){
		this.listaVehiculos = new HashSet<Vehiculo>();
		this.listaVehiculoResidente = new HashSet<VehiculoResidente>();
		this.listaVehiculoOficial = new HashSet<VehiculoOficial>();
	}
	
	// METODOS
	
	public int registrarEntrada(String matricula) {
		
		int valor = 0;
		
		VehiculoNoResidente vehiculo1 = new VehiculoNoResidente(matricula);
		VehiculoOficial vehiculo2 = new VehiculoOficial(matricula);
		VehiculoResidente vehiculo3 = new VehiculoResidente(matricula);
		
		if(this.listaVehiculos.contains(vehiculo1)) {
			valor = -1;
		}else{
			
			if(this.listaVehiculoOficial.contains(vehiculo2)) {
				vehiculo2 = (VehiculoOficial) this.obtenerVehiculoOficial(matricula);
				vehiculo2.registrarEntrada();
			
			}else if(this.listaVehiculoResidente.contains(vehiculo3)) {
				vehiculo3 = (VehiculoResidente) this.obtenerVehiculoResidente(matricula);
				vehiculo3.registrarEntrada();
			}else {
				this.listaVehiculos.add(vehiculo1);
			}
		}
		
		
		return valor;
		
	}
	
	private VehiculoResidente obtenerVehiculoResidente(String matricula) {

		VehiculoResidente aux = new VehiculoResidente(matricula);
		
		for(VehiculoResidente lis: this.listaVehiculoResidente) {
			if(lis.equals(aux)) {
				aux = (VehiculoResidente) lis;
			}
		}
		return aux;
	}

	public double registrarSalida(String matricula) {
		
		double valor = 0;
		
		VehiculoNoResidente aux = new VehiculoNoResidente(matricula);
		VehiculoOficial aux1 = new VehiculoOficial(matricula);
		
		if(listaVehiculos.contains(aux)) {
			Vehiculo vehiculoEncontrado = obtenerVehiculo(matricula);
			valor = vehiculoEncontrado.calcularPrecio();
			this.listaVehiculos.remove(vehiculoEncontrado);
		}else {
			valor = -1;
		}
		
		if(this.listaVehiculoOficial.contains(aux1)) {
			Vehiculo vehiculoEncontradoOficial = obtenerVehiculoOficial(matricula);
			valor = vehiculoEncontradoOficial.registrarSalida();
		}
		
		
		
			return valor;
	}
	
	private Vehiculo obtenerVehiculo(String matricula) {
		// TODO Auto-generated method stub
		
		VehiculoNoResidente aux = new VehiculoNoResidente(matricula);
		
		for(Vehiculo lis: this.listaVehiculos) {
			if(lis.equals(aux)) {
				aux = (VehiculoNoResidente) lis;
			}
		}
		return aux;
	}
	
	private Vehiculo obtenerVehiculoOficial(String matricula) {
		// TODO Auto-generated method stub
		
		VehiculoOficial aux = new VehiculoOficial(matricula);
		
		for(VehiculoOficial lis: this.listaVehiculoOficial) {
			if(lis.equals(aux)) {
				aux = (VehiculoOficial) lis;
			}
		}
		return aux;
	}

	public int altaVehiculoOficial(String matricula) {
		
		int valor = 0;
		
		VehiculoOficial vehiculo1 = new VehiculoOficial(matricula);
		
		if(this.listaVehiculoOficial.contains(vehiculo1)) {
			valor = -1;
		}else{
			this.listaVehiculoOficial.add(vehiculo1);
		}
		
		return valor;
		
	}
	
	public int altaVehiculoResidente(String matricula) {
		
		int valor = 0;
		
		VehiculoResidente vehiculo1 = new VehiculoResidente(matricula);
		
		if(listaVehiculoResidente.contains(vehiculo1)) {
			valor = -1;
		}else{
			this.listaVehiculoResidente.add(vehiculo1);
		}
		
		return valor;
		
	}


	
}

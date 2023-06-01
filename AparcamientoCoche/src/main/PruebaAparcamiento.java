package main;

import java.util.Scanner;

import Coche.Aparcamiento;

public class PruebaAparcamiento {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		Aparcamiento nuevoAparcamiento = new Aparcamiento();
	
	boolean s = false;
	
	while(!s) {
		
		System.out.println("1. Registra entrada");
		System.out.println("2. Registra salida");
		System.out.println("3. Da de alta vehículo oficial");
		System.out.println("4. Da de alta vehiculo de residente");
		System.out.println("5. Comienza mes");
		System.out.println("6. Pagos de residentes");
		System.out.println("7. Salir");
		int opcion = entrada.nextInt();
		
		
		if(opcion == 1) {
			System.out.println("Introduce matricula");
			String matricula = entrada.next();
			
			int valor = nuevoAparcamiento.registrarEntrada(matricula);
			
			if(valor == -1) {
				System.err.println("La matricula ya esta registrada en el parking");
			}else if(valor == 0) {
				System.out.println("Se ha registrado la matricula en el parking");
			}
		
		}else if(opcion == 2) {
			System.out.println("Introduce matricula");
			String matricula = entrada.next();
			
				double valor = nuevoAparcamiento.registrarSalida(matricula);
			
				if(valor == -1) {
					System.err.println("No existe el vehiculo");				
				}else {
					System.out.println(valor);
				}
			
		}else if(opcion == 3) {
			System.out.println("Introduce matricula");
			String matricula = entrada.next();
			
			int valor = nuevoAparcamiento.registrarEntrada(matricula);
			
			if(valor == -1) {
				System.err.println("La matricula ya esta registrada en el parking");
			}else if(valor == 0) {
				System.out.println("Se ha registrado la matricula en el parking");
			}
		
		}else if(opcion == 4) {
			System.out.println("Introduce matricula");
			String matricula = entrada.next();
			
			int valor = nuevoAparcamiento.registrarEntrada(matricula);
			
			if(valor == -1) {
				System.err.println("La matricula ya esta registrada en el parking");
			}else if(valor == 0) {
				System.out.println("Se ha registrado la matricula en el parking");
			}
		
		}else if(opcion == 5) {
			
		}
		
		
	}
	
	}
}

package Agenda;

import java.util.Scanner;

import Fraccion.Fraccion;

public class Prueba_Agenda {
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_RESET = "\u001B[0m";
	
	/*
	 * Este metodo verifica si el nombre del contacto ya existe, puesto que varios contactos pueden tener
	 * el mismo numero y correo pero NO el mismo nombre.
	 */
	public  static boolean verificarSiExisteContacto (String nombreNuevo) {
		boolean contactoRepetido = false;
		Agenda agendaDeContactos = new Agenda();
		Contacto contactoNuevo = new Contacto(nombreNuevo);
		for (int i = 0 ; i < 100 ; i++) {
		Contacto contactoEncontrado = agendaDeContactos.contactosDeLaAgenda [i];
			if (contactoEncontrado.equals(contactoNuevo) == true) {
				contactoRepetido = true;
			}
		}
		
		return contactoRepetido;
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Agenda miAgenda = new Agenda();
		boolean repetir = true;
		
		
		while (repetir) {
		System.out.println(ANSI_YELLOW+"\n*** AGENDA DE CONTACTOS ***");
		System.out.println("\n1.	Añade Contacto.");
		System.out.println("2.	Elimina Contacto");
		System.out.println("3.	Buscar Contacto");
		System.out.println("4.	Ver todos los nombres");
		System.out.println("5.	Modifica Contacto");
		System.out.println("6.	Numero de contactos" +ANSI_RESET);
		int opcionElegida = sc.nextInt();
		System.out.println();
		
			switch (opcionElegida) {
			
				case 1:
					System.out.println(ANSI_GREEN+"Indica el nombre del contacto: ");
					String nombreParaAñadir = sc.next();
					boolean contactoRepetido = verificarSiExisteContacto(nombreParaAñadir);
					System.out.println("Indica el correo electronico del contacto: ");
					String correoParaAñadir = sc.next();
					System.out.println("Indica el numero de telefono del contacto: "+ ANSI_RESET);
					int telefonoParaAñadir = sc.nextInt();

				
					if (contactoRepetido == true) {
						System.out.print("El contacto ya existe en la agenda, no se ha podido añadir");
					}else {
						miAgenda.añadirContacto(nombreParaAñadir, telefonoParaAñadir, correoParaAñadir);
						System.out.print("El contacto se ha añadido correctamente.");
					}
					
					break;
				case 2:
					System.out.println(ANSI_GREEN+"Indica el nombre del contacto: "+ANSI_RESET);
					String nombreAEliminar = sc.next();
					boolean contactoExiste = verificarSiExisteContacto(nombreAEliminar);
					if (contactoExiste == true) {
						miAgenda.eliminarContactos(nombreAEliminar);
						System.out.print("El contacto ha sido eliminado de manera correcta.");
						
					}else {
						
						System.out.print("El contacto no existe.");
					}
					break;
				case 3:
					System.out.println(ANSI_GREEN+"Indica el nombre del contacto a buscar: "+ANSI_RESET);
					String nombreABuscar = sc.next();
					 contactoExiste = verificarSiExisteContacto(nombreABuscar);
					if (contactoExiste == true) {
						Contacto contactoEncontrado =miAgenda.buscaelContacto(nombreABuscar);
						System.out.println("Datos de contacto");
						System.out.println("	"+ contactoEncontrado.toString() );
						
					}else {
						System.out.print("El contacto no existe.");
					}
					break;
				case 4:
					System.out.println("Estos son los contactos " + miAgenda.toString() );
					break;
				case 5:
					System.out.println(ANSI_GREEN+"Indica el nombre del contacto a modificar: "+ANSI_RESET);
					String nombreAModificar = sc.next();
					contactoExiste = verificarSiExisteContacto(nombreAModificar);
					if (contactoExiste == true) {
						Contacto contactoAModificar = miAgenda.buscaelContacto(nombreAModificar);
						
						System.out.println(ANSI_GREEN+"Indica el nuevo nombre del contacto a modificar: "+ANSI_RESET);
						String nuevoNombre = sc.next();
						contactoAModificar.setNombre(nuevoNombre);
						
						System.out.println(ANSI_GREEN+"Indica el nuevo nombre del contacto a modificar: "+ANSI_RESET);
						String nuevoCorreo = sc.next();
						contactoAModificar.setDireccionDeCorreo(nuevoCorreo);
						
						System.out.println(ANSI_GREEN+"Indica el nuevo nombre del contacto a modificar: "+ANSI_RESET);
						int nuevoTelefono = sc.nextInt();
						contactoAModificar.setTelefono(nuevoTelefono);
						
					}else {
						System.out.print("El contacto no existe.");
					}
					break;
				case 6:
					
					break;
				default:
					System.out.println("La opción indicada no existe.");
					
					break;
			
			}
		}
	}
	
	

}

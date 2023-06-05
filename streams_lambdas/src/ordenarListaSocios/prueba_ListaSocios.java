package ordenarListaSocios;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class prueba_ListaSocios {

    public static void main(String[] args) throws SocioYaExiste_Error, SocioNoExiste_Error {
        ListaSocios listaSocios = new ListaSocios();
        Scanner scanner = new Scanner(System.in);
        /*
         * se utiliza el localdate .of para  indicar una fecha con diferentes enteros.
         * si por pantalla hubiese pedido los numeros de manera individual
         * hubiese tenido que utilizar este metodo
         */
        
        listaSocios.addSocio("123456789A", "Juan Pérez", LocalDate.of(1990, 1, 1), 150, 1);
        listaSocios.addSocio("987654321B", "María Sánchez", LocalDate.of(1985, 5, 15), 120, 2);
        listaSocios.addSocio("543216789C", "Pedro López", LocalDate.of(1987, 8, 20), 120, 0);
        listaSocios.addSocio("987654321D", "Ana García", LocalDate.of(1992, 12, 5), 130, 3);
        listaSocios.addSocio("123450987E", "Luis Martínez", LocalDate.of(1983, 6, 10), 160, 2);
        
        
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("-------- MENU --------");
            System.out.println("1. Agregar socio");
            System.out.println("2. Calcular edad de un socio");
            System.out.println("3. Calcular meses de antigüedad de un socio");
            System.out.println("4. Eliminar socio");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    
                	 System.out.println("Ingrese el DNI del socio: ");
                     String dni = scanner.next();
                     System.out.println("Ingrese el nombre del socio: ");
                     String nombre = scanner.next();
                     System.out.println("Ingrese la fecha de nacimiento del socio:  dd/MM/yyyy ");
                     String fechaNacimientoSTR = scanner.next();
                     //utilizo este metodo para crear un foramto predefino que es el que solicitare por pantalla
                     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
                     // utilizo este metodo para pasar de un string a un formatofecha 
                     LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoSTR, formatter);
                     System.out.println("Ingrese la cuota del socio: ");
                     float cuota = scanner.nextFloat();
                     System.out.println("Ingrese la cantidad de familia del socio: ");
                     int cantidadFamilia = scanner.nextInt();
                     scanner.nextLine(); 

                     try {
                         listaSocios.addSocio(dni, nombre, fechaNacimiento, cuota, cantidadFamilia);
                         System.out.println("Socio agregado exitosamente.");
                     } catch (SocioYaExiste_Error e) {
                         System.out.println(e);
                     }catch (java.time.format.DateTimeParseException error) {
                         System.out.println("Introduce bien la fecha");
                     }
                    break;
                    
                case 2:
           
                	System.out.println("Ingrese el DNI del socio: ");
                    String dniElegido = scanner.next();
                    System.out.println("la edad del socio es : "+listaSocios.saberEdadSocio(dniElegido));
                    break;
                case 3:
                    
                    break;
                case 4:
                   
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }

            System.out.println();
        }

        scanner.close();
    }
	}
package prueba_gestion_facturas;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import modelo_gestion_facturas.Comercio;

public class programa_gestion_clientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean encendido = true;
		Comercio amazonea = new Comercio ();
		
		amazonea.introducirProducto("arroz",1,4);
		amazonea.introducirProducto("azucar",1,4);
		amazonea.introducirProducto("frijoles",2,5);
		amazonea.introducirProducto("sal",0.75,10);
		
		amazonea.registrarCliente("12345678A", "Marta", "García", 5);
		amazonea.registrarCliente("23456789B", "Javier", "López", 18);
		amazonea.registrarCliente("34567890C", "Ana", "Fernández", 9);
		amazonea.registrarCliente("45678901D", "David", "Martínez", 12);
		amazonea.registrarCliente("56789012E", "Sara", "González", 0);
		
		amazonea.addProductoAPedido("arroz",2, "12345678A");
		amazonea.addProductoAPedido("frijoles",3, "12345678A");
		amazonea.generarFactura("12345678A");
		
		amazonea.addProductoAPedido("azucar",1, "12345678A");
		amazonea.addProductoAPedido("sal",1, "12345678A");
		amazonea.generarFactura("12345678A");
		
		amazonea.addProductoAPedido("arroz",2, "23456789B");
		amazonea.addProductoAPedido("frijoles",3, "23456789B");
		
		
		while (encendido) {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("\n1 - Registrar cliente ");
			System.out.println("2 - Icorporar productos a almacen");
			System.out.println("3 - Reposicion de existencias");
			System.out.println("4 - Generar pedido");
			System.out.println("5 - Generar factura ");
			System.out.println("6 - Visualizar una factura");
			System.out.println("7 - Visualizar las facturas de un cliente");
			System.out.println("8 - Guardar factura	 en un archivo ");
			System.out.println("9 - Salir ");
			
			System.out.println("Por favor, ingrese una opcion:");
			int opcion = sc.nextInt();
			if (opcion == 1) {
				System.out.println("Indica el DNI del cliente");
				String DNI = sc.next();
				System.out.println("Indica el nombre del cliente");
				String nombre = sc.next();
				System.out.println("Indica el apellido del cliente");
				String Apellidos = sc.next();
				System.out.println("Indica el descuento del cliente");
				int descuento = sc.nextInt();
				int codigo = amazonea.registrarCliente(DNI, nombre, Apellidos, descuento);
				if (codigo == 0) {
					System.out.println("El cliente ya existe por favor verifique si ha introducido bien el DNI.");
				}else {
					System.out.println("El cliente se ha registrado con exito, ya puede realizar pedidos.");
				}
			}
			if (opcion == 2) {
				System.out.println("Introduce el nombre del producto");
				String nameProduct = sc.next();
				System.out.println("Introduce el precio del producto");	
				double precio = sc.nextDouble();
				System.out.println("Introduce la cantidad de existencias del producto");	
				int existencias = sc.nextInt();
				int code = amazonea.introducirProducto(nameProduct,precio,existencias);
				if (code == 0) {
					System.out.println("El producto que ha ingresado ya existe");
				}else if(code == 1) {
					System.out.println("El producto y su cantidad se han agregado de manaera correcta.");
				}else if(code == 2) {
					System.out.println("La cantidad ingresada no puede ser menor a 1");
				}
			}
			if (opcion == 3) {
				System.out.println("Introduce el nombre del producto al que le desaes reponer existencias");
				String nameProduct = sc.next();
				System.out.println("Introduce la cantidad de existencias a agregar del producto");	
				int cantidad = sc.nextInt();
				int code = amazonea.reponerProducto(nameProduct,cantidad);
				if (code == 0) {
					System.out.println("El producto que ha ingresado no existe");
				}else if(code == 1) {
					System.out.println("La cantidad de existencias de producto se ha actualizado");
				}else if(code == 2) {
					System.out.println("La cantidad ingresada no puede ser menor a 1");
				}
			}
			
			
			if (opcion == 4) {
				System.out.println("Introduce el dni ");
				String dni = sc.next();
				int code = amazonea.verificarCliente(dni);
				if (code == 1) {
					System.out.println(""+amazonea.mostrarProductosAlmacen());
					System.out.println("Que producto deseas añadir a al pedido");
					String nameProduct = sc.next();
					System.out.println("Cuanta cantidad deseas añadir ");
					int cantidad = sc.nextInt();
					code = amazonea.addProductoAPedido(nameProduct,cantidad, dni);
						if (code == 1) {
							System.out.println("El producto indicado no existe, no se ha modificado el carrito");
							
						}else if(code == 2){
							System.out.println("No existe el stock suficiente para efectuar tu pedido");
	
						}else if(code == 3) {
							System.out.println("Se ha añadido el producto ala carrito");
						}
					
				}else if (code == 0) {
					System.out.println("No existe ese cliente, compruebe los valores introducidos");
				}
			}
			if (opcion == 5) {
				System.out.println("Introduce el dni ");
				String dni = sc.next();
				int code = amazonea.verificarCliente(dni);
					if (code == 0) {
						System.out.println("No existe ese cliente, compruebe los valores introducidos");
					}else  {
						code = amazonea.generarFactura(dni);
							if (code == 1) {
								System.out.println("Este cliente no tiene productos en el carrito, no se genera factura");
							}else  {
								System.out.println("Se ha generado la factura con numero:	" + code);
							}
					}
			}
			if (opcion == 6) {
				System.out.println("Introduce la factura que deseas visualizar ");
				String facturaAVisualizar = sc.next();
				System.out.println(amazonea.visualizarFactura( facturaAVisualizar));
				
			}
			if (opcion == 7) {
				System.out.println("Introduce el dni ");
				String dni = sc.next();
				int code = amazonea.verificarCliente(dni);
					if (code == 0) {
						System.out.println("No existe ese cliente, compruebe los valores introducidos");
					}else  {
						System.out.println(amazonea.visualizarFacturasCliente( dni));
					}
			}
			if (opcion == 8) {
				
			}
			if (opcion == 9) {
				encendido = false;
			}
		}
	}

}

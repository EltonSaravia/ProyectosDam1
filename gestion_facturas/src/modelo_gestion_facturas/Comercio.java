package modelo_gestion_facturas;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class Comercio {
	private HashSet<Cliente> listaClientes ;
	private TreeMap<String,Factura > listaFacturasComercio ;
	private Almacen almacen;
	
	public Comercio() {
		this.listaClientes = new HashSet <Cliente>();
		this.listaFacturasComercio = new TreeMap<String, Factura>();
		this.almacen = new Almacen ();
	}
	/*
	 * Metodo para registrar a el cliente, si el codigo a devolver es 
	 * 0- no se crea el cliente porque existe,
	 * 1- se crea cliente
	 */
	public int registrarCliente(String DNI,String nombre,String apellidos, int descuento) {
		int code = 0;
		if (clienteExiste(DNI) == false  ) {
			Cliente nuevoCliente = new Cliente ( DNI, nombre, apellidos,  descuento);
			this.listaClientes.add(nuevoCliente);
			code = 1;
		}
		return code;
	}
	/*
	 * metodo para verificar si un clinte existe recorriendo la lista de cleintes 
	 */
	private boolean clienteExiste(String DNI) {
		boolean existe = false;
		 for(Cliente clienteEncontrado : this.listaClientes){
	           if (clienteEncontrado.getDNI().equals(DNI)) {
	        	   existe = true;
	           }
	        }
		return existe;
	}
	/*
	 * metodo para meter un nuevo producto 
	 */
	public int introducirProducto(String nombre, double precio, int existencias) {
		int code = 0;
		if (CantidadProductoCorrecta(existencias) == true) {
			if (productoExiste(nombre) == false) {
				this.almacen.addProductoALista(nombre, precio,existencias);
				code = 1;
			}
		}
		else {
			code = 2;
		}
		return code;
	}
	/*
	 * metodo para recorrer la lista y verificar si ya existe el procuto por el nombre
	 */
	private boolean productoExiste(String nombre) {
		boolean existe = false;
	           if (this.almacen.productoExiste(nombre) == true) {
	        	   existe = true;
	           }
		return existe;
	}
	
	/*
	 * metodo para verificar si al meter un producto la cantidad de existencias es mayor a 0
	 */
	private boolean CantidadProductoCorrecta(int cantidad) {
		boolean correcta = true;
	           if (cantidad <= 0) {
	        	   correcta = false;
	           }
		return correcta;
	}
	
	/*
	 * metodo para reponer productos
	 */
	public int reponerProducto(String nombre, int cantidad) {
		int code = 0;
		if (productoExiste(nombre) == true) {
			if (CantidadProductoCorrecta (cantidad) == true) {
				this.almacen.reponerProducto(nombre,cantidad);
				code = 1;
			}else {
				code =2;
			}
		}
		return code;
	}
	
	
	/*
	 * metodo para averificar cliente
	 */
	public int verificarCliente (String dni){
		int codigo = 0;
		
		if (clienteExiste(dni) == true){
			codigo = 1;
		}
		return codigo ;
	}
	/*
	 * metodo para añadir los productos al carrito de la compra
	 */
	public int addProductoAPedido(String nameProduct, int cantidad, String dni) {
		int codigo = 0;
		if (productoExiste(nameProduct)== true) { 
				if (hayExistencias(nameProduct,cantidad) == true) {
					Cliente clienteOBT = obtenerCliente(dni);
					Producto objProducto = this.almacen.obtenerProducto(nameProduct);
					clienteOBT.addProductoAPedidos(objProducto, cantidad);
					codigo = 3;
				}else {
					codigo = 2;
				}
		}else {
			 codigo = 1;
		}
		
		return codigo ;
	}
	
	/*
	 * metodo para verificar si la cantidad indicada existe y se puede comprar
	 */
	
	private boolean hayExistencias(String producto ,int cantidad) {
		boolean sePuedeVender = false;
	   Producto articulo = this.almacen.obtenerProducto(producto) ;
     	 int  stock = this.almacen.obtenercantidad(articulo);
        if (stock >= cantidad) {
        	sePuedeVender = true;
        }
		return sePuedeVender;
	}
	
	/*
	 * metodo para obtener cliente en base a un dni
	 */
	private Cliente obtenerCliente(String dni) {
		Cliente clienteObt = null;
		 for(Cliente clienteEncontrado : this.listaClientes){
	           if (clienteEncontrado.getDNI().equals(dni)) {
	        	    clienteObt = clienteEncontrado;
	           }
	}
		 return clienteObt;
	}
	/*
	 * metodo apra genera factura
	 */
	public int generarFactura(String dni) {
		int code = 1;
		Cliente client = obtenerCliente(dni);
		if (carritoVacio(client) == false) {
			String numFactura = obtenerNumeroFactura();
			Factura facturaCreada = new Factura (client,client.getCarrito(),numFactura);
			client.almacenarFactura(facturaCreada);
			client.borrarPedido();
			this.listaFacturasComercio.put(numFactura, facturaCreada);
			code = Integer.parseInt(numFactura);
		}
		return code;
	}
	
	/*
	 * este metodo comprueba si el cliente tiene algun pedido àra poder generar factura
	 */
	public boolean carritoVacio(Cliente cliente) {
		int code = 0;
		return cliente.carritoVacio();
	}
	
	/*
	 * con este metodo obtenemos el numero de factura que siempre correpondera al 
	 * mes/dia/hora/min/seg de el momento en el que se crea la factura
	 */
	private String obtenerNumeroFactura() {
		Date fechaActual = new Date();
		Calendar calendario = Calendar.getInstance();
        calendario.setTime(fechaActual);
		int mes = calendario.get(Calendar.MONTH) + 1; // Los meses empiezan en cero, por lo que se debe sumar 1
	    int dia = calendario.get(Calendar.DAY_OF_MONTH);
	    int hora = calendario.get(Calendar.HOUR_OF_DAY);
	    int minuto = calendario.get(Calendar.MINUTE);
	    int segundo = calendario.get(Calendar.SECOND);
	    String resultado = mes + "" + dia+ "" + hora+ "" + minuto+ "" + segundo;
	    return resultado;

	}
	
	public String visualizarFactura(String numFactura) {
		Factura facturaEncontrada = buscarFactura( numFactura);
		if (facturaEncontrada == null) {
			return "la factura no existe";
		}
		
		return facturaEncontrada.toString();
	}
	
	
	public Factura buscarFactura(String numeroFactura) {
		Factura facturaEncontrada = null;
	    for (Map.Entry<String, Factura> entry : listaFacturasComercio.entrySet()) {
	        if (entry.getKey().equals(numeroFactura)) {
	        	facturaEncontrada = entry.getValue() ;
	            return entry.getValue();
	        }
	        //listaFacturasComercio.get(numeroFactura);esto remplaza esto
	    }
	    return facturaEncontrada; 
	}
	
	
	
	public String mostrarProductosAlmacen() {
		return this.almacen.toString();
	}
	
	public String visualizarFacturasCliente(String DNI) {
		Cliente client = obtenerCliente(DNI);
		return client.mostrarFacturasCliente();
	}
	
	
	
	
	
	
	
	
	
	
}

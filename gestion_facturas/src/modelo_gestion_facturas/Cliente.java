package modelo_gestion_facturas;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.TreeSet;

public class Cliente {

	private String DNI;
	private String nombre;
	private String apellidos;
	private int descuento;
	private Pedido carrito;
	HashSet <Factura> listaFacturasCliente ;
	
	protected Cliente(String DNI,String nombre,String apellidos, int descuento) {
		this.DNI = DNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.descuento = descuento;
		this.carrito = new Pedido();
		this.listaFacturasCliente = new HashSet <Factura>();
	}
	protected Cliente(String DNI) {
		this.DNI = DNI;
	}

	public String getDNI() {
		return DNI;
	}
	
	protected int getDescuento() {
		return this.descuento;
	}

	protected void addProductoAPedidos(Producto productoAMeter, int cantidad){
		this.carrito.addProducto(productoAMeter, cantidad);
	}

	protected String getNombre() {
		return nombre;
	}

	protected String getApellidos() {
		return apellidos;
	}
	
	protected boolean carritoVacio() {
		return this.carrito.carritoVacio();
	}
	
	protected void almacenarFactura(Factura facturaAGuardar) {
		this.listaFacturasCliente.add(facturaAGuardar);
		
	}
	protected void borrarPedido() {
		this.carrito.borrarPedido();
	}
	
	public Pedido getCarrito() {
		return this.carrito;
	}
	
	
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(DNI, other.DNI);
	}
	/*
	 * muestra todas las facturas pero solo de este cliente
	 */
	public String mostrarFacturasCliente() {
		return "\n" + listaFacturasCliente + "\n";
	}
	
	
	
	
}

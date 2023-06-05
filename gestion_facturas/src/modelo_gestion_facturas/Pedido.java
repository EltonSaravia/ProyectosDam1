package modelo_gestion_facturas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Pedido {
	private HashMap<Producto,Integer> listaProductos ; 
	
	/*protected Pedido(Cliente cliente) {
		this.listaProductos = new HashMap<Producto,Integer>();
		
	} no se si esta correcto porque estoy metiendo carrito dentro de un cliente, 
	ya no haria falta.*/
	protected Pedido() {
		this.listaProductos= new HashMap<Producto,Integer>();
	}
	
	/*
	 * crea un pedido que se ñadira a un cliente
	 */
	protected void addProducto(Producto productoAMeter, int cantidad){
		this.listaProductos.put(productoAMeter, cantidad);
	}
	/*
	 * metodo para obtener el precio total de todos los productos
	 */
	protected double importeTotal(){
		double precioTotal = 0;
		for (HashMap.Entry<Producto, Integer> salida : this.listaProductos.entrySet()) {
			precioTotal = salida.getKey().getPrecio() + precioTotal ;
		}
		
		return precioTotal;
	}
	
	public HashMap<Producto, Integer> getListaProductos() {
		return listaProductos;
	}

	protected boolean carritoVacio() {
		return this.listaProductos.isEmpty();
	}
	
	protected void borrarPedido() {
		this.listaProductos.clear();
	}

	@Override
	public String toString() {
		System.out.println("PRODUCTO	"+"PRECIO	"+"CANTIDAD	\n");
	    for (Map.Entry<Producto,Integer> salida : listaProductos.entrySet()) {
	    	System.out.println(salida.getKey().toString() + salida.getValue());
	    }
		return "";
	   
	    
	}

	
	
	
	
}

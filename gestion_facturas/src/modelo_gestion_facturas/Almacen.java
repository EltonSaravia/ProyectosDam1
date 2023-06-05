package modelo_gestion_facturas;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;



public class Almacen {
	
	private HashMap<Producto, Integer> lista_productosYcantidad ;
	
	protected Almacen (){
		this.lista_productosYcantidad = new HashMap<Producto, Integer>();
	}
	
	/*
	 * metodo para recorrer la lista de productos y verificar si existe.
	 */
	protected boolean productoExiste(String nombre) {
		boolean existe = false;
		Producto nuevoProducto = new Producto (nombre);
		 for (Map.Entry<Producto, Integer> productoEncontrado : this.lista_productosYcantidad.entrySet()) {
	          if (productoEncontrado.getKey().equals(nuevoProducto)) {
	        	  existe = true;
	          }
	        }
		return existe;
	}
	/*
	 * metodo para añadir prodcuto a la lista donde la clave valor sera el nombre de producto y el valor sera la cantidad de stock
	 */
	protected void addProductoALista(String nombre, double precio, int existencias) {
		Producto nuevoProducto = new Producto (nombre, precio);
		this.lista_productosYcantidad.put(nuevoProducto, existencias);	
	}
	
	protected void reponerProducto(String nombre, int cantidad) {
		Producto nuevoProducto = new Producto (nombre);
		 for (Map.Entry<Producto, Integer> productoEncontrado : this.lista_productosYcantidad.entrySet()) {
	          if (productoEncontrado.getKey().equals(nuevoProducto)) {
	        	  this.lista_productosYcantidad.replace(productoEncontrado.getKey(), cantidad);
	          }}
		
	}
	
	/*
	 * metodo que develve la clave valor(objeto) si le pasamos como parametro un String
	 */
	protected Producto obtenerProducto(String nombre) {
		  for (Map.Entry<Producto, Integer> entry : this.lista_productosYcantidad.entrySet()) {
		        if (entry.getKey().getNombre().equals(nombre)) {
		            return entry.getKey();
		        }
		    }
		  return null;
	}
	
	/*
	 * Metodo que devuelve la cantidad que hay en almacen de un objeto si le pasamos por parametro un objeto
	 */
	
	protected int obtenercantidad (Producto articulo) {
		return this.lista_productosYcantidad.get(articulo);
		
	}
	private String formateoProductos() {
		String imprimir = "";
		imprimir = String.format("%10s %10s %5s \n","Producto", "Precio", "Stock");
		for (Map.Entry<Producto, Integer> entry : this.lista_productosYcantidad.entrySet()) {
	        imprimir = imprimir + entry.getKey() + " " + entry.getValue() + "\n";
	    }
		return imprimir;
	}
	@Override
	public String toString() {
		//return "producto	" + "precio		"+"Stock disponible	\n" +formateoProductos() + "";
		return formateoProductos();
	}
}

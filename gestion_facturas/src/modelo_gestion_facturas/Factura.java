package modelo_gestion_facturas;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
public class Factura {
	
	private String numeroFactura;
	private Cliente clienteFacturado;
	private String  pedido;
	private double subtotal;
	private double total;
	private double descuento;
	private boolean pagada;
	static private double iva = 1.21;
	 
	protected Factura (Cliente cliente, Pedido pedido,String numeroFactura) {

		this.clienteFacturado = cliente;
		this.pedido = formateoProductos(pedido);
		this.pagada = false;
		this.numeroFactura = numeroFactura;
		calcularSubtotal(pedido);
		descuento();
		aplicarDescuento();
		calcularTotal ();
	}
	

	protected String getNumeroFactura() {
		return numeroFactura;
	}

	private void calcularSubtotal (Pedido pedido) {
		this.subtotal = pedido.importeTotal() ;
	}
	
	private void aplicarDescuento () {
		this.subtotal = this.subtotal - (this.subtotal * (this.descuento / 100));
	}
	private void calcularTotal () {
		this.total = this.subtotal * iva;
	}
	
	private void descuento() {
		this.descuento = this.clienteFacturado.getDescuento();
	}
	
	private void pagarFactura() {
		this.pagada = true;
	}
	
	private String estadoFactura() {
		String estado = "";
		if (this.pagada == false)
			estado = "Pendiente de pago";
		else {
			estado = "pagada";
		}
		return estado;
	}
	
	/*
	 * metodo que transforma una lista de productos de un hashmap a un
	 * arry donde no importa el orden y asi que no se modifique el pedido
	 */

	@Override
	public String toString() {
		return "\nCliente:	"+ this.clienteFacturado.getNombre() +" "+this.clienteFacturado.getApellidos()+
				"\nFactura nº	" +this.numeroFactura+ "	" +estadoFactura()+"\n"
				+"\n" + this.pedido +"\n"
				+"\nSUBTOTAL:	"+ this.subtotal + "	DESCUENTO:	"+this.descuento+"%"+ 
	
				 "	\nTOTAL con iva:	" + this.total+"€";
				
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(numeroFactura);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Factura other = (Factura) obj;
		return Objects.equals(numeroFactura, other.numeroFactura);
	}

	private String formateoProductos(Pedido pedido) {
		String pedidoString = "";
		pedidoString = String.format("%10s %10s %5s \n","Producto", "Precio", "Stock");
		for (Map.Entry<Producto, Integer> entry : pedido.getListaProductos().entrySet()) {
			pedidoString = pedidoString + entry.getKey() + " " + entry.getValue() + "\n";
	    }
		return pedidoString;
	}

	
	
	
}

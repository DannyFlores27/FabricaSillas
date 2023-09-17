package fabricaSillas;

import java.util.ArrayList;

public class Pedido {
	private Boolean estado;
	private ArrayList <Producto> productos;
	private Double totalAPagar;
	private Double anticipo;
	private Integer id;
	private Double tiempo;
	private Etapa etapa;
	private Entregar entrega;
	private Cliente cliente;
	private Factura factura;
	
	
	
	public Pedido(Cliente cliente) {
		super();
		this.cliente = cliente;
		this.productos = new ArrayList<>();
	}
	
	public void agregarProducto(Producto producto) {
		this.productos.add(producto);
	}

	public void listarProductos () {
		for (Producto producto : productos) {
			System.out.println(producto);
		}
	}
	
	public void listarProductosFactura () {
		for (Producto producto : productos) {
			producto.datosFactura();
		}
	}
	
	public void asignarEntrega(Entregar entrega) {
		this.entrega = entrega;
	}
	
	/* Pendiente de generar funciones
	private calcularTotalAPagar() {
		//Pendiente de realizar
	}
	
	private calcularAnticipo() {
		//Pendiente de realizar
	}
	
	private asignarId() {
		//Pendiente de realizar
	}
	
	private double calcularTiempo() {
		//Pendiente de realizar
		return;
	}
	
	private actualizarEtapa() {
		//Pendiente de realizar
	}
	
	private actualizarEntrega() {
		//Pendiente de realizar
	}
	
	private asignarCliente() {
		//Pendiente de realizar
	}
	
	private asignarFactura() {
		//Pendiente de realizar
	}
	*/
	
}

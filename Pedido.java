package fabricaSillas;

import java.util.ArrayList;

public class Pedido {
	private ArrayList <Producto> productos;
	private Double totalPrecioProductos = 0.00;
	private Integer id;
	private static Integer contador = 0;
	private Double tiempo = 0.00;
	private Etapa etapa;
	private Entregar entrega;
	private Cliente cliente;
	private Factura factura;
	
	
	
	public Pedido(Cliente cliente) {
		super();
		contador++;
		this.id = contador;
		this.cliente = cliente;
		this.productos = new ArrayList<>();
		this.etapa = Etapa.EN_COLA;
	}
	
	public void agregarProducto(Producto producto) {
		this.productos.add(producto);
		this.tiempo += producto.getTiempo();
		this.totalPrecioProductos += producto.getPrecio();
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
	
	public Producto buscarProducto(Integer id) {
		int i = 0;
		Producto productoEncontrado = null;
		while (i < productos.size() && !this.productos.get(i).getId().equals(id)) {
			i++;
		}
		if (i < productos.size()) {
			productoEncontrado = this.productos.get(i);
		}
		return productoEncontrado;
	}
	
	public Producto eliminarProducto(Integer id) {
		Producto productoAEliminar = buscarProducto(id);
		if(productoAEliminar != null) {
			totalPrecioProductos -= productoAEliminar.getPrecio();
			this.productos.remove(productoAEliminar);
		}else {
			System.out.println("Producto no encontrado.");
		}
		
		return productoAEliminar;
	}
		
	public void setEntrega(Entregar entrega) {
		this.entrega = entrega;
	}
	
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
	public void setEtapa(Etapa etapa) {
		this.etapa = etapa;
	}

	public Double getTotalPrecioProductos() {
		return totalPrecioProductos;
	}

	public Integer getId() {
		return id;
	}

	public Double getTiempo() {
		return tiempo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Factura getFactura() {
		return factura;
	}

	@Override
	public String toString() {
		return "Pedido [productos=" + productos + ", totalPrecioProductos=" + totalPrecioProductos + ", id=" + id
				+ ", tiempo=" + tiempo + ", etapa=" + etapa + ", entrega=" + entrega + ", cliente=" + cliente
				+ ", factura=" + factura + "]";
	}
	
	

}

package fabricaSillas;

import java.util.ArrayList;

public class Fabrica {
	private ArrayList <Pedido> pedidos;
	private ArrayList <Factura> facturas;
	
	public Fabrica() {
		super();
		this.pedidos = new ArrayList<>();
		this.facturas = new ArrayList<>();
	}
	
	public void agregarPedido(Pedido pedido) {
		this.pedidos.add(pedido);
	}
	
	public Pedido buscarPedido(Integer id) {
		int i = 0;
		Pedido pedidoEncontrado = null;
		while (i < pedidos.size() && !this.pedidos.get(i).getId().equals(id)) {
			i++;
		}
		if (i < pedidos.size()) {
			pedidoEncontrado = this.pedidos.get(i);
		}
		return pedidoEncontrado;
	}
	
	public Pedido eliminarPedido(Integer id) {
		Pedido pedidoAEliminar = buscarPedido(id);
		this.pedidos.remove(pedidoAEliminar);
		return pedidoAEliminar;
	}	
	
	public void listarPedidos () {
		for (Pedido pedido : pedidos) {
			pedido.listarProductos();
		}
	}
	
	public void agregarFactura(Factura factura) {
		this.facturas.add(factura);
	}
	
	public Factura buscarFactura(Integer id) {
		int i = 0;
		Factura facturaEncontrada = null;
		while (i < facturas.size() && !this.facturas.get(i).getId().equals(id)) {
			i++;
		}
		if (i < facturas.size()) {
			facturaEncontrada = this.facturas.get(i);
		}
		return facturaEncontrada;
	}
	
	public Factura eliminarFactura(Integer id) {
		Factura facturaAEliminar = buscarFactura(id);
		this.facturas.remove(facturaAEliminar);
		return facturaAEliminar;
	}	
	
	public void listarFacturas () {
		for (Factura factura : facturas) {
			System.out.println(factura.toString());
		}
	}

}

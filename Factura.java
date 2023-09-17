package fabricaSillas;

import java.util.ArrayList;

public class Factura {
	private EstadoFactura estado;
	private Pedido pedido;
	
	public Factura(EstadoFactura estado, Pedido pedido) {
		super();
		this.estado = estado;
		this.pedido = pedido;
	}
	
	@Override
	public String toString() {
		return "Factura [estado=" + estado + ", pedido=" + pedido + "]";
	}
	
	
	
	/*
	private agregarPedido() {
		
	}
	
	private eliminarPedido() {
		
	}
	
	private actualizarPedido() {
		
	}
	
	private actualizarEstado(){
	}
	*/
}

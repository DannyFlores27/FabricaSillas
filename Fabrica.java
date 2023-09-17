package fabricaSillas;

import java.util.ArrayList;

public class Fabrica {
	private ArrayList <Producto> inventario;
	private ArrayList <Pedido> pedidos;
	
	public Fabrica() {
		super();
		this.pedidos = new ArrayList<>();
	}
	
	public void agregarPedido(Pedido pedido) {
		this.pedidos.add(pedido);
	}
	
	/* pendiente de realizar
	  
	 public agregarAlInventario(){
	 }
	 
	 private eliminarPedido(){
	 }
	 
	 private buscarEnInventario(){
	 	return;
	 }
	 
	 */
}

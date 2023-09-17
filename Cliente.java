package fabricaSillas;

import java.util.ArrayList;

public class Cliente {
	private String nombre;
	private String apellido;
	private String nit;
	private String residencia;
	private String telefono;
	private CategoriaCliente categoria;
	private ArrayList<Pedido>pedidos;
	
	
	
	public Cliente(String nombre, String apellido, String nit, String residencia, String telefono,
			CategoriaCliente categoria) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.nit = nit;
		this.residencia = residencia;
		this.telefono = telefono;
		this.categoria = categoria;
	}

	public Cliente() {
		super();
		this.pedidos = new ArrayList<>();
	}
	
	public void agregarPedido(Pedido pedido) {
		this.pedidos.add(pedido);
	}
	
	
	/*
	
	private asignarCategoria() {
		
	}
	
	private agregarPedido(){
	}
	
	*/
}

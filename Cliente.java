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
		this.pedidos = new ArrayList<>();
	}

	public void agregarPedido(Pedido pedido) {
		this.pedidos.add(pedido);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getResidencia() {
		return residencia;
	}

	public void setResidencia(String residencia) {
		this.residencia = residencia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public CategoriaCliente getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaCliente categoria) {
		this.categoria = categoria;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public void listarPedidos () {
		for (Pedido pedido : pedidos) {
			System.out.println(pedido);
		}
	}
	
}

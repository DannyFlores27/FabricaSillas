package fabricaSillas;

public class Factura {
	private static Integer contador = 0;
	private Integer id;
	private EstadoFactura estado;
	private Pedido pedido;
	private Double totalAPagarSinIva = 0.00;
	private Double totalAPagar = 0.00;
	private Double saldo = 0.00;
	private Double iva = 0.00;
	private Double anticipo = 0.00;
	private static Double porcentajeIva = 0.12;
	private static Double porcentajeAnticipo = 0.5;
	private boolean anticipoPagado = false;
	
	public Factura(Pedido pedido) {
		super();
		contador++;
		this.id = contador;
		this.pedido = pedido;
		//this.totalAPagarSinIva = pedido.getTotalPrecioProductos();
		//this.totalAPagarSinIva -= (totalAPagarSinIva * pedido.getCliente().getCategoria().getDescuento());
		this.estado = EstadoFactura.SIN_PAGAR;
	}
	
	public void actualizarPedido() {
		this.totalAPagarSinIva = pedido.getTotalPrecioProductos();
		calcularIva();
		calcularTotalAPagar();
		calcularAnticipo();
		this.saldo = totalAPagar;
	}	
	
	public void pagarAnticipo() {
		if(anticipoPagado != true) {
			this.saldo -= anticipo;
			anticipoPagado = true;
		}else {
			System.out.println("Invalido. No hay saldo de anticipo.");
		}
	}
	
	public boolean abonarASaldo(Double abono) {
		boolean aplicado = false;
		if(abono > 0 && abono <= saldo) {
			this.saldo -= abono;
			aplicado = true;
		}
		return aplicado;
	}
	
	public void setEstado(EstadoFactura estado) {
		this.estado = estado;
	}

	public void setTotalAPagar(Double monto) {
		this.totalAPagar = monto;
	}
	
	public void descontarProducto(Double monto) {
		this.totalAPagarSinIva = monto;
		
	}
	
	public Integer getId() {
		return id;
	}
	
	public Double getSaldo() {
		return saldo;
	}

	public Double getIva() {
		return iva;
	}

	public Double getAnticipo() {
		return anticipo;
	}

	public void listarProductos () {
		pedido.listarProductosFactura();
	}
	
	private void calcularIva() {
		this.iva = totalAPagarSinIva * porcentajeIva;
	}
	
	private void calcularTotalAPagar() {
		this.totalAPagar = totalAPagarSinIva + iva;
	}
	
	private void calcularAnticipo() {
		this.anticipo = totalAPagar * porcentajeAnticipo;
	}
		
}

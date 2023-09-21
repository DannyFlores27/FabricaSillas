package fabricaSillas;

public enum TipoProducto {
	COMEDOR_CLASICO (300.00, 2),
	COMEDOR_ALTO (375.00, 3),
	ISLA_COCINA (450.00, 4),
	BARRA (450.00, 4),
	BANCO_CLASICO (250.00, 1),
	BANCO_ALTO (300.00, 2);
	
	private Double precio;
	private Integer tiempo;
	
	private TipoProducto(Double precio, int tiempo) {
		this.precio = precio;
		this.tiempo = tiempo;
	}

	public Double getPrecio() {
		return precio;
	}
	
	public Integer getTiempo() {
		return tiempo;
	}
	
}

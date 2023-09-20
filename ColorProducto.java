package fabricaSillas;

public enum ColorProducto {
	NATURAL_CLARO (100.00, 1),
	NATURAL_OSCURO (100.00, 1),
	BLANCO (100.00, 1),
	BLANCO_ROTO (100.00, 1),
	NEGRO (100.00, 1),
	NEGRO_OXIDO (100.00, 1),
	ROJO (100.00, 1),
	PERSONALIZADO (150.00, 2);

	private Double precio;
	private Integer tiempo;
	
	private ColorProducto(Double precio, Integer tiempo) {
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

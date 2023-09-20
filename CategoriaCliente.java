package fabricaSillas;

public enum CategoriaCliente {
	SILVER (0.00),
	GOLD (0.01),
	PLATINUM (0.04);
	
	private Double descuento;
	
	private CategoriaCliente(Double descuento) {
		this.descuento = descuento;
	}

	public Double getDescuento() {
		return descuento;
	}
	
}

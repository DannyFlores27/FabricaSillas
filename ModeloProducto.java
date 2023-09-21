package fabricaSillas;

public enum ModeloProducto {
	VINTAGE_RETRO (100.00, 2),
	COLONIAL (125.00, 2),
	RUSTICO (100.00, 2),
	CLASICO (100.00, 2),
	MODERNO_CONTEMPORANEO (125.00, 2),
	NORDICO_ESCANDINAVO_A1 (150.00, 3),
	NORDICO_ESCANDINAVO_A2 (150.00, 3),
	DESCANSO (200.00, 3),
	DESCANSO_CON_BRAZOS (250.00, 4),
	INFANTIL_OVAL (75.00, 1),
	INFANTIL_REDONDA (60.00, 1),
	EXTERIOR (200.00, 3),
	EXTERIOR_CON_BRAZOS (250.00, 4),
	JUVENIL_A1 (125.00, 2),
	JUVENIL_A2 (125.00, 2),
	INDUSTRIAL_A1 (150.00, 3),
	INDUSTRIAL_A2 (175.00, 3);
	
	private Double precio;
	private Integer tiempo;
	
	private ModeloProducto(Double precio, Integer tiempo) {
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

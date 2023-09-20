package fabricaSillas;

public class Producto {
	private static Integer contador = 0;
	private Integer id;
	private Integer tiempo;
	private Double precio;
	private Etapa etapa;
	private ColorProducto color;
	private ModeloProducto modelo;
	private TipoProducto tipo;
	
	
	
	public Producto(ColorProducto color, ModeloProducto modelo, TipoProducto tipo) {
		super();
		contador++;
		this.id = contador;
		this.color = color;
		this.modelo = modelo;
		this.tipo = tipo;
		this.etapa = Etapa.EN_COLA;
		this.precio = color.getPrecio() + modelo.getPrecio() + tipo.getPrecio();
		this.tiempo = color.getTiempo() + modelo.getTiempo() + tipo.getTiempo();
	}
	
	public String datosFactura() {
		return "Producto [Id=" + id + "modelo=" + modelo + ", tipo=" +  tipo + ", color=" + color + "precio=" + precio + "]";
	}
		
	public Double getPrecio() {
		return precio;
	}
	
	public Integer getTiempo() {
		return tiempo;
	}

	public Etapa getEtapa() {
		return etapa;
	}
	
	public Integer getId() {
		return id;
	}
		
	public void setEtapa(Etapa etapa) {
		this.etapa = etapa;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + "tiempo=" + tiempo + ", precio=" + precio + ", etapa=" + etapa + ", color=" + color
				+ ", modelo=" + modelo + ", tipo=" + tipo + "]";
	}

}

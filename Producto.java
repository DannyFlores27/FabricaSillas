package fabricaSillas;

public class Producto {
	private Double tiempo;
	private Double precio;
	private Etapa etapa;
	private ColorProducto color;
	private ModeloProducto modelo;
	private TipoProducto tipo;
	
	
	
	public Producto(ColorProducto color, ModeloProducto modelo, TipoProducto tipo) {
		super();
		this.color = color;
		this.modelo = modelo;
		this.tipo = tipo;
	}
	
	public String datosFactura() {
		return "Producto [modelo=" + modelo + ", tipo=" +  tipo + ", color=" + color + "precio=" + precio + "]";
	}
	
	@Override
	public String toString() {
		return "Producto [tiempo=" + tiempo + ", precio=" + precio + ", etapa=" + etapa + ", color=" + color
				+ ", modelo=" + modelo + ", tipo=" + tipo + "]";
	}

	
	
	
	
	/* Pendiente de generar funciones
	private double calcularTiempo() {
		//Pendiente de realizar
		return;
	}
	
	private double calcularPrecio() {
		//Pendiente de realizar
		return;
	}
	
	private actualizarEtapa() {
		//Pendiente de realizar
	}
	
	
	private asignarColor() {
		//Pendiente de realizar
	}
	
	
	private asignarModelo() {
		//Pendiente de realizar
	}
	*/
}

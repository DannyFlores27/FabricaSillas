package fabricaSillas;

import java.util.Scanner;

public class Main {
	
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		Fabrica fabrica = new Fabrica();
		//cargarFabrica(fabrica);
		
		System.out.println("Bienvenido a la Fabrica de sillas.");

        MenuOpciones menuOpciones = MenuOpciones.z;
        

        while (menuOpciones != MenuOpciones.s)
            try
            {
                menuPrincipal();


                menuOpciones = MenuOpciones.valueOf(input.nextLine());


                switch (menuOpciones)
                {
                    case a:
                        // crearPedido();
                        break;

                    case b:
                        // menuPedidos();
                        break;

                    case c:
                        // menuFacturacion();
                        break;

                    case d:
                        // menuInventario();
                        break;

                    case e:
                    	// menuProduccion();
                        break;

                    case s:
                        System.out.println("Gracias por su tiempo.");
                        break;

                    default:
                        System.out.println("Seleccion fuera de rango. Intentar de nuevo");
                }
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("Seleccion fuera de rango. Intentar de nuevo:");
            }


    }

    public static void menuPrincipal()
    {
        System.out.println("\nIngresar:");
        System.out.println("\ta. Crear pedido");
        System.out.println("\tb. Pedidos");
        System.out.println("\tc. Facturacion");
        System.out.println("\td. Inventario");
        System.out.println("\te. Produccion.");
        System.out.println("\tq. Salir de aplicacion.");
        System.out.print("\nSeleccion-> ");

    }
    
    enum MenuOpciones
    {
        z("Continuar"), a("Crear pedido"), b("Pedidos"), c("Facturacion"),
        d("Inventario"), e("Produccion"), s("Salir de aplicacion");

        // field
        private String meaning;

        // constructor
        MenuOpciones(String meaning)
        {
            this.meaning = meaning;
        }

        // getters
        public String getMeaning()
        {
            return meaning;
        }
    }
	
	private static void cargarFabrica(Fabrica fabrica) {
		Cliente cliente1 = new Cliente("Alex", "Cordero", "90706439", "Ciudad", "12345678", CategoriaCliente.PLATINUM);
		
		Producto producto1 = new Producto(ColorProducto.BLANCO, ModeloProducto.CLASICO, TipoProducto.COMEDOR_ALTO);
		
		Pedido pedido1 = new Pedido(cliente1);
		
		pedido1.agregarProducto(producto1);
		
		Factura factura1 = new Factura(EstadoFactura.ANTICIPO_CANCELADO, pedido1);
		
		fabrica.agregarPedido(pedido1);
		
		pedido1.listarProductos();
	}

}

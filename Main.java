package fabricaSillas;

import java.util.Scanner;

public class Main implements ValidarDatos {
	
	private static Scanner input = new Scanner(System.in);
	public static Integer eleccion;

	public static void main(String[] args) {
		Fabrica fabrica = new Fabrica();
		
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
                        crearPedido(fabrica);
                        break;

                    case b:
                        menuPedidos(fabrica);
                        break;

                    case c:
                        menuAnticiposPagos(fabrica);
                        break;

                    case d:
                        menuProduccion(fabrica);
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
        System.out.println("\tc. Anticipo y pago de clientes");
        System.out.println("\td. Produccion.");
        System.out.println("\ts. Salir de aplicacion.");
        System.out.print("\nSeleccion-> ");

    }
    
    enum MenuOpciones
    {
        z("Continuar"), a("Crear pedido"), b("Pedidos"), c("Facturacion"),
        d("Produccion"), s("Salir de aplicacion");

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
    
    private static void crearPedido(Fabrica fabrica) {
    	
    	System.out.println("Creando un pedido.");
    	System.out.println("Ingrese los siguientes datos del cliente: ");
    	System.out.println("Nombre: ");
    	String nombre = ValidarDatos.IngLetras();
    	System.out.println("Apellido: ");
    	String apellido = ValidarDatos.IngLetras();
    	System.out.println("Nit: ");
    	String nit = ValidarDatos.IngNit();
    	System.out.println("Residencia: ");
    	String residencia = new String(input.nextLine());
    	System.out.println("Telefono: ");
    	String telefono = ValidarDatos.IngTelefono();
    	System.out.println("Categoria: ");
    	CategoriaCliente categoriaCliente = ValidarDatos.elegirCatCliente();
    	
    	Cliente cliente = new Cliente(nombre, apellido, nit, residencia, telefono, categoriaCliente);
    	Pedido pedido = new Pedido(cliente);
    	Factura factura = new Factura(pedido);
    	
    	System.out.println("Pedido iniciado.");
    	
    	Integer eleccionCrearPedido = 1;
    	 while (eleccionCrearPedido != 0)
             try
             {
            	 System.out.println("1. Agregar producto\n2. Mostrar productos del pedido\n3.Eliminar producto\n0. Terminar pedido");
                 eleccionCrearPedido = Integer.valueOf(input.nextInt());

                 switch (eleccionCrearPedido)
                 {
                     case 1:
                    	 System.out.println("Ingrese los siguientes datos del producto: ");
                    	 System.out.println("Color: ");
                    	 ColorProducto color = ValidarDatos.elegirColorProducto();
                    	 System.out.println("Modelo: ");
                    	 ModeloProducto modelo = ValidarDatos.elegirModeloProducto();
                    	 System.out.println("Tipo: ");
                    	 TipoProducto tipo = ValidarDatos.elegirTipoProducto();
                    	 
                    	 Producto producto = new Producto(color, modelo, tipo);
                    	 pedido.agregarProducto(producto);
                    	 factura.actualizarPedido();
                    	 System.out.println("Producto ingresado exitosamente.");
                         break;

                     case 2:
                         pedido.listarProductos();
                         System.out.println("Total precio productos: " +pedido.getTotalPrecioProductos());
                         break;

                     case 3:
                    	 pedido.listarProductos();
                    	 System.out.println("Ingrese el id del producto que desea eliminar: ");
                         Producto productoEliminado = pedido.eliminarProducto(input.nextInt());
                         factura.actualizarPedido();
                         System.out.println("Producto eliminado " + productoEliminado);
                         break;

                     case 0:
                    	 System.out.println("Total precio productos: Q." + pedido.getTotalPrecioProductos());
                    	 pedido.setEntrega(ValidarDatos.elegirEntrega());
                    	 fabrica.agregarPedido(pedido);
                    	 fabrica.agregarFactura(factura);
                    	 factura.listarProductos();
                         System.out.println("Pedido creado correctamente.");
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
    
    private static void menuPedidos(Fabrica fabrica) {
    	
    	Integer eleccionPedidos = 1;
    	 while (eleccionPedidos != 0)
             try
             {
            	 System.out.println("1. Listar pedidos\n2. Buscar pedido\n3.Eliminar pedido\n0. Regresar a menu principal");
                 eleccionPedidos = Integer.valueOf(input.nextInt());

                 switch (eleccionPedidos)
                 {
                     case 1:
                    	 fabrica.listarPedidos();
                         break;

                     case 2:
                    	 System.out.println("Ingrese el id del pedido: ");
                    	 Pedido encontrado = fabrica.buscarPedido(input.nextInt());
                    	 if(encontrado != null) {
                    		 System.out.println("Se a encontrado el pedido: " + encontrado.toString());
                    	 }else {
                    		 System.out.println("No se a encontrado el pedido. ");
                    	 }
                         break;

                     case 3:
                    	 fabrica.listarPedidos();
                    	 System.out.println("Ingrese el id del pedido que desea eliminar: ");
                         Pedido pedidoEliminado = fabrica.eliminarPedido(input.nextInt());

                         if(pedidoEliminado != null) {
                        	 Factura facturaAELiminar = fabrica.eliminarFactura(pedidoEliminado.getFactura().getId());
                        	 System.out.println("Pedido eliminado " + pedidoEliminado.toString()); 
                         }else {
                        	 System.out.println("Pedido no encontrado");
                         }
                         break;

                     case 0:

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
    
    private static void menuAnticiposPagos(Fabrica fabrica) {
    	
    	Integer eleccionAnticipoPago = 1;
    	 while (eleccionAnticipoPago != 0)
             try
             {
            	 System.out.println("1. Listar facturas\n2. Buscar factura\n3.Pagar anticipo\n4.Abonar\n0. Regresar a menu principal");
                 eleccionAnticipoPago = Integer.valueOf(input.nextInt());

                 switch (eleccionAnticipoPago)
                 {
                     case 1:
                    	 fabrica.listarFacturas();
                         break;

                     case 2:
                    	 System.out.println("Ingrese el id de la factura: ");
                         fabrica.buscarFactura(input.nextInt());
                         break;

                     case 3:
                    	 System.out.println("Ingrese el id de la factura: ");
                         Factura facturaAnticipo = fabrica.buscarFactura(input.nextInt());
                         System.out.println("Monto de anticipo: Q." + facturaAnticipo.getAnticipo());

                         Integer eleccionPagarAnticipo = 1;
                    	 while (eleccionPagarAnticipo != 0)
                             try
                             {
                            	 System.out.println("Pagar: \n\t1. Si\n\t0. No");
                                 eleccionPagarAnticipo = Integer.valueOf(input.nextInt());

                                 switch (eleccionPagarAnticipo)
                                 {
                                     case 1:
                                         facturaAnticipo.pagarAnticipo();
                                         System.out.println("Anticipo pagado exitosamente.");
                                         eleccionPagarAnticipo = 0;
                                         break;

                                     case 0:
                                    	 
                                         break;

                                     default:
                                         System.out.println("Seleccion fuera de rango. Intentar de nuevo");
                                 }
                             }
                             catch (IllegalArgumentException e)
                             {
                                 System.out.println("Seleccion fuera de rango. Intentar de nuevo:");
                             }
                         break;
                         
                     case 4:
                    	 System.out.println("Ingrese el id de la factura: ");
                         Factura facturaAbono = fabrica.buscarFactura(input.nextInt());
                         System.out.println("Saldo de factura Q." + facturaAbono.getSaldo());

                         Integer eleccionPagarAbono = 1;
                    	 while (eleccionPagarAbono != 0)
                             try
                             {
                            	 System.out.println("Pagar: \n\t1. Si\n\t0. No");
                                 eleccionPagarAbono = Integer.valueOf(input.nextInt());

                                 switch (eleccionPagarAbono)
                                 {
                                     case 1:
                                         if(facturaAbono.abonarASaldo(input.nextDouble())) {
                                        	 System.out.println("Abono realizado exitosamente");
                                        	 eleccionPagarAbono = 0;
                                         }else {
                                        	 System.out.println("Abono no valido");
                                         }
                                         break;

                                     case 0:
                                    	 
                                         break;

                                     default:
                                         System.out.println("Seleccion fuera de rango. Intentar de nuevo");
                                 }
                             }
                             catch (IllegalArgumentException e)
                             {
                                 System.out.println("Seleccion fuera de rango. Intentar de nuevo:");
                             }
                         break;

                     case 0:

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
    
    private static void menuProduccion(Fabrica fabrica) {
    	
    	Integer eleccionProduccion = 1;
    	 while (eleccionProduccion != 0)
             try
             {
            	 System.out.println("1. Actualizar etapa de un pedido\n2. Actualizar etapa de un producto\n3.Actualizar entrega de un pedido\n0. Regresar a menu principal");
                 eleccionProduccion = Integer.valueOf(input.nextInt());

                 switch (eleccionProduccion)
                 {
                     case 1:
                    	 fabrica.listarPedidos();
                    	 System.out.println("Ingrese el id del pedido: ");
                    	 Pedido pedidoEncontrado = fabrica.buscarPedido(input.nextInt());
                    	 if(pedidoEncontrado != null) {
                        	 pedidoEncontrado.setEtapa(ValidarDatos.elegirEtapa());
                        	 System.out.println(pedidoEncontrado.toString());
                    	 }else {
                    		 System.out.println("Pedido no encontrado.");
                    	 }

                         break;

                     case 2:
                    	 fabrica.listarPedidos();
                    	 System.out.println("Ingrese el id del pedido: ");
                    	 Pedido pedidoActProducto = fabrica.buscarPedido(input.nextInt());
                    	 pedidoActProducto.listarProductos();
                    	 System.out.println("Ingrese el id del producto: ");
                    	 Producto productoAActualizar = pedidoActProducto.buscarProducto(input.nextInt());
                    	 if(productoAActualizar != null) {
                        	 productoAActualizar.setEtapa(ValidarDatos.elegirEtapa());
                        	 System.out.println(productoAActualizar.toString());
                    	 }else {
                    		 System.out.println("Producto no encontrado.");
                    	 }

                         break;

                     case 3:
                    	 fabrica.listarPedidos();
                    	 System.out.println("Ingrese el id del pedido: ");
                    	 Pedido pedidoActEntrega = fabrica.buscarPedido(input.nextInt());
                    	 if(pedidoActEntrega != null) {
                    		 pedidoActEntrega.setEntrega(ValidarDatos.elegirEntrega());
                        	 System.out.println(pedidoActEntrega.toString());
                    	 }else {
                    		 System.out.println("Pedido no encontrado.");
                    	 }
                    	 
                         break;
                         
                     case 0:

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

}

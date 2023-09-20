package fabricaSillas;

import java.util.Scanner;

public interface ValidarDatos {
	
	//Metodo para ingresar un nit valido
    public static String IngNit (){
        Scanner entrada=new Scanner(System.in);
        int cuentaNum=0, factor, sumaTotal=0, resultado;
        boolean nitValid=false;
        String nit="", digitoControl="";
        do{
            System.out.println("\tNit: Sin guion: Si hay letras en mayuscula: ");
            nit=entrada.nextLine();
            //Primer filtro solo numeros
            cuentaNum=0;
            for(int i=0; i<nit.length(); i++){
                switch(nit.charAt(i)){
                    case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9': case '0':
                        cuentaNum++;
                        break;
                }
            }
            //Validando ultimo digito puede ser K o k
            switch(nit.charAt(nit.length()-1)){
                case 'K':
                    cuentaNum++;
                    break;
            }
            //Validando digitos correctos en nit con respecto al largo
            if(cuentaNum==nit.length()){
                factor=nit.length();
                resultado=0;
                digitoControl="";
                sumaTotal=0;
                //Suma y multiplicacion de factor con respecto al largo del nit
                for(int i=0; (i<nit.length()-1); i++){
                    sumaTotal=sumaTotal+((Integer.parseInt(Character.toString(nit.charAt(i))))*factor);
                    factor--;
                }
                resultado=sumaTotal%11;
                resultado=11-resultado;
                if(resultado<10){
                    digitoControl=Integer.toString(resultado);
                }else if(resultado==11){
                    digitoControl="0";
                }else{
                    digitoControl="K";
                }
            }
            if(digitoControl.equalsIgnoreCase(Character.toString(nit.charAt(nit.length()-1)))){
                nitValid=true;
                System.out.println("Nit valido");
            }else{
                System.out.println("Nit no valido");
            }
        }while(nitValid!=true);
        return nit;
    }

  //Metodo para ingresar numero de telefono valido
    public static String IngTelefono (){
        boolean telValid=false;
        String telefono="", digitos="";
        Scanner entrada=new Scanner(System.in);
        do{
            System.out.println("\tTelefono: ");
            int cuentaDigitos=0;
            digitos=entrada.nextLine();
            if(digitos.length()==8){
                cuentaDigitos=0;
                for(int i=0; i<digitos.length(); i++){
                    switch(digitos.charAt(i)){
                        case '1': case'2': case'3': case'4': case'5': case'6': case'7': case'8': case'9': case'0':
                            cuentaDigitos++;
                    }
                }
                if(cuentaDigitos==8){
                telefono=digitos;
                System.out.println("¡Telefono valido!");
                telValid=true;
                }else{
                    System.out.println("¡Telefono no valido!");
                }
            }else{
                System.out.println("¡Telefono no valido!");
            }
        }while(telValid!=true);
        return telefono;
    }

  //Metodo ingresar letras
    public static String IngLetras(){
        boolean valid=false;
        int letters=0;
        String palabra ="";
        Scanner entrada=new Scanner(System.in);
        do{
            System.out.println("\tIngresar: ");
            palabra = entrada.nextLine();
            letters=0;
                        for(int i=0; i<palabra.length(); i++){
                            switch(palabra.charAt(i)){
                            	case'A': case'B': case'C': case'D': case'E': case'F': case'G': case'H': case'I': case'J': case'K': case'L': case'M': case'N': case'P': case'Q': case'R': case'S': case'T': case'U': case'V': case'W': case'X': case'Y': case'Z':
                                case'a': case'b': case'c': case'd': case'e': case'f': case'g': case'h': case'i': case'j': case'k': case'l': case'm': case'n': case'p': case'o': case'r': case's': case't': case'u': case'v': case'w': case'x': case'y': case'z':
                            	letters++;
                            break;
                            }
                        }
                        if(letters == palabra.length()){
                            System.out.println("¡Valido!");
                            valid=true;
                        }else{
                            System.out.println("¡No valido!");
                        }
        }while(valid!=true);
        return palabra;
    }

	public static CategoriaCliente elegirCatCliente() {
		Scanner input = new Scanner(System.in);
		Integer i = 0;
		boolean valid = false;
		CategoriaCliente categoria = CategoriaCliente.SILVER;
		while (valid != true) {
			System.out.println("Categoria de cliente: 1.Silver 2.Gold 3.Platinum");
			i = input.nextInt();
			switch(i) {
			case 1: categoria = CategoriaCliente.SILVER; valid = true;
			case 2: categoria = CategoriaCliente.GOLD; valid = true;
			case 3: categoria = CategoriaCliente.PLATINUM; valid = true;
			}
		}

		return categoria;
	}
	
	public static ColorProducto elegirColorProducto() {
		Scanner input = new Scanner(System.in);
		Integer i = 0;
		boolean valid = false;
		ColorProducto color = ColorProducto.NATURAL_CLARO;
		while (valid != true) {
			System.out.println("Color: \n\t1.Natural claro\n\t2.Natural oscuro\n\t3.Blanco\n\t4.Blanco roto\n\t5.Negro\n\t6.Negro oxido\n\t7.Rojo\n\t8.Personalizado");
			i = input.nextInt();
			switch(i) {
			case 1: color = ColorProducto.NATURAL_CLARO; valid = true;
			case 2: color = ColorProducto.NATURAL_OSCURO; valid = true;
			case 3: color = ColorProducto.BLANCO; valid = true;
			case 4: color = ColorProducto.BLANCO_ROTO; valid = true;
			case 5: color = ColorProducto.NEGRO; valid = true;
			case 6: color = ColorProducto.NEGRO_OXIDO; valid = true;
			case 7: color = ColorProducto.ROJO; valid = true;
			case 8: color = ColorProducto.PERSONALIZADO; valid = true;
			}
		}
		return color;
	}
	
	public static ModeloProducto elegirModeloProducto() {
		Scanner input = new Scanner(System.in);
		Integer i = 0;
		boolean valid = false;
		ModeloProducto modelo = ModeloProducto.CLASICO;
		while (valid != true) {
			System.out.println("Modelo: \n\t1.Vintage retro\n\t2.Colonial\n\t3.Rustico\n\t4.Clasico\n\t5.Moderno contemporaneo\n\t6.Nordico escandinavo A1\n\t7.Nordico escandinavo A2"
					+ "\n\t8.Descanso\n\t9.Descanso con brazos\n\t10.Infantil oval\n\t11.Infantil redonda\n\t12.Exterior\n\t13.Exterior con brazos\n\t14.Juvenil A1\n\t15.Juvenil A2"
					+ "\n\t16.Insdustrial A1\n\t17.Industrial A2");

			i = input.nextInt();
			switch(i) {
			case 1: modelo = ModeloProducto.VINTAGE_RETRO; valid = true;
			case 2: modelo = ModeloProducto.COLONIAL; valid = true;
			case 3: modelo = ModeloProducto.RUSTICO; valid = true;
			case 4: modelo = ModeloProducto.CLASICO; valid = true;
			case 5: modelo = ModeloProducto.MODERNO_CONTEMPORANEO; valid = true;
			case 6: modelo = ModeloProducto.NORDICO_ESCANDINAVO_A1; valid = true;
			case 7: modelo = ModeloProducto.NORDICO_ESCANDINAVO_A2; valid = true;
			case 8: modelo = ModeloProducto.DESCANSO; valid = true;
			case 9: modelo = ModeloProducto.DESCANSO_CON_BRAZOS; valid = true;
			case 10: modelo = ModeloProducto.INFANTIL_OVAL; valid = true;
			case 11: modelo = ModeloProducto.INFANTIL_REDONDA; valid = true;
			case 12: modelo = ModeloProducto.EXTERIOR; valid = true;
			case 13: modelo = ModeloProducto.EXTERIOR_CON_BRAZOS; valid = true;
			case 14: modelo = ModeloProducto.JUVENIL_A1; valid = true;
			case 15: modelo = ModeloProducto.JUVENIL_A2; valid = true;
			case 16: modelo = ModeloProducto.INDUSTRIAL_A1; valid = true;
			case 17: modelo = ModeloProducto.INDUSTRIAL_A2; valid = true;
		}
		}
		return modelo;
	}
	
	public static TipoProducto elegirTipoProducto() {
		Scanner input = new Scanner(System.in);
		Integer i = 0;
		boolean valid = false;
		TipoProducto tipo = TipoProducto.COMEDOR_CLASICO;
		while (valid != true) {
			System.out.println("Tipo: \n\t1.Comedor clasico\n\t2.Comedor alto\n\t3.Isla cocina\n\t4.Barra\n\t5.Banco clasico\n\t6.Banco alto");
			i = input.nextInt();
			switch(i) {
			case 1: tipo = TipoProducto.COMEDOR_CLASICO; valid = true;
			case 2: tipo = TipoProducto.COMEDOR_ALTO; valid = true;
			case 3: tipo = TipoProducto.ISLA_COCINA; valid = true;
			case 4: tipo = TipoProducto.BARRA; valid = true;
			case 5: tipo = TipoProducto.BANCO_CLASICO; valid = true;
			case 6: tipo = TipoProducto.BANCO_ALTO; valid = true;
			}
		}
		return tipo;
	}
	
	public static Entregar elegirEntrega() {
		Scanner input = new Scanner(System.in);
		Integer i = 0;
		boolean valid = false;
		Entregar entrega = Entregar.EN_TIENDA;
		while (valid != true) {
			System.out.println("Elegir entrega: \n\t1.En tienda\n\t2.Delivery");
			i = input.nextInt();
			switch(i) {
			case 1: entrega = Entregar.EN_TIENDA; valid = true;
			case 2: entrega = Entregar.DELIVERY; valid = true;
			}
		}
		return entrega;
	}
    
	public static Etapa elegirEtapa() {
		Scanner input = new Scanner(System.in);
		Integer i = 0;
		boolean valid = false;
		Etapa etapa = Etapa.EN_COLA;
		while (valid != true) {
			System.out.println("Elegir etapa: \n\t1.En cola\n\t2.En produccion\n\t3.Terminado"
					+ "\n\t4.Empacado\n\t5.Entregado a delivery\n\t6.En tienda");
			i = input.nextInt();
			switch(i) {
			case 1: etapa = Etapa.EN_COLA; valid = true;
			case 2: etapa = Etapa.EN_PRODUCCION; valid = true;
			case 3: etapa = Etapa.TERMINADO; valid = true;
			case 4: etapa = Etapa.EMPACADO; valid = true;
			case 5: etapa = Etapa.ENTREGADO_DELIVERY; valid = true;
			case 6: etapa = Etapa.EN_TIENDA; valid = true;
			}
		}
		return etapa;
	}
	
}

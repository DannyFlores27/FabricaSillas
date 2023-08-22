class Persona {
  private String nit;
  private String nombre;
  private String apellido;
  private String telefono;
  private String direccion;

public Persona (String nit, String nombre, String apellido, String telefono, String direccion){
  this.nit=nit;
  this.nombre=nombre;
  this.apellido=apellido;
  this.telefono=telefono;
  this.direccion=direccion;
}
  
public String getNit() {
	return nit;
}
public void setNit(String nit) {
	this.nit = nit;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}


}

class Colaborador extends Persona {

  private String fechaInicioContrato;
  private String fechaFinContrato;
  private Integer cui;
  private Integer id;
  
  public Colaborador (String nit, String nombre, String apellido, String telefono, String direccion, String fechaInicioContrato, String fechaFinContrato, Integer cui, Integer id){
  super(nit, nombre, apellido, telefono, direccion);
    this.fechaFinContrato = fechaFinContrato;
    this.fechaFinContrato = fechaFinContrato;
    this.cui = cui;
    this.id = id;
}
}

class Supervisor extends Colaborador {
  
  public Supervisor (String nit, String nombre, String apellido, String telefono, String direccion, String fechaInicioContrato, String fechaFinContrato, Integer cui, Integer id){
  super(nit, nombre, apellido, telefono, direccion);
}

  boolean inspeccionCalidad (){
    boolean valid=true;
    System.out.println("Supervisor inspecciono");
    return valid;
  }
}

class Vendedor extends Supervisor {
  
  public Vendedor (String nit, String nombre, String apellido, String telefono, String direccion, String fechaInicioContrato, String fechaFinContrato, Integer cui, Integer id){
  super(nit, nombre, apellido, telefono, direccion);
}

  boolean vender (){
    boolean valid=true;
    System.out.println("Vendedor hizo venta");
    return valid;
  }

  boolean facturar (){
    boolean valid=true;
    System.out.println("Vendedor facturo");
    return valid;
  }

  boolean solicitarMercaderia (){
    boolean valid=true;
    System.out.println("Vendedor solicito mercaderia");
    return valid;
  }
}

interface Reportar {

    public hacerReporte {
    System.out.println("Reporte lleno");
  }
  
}
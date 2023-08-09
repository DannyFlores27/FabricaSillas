public class Material {
  private String nombre;
  private Integer cantidadStock;
  private String numeroParte;
  private Integer estado;

  public Material(String nombre, Integer cantidadStock, String numeroParte, Integer estado) {
    this.nombre = nombre;
    this.cantidadStock = cantidadStock;
    this.numeroParte = numeroParte;
    this.estado = estado;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Integer getCantidadStock() {
    return cantidadStock;
  }

  public void setCantidadStock(Integer cantidadStock) {
    this.cantidadStock = cantidadStock;
  }

  public String getNumeroParte() {
    return numeroParte;
  }

  public void setNumeroParte(String numeroParte) {
    this.numeroParte = numeroParte;
  }

  public Integer getEstado() {
    return estado;
  }

  public void setEstado(Integer estado) {
    this.estado = estado;
  }

}
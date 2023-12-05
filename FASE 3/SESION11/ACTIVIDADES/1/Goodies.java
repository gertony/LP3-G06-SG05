public class Goodies {
  private Integer id;
  private String descripcion;
  private float price;
  
  public Goodies(Integer id, String descripcion, float price) {
    this.id = id;
    this.descripcion = descripcion;
    this.price = price;
  }
  public float getPrice() {
    return price;
  }
  public void setPrice(float price) {
    this.price = price;
  }
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getDescripcion() {
    return descripcion;
  }
  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  @Override
  public boolean equals(Object obj){
    if(obj instanceof Goodies){
      Goodies tmpGoodies = (Goodies) obj;
      if(this.id.equals(tmpGoodies.id)){
        return true;
      }else{return false;}
    }else{return false;}
  }

}

public class Procedencia {
  private String departamento;
  private String provincia;
  public String getDepartamento() {
    return departamento;
  }
  public void setDepartamento(String departamento) {
    this.departamento = departamento;
  }
  public String getProvincia() {
    return provincia;
  }
  public void setProvincia(String provincia) {
    this.provincia = provincia;
  }
  public Procedencia(String departamento, String provincia) {
    this.departamento = departamento;
    this.provincia = provincia;
  }

  @Override
  public boolean equals(Object obj){
    if(obj instanceof Procedencia){
      Procedencia tmpProcedencia = (Procedencia) obj;
      if(this.departamento.equals(tmpProcedencia.departamento) && this.provincia.equals(tmpProcedencia.provincia)){
        return true;
      }else{return false;
    }

  }else{return false;}
}}

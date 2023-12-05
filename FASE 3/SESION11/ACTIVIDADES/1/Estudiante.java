public class Estudiante extends Persona {
  private String especialidad;
  private Procedencia proced;
  public String getEspecialidad() {
    return especialidad;
  }
  public Procedencia getProced() {
    return proced;
  }
  public Estudiante(String nombres, String dirreccion, String telefono, String especialidad, Procedencia proced) {
    super(nombres, dirreccion, telefono);
    this.especialidad = especialidad;
    this.proced = proced;
  }

  @Override
  public boolean equals(Object obj){
    if(obj instanceof Estudiante){
      Estudiante tmpEstudiante = (Estudiante) obj;
      if(super.equals(tmpEstudiante) && this.proced.equals(tmpEstudiante.proced))
      {return true;}
      else{return false;}
    }{return false;}
  }


}

class Bicicleta implements ImpactoEcologico{
  private boolean bicicletaElectrica;

  public Bicicleta(boolean bicicletaElectrica){
    this.bicicletaElectrica = bicicletaElectrica;
  }

  @Override
  public double obtenerImpactoEcologico(){

    double datoActividad = bibicletaElectrica ? 0.5 : 2.0;

    double factorEmision = 0.05;
    return datoActividad * factorEmision;
  }
}

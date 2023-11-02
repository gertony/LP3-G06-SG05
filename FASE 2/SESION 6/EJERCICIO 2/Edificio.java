class Edificio implements ImpactoEcologico {
    private int consumoEnergia; // Atributo ejemplo

    public Edificio(int consumoEnergia) {
        this.consumoEnergia = consumoEnergia;
    }

    @Override
    public double obtenerImpactoEcologico() {

        double datoActividad = consumoEnergia * 2.5;

        double factorEmision = 0.5;
        return datoActividad * factorEmision;
    }
}
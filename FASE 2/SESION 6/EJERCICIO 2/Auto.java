class Auto implements ImpactoEcologico {
    private int emisionCO2; // Atributo ejemplo

    public Auto(int emisionCO2) {
        this.emisionCO2 = emisionCO2;
    }

    @Override
    public double obtenerImpactoEcologico() {

        double datoActividad = emisionCO2 * 1.2;

        double factorEmision = 0.3;

        return datoActividad * factorEmision;
    }
}
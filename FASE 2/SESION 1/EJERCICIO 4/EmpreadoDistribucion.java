public class EmpleadoDistribucion extends Asalariado {

    private String region;

    public EmpleadoDistribucion(String nombre, long dni, int diasVacaciones, double salario, String region) {
        super(nombre, dni, diasVacaciones, (salario + (salario * 0.15)));
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "--------------------------------------\n" +
                "Empleado Distribucion\n" +
                "DNI        : " + getDni() + "\n" +
                "Nombre     : " + getNombre() + "\n" +
                "Vacaciones : " + getDiasVacaciones() + " días " + "   Zona  : " + region + "\n" +
                "Salario    : " + getSalario() + "\n" +
                "--------------------------------------";
    }

}

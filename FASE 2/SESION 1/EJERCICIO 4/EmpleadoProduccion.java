public class EmpleadoProduccion extends Asalariado {
    private String turno;

    public EmpleadoProduccion(String nombre, long dni, int diasVacaciones, double salario, String turno) {
        super(nombre, dni, diasVacaciones, salario + (salario * 0.10));
        this.turno = turno;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "--------------------------------------\n" +
                "Empleado Produccion\n" +
                "DNI        : " + getDni() + "\n" +
                "Nombre     : " + getNombre() + "\n" +
                "Vacaciones : " + getDiasVacaciones() + " días" + "   Turno  : " + turno + "\n" +
                "Salario    : " + getSalario()+ "\n" +
                "--------------------------------------";
    }

}

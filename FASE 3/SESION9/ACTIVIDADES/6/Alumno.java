public class Alumno extends Personal {
    private Fecha fechaMatricula;

    public Alumno(String nif, String nombre, int edad, Fecha fechaMatricula) {
        super(nif, nombre, edad);
        this.fechaMatricula = fechaMatricula;
    }

    public Alumno() {
        this.fechaMatricula = new Fecha();
    }

    public Fecha getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(Fecha fechaMatricula) {
        this.fechaMatricula.setDia(fechaMatricula.getDia());
        this.fechaMatricula.setMes(fechaMatricula.getMes());
        this.fechaMatricula.setAnnio(fechaMatricula.getAnnio());
    }

    @Override
public String toString() {
    return "NIF: " + nif + "\nNombre: " + nombre + "\nEdad: " + edad + "\nFecha de Matrícula: " + fechaMatricula.toString();
}

}


public class Persona implements Comparable<Persona> {

    private String nombre;
    private int dni;
    private String direccion;

    public Persona(String nombre, int dni, String direccion) {
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public int compareTo(Persona b) {
        if (this.nombre.compareTo(b.nombre) != 0) {
            return this.nombre.compareTo(b.nombre);
        } else {
            return 0;
        }

    }

    @Override
    public String toString() {
        return (" |Nombre: " + nombre + " - DNI: " + dni + " - Direccion:" + direccion + "|\n");
    }
}

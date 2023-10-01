
public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private Cuenta cuenta;
    private char tipo;

    public char getTipo() {
        return this.tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    static int aux = 1;

    static int numero = 0;

    public Persona() {
    }

    public Persona(int id, String nombre, String apellido, char tipo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        aux++;
        this.cuenta = new Cuenta(aux);
        this.tipo = tipo;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cuenta=" + cuenta + ", tipo="
                + tipo + "]";
    }

}

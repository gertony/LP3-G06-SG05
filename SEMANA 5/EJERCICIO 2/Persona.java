
public class Persona {
    private int genero;
    private String nombre;
    private String trabaja;
    private int sueldo=0;

    public Persona(int genero, String nombre, String trabaja, int sueldo) {
        this.genero = genero;
        this.nombre = nombre;
        this.trabaja = trabaja;
        this.sueldo=sueldo;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTrabaja() {
        return trabaja;
    }

    public void setTrabaja(String trabaja) {
        this.trabaja = trabaja;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
    
}


import java.util.Arrays;

public class Banco {
    private String nombre;
    private Persona clientes[];
    private int numClientes;

    public Banco(String nombre, int numCli) {
        this.nombre = nombre;
        this.clientes = new Persona[numCli];
        this.numClientes = 0;
    }

    public void agregarCliente(Persona persona) {
        if (numClientes < clientes.length) {
            clientes[numClientes] = persona;
            numClientes++;
        } else {
            System.out.println("No se pueden agregar más clientes. El banco está lleno.");
        }
    }

    public Persona darBajaCliente(Persona persona) {
        for (int i = 0; i < numClientes; i++) {
            if (clientes[i].equals(persona)) {
                Persona clienteDadoDeBaja = clientes[i];

                for (int j = i; j < numClientes - 1; j++) {
                    clientes[j] = clientes[j + 1];
                }
                clientes[numClientes - 1] = null;
                numClientes--;
                return clienteDadoDeBaja;
            }
        }
        System.out.println("El cliente no esta en el banco.");
        return null;
    }

    public boolean buscarCliente(Persona persona) {
        for (int i = 0; i < numClientes; i++) {
            if (clientes[i].equals(persona)) {
                return true;
            }
        }
        return false;
    }

    public void clientesTipo(char tipo) {
        System.out.println("Clientes de tipo '" + tipo + "':");
        for (int i = 0; i < numClientes; i++) {
            if (clientes[i].getTipo() == tipo) {
                System.out.println(clientes[i]);
            }
        }
    }

    public Banco(String nombre) {
        this(nombre, 20);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Persona[] getClientes() {
        return clientes;
    }

    public void setClientes(Persona[] clientes) {
        this.clientes = clientes;
    }

    @Override
    public String toString() {
        return "Banco [nombre=" + nombre + ", clientes=" + Arrays.toString(clientes) + "]";
    }
}

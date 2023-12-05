import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String[] arrayStrings1 = { "A", "B", "C" };
        String[] arrayStrings2 = { "B", "C", "D" };

        String[] resultadoStrings = copyArray(arrayStrings1, arrayStrings2);
        imprimirArray(resultadoStrings);

        Producto[] arrayProductos1 = {
                new Producto(1, "Producto1", 10.0),
                new Producto(2, "Producto2", 15.0)
        };
        Producto[] arrayProductos2 = {
                new Producto(2, "Producto2", 15.0),
                new Producto(3, "Producto3", 20.0)
        };

        Producto[] resultadoProductos = copyArray(arrayProductos1, arrayProductos2);
        imprimirArray(resultadoProductos);

        Persona[] arrayPersonas1 = {
                new Persona("111", "Persona1", "Dirección1"),
                new Persona("222", "Persona2", "Dirección2")
        };
        Persona[] arrayPersonas2 = {
                new Persona("222", "Persona2", "Dirección2"),
                new Persona("333", "Persona3", "Dirección3")
        };

        Persona[] resultadoPersonas = copyArray(arrayPersonas1, arrayPersonas2);
        imprimirArray(resultadoPersonas);
    }

    public static <T> T[] copyArray(T[] arr1, T[] arr2) {
        List<T> resultList = new ArrayList<>();
        resultList.addAll(Arrays.asList(arr1));

        for (T element : arr2) {
            if (!resultList.contains(element)) {
                resultList.add(element);
            }
        }

        T[] resultado = resultList.toArray((T[]) Arrays.copyOf(arr1, 0));
        return resultado;
    }

    private static <T> void imprimirArray(T[] arr) {
        for (T element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

class Producto {
    private int codigo;
    private String descripcion;
    private double precio;

    public Producto(int codigo, String descripcion, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                '}';
    }
}

class Persona {
    private String dni;
    private String nombre;
    private String direccion;

    public Persona(String dni, String nombre, String direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}

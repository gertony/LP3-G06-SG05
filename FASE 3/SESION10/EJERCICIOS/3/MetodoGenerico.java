public class MetodoGenerico {

    public static void main(String[] args) {
        System.out.println(isEqualTo(2, 4)); // Integer
        System.out.println(isEqualTo(2.5, 2.5)); // Double
        System.out.println(isEqualTo("hola", "adios")); // String
        System.out.println(isEqualTo("hola", "hola")); // String

        Persona p1 = new Persona("Juan", 23, "M");
        Persona p2 = new Persona("Luigi", 18, "M");

        System.out.println(isEqualTo(p1, p2));

        Persona p3 = p1;
        System.out.println(isEqualTo(p1, p3));
    }

    public static <T> boolean isEqualTo(T obj1, T obj2) {
        if (obj1.equals(obj2)) {
            System.out.println("Los elementos " + obj1 + " y " + obj2 + " son iguales.");
            return true;
        } else {
            System.out.println("Los elementos " + obj1 + " y " + obj2 + " son diferentes.");
            return false;
        }
    }
}

class Persona {
    String nombre;
    int edad;
    String genero;

    public Persona(String nombre, int edad, String genero) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
    }
}

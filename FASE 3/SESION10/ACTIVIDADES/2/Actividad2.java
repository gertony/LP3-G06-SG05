
public class Actividad2 {
    public static void main(String[] args) {
        System.out.printf("Maximo de %d, %d, %d y %d es %d%n%n",
                3, 4, 5, 1, minimo(3, 4, 5, 1));
        System.out.printf("Maximo de %.1f, %.1f, %.1f y %.1f es %.1f%n%n",
                6.6, 7.7, 8.8, 5.6, minimo(6.6, 7.7, 8.8, 5.6));
        System.out.printf("Maximo de %s, %s, %s and %s es %s%n%n",
                "pera", "zanahoria", "uva", "happens", minimo("pera", "zanahoria", "uva", "happens"));

        Persona a = new Persona("Juan", 2043214, "calle magia");
        Persona b = new Persona("Pedro", 343240, "calle 1");
        Persona c = new Persona("María", 4432340, "calle 2");
        Persona d = new Persona("Angel", 1423420, "calle 3");

        System.out.println("La persona menor es: " + minimo(a, b, c, d));

    }

    public static <T extends Comparable<T>> T minimo(T x, T y, T z, T d) {
        T min = x;
        if (y.compareTo(min) < 0) {
            min = y;
        }
        if (z.compareTo(min) < 0) {
            min = z;
        }
        if (d.compareTo(min) < 0) {
            min = d;
        }
        return min;
    }
}

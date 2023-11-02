public class EjemploAsercion {
    public static void main(String[] args) {
        int x = 10;
        int y = 5;

        // Verificar que y sea menor que x usando una asercion
        assert y < x : "y no es menor que x";

        System.out.println("Programa continúa después de la aserción.");
    }
}

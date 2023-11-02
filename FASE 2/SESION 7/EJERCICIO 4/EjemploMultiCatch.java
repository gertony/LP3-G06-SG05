public class EjemploMultiCatch {
    public static void main(String[] args) {
        try {
            int[] numbers = { 1, 2, 3 };
            int result = numbers[4] / 0;
        } catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
            // Esta cláusula catch maneja tanto ArrayIndexOutOfBoundsException como ArithmeticException.
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }
    }
}

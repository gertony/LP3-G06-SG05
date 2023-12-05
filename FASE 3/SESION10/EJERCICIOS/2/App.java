public class App {

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"uno", "dos", "tres", "cuatro", "cinco"};

        System.out.println("Array original de enteros:");
        imprimirArray(intArray);

        intercambiarElementos(intArray, 1, 3);

        System.out.println("\nArray después del intercambio:");
        imprimirArray(intArray);

        System.out.println("\nArray original de cadenas:");
        imprimirArray(strArray);

        intercambiarElementos(strArray, 0, 4);

        System.out.println("\nArray después del intercambio:");
        imprimirArray(strArray);
    }

    public static <T> void intercambiarElementos(T[] array, int indice1, int indice2) {
        T temp = array[indice1];
        array[indice1] = array[indice2];
        array[indice2] = temp;
    }

    public static <T> void imprimirArray(T[] array) {
        for (T elemento : array) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }
}

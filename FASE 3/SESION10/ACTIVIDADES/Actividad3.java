public class Actividad3 {

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

       imprimirArray(array);

        try {
            imprimirArray(array, 2, 5);
        } catch (LimiteInvalidoException e) {
            System.err.println(e.getMessage());
        }
    }

    public static <T> void imprimirArray(T[] array) {
        try {
            imprimirArray(array, 0, array.length - 1);
        } catch (LimiteInvalidoException e) {
            System.err.println(e.getMessage());
        }
    }

    public static <T> void imprimirArray(T[] array, int limiteInferior, int limiteSuperior) throws LimiteInvalidoException {
        if (limiteInferior < 0 || limiteSuperior >= array.length || limiteInferior > limiteSuperior) {
            throw new LimiteInvalidoException("Los limites ingresados son invalidos");
        }

        for (int i = limiteInferior; i <= limiteSuperior; i++) {
            System.out.println(array[i]);
        }
    }
}

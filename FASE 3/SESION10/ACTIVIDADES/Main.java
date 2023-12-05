import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Float[] floatArray = { (float) 1.2, (float) 2.3, (float) 1.4, (float) 1.3, (float) 1.3 };
        Boolean[] booleanArray = { false, true, true, true, false };
        Persona p1 = new Persona("Juan", 72727272, "calle 123 a");
        Persona p2 = new Persona("Marco", 654542442, "calle 1234");
        Persona p3 = new Persona("Antoine", 71234124, "calle p 12");
        Persona[] personaArray = { p1, p2, p3 };

        System.out.printf("Array AfloatArray contiene:%n");
        imprimirArray(floatArray);
        System.out.printf("%nArray BooleanArray contiene:%n");
        imprimirArray(booleanArray);
        System.out.printf("%nArray PersonaArray contiene:%n");
        imprimirArray(personaArray);
    }

    public static <T> void imprimirArray(T[] inputArray) {
        for (T elemento : inputArray)
            System.out.printf("%s ", elemento);
        System.out.println();
    }
}
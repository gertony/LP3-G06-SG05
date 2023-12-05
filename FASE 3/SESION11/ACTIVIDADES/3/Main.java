
package main;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Bag<Integer> integerBag = new Bag<>(5);
            integerBag.add(1);
            integerBag.add(2);
            integerBag.add(3);
            System.out.println("Bolsa de enteros: " + integerBag);
            integerBag.remove(3);
            System.out.println("Después de quitar el 3: " + integerBag);

            Bag<String> stringBag = new Bag<>(5);
            stringBag.add("Hola");
            stringBag.add("Mundo");
            stringBag.add("Hola");
            System.out.println("Bolsa de cadenas: " + stringBag);
            stringBag.remove("Hola");
            System.out.println("Después de quitar 'Hola': " + stringBag);

            // Clase Persona simplificada para ejemplo
            Bag<Persona> personaBag = new Bag<>(3);
            personaBag.add(new Persona("Nombre1", 20));
            personaBag.add(new Persona("Nombre2", 25));
            System.out.println("Bolsa de personas: " + personaBag);
            personaBag.remove(new Persona("Nombre2", 25));
            System.out.println("Después de quitar persona2: " + personaBag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

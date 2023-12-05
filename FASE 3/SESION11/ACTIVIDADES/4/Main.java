/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
    package main;
import java.util.ArrayList;
import java.util.List;
// Clase base Goodies
class Goodies {
    private String name;

    public Goodies(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Otros métodos y atributos relevantes para Goodies
}

// Clase Biscuits que hereda de Goodies
class Biscuits extends Goodies {
    private int quantity;

    public Biscuits(String name, int quantity) {
        super(name);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    // Otros métodos y atributos específicos para Biscuits
}

// Clase Chocolate que hereda de Goodies
class Chocolate extends Goodies {
    private String type;

    public Chocolate(String name, String type) {
        super(name);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    // Otros métodos y atributos específicos para Chocolate
}

// Clase Soda que hereda de Biscuits
class Soda extends Biscuits {
    private String flavor;

    public Soda(String name, int quantity, String flavor) {
        super(name, quantity);
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    // Otros métodos y atributos específicos para Soda
}

// Clase Sweet que hereda de Biscuits
class Sweet extends Biscuits {
    private boolean isFilling;

    public Sweet(String name, int quantity, boolean isFilling) {
        super(name, quantity);
        this.isFilling = isFilling;
    }

    public boolean isFilling() {
        return isFilling;
    }

    // Otros métodos y atributos específicos para Sweet
}

public class Main {
    public static void main(String[] args) {
        try {
            Bag<Goodies> goodiesBag = new Bag<>(5);

            goodiesBag.add(new Biscuits("Cookie", 10));
            goodiesBag.add(new Chocolate("Dark Chocolate", "Bitter"));
            goodiesBag.add(new Soda("Cola", 6, "Cola flavor"));
            goodiesBag.add(new Sweet("Donut", 12, true));

            System.out.println("Bolsa de Goodies: " + goodiesBag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


package com.mycompany.principal;
public class Principal {
    public static void main(String[] args) {
        // Crear un objeto Manejador
        Manejador manejador = new Manejador(5, 3);

        // Mostrar el área y el perímetro iniciales
        System.out.println("Área inicial: " + manejador.area());
        System.out.println("Perímetro inicial: " + manejador.perimetro());

        // Mostrar el color del rectángulo
        System.out.println("Color inicial: " + manejador.getColor());

        // Mover el rectángulo y mostrar la nueva posición
        manejador.moverX(2); // Mueve el rectángulo 2 unidades en la dirección X
        manejador.moverY(1); // Mueve el rectángulo 1 unidad en la dirección Y
        System.out.println("Nueva posición: " + manejador.r.toString());

        // Mostrar el área y el perímetro después de mover el rectángulo
        System.out.println("Área después de mover: " + manejador.area());
        System.out.println("Perímetro después de mover: " + manejador.perimetro());
    }
}

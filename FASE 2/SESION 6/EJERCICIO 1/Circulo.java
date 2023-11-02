/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author USER
 */
public class Circulo extends FiguraBidimensional{
    private int r;
    private final String color = "Rojo";
    public Circulo(int r) {
        this.r = r;
    }
    
    public void obtenerArea(){
        System.out.println("El área del círculo: " + 3.1415*r*r);
    }

    public String getColor() {
        return color;
    }
}

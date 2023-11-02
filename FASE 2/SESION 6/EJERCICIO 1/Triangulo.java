/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author USER
 */
public class Triangulo extends FiguraBidimensional{
    private int base;
    private int altura;
    public Triangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }
    public void obtenerArea(){
        System.out.println("Área: " + (base*altura)/2);
    }
}

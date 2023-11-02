/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author USER
 */
public class Cuadrado extends FiguraBidimensional{
    private int l;
    public Cuadrado(int l){
        this.l=l;
    }
    public void obtenerArea(){
        System.out.println("Area: " + l*l);
    }
}

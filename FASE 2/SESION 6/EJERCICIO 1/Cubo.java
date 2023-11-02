/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author USER
 */
public class Cubo extends FiguraTridimensional{
    private int l;
    public Cubo(int l) {
        this.l = l;
    }
    public void obtenerArea(){
        System.out.println("Área: " + 6*l*l);
    }
    public void obtenerVolumen(){
        System.out.println("Volumen: " + l*l*l);
    }
}

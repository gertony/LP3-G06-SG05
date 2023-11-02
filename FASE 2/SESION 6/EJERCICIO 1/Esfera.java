/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author USER
 */
public class Esfera extends FiguraTridimensional{
    private int r;
    public Esfera(int r) {
        this.r = r;
    }
    public void obtenerArea(){
        System.out.println("Área: " + 4*3.14*r*r);
    }
    public void obtenerVolumen(){
        System.out.println("Volumen: " + (4*3.14*r*r*r)/3);
    }
}

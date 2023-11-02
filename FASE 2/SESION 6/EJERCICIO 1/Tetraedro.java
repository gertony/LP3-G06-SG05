/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author USER
 */
public class Tetraedro extends FiguraTridimensional{
    private int l;
    private final String aplicacion="Egipto";
    public Tetraedro(int l) {
        this.l = l;
    }
    public void obtenerArea(){
        System.out.println("Área: " + l*l*Math.sqrt(3));
    }
    public void obtenerVolumen(){
        System.out.println("Volumen: " + (l*l*l*Math.sqrt(2)/12));
    }
    public String getAplicacion() {
        return aplicacion;
    }
}
package com.mycompany.principal;
public class Rectangulo {
    private Coordenada esquina1;
    private Coordenada esquina2;
    private String color; // Variable de instancia para el color

    // Variable de clase para rastrear el último color
    private static String ultimoColor = "rojo";

    public Rectangulo(int base, int altura) {
        this.esquina1 = new Coordenada(0, 0);
        this.esquina2 = new Coordenada(base, altura);
        asignarSiguienteColor(); // Asignar el siguiente color al crear un rectángulo
    }

    // Método para asignar el siguiente color en la secuencia
    private void asignarSiguienteColor() {
        if (ultimoColor.equals("rojo")) {
            color = "verde";
            ultimoColor = "verde";
        } else {
            color = "amarillo";
            ultimoColor = "amarillo";
        }
    }
    public Coordenada getEsquina1() {
        return esquina1;
    }

    public void setEsquina1(Coordenada esquina1) {
        this.esquina1 = esquina1;
    }

    public Coordenada getEsquina2() {
        return esquina2;
    }

    public void setEsquina2(Coordenada esquina2) {
        this.esquina2 = esquina2;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Rectangulo [esquina1=" + esquina1 + ", esquina2=" + esquina2 + ", color=" + color + "]";
    }
}


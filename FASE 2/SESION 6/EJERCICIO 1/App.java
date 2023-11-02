
package app;

public class App {
    public static void main(String[] args) {
        Figura figuras[] = new Figura[6];
        figuras[0] = new Circulo(2);
        figuras[1] = new Cuadrado(6);
        figuras[2] = new Triangulo(2, 3);
        figuras[3] = new Esfera(6);
        figuras[4] = new Cubo(2);
        figuras[5] = new Tetraedro(6);
        for (Figura arreglo : figuras) {
            System.out.println("Descripcion: " + arreglo.getClass().getSimpleName());
            if (arreglo instanceof FiguraBidimensional) {
                arreglo.obtenerArea();
                if (arreglo instanceof Circulo) {
                    String color = ((Circulo) arreglo).getColor();
                    System.out.println("Color del círculo: " + color);
                }
            }
            if (arreglo instanceof FiguraTridimensional figura3D) {
                figura3D.obtenerArea();
                figura3D.obtenerVolumen();
                if (arreglo instanceof Tetraedro) {
                    String aplicacion = ((Tetraedro) arreglo).getAplicacion();
                    System.out.println("Aplicación del tetraedro: " + aplicacion);
                }
            }
        }
    }
}

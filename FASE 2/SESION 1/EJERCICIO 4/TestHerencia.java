public class TestHerencia {
    public static void main(String[] args) {
        Asalariado emplead1 = new Asalariado("Manuel Cortina", 12345678, 28, 2000.00);
        EmpleadoProduccion emplead2 = new EmpleadoProduccion("Juan Mota", 55333222, 30, 2000.00, "noche");
        EmpleadoDistribucion emplead3 = new EmpleadoDistribucion("Antonio Camino", 55333666, 35, 2000.00, "Granada");

        System.out.println(emplead1.toString());
        System.out.println(emplead2.toString());
        System.out.println(emplead3.toString());

    }

}

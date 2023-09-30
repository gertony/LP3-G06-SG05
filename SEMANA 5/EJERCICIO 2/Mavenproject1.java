
    import java.util.ArrayList;
    import java.util.Random;
    import java.util.Scanner;

    public class Mavenproject1 {

        public static void main(String[] args) {
            Scanner sn = new Scanner(System.in);
            ArrayList<Persona> personas = new ArrayList<>();
            int hombresTotales = 0;
            int hombresTrabajan = 0;
            int mujeresTotales = 0;
            int mujeresTrabajan = 0;
            int sueldosHombres = 0;
            int hombresConTrabajo = 0;
            int sueldosMujeres = 0;
            int mujeresConTrabajo = 0;

            for (int i = 1; i < 9; i++) {
                System.out.println("Ingrese el genero de la persona " + i + " (1 para masculino, 2 para femenino):");
                int genero = sn.nextInt();
                sn.nextLine();
                System.out.println("Trabaja la persona " + i + "? (S/N):");
                String trabaja = sn.nextLine();
                int sueldo = 0;
                if (trabaja.equalsIgnoreCase("S")) {
                    System.out.println("Ingrese el sueldo de la persona " + i + ":");
                    sueldo = sn.nextInt();

                    if (genero == 1) {
                        hombresTrabajan++;
                        sueldosHombres += sueldo;
                    } else if (genero == 2) {
                        mujeresTrabajan++;
                        sueldosMujeres += sueldo;
                    }
                }

                Persona p = new Persona(genero,"Persona " +i , trabaja, sueldo);
                personas.add(p);
            }

            hombresTotales = hombresTrabajan + (8 - personas.size() / 2);
            mujeresTotales = 8 - hombresTotales;

            double porcentajeHombres = (double) hombresTotales / 8 * 100;
            double porcentajeMujeres = (double) mujeresTotales / 8 * 100;
            double porcentajeHombresTrabajan = (double) hombresTrabajan / hombresTotales * 100;
            double porcentajeMujeresTrabajan = (double) mujeresTrabajan / mujeresTotales * 100;
            double sueldoPromedioHombres = (double) sueldosHombres / hombresTrabajan;
            double sueldoPromedioMujeres = (double) sueldosMujeres / mujeresTrabajan;

            System.out.println("Porcentaje de hombres (tengan o no trabajo): " + porcentajeHombres + "%");
            System.out.println("Porcentaje de mujeres (tengan o no trabajo): " + porcentajeMujeres + "%");
            System.out.println("Porcentaje de hombres que trabajan: " + porcentajeHombresTrabajan + "%");
            System.out.println("Porcentaje de mujeres que trabajan: " + porcentajeMujeresTrabajan + "%");
            System.out.println("Sueldo promedio de hombres que trabajan: " + sueldoPromedioHombres);
            System.out.println("Sueldo promedio de mujeres que trabajan: " + sueldoPromedioMujeres);
        }
    }


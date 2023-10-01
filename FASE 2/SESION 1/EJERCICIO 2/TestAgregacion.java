
package testagregacion;
import java.util.Scanner;

public class TestAgregacion {

    public static void main(String[] args) {
        int op = 1;
        Automovil auto = null;
        Motor motor = null;

        while (op != 4) {
            System.out.println("MENU");
            System.out.println("1.- Agregar Nuevo Auto");
            System.out.println("2.- Agregar Motor");
            System.out.println("3.- Información");
            System.out.println("4.- Salir");
            System.out.println("Ingrese una opción: ");

            Scanner sn = new Scanner(System.in);
            op = sn.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Ingrese la placa del auto: ");
                    String placa = sn.next();
                    System.out.println("Ingrese el número de puertas: ");
                    int puertas = sn.nextInt();
                    System.out.println("Ingrese la marca del auto: ");
                    String marca = sn.next();
                    System.out.println("Ingrese el modelo del auto: ");
                    String modelo = sn.next();
                    auto = new Automovil(placa, puertas, marca, modelo);
                    System.out.println("Auto agregado exitosamente!");
                    break;
                case 2:
                    System.out.println("Ingrese el número del motor: ");
                    int numMotor = sn.nextInt();
                    System.out.println("Ingrese las revoluciones por minuto: ");
                    int revPorMin = sn.nextInt();
                    motor = new Motor(numMotor, revPorMin);
                    System.out.println("Motor agregado exitosamente!");
                    break;
                case 3:
                    if (auto != null) {
                        System.out.println(auto.toString());
                    } else {
                        System.out.println("No se ha agregado ningún auto aún.");
                    }
                    if (motor != null) {
                        System.out.println(motor.toString());
                    } else {
                        System.out.println("No se ha agregado ningún motor aún.");
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción del 1 al 4.");
                    break;
            }
        }
    }
}

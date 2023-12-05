import java.util.Scanner;

public class Contactos {
    public static void main(String[] args) {
        Dictionary2<String, DatosPersona> agenda = new Dictionary2<>();
        Scanner sc = new Scanner(System.in);
        int opc;

        do {
            System.out.println("1. Agregar contacto");
            System.out.println("2. Eliminar contacto");
            System.out.println("3. Obtener información de contacto");
            System.out.println("4. Mostrar todos los contactos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    System.out.print("Ingrese el DNI del contacto: ");
                    String dni = sc.nextLine();
                    System.out.print("Ingrese los datos del contacto: ");
                    String datos = sc.nextLine();

                    agenda.add(dni, new DatosPersona(datos));
                    System.out.println("Contacto agregado.");
                    break;
                case 2:
                    System.out.print("Ingrese el DNI del contacto a eliminar: ");
                    String dniEliminar = sc.nextLine();

                    if (agenda.delete(dniEliminar)) {
                        System.out.println("Contacto eliminado.");
                    } else {
                        System.out.println("No se encontró el contacto.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el DNI del contacto a consultar: ");
                    String dniConsultar = sc.nextLine();

                    try {
                        DatosPersona datosPersona = agenda.getValue(dniConsultar);
                        System.out.println("Datos del contacto: " + datosPersona);
                    } catch (ObjectNoExistException e) {
                        System.out.println("No se encontró el contacto.");
                    }
                    break;
                case 4:
                    agenda.imprimirArray();
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opc != 0);
        sc.close();
    }
}

class DatosPersona {
    private String datos;

    public DatosPersona(String datos) {
        this.datos = datos;
    }

    @Override
    public String toString() {
        return datos;
    }
}

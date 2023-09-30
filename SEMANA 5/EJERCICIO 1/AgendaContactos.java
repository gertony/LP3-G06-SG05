
import java.util.ArrayList;
import java.util.Scanner;

public class AgendaContactos {
    private ArrayList<Contactos> contactos;

    public AgendaContactos() {
        contactos = new ArrayList<>();
    }

    public void agregarContacto(Contactos contacto) {
        contactos.add(contacto);
    }

    public Contactos buscarContacto(String nombre) {
        for (Contactos contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                return contacto;
            }
        }
        return null;
    }

    public void modificarContacto(String nombre, String nuevoNombre, String nuevoTelefono, String nuevaDireccion) {
        Contactos contacto = buscarContacto(nombre);
        if (contacto != null) {
            contacto.setNombre(nuevoNombre);
            contacto.setTelefono(nuevoTelefono);
            contacto.setDireccion(nuevaDireccion);
            System.out.println("Contacto modificado");
        } else {
            System.out.println("Contacto no encontrado");
        }
    }

    public void borrarContacto(String nombre) {
        Contactos contacto = buscarContacto(nombre);
        if (contacto != null) {
            contactos.remove(contacto);
            System.out.println("Contacto borrado con exito");
        } else {
            System.out.println("Contacto no encontrado");
        }
    }

    public void mostrarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos en la agenda");
        } else {
            System.out.println("Lista de contactos:");
            for (Contactos contacto : contactos) {
                System.out.println("-------------------------");
                System.out.println("Nombre: " + contacto.getNombre());
                System.out.println("Telefono: " + contacto.getTelefono());
                System.out.println("Direccion: " + contacto.getDireccion());
                System.out.println("-------------------------");
            }
        }
    }

    public void eliminarTodosLosContactos() {
        contactos.clear();
    }

    public static void main(String[] args) {
        AgendaContactos agenda = new AgendaContactos();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("-------------------------");
            System.out.println("\nMenú de la Agenda de Contactos:");
            System.out.println("1. Anadir contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Modificar contacto");
            System.out.println("4. Borrar contacto");
            System.out.println("5. Eliminar todos los contactos");
            System.out.println("6. Mostrar contactos");
            System.out.println("7. Salir");
            System.out.println("-------------------------");

            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del contacto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el telefono del contacto: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Ingrese la dirección del contacto: ");
                    String direccion = scanner.nextLine();
                    Contactos nuevoContacto = new Contactos(nombre, telefono, direccion);
                    agenda.agregarContacto(nuevoContacto);
                    System.out.println("Contacto agregado ");
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del contacto a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    Contactos contactoEncontrado = agenda.buscarContacto(nombreBuscar);
                    if (contactoEncontrado != null) {
                        System.out.println("Contacto encontrado:");
                        System.out.println("-------------------------");
                        System.out.println("Nombre: " + contactoEncontrado.getNombre());
                        System.out.println("Telefono: " + contactoEncontrado.getTelefono());
                        System.out.println("Direccion: " + contactoEncontrado.getDireccion());
                        System.out.println("-------------------------");
                    } else {
                        System.out.println("Contacto no encontrado");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del contacto a modificar: ");
                    String nombreModificar = scanner.nextLine();
                    System.out.print("Ingrese el nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Ingrese el nuevo telfono: ");
                    String nuevoTelefono = scanner.nextLine();
                    System.out.print("Ingrese la nueva direccion: ");
                    String nuevaDireccion = scanner.nextLine();
                    agenda.modificarContacto(nombreModificar, nuevoNombre, nuevoTelefono, nuevaDireccion);
                    break;

                case 4:
                    System.out.print("Ingrese el nombre del contacto a borrar: ");
                    String nombreBorrar = scanner.nextLine();
                    agenda.borrarContacto(nombreBorrar);
                    break;
                case 5:
                    agenda.eliminarTodosLosContactos();
                    System.out.println("Se eliminaron todos los contactos");
                    break;
                case 6:
                    agenda.mostrarContactos();
                    break;
                case 7:
                    System.out.println("Saliendo delprograma");
                    break;
                default:
                    System.out.println("ingrese una opcion valida");
            }
        }
    }
}

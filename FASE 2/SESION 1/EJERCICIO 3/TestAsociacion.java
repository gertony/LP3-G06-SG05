import java.util.Scanner;

public class TestAsociacion {
    public static void main(String[] args) {
        Banco banco1 = new Banco("BCP", 20);
        Banco banco2 = new Banco("BBVA", 20);

        Scanner scanner = new Scanner(System.in);
        int opcionBanco;

        do {
            System.out.println("\nSeleccione un banco:");
            System.out.println("1. BCP");
            System.out.println("2. BBVA");
            System.out.println("3. Salir");
            System.out.print("");

            opcionBanco = scanner.nextInt();

            if (opcionBanco == 1) {
                gestionarBanco(banco1, scanner);
            } else if (opcionBanco == 2) {
                gestionarBanco(banco2, scanner);
            } else if (opcionBanco == 3) {
                System.out.println("Saliendo del programa.");
            } else {
                System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcionBanco != 3);
    }

    public static void gestionarBanco(Banco banco, Scanner scanner) {
        int opcion;

        do {
            System.out.println("\nMenú para " + banco.getNombre() + ":");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Dar de Baja Cliente");
            System.out.println("3. Buscar Clientes por Tipo");
            System.out.println("4. Buscar Cliente por ID");
            System.out.println("5. Mostrar Todos los Clientes");
            System.out.println("6. Volver al Menú Principal");
            System.out.print("Elija una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarCliente(banco, scanner);
                    break;
                case 2:
                    darDeBajaCliente(banco, scanner);
                    break;
                case 3:
                    buscarClientesPorTipo(banco, scanner);
                    break;
                case 4:
                    buscarClientePorID(banco, scanner);
                    break;
                case 5:
                    mostrarTodosLosClientes(banco);
                    break;
                case 6:
                    System.out.println("Volviendo al Menú Principal.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;

            }

        } while (opcion != 6);
    }

    public static void agregarCliente(Banco banco, Scanner scanner) {
        System.out.print("Ingrese un id para el cliente: ");
        int id = scanner.nextInt();
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el apellido del cliente: ");
        String apellido = scanner.next();
        System.out.print("Ingrese el tipo del cliente (C/B/E): ");
        char tipo = scanner.next().charAt(0);

        System.out.print("¿Desea asignar un saldo a la cuenta? (S/N): ");
        char respuesta = scanner.next().charAt(0);
        double saldo = 0;

        if (respuesta == 'S' || respuesta == 's') {
            System.out.print("Ingrese el saldo inicial de la cuenta: ");
            saldo = scanner.nextDouble();
            Persona nuevoCliente = new Persona(id, nombre, apellido, tipo);
            Cuenta auxCuenta = new Cuenta(Persona.aux, saldo);
            nuevoCliente.setCuenta(auxCuenta);
            banco.agregarCliente(nuevoCliente);
            System.out.println("Cliente agregado con éxito.");

        } else {
            Persona nuevoCliente = new Persona(id, nombre, apellido, tipo);
            banco.agregarCliente(nuevoCliente);
            System.out.println("Cliente agregado con éxito.");
        }
    }

    public static void darDeBajaCliente(Banco banco, Scanner scanner) {
        System.out.print("Ingrese el ID del cliente a dar de baja: ");
        int idCliente = scanner.nextInt();
        Persona clienteDadoDeBaja = null;

        for (Persona cliente : banco.getClientes()) {
            if (cliente.getId() == idCliente) {
                clienteDadoDeBaja = banco.darBajaCliente(cliente);
                break;
            }
        }

        if (clienteDadoDeBaja != null) {
            System.out.println("Cliente dado de baja con éxito:\n" + clienteDadoDeBaja);
        } else {
            System.out.println("Cliente no encontrado en el banco.");
        }
    }

    public static void buscarClientesPorTipo(Banco banco, Scanner scanner) {
        System.out.print("Ingrese el tipo de cliente a buscar(C/B/E): ");
        char tipo = scanner.next().charAt(0);
        banco.clientesTipo(tipo);
    }

    public static void buscarClientePorID(Banco banco, Scanner scanner) {
        System.out.print("Ingrese el ID del cliente a buscar: ");
        int idCliente = scanner.nextInt();
        Persona cliente = buscarClientePorID(banco, idCliente);

        if (cliente != null) {
            System.out.println("Cliente encontrado:\n" + cliente);
        } else {
            System.out.println("Cliente no encontrado en el banco.");
        }
    }

    public static Persona buscarClientePorID(Banco banco, int idCliente) {
        Persona[] clientes = banco.getClientes();
        for (Persona cliente : clientes) {
            if (cliente != null && cliente.getId() == idCliente) {
                return cliente;
            }
        }
        return null;
    }

    public static void mostrarTodosLosClientes(Banco banco) {
        System.out.println("Clientes del banco " + banco.getNombre() + ":");
        for (Persona cliente : banco.getClientes()) {
            if (cliente != null) {
                System.out.println(cliente);
            }
        }
    }
}

import java.util.Scanner;

public class RegistroVentas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[][] ventas = new double[5][4];

        for (int vendedor = 0; vendedor < 4; vendedor++) {
            for (int producto = 0; producto < 5; producto++) {
                System.out
                        .print("Ventas del vendedor " + (vendedor + 1) + " para el producto " + (producto + 1) + ": $");
                ventas[producto][vendedor] = scanner.nextDouble();
            }
        }

        double[] ventasTotalesPorVendedor = new double[4];
        double[] ventasTotalesPorProducto = new double[5];

        for (int vendedor = 0; vendedor < 4; vendedor++) {
            for (int producto = 0; producto < 5; producto++) {
                ventasTotalesPorVendedor[vendedor] += ventas[producto][vendedor];
                ventasTotalesPorProducto[producto] += ventas[producto][vendedor];
            }
        }

        System.out.println("Resumen de Ventas:");
        System.out.println("Producto   Vendedor 1   Vendedor 2   Vendedor 3   Vendedor 4   Total por Producto");

        for (int producto = 0; producto < 5; producto++) {
            System.out.print("Producto " + (producto + 1) + "  ");
            for (int vendedor = 0; vendedor < 4; vendedor++) {
                System.out.print("$" + ventas[producto][vendedor] + "        ");
            }
            System.out.println("$" + ventasTotalesPorProducto[producto]);
        }

        System.out.println("Total por Vendedor:");
        for (int vendedor = 0; vendedor < 4; vendedor++) {
            System.out.println("Vendedor " + (vendedor + 1) + ": $" + ventasTotalesPorVendedor[vendedor]);
        }
    }
}

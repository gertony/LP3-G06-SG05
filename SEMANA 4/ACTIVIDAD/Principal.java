import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int matriz[][] = new int[4][4];
        boolean salir = false;
        int opcion, fila, columna;

        boolean rellenado = false;

        do {
            System.out.println("Menu");
            System.out.println("1. Rellenar Matriz");
            System.out.println("2. Sumar fila");
            System.out.println("3. Sumar columna");
            System.out.println("4. Sumar diagonal principal");
            System.out.println("5. Sumar diagonal inversa");
            System.out.println("6. Media de todos los valores de la matriz");
            System.out.println("7. Salir");
            System.out.println("Elije una opcion");
            opcion = sn.nextInt();

            switch (opcion) {
                case 1:
                    rellenarMatriz(sn, matriz);
                    rellenado = true;
                    break;
                case 2:
                    if (rellenado) {
                        do {
                            System.out.println("Elige una fila");
                            fila = sn.nextInt();
                        } while (!(fila >= 0 && fila < matriz.length));
                        System.out.println("La suma de los valores en la fila " + fila + " es: ");
                        int sumaFila = sumaFila(matriz, fila);
                        System.out.println("Resultado: " + sumaFila);
                    } else {
                        System.out.println("Debes rellenar la matriz primero");
                    }
                    break;
                case 3:
                    if (rellenado) {
                        do {
                            System.out.println("Elige una columna");
                            columna = sn.nextInt();
                        } while (!(columna >= 0 && columna < matriz[0].length));
                        System.out.println("La suma de los valores en la columna " + columna + " es: ");
                        int sumaColumna = sumaColumna(matriz, columna);
                        System.out.println("Resultado: " + sumaColumna);
                    } else {
                        System.out.println("Debes rellenar la matriz primero");
                    }
                    break;
                case 4:
                    if (rellenado) {
                        System.out.println("La suma de los valores en la diagonal principal es: ");
                        int sumaDiagonalPrincipal = sumaDiagonalPrincipal(matriz);
                        System.out.println("Resultado: " + sumaDiagonalPrincipal);
                    } else {
                        System.out.println("Debes rellenar la matriz primero");
                    }
                    break;
                case 5:
                    if (rellenado) {
                        System.out.println("La suma de los valores en la diagonal inversa es: ");
                        int sumaDiagonalInversa = sumaDiagonalInversa(matriz);
                        System.out.println("Resultado: " + sumaDiagonalInversa);
                    } else {
                        System.out.println("Debes rellenar la matriz primero");
                    }
                    break;
                case 6:
                    if (rellenado) {
                        System.out.println("La media de todos los valores de la matriz es: ");
                        double media = mediaMatriz(matriz);
                        System.out.println("Resultado: " + media);
                    } else {
                        System.out.println("Debes rellenar la matriz primero");
                    }
                    break;
                case 7:
                    salir = true;
                    break;
                default:
                    System.out.println("Tienes que meter un valor entre 1 y 7");
            }
        } while (!salir);

        System.out.println("FIN");
    }

    public static void rellenarMatriz(Scanner sn, int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.println("Escribe un numero en la posicion " + i + " " + j);
                matriz[i][j] = sn.nextInt();
            }
        }
    }

    public static int sumaFila(int[][] matriz, int fila) {
        int suma = 0;
        System.out.print("Valores en la fila " + fila + ": ");
        for (int j = 0; j < matriz.length; j++) {
            int valor = matriz[fila][j];
            suma += valor;
            System.out.print(valor + " ");
        }
        System.out.println();
        return suma;
    }
    public static int sumaColumna(int[][] matriz, int columna) {
        int suma = 0;
        System.out.print("Valores en la columna " + columna + ": ");
        for (int i = 0; i < matriz.length; i++) {
            int valor = matriz[i][columna];
            suma += valor;
            System.out.print(valor + " ");
        }
        System.out.println();
        return suma;
    }
    public static int sumaDiagonalPrincipal(int[][] matriz) {
        int suma = 0;
        System.out.print("Valores en la diagonal principal: ");
        for (int i = 0; i < matriz.length; i++) {
            int valor = matriz[i][i];
            suma += valor;
            System.out.print(valor + " ");
        }
        System.out.println();
        return suma;
    }
    public static int sumaDiagonalInversa(int[][] matriz) {
        int suma = 0;
        System.out.print("Valores en la diagonal inversa: ");
        for (int i = 0; i < matriz.length; i++) {
            int valor = matriz[i][matriz.length - 1 - i];
            suma += valor;
            System.out.print(valor + " ");
        }
        System.out.println();
        return suma;
    }
    public static double mediaMatriz(int[][] matriz) {
        int suma = 0;
        int totalValores = matriz.length * matriz[0].length;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                int valor = matriz[i][j];
                suma += valor;
            }
        }
        return (double) suma / totalValores;
    }
}

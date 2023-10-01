package com.mycompany.testcomposicion;
import java.util.Scanner;

public class TestComposicion {

    public static void main(String[] args) {
       int op=1;
        Persona p1 = new Persona('C'); // 'C' para tipo de cliente C
        Cuenta cuenta = p1.getCuenta();
        
        while(op!=5){
            System.out.println("MENU");
            System.out.println("1.- Agregar Nuevo Cliente");
            System.out.println("2.- Depositar monto");
            System.out.println("3.- Retirar monto");
            System.out.println("4.- Mostrar información");
            System.out.println("5.- Salir");
            System.out.println("Ingrese una opción: ");
            Scanner sn = new Scanner(System.in);
            op=sn.nextInt();
            switch(op){
              
                case 1:
                    System.out.println("Nombre del cliente y apellido : " );
                    sn.nextLine();
                    String nombre = sn.nextLine();
                    
                    System.out.println("Apellido del cliente : " );
                    String apellido = sn.nextLine();
                    System.out.println("ID del cliente");
                    int id=sn.nextInt();
                    System.out.println("Tipo del cliente");
                    char tipo=sn.next().charAt(0);
                    p1.setNombre(nombre);
                    p1.setId(id);
                    p1.setApellido(apellido);
                    p1.setTipoCliente(tipo);
                    break;
                case 2:
                    System.out.println("Ingrese un monto a depositar: ");
                    double dep=sn.nextDouble();
                    cuenta.depositar(dep);
                    break;
                case 3:
                    System.out.println("Ingrese un monto a retirar: ");
                    double ret=sn.nextDouble();
                    cuenta.retirar(ret);  
                    break;
                case 4:
                    System.out.println(p1.toString());
                    break;
            }
        }
    }
}

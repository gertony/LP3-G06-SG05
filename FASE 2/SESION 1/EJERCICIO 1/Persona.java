package com.mycompany.testcomposicion;

public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private Cuenta cuenta;
    private char tipoCliente;
    public static int aux;

    public Persona(char tipoCliente) {
        this.tipoCliente = tipoCliente;
        aux += 1;

        switch (tipoCliente) {
            case 'C':
                this.cuenta = new Cuenta(aux + 999, 50); 
                break;
            case 'B':
                this.cuenta = new Cuenta(aux + 4999, 50);
                break;
                        
            case 'E':
                this.cuenta = new Cuenta(aux + 7999, 50); 
                break;
            default:
                System.out.println("Tipo de cliente inválido.");
                this.cuenta = new Cuenta(0, 11
                        0);
                break;
        }
    }

    public char getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(char tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public static int getAux() {
        return aux;
    }

    public static void setAux(int aux) {
        Persona.aux = aux;
    }

    @Override
    public String toString() {
        return "Cliente= " + id + ", Nombre = " + nombre + ", Apellido = " + apellido
                + ", Numero de Cuenta = " + tipoCliente + cuenta.getNumero() +     ", Saldo = " + cuenta.getSaldo();
    }
}

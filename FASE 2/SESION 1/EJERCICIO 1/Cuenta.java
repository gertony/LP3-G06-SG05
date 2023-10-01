package com.mycompany.testcomposicion;

public class Cuenta {
    private int numero;
    private double saldo;

    public Cuenta(int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public double retirar(double cantidad) {
        saldo -= cantidad;
        return saldo;
    }

    public double depositar(double cantidad) {
        saldo += cantidad;
        return saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "numero=" + numero + ", saldo=" + saldo + '}';
    }
}


public class Cuenta {
    private int numCuenta;
    private double saldo;

    public Cuenta(int numCuenta, double saldo) {
        this.numCuenta = numCuenta;
        this.saldo = saldo;
    }

    public Cuenta(int numCuenta) {
        this(numCuenta, 0);
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cuenta [numCuenta=" + numCuenta + ", saldo=" + saldo + "]";
    }

}

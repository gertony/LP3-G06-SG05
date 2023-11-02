public class Factura implements PorPagar{
    private String numeroPieza;
    private String descripcionPieza;
    private int cantidad;
    private double precioPorArticulo;
    public int obtenerCantidad() {
        return cantidad;
    }

    public void establecerCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double obtenerPrecioPorArticulo() {
        return precioPorArticulo;
    }

    public void establecerPrecioPorArticulo(double precioPorArticulo) {
        this.precioPorArticulo = precioPorArticulo;
    }

    public Factura(String numeroPieza, String descripcionPieza, int cuenta, double precio) {
        this.numeroPieza = numeroPieza;
        this.descripcionPieza = descripcionPieza;
        establecerCantidad(cuenta);
        establecerPrecioPorArticulo(precio);
    }
    
    @Override
    public double obtenerMontoPago(){
        return obtenerCantidad() * obtenerPrecioPorArticulo();
    }
    @Override
    public String toString() {
        return "Factura{" +
                "numeroPieza='" + numeroPieza + '\'' +
                ", descripcionPieza='" + descripcionPieza + '\'' +
                ", cantidad=" + cantidad +
                ", precioPorArticulo=" + precioPorArticulo +
                '}';
    }

}
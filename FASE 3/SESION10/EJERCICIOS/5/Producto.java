class Producto implements Identificable<Integer> {
    private int codigo;
    private String desc;
    private double price;

    public Producto(int codigo, String desc, double price) {
        this.codigo = codigo;
        this.desc = desc;
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public Integer getId() {
        return getCodigo();
    }
}
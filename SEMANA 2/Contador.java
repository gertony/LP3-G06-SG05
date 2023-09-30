public class Contador {
    static int acumulador;
    private int valor;
    final static int VALOR_INICIAL = 10;
    
    public static int acumulador(){
        return acumulador;
    }

    public Contador(int valor){
        this.valor = valor;
        acumulador += valor;
        Contador.VALOR_INICIAL += valor;
    }

    public Contador(){
        new Contador(Contador.VALOR_INICIAL);
    }

    public void inc(){
       this.valor++;
        acumulador++;
    }
    public int getValor(){
        return this.valor;
    }
}

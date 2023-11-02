import java.util.ArrayList;

public class TestEcologico {
    public static void main(String[] args) {

        ArrayList<ImpactoEcologico> objetos = new ArrayList<>();

    
        Edificio edificio = new Edificio(500); 
        Auto auto = new Auto(150); 
        Bicicleta bicicleta1 = new Bicicleta(true); 
        Bicicleta bicicleta2 = new Bicicleta(false); 

        objetos.add(edificio);
        objetos.add(auto);
        objetos.add(bicicleta1);
        objetos.add(bicicleta2);

        System.out.println("---------------");
        for (ImpactoEcologico objeto : objetos) {
            System.out.println("Tipo de objeto: " + objeto.getClass().getSimpleName());
            System.out.println("Impacto Ecologico: " + objeto.obtenerImpactoEcologico() + " GEI");
            System.out.println("---------------");
        }
    }
}
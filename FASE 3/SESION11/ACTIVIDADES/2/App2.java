public class App2 {
  public static void main(String[] args) {
    OrderedPair<Integer,Integer> parInteger = new OrderedPair<Integer,Integer>((Integer)21,(Integer) 22);
    OrderedPair<Integer,String> parIntegerString = new OrderedPair<Integer,String>((Integer)21,"Holi");
    Persona p1 = new Persona("Juan", "Calle 2", "9192919291");
    OrderedPair<String, Persona> parStringPersona = new OrderedPair<String,Persona>("Happens", p1);
    System.err.println(parInteger);
        System.err.println(parIntegerString);

            System.err.println(parStringPersona);



  }
}

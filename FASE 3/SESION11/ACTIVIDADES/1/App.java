public class App {
  public static void main(String[] args) {
    
    Persona p1 = new Persona("Juan", "Calle 2", "9192919291");
    Persona p2 = new Persona("Pedro", "Calle 3", "8568658565");
    Persona p3 = new Persona("Juan", "Calle 4", "75657564");

    Persona[] pe = {p1,p2};
    
    Verificadora<Persona> verPersona = new Verificadora<>(pe);


    Goodies g1 = new Goodies((Integer)1,"Leche",(float)12.50);
    Goodies g2 = new Goodies((Integer)2,"Pollo",(float)20.50);
    Goodies g3 = new Goodies((Integer)3,"Laptp",(float)150.10);

    Goodies[] go = {g1,g2,g3};

    Verificadora<Goodies> verGoodies = new Verificadora<>(go);

    Procedencia pr1 =new Procedencia("Arequipa", "Arequipa");
    Procedencia pr2 =new Procedencia("Puno", "punoyork");


    Estudiante e1 = new Estudiante("Marco","Calle 21", "3984010431","Ingenieria", pr1);
    Estudiante e2 = new Estudiante("Juan","Calle 31", "414134","Sociales", pr2);
    Estudiante e3 = new Estudiante("Juan","Calle 44", "341431431","Sociales", pr2);

    Estudiante[] es ={e1,e2};

    Verificadora<Estudiante> verEstudiante = new Verificadora<>(es);

    System.out.println("Verificacion Personas");

    System.out.println(verPersona.contiene(p3));
    
    System.out.println("Verificacion Goodies ");

    System.out.println(verGoodies.contiene(g3));

    System.out.println("Verificacion Estudiantes");

    System.out.println(verEstudiante.contiene((e3)));


  }
}

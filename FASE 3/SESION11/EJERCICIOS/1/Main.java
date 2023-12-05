public class Main {
 public static void main(String[] args) {
 Goodies chocolate = new Goodies("Chocolate", 5);
 Goodies caramelos = new Goodies("Caramelos", 4);
 Goodies chicle = new Goodies("Chicle", 2);
 CandyBags bolsa = new CandyBags();
 bolsa.add(chocolate);
 bolsa.add(caramelos);
 bolsa.add(chicle);
 bolsa.add(chocolate); // No se debe agregar de nuevo
 Goodies cheapest = bolsa.cheapest();
 if (cheapest != null) {
 System.out.println("Golosina más barata: " +
cheapest.getName() + " - Precio: " + cheapest.getPrice() + " soles.");
 } else {
 System.out.println("La bolsa está vacía");
 }
 CandyBags mostExpensive = bolsa.mostExpensive(2);
 if (mostExpensive != null) {
 System.out.println("Las golosinas más caras:");
 for (Goodies g : mostExpensive.items) {
 System.out.println(g.getName() + " - Precio: " +
g.getPrice() + " soles.");
 }
 } else {
 System.out.println("La bolsa está vacía");
 }
 }
}

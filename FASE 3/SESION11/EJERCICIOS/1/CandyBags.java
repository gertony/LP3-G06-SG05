class CandyBags extends Bag<Goodies> {
 public CandyBags() {
 super();
 }
 @Override
 public void add(Goodies item) {
 if (!items.contains(item)) {
 super.add(item);
 } else {
 System.out.println("Esta golosina ya está en la bolsa");
 }
 }
public Goodies cheapest() {
 if (items.isEmpty()) {
 return null;
 }
 Goodies cheapestGoodie = items.get(0);
 for (Goodies g : items) {
 if (g.getPrice() < cheapestGoodie.getPrice()) {
 cheapestGoodie = g;
 }}}
public CandyBags mostExpensive(int n) {
 if (items.isEmpty()) {
 return null;
 }
 items.sort((g1, g2) -> Double.compare(g2.getPrice(), g1.getPrice()));
 CandyBags mostExpensiveBag = new CandyBags();
 for (int i = 0; i < Math.min(n, items.size()); i++) {
 mostExpensiveBag.add(items.get(i));
 }
 return mostExpensiveBag;
 }
  
 
}

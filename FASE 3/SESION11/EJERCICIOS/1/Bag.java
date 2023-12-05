class Bag<T> {
 protected List<T> items;
 public Bag() {
 this.items = new ArrayList<>();
 }
 public void add(T item) {
 items.add(item);
 }

public class OrderedPair<K,V> implements Pair<K,V> {
 private K key;
 private V value;
 public void setKey(K key) {
  this.key = key;
}
public void setValue(V value) {
  this.value = value;
}
public OrderedPair(K key, V value) {
 this.key = key;
 this.value = value;
 }
 public K getKey() {
 return this.key;
 }
 public V getValue() {
 return this.value;
 }

 @Override
 public String toString(){
  return "{key = " + key +" --- value = "+value+"}";
 }

}

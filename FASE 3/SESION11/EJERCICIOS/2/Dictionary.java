import java.util.ArrayList;

public class Dictionary<K, V> {
    public static void main(String[] args) {

        ArrayList<OrderedPair> arrai = new ArrayList<OrderedPair>();
        OrderedPair par1 = new OrderedPair<Integer, Integer>(1, 2);

        arrai.add(par1);
        add(arrai, "japens", (Integer) 2121);
        add(arrai, 24.21, "Waza");
        add(arrai, 211, (Integer) 3131);

        System.out.println(delete(arrai, 2112));
        delete(arrai, 24.21);

        try {
            Object value = getValue(arrai, 21);
            System.out.println("Valor encontrado: " + value);
        } catch (ObjectNoExistException e) {
            System.out.println(e.getMessage());

        }
        ImprimirArray(arrai);

    }

    public static <K, V> void add(ArrayList<OrderedPair> arrai, K key, V value) {
        OrderedPair<K, V> parkv = new OrderedPair<>(key, value);
        arrai.add(parkv);
    }

    public static <K, V> boolean delete(ArrayList<OrderedPair> arrai, K key) {
        for (OrderedPair<K, V> elemento : arrai) {
            if (elemento.getKey().equals(key)) {
                arrai.remove(elemento);
                return true;
            }
        }
        return false;
    }

    public static <K, V> V getValue(ArrayList<OrderedPair> arrai, K key) throws ObjectNoExistException {
        for (OrderedPair<K, V> elemento : arrai) {
            if (elemento.getKey().equals(key)) {
                return elemento.getValue();
            }
        }
        throw new ObjectNoExistException("El objeto con la clave: " + key + " no existe");
    }

    public static void ImprimirArray(ArrayList<OrderedPair> arrai) {
        for (OrderedPair elemento : arrai) {
            System.out.println(elemento);
        }
    }
}

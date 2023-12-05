public class App {

    public static void main(String[] args) {
        Producto p1 = new Producto(2113, "Limpiavidrios", 20.10);
        Producto p2 = new Producto(1441, "Papel", 10.0);
        Persona pe1 = new Persona("123456789", "Juan Pérez", "Calle A");
        Persona pe2 = new Persona("987654321", "Ana López", "Calle B");
        Estudiante e1 = new Estudiante("456789012", "Carlos González", "Calle C", "Ingeniería");
        Estudiante e2 = new Estudiante("789012345", "María Rodríguez", "Calle D", "Medicina");

        Producto[] arrProductos = { p1, p2 };
        Persona[] arrPersonas = { pe1, pe2, e1, e2 };

        System.out.println(buscarEnArrayNumerico(arrProductos, 1441));

    }

    public static <T extends Number, E extends Identificable<T>> Integer buscarEnArrayNumerico(E[] arr, T id) {
        for (int i = 0; i < arr.length; i++) {
            T objetoId = arr[i].getId();
            if (objetoId.equals(id)) {
                return i;
            }
        }
        return -1;
    }
}

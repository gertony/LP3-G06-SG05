public class Principal {
    public static void main(String[] args) {
        double[] v = new double[15];

        for (int i = 0; i < v.length; i++) {
            v[i] = i * i;
        }

        for (int i = 0; i < v.length; i++) {
            try {
                System.out.println("v[" + i + "] = " + acceso(v, i));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static double acceso(double[] v, int j) throws Exception {
        if (j >= 0 && j < v.length) {
            return v[j];
        } else {
            throw new Exception("El indice " + j + " no existe en el vector");
        }
    }
}

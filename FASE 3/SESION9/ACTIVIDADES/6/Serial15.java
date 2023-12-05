import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Serial15 {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        ObjectOutputStream salida = null;
        Alumno a;
        Fecha f;

        try {
            fos = new FileOutputStream("alumnos.dat");
            salida = new ObjectOutputStream(fos);

            f = new Fecha(5, 9, 2011);
            a = new Alumno("12345678A", "Lucas González", 20, f);
            salida.writeObject(a);
            
            f = new Fecha(7, 9, 2011);
            a = new Alumno("987654328", "Anacleto Jiménez", 19, f);
            salida.writeObject(a);

            f = new Fecha(8, 9, 2011);
            a = new Alumno("782342125", "María Zapata", 21, f);
            salida.writeObject(a);
        } catch (FileNotFoundExcep
            rintln(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fos != null)
                    fos.close();
                if (salida != null)
                    salida.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}


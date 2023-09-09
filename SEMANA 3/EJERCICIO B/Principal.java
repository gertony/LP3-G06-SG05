import java.time.Period;
import java.util.Scanner;
import java.time.format.TextStyle;
import java.util.Locale;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Principal {
    public static void main(String[] args) {
        Fecha fecha1 = new Fecha();
        Fecha fecha2 = new Fecha(15, 9, 2023);
        Fecha fecha3 = new Fecha();
        fecha3.leer();

        System.out.print("Fecha 1: ");
        fecha1.corta();

        System.out.print("Fecha 2: ");
        fecha2.corta();

        System.out.print("Fecha 3: ");
        fecha3.corta();

        fecha1.bisiesto();
        fecha2.bisiesto();

        int diasMesEnero = fecha1.diasMes(1);
        System.out.println("Enero tiene " + diasMesEnero + " días.");

        int diasMesFebrero = fecha1.diasMes(2);
        System.out.println("Febrero tiene " + diasMesFebrero + " días.");

        int diasTranscurridos = fecha2.diasTranscurrido();
        System.out.println("Días transcurridos desde 1-1-1900 hasta 15-9-2023: " + diasTranscurridos);

        int diaSemana = fecha2.diaSemana();
        System.out.println("Día de la semana de 15-9-2023: " + fecha2.getDiaTexto());

        Fecha copiaFecha2 = fecha2.copia();

        boolean sonIguales = Fecha.igualQue(fecha2, copiaFecha2);

        boolean esMenor = Fecha.menorQue(fecha1, fecha2);
        boolean esMayor = Fecha.mayorQue(fecha2, fecha1);
    }
}

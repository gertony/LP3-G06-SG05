import java.time.Period;
import java.util.Scanner;
import java.time.format.TextStyle;
import java.util.Locale;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Fecha {
    Scanner s1 = new Scanner(System.in);
    private int dia;
    private int mes;
    private int annio;

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnnio() {
        return annio;
    }

    public void setAnnio(int annio) {
        this.annio = annio;
    }

    Fecha() {
        this.dia = 1;
        this.mes = 1;
        this.annio = 1900;
    }

    Fecha(int dia, int mes, int annio) {
        this.dia = dia;
        this.mes = mes;
        this.annio = annio;
        valida();
    }

    public void leer() {
        System.out.println("Ingrese el día (1-31):");
        this.dia = this.s1.nextInt();

        System.out.println("Ingrese el mes (1-12):");
        this.mes = this.s1.nextInt();

        System.out.println("Ingrese el año (1900-2050):");
        this.annio = this.s1.nextInt();

        valida();
    }

    public boolean bisiesto() {
        if ((this.annio % 4 == 0 && this.annio % 100 != 0) || (this.annio % 400 == 0)) {
            System.out.println(annio + " es año bisiesto.");
            return true;
        } else {
            System.out.println(annio + " no es año bisiesto.");
            return false;
        }
    }

    public int diasMes(int a) {
        if (a > 0 && a < 13) {
            if (a == 2) {
                boolean aux = this.bisiesto();
                if (aux == true)
                    return 29;
                else {
                    return 28;
                }
            } else if (a == 4 || a == 6 || a == 9 || a == 11) {
                return 30;
            } else {
                return 31;
            }

        } else {
            return -1;
        }
    }

    private void valida() {

        if (this.dia < 1 || this.dia > 31) {
            this.dia = 1;
        }

        if (this.mes < 1 || this.mes > 12) {
            this.mes = 1;
        }

        if (this.annio < 1900 || this.annio > 2050) {
            this.annio = 1900;
        }
    }

    public void corta() {
        System.out.println(this.dia + "-" + this.mes + "-" + this.annio);
    }

    public int diasTranscurrido() {
        LocalDate fecha1 = LocalDate.of(this.annio, this.mes, this.dia);
        LocalDate fecha2 = LocalDate.of(1900, 1, 1);

        Period periodo = Period.between(fecha2, fecha1);

        int diasDiferencia = periodo.getDays();

        return diasDiferencia;
    }

    public int diaSemana() {
        LocalDate fecha = LocalDate.of(this.annio, this.mes, this.dia);
        DayOfWeek diaSemana = fecha.getDayOfWeek();
        int valorDiaSemana = diaSemana.getValue() - 1;
        return valorDiaSemana;
    }

    public String getDiaTexto() {
        String aux = "";
        switch (diaSemana()) {
            case 0:
                aux = "Domingo";
                break;
            case 1:
                aux = "Lunes";
                break;
            case 2:
                aux = "Martes";
                break;
            case 3:
                aux = "Miércoles";
                break;
            case 4:
                aux = "Jueves";
                break;
            case 5:
                aux = "Viernes";
                break;
            case 6:
                aux = "Sábado";
                break;
        }
        return aux;
    }

    public String getMesTexto() {
        String aux = "";
        switch (this.mes) {
            case 1:
                aux = "Enero";
                break;
            case 2:
                aux = "Febrero";
                break;
            case 3:
                aux = "Marzo";
                break;
            case 4:
                aux = "Abril";
                break;
            case 5:
                aux = "Mayo";
                break;
            case 6:
                aux = "Junio";
                break;
            case 7:
                aux = "Julio";
                break;
            case 8:
                aux = "Agosto";
                break;
            case 9:
                aux = "Septiembre";
                break;
            case 10:
                aux = "Octubre";
                break;
            case 11:
                aux = "Noviembre";
                break;
            case 12:
                aux = "Diciembre";
                break;
        }
        return aux;
    }

    public void larga() {

        System.out.println(aux + this.dia + " de " + getMesTexto() + " del " + this.annio);
    }

    public void fechaTras(long dias) {
        LocalDate fechaActual = LocalDate.of(this.annio, this.mes, this.dia);
        LocalDate nuevaFecha = fechaActual.plus(dias, ChronoUnit.DAYS);

        this.dia = nuevaFecha.getDayOfMonth();
        this.mes = nuevaFecha.getMonthValue();
        this.annio = nuevaFecha.getYear();
    }

    public int diasEntre(Fecha f) {
        LocalDate fecha1 = LocalDate.of(this.annio, this.mes, thies.dia);
        LocalDate fecha2 = LocalDate.of(f.getAnnio(), f.getMes(), f.getDia());

        Period periodo = Period.between(fecha2, fecha1);

        int diasDiferencia = periodo.getDays();

        return diasDiferencia;
    }

    public void siguiente() {

        if (this.dia == diasMes(this.mes)) {
            if (this.mes == 12) {
                this.annio++;
                this.dia = 1;
                this.mes = 1;
                valida();
            } else {
                this.mes++;
                this.dia = 1;
            }
        } else {
            this.dia++;
        }
    }

    public void anterior() {

        if (this.dia == 1) {
            if (this.mes == 1) {
                this.annio--;
                this.mes = 12;
                this.dia = diasMes(this.mes);
                valida();
            } else {
                this.mes--;
                this.dia = diasMes(this.mes);
            }
        } else {
            this.dia--;
        }
    }

    public void fechaFutura(long dias) {
        LocalDate fechaActual = LocalDate.of(this.annio, this.mes, this.dia);
        LocalDate nuevaFecha = fechaActual.plus(dias, ChronoUnit.DAYS);

        this.dia = nuevaFecha.getDayOfMonth();
        this.mes = nuevaFecha.getMonthValue();
        this.annio = nuevaFecha.getYear();
        valida();
    }

    public Fecha copia() {
        return new Fecha(this.dia, this.mes, this.annio);
    }

    public static boolean igualQue(Fecha fecha1, Fecha fecha2) {
        return fecha1.dia == fecha2.dia && fecha1.mes == fecha2.mes && fecha1.annio == fecha2.annio;
    }

    public static boolean menorQue(Fecha fecha1, Fecha fecha2) {
        if (fecha1.annio < fecha2.annio) {
            return true;
        } else if (fecha1.annio == fecha2.annio) {
            if (fecha1.mes < fecha2.mes) {
                return true;
            } else if (fecha1.mes == fecha2.mes) {
                return fecha1.dia < fecha2.dia;
            }
        }
        return false;
    }

    public static boolean mayorQue(Fecha fecha1, Fecha fecha2) {
        if (fecha1.annio > fecha2.annio) {
            return true;
        } else if (fecha1.annio == fecha2.annio) {
            if (fecha1.mes > fecha2.mes) {
                return true;
            } else if (fecha1.mes == fecha2.mes) {
                return fecha1.dia > fecha2.dia;
            }
        }
        return false;
    }

}

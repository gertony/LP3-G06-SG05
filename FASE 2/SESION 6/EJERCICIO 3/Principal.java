import java.io.IOException;


class ExcepcionVocal extends Exception {
    public ExcepcionVocal(String mensaje) {
        super(mensaje);
    }
}


class ExcepcionNumero extends Exception {
    public ExcepcionNumero(String mensaje) {
        super(mensaje);
    }
}


class ExcepcionBlanco extends Exception {
    public ExcepcionBlanco(String mensaje) {
        super(mensaje);
    }
}


class ExcepcionSalida extends Exception {
    public ExcepcionSalida(String mensaje) {
        super(mensaje);
    }
}


class LeerEntrada {
    private char caracter;

    public char getChar() throws IOException {
        System.out.print("Ingrese un carácter: ");
        caracter = (char) System.in.read();
        System.in.read(); 
        return caracter;
    }

    public void procesar() throws IOException, ExcepcionVocal, ExcepcionNumero, ExcepcionBlanco, ExcepcionSalida {
        if (Character.isLetter(caracter)) {
            if ("AEIOUaeiou".indexOf(caracter) >= 0) {
                throw new ExcepcionVocal("Es una vocal.");
            }
        } else if (Character.isDigit(caracter)) {
            throw new ExcepcionNumero("Es un número.");
        } else if (Character.isWhitespace(caracter)) {
            throw new ExcepcionBlanco("Es un espacio en blanco.");
        } else if (caracter == 'q' || caracter == 'Q') {
            throw new ExcepcionSalida("Carácter de salida ('q' o 'Q').");
        }
    }
}

public class Principal {
    public static void main(String[] args) {
        LeerEntrada lector = new LeerEntrada();
       
        while (true) {
            try {
                char caracter = lector.getChar();
                lector.procesar();
                System.out.println("Carácter válido.");
            } catch (IOException e) {
                System.out.println("Error de entrada/salida: " + e.getMessage());
            } catch (ExcepcionVocal | ExcepcionNumero | ExcepcionBlanco | ExcepcionSalida e) {
                System.out.println("Excepción: " + e.getMessage());
            }
        }
    }
}

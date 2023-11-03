import javax.swing.*;
import java.awt.*;

public class CuadroCombinadoDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rodrigo Gomez y Tony Jimenez");
        String[] opciones = {"Opción 1", "Opción 2", "Opción 3"};
        JComboBox<String> comboBox = new JComboBox<>(opciones);
        frame.getContentPane().add(comboBox, BorderLayout.CENTER);
        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

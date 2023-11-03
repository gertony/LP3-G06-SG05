import javax.swing.*;
import java.awt.*;
public class CasillaDeVerificacionDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rodrigo Gomez y Tony Jimenez");
        JCheckBox checkBox = new JCheckBox("Acepto los términos y condiciones");
        frame.getContentPane().add(checkBox, BorderLayout.CENTER);
        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

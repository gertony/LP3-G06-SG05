import javax.swing.*;
import java.awt.*;
public class BotonDeOpcionDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rodrigo Gomez y Tony Jimenez");
        JRadioButton radioButton1 = new JRadioButton("Opción 1");
        JRadioButton radioButton2 = new JRadioButton("Opción 2");
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        frame.getContentPane().add(radioButton1, BorderLayout.WEST);
        frame.getContentPane().add(radioButton2, BorderLayout.EAST);
        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

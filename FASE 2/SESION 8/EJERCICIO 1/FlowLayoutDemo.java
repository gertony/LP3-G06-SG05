import javax.swing.*;
import java.awt.*;
public class FlowLayoutDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("FlowLayout - Rodrigo Gomez/Tony Jimenez");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        for (int i = 1; i <= 5; i++) {
            JButton button = new JButton("Botón " + i);
            panel.add(button);
        }

        frame.getContentPane().add(panel);
        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

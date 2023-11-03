import javax.swing.*;
import java.awt.*;
public class BorderLayoutDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BorderLayout - Rodrigo Gomez/Tony Jimenez");
        JButton norte = new JButton("Norte");
        JButton sur = new JButton("Sur");
        JButton este = new JButton("Este");
        JButton oeste = new JButton("Oeste");
        JButton centro = new JButton("Centro");
        frame.add(norte, BorderLayout.NORTH);
        frame.add(sur, BorderLayout.SOUTH);
        frame.add(este, BorderLayout.EAST);
        frame.add(oeste, BorderLayout.WEST);
        frame.add(centro, BorderLayout.CENTER);
        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

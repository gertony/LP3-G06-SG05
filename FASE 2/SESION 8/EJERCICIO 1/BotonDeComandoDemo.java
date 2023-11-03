import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BotonDeComandoDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rodrigo Gomez y Tony Jimenez");
        JButton button = new JButton("Haz clic");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "¡Has hecho clic en el botón!");
            }
        });
        frame.getContentPane().add(button, BorderLayout.CENTER);
        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

    

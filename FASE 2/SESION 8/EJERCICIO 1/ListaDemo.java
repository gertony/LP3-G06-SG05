import javax.swing.*;
import java.awt.*;

public class ListaDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rodrigo Gomez y Tony Jimenez");
        String[] elementos = {"Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4"};
        JList<String> lista = new JList<>(elementos);
        frame.getContentPane().add(new JScrollPane(lista), BorderLayout.CENTER);
        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

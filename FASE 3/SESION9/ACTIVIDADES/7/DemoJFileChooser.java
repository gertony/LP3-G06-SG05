
import javax.swing.*;
import java.io.IOException;
import java.nio.file.*;

public class DemoJFileChooser extends JFrame {
    private final JTextArea areaSalida;

    public DemoJFileChooser() {
        super("Demo de JFileChooser");
        areaSalida = new JTextArea();
        add(new JScrollPane(areaSalida));
        try {
            analizarRuta();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void analizarRuta() throws IOException {

        Path ruta = obtenerRutaArchivoDirectorio();

        if (ruta != null && Files.exists(ruta)) {
            StringBuilder builder = new StringBuilder();
            builder.append(String.format("%s:%n", ruta.getFileName()));
            builder.append(String.format("%s un directorio%n", Files.isDirectory(ruta) ? "Es" : "No es"));
            builder.append(String.format("%s una ruta absoluta%n", ruta.isAbsolute() ? "Es" : "No es"));
            builder.append(String.format("Ultima modificacion: %s%n", Files.getLastModifiedTime(ruta)));
            builder.append(String.format("Tamanio: %s%n", Files.size(ruta)));
            builder.append(String.format("Ruta: %s%n", ruta));
            builder.append(String.format("Ruta absoluta: %s%n", ruta.toAbsolutePath()));

            if (Files.isDirectory(ruta)) {
                builder.append(String.format("%nContenido del directorio:%n"));
                try (DirectoryStream<Path> flujoDirectorio = Files.newDirectoryStream(ruta)) {
                    for (Path p : flujoDirectorio) {
                        builder.append(String.format("%s%n", p));
                    }
                }
            }

            areaSalida.setText(builder.toString());
        } else {
            JOptionPane.showMessageDialog(this, ruta.getFileName() + " no existe.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Path obtenerRutaArchivoDirectorio() {
        JFileChooser selectorArchivos = new JFileChooser();
        selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int resultado = selectorArchivos.showOpenDialog(this);

        if (resultado == JFileChooser.CANCEL_OPTION) {
            System.exit(1);
        }

        return selectorArchivos.getSelectedFile().toPath();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DemoJFileChooser aplicacion = new DemoJFileChooser();
            aplicacion.setSize(400, 400);
            aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            aplicacion.setVisible(true);
        });
    }
}

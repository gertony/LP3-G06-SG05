import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompraPasajesApp {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Compra de Pasajes Tony/Rodrigo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(0, 2));

        JLabel nombreLabel = new JLabel("Nombre del pasajero:");
        JLabel documentoLabel = new JLabel("Documento de Identidad:");
        JLabel fechaLabel = new JLabel("Fecha de viaje:");
        JLabel servicioOpcionalLabel = new JLabel("Servicio Opcional:");
        JLabel pisoLabel = new JLabel("Piso de viaje:");
        JLabel origenLabel = new JLabel("Origen:");
        JLabel destinoLabel = new JLabel("Destino:");
        JLabel calidadServicioLabel = new JLabel("Calidad de Servicio:");

        JTextField nombreField = new JTextField();
        JTextField documentoField = new JTextField();
        JTextField fechaField = new JTextField();

        JCheckBox audifonosCheckBox = new JCheckBox("Audífonos");
        JCheckBox mantaCheckBox = new JCheckBox("Manta");
        JCheckBox revistasCheckBox = new JCheckBox("Revistas");

        JRadioButton primerPisoRadioButton = new JRadioButton("1er Piso");
        JRadioButton segundoPisoRadioButton = new JRadioButton("2do Piso");
        ButtonGroup pisoGroup = new ButtonGroup();
        pisoGroup.add(primerPisoRadioButton);
        pisoGroup.add(segundoPisoRadioButton);

        String[] origenes = { "AREQUIPA", "LIMA", "CUSCO" };
        JComboBox<String> origenComboBox = new JComboBox<>(origenes);

        String[] destinos = { "TACA", "PASCO", "CHOTA" };
        JComboBox<String> destinoComboBox = new JComboBox<>(destinos);

        String[] calidadServicio = { "Humilde", "Estándar", "VIP" };
        JList<String> calidadServicioList = new JList<>(calidadServicio);
        calidadServicioList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JButton resumenButton = new JButton("Generar Resumen");

        frame.add(nombreLabel);
        frame.add(nombreField);
        frame.add(documentoLabel);
        frame.add(documentoField);
        frame.add(fechaLabel);
        frame.add(fechaField);
        frame.add(servicioOpcionalLabel);
        frame.add(audifonosCheckBox);
        frame.add(new JLabel("")); // Espacio en blanco
        frame.add(mantaCheckBox);
        frame.add(new JLabel("")); // Espacio en blanco
        frame.add(revistasCheckBox);
        frame.add(pisoLabel);
        frame.add(primerPisoRadioButton);
        frame.add(new JLabel("")); // Espacio en blanco
        frame.add(segundoPisoRadioButton);
        frame.add(origenLabel);
        frame.add(origenComboBox);
        frame.add(destinoLabel);
        frame.add(destinoComboBox);
        frame.add(calidadServicioLabel);
        frame.add(new JScrollPane(calidadServicioList));
        frame.add(new JLabel("")); // Espacio en blanco
        frame.add(resumenButton);

        resumenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Resumen de la compra:\n" +
                        "Nombre: " + nombreField.getText() + "\n" +
                        "Documento: " + documentoField.getText() + "\n" +
                        "Fecha de Viaje: " + fechaField.getText() + "\n" +
                        "Servicios Opcionales: " +
                        (audifonosCheckBox.isSelected() ? "Audífonos " : "") +
                        (mantaCheckBox.isSelected() ? "Manta " : "") +
                        (revistasCheckBox.isSelected() ? "Revistas " : "") + "\n" +
                        "Piso de Viaje: " + (primerPisoRadioButton.isSelected() ? "1er Piso" : "2do Piso") + "\n" +
                        "Origen: " + origenComboBox.getSelectedItem() + "\n" +
                        "Destino: " + destinoComboBox.getSelectedItem() + "\n" +
                        "Calidad de Servicio: " + calidadServicioList.getSelectedValue());
            }
        });

        frame.setVisible(true);
    }
}

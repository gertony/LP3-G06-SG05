import javax.swing.*;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

public class GUIApp extends JFrame {
    private JdbcRowSet rowSet;
    private JTextField nombreField, apellidoField, correoField, telefonoField, inputField, filtroApellidoField;
    private JLabel totalRegistrosLabel;
    private int rowCount, currentRow;

    public GUIApp() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            rowSet = RowSetProvider.newFactory().createJdbcRowSet();
            rowSet.setUrl("jdbc:mysql://localhost:3306/agenda");
            rowSet.setUsername("root");
            rowSet.setPassword("gerto2121");

            rowSet.setCommand("select * from contactos");
            rowSet.execute();

            setupUI();
            rowCount = getRowCount();
            currentRow = 1;
            mostrarDatos();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos.");
            System.exit(1);
        }
    }

    private void setupUI() {
        setTitle("MANEJADOR AGENDA");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        totalRegistrosLabel = new JLabel();

        nombreField = new JTextField(20);
        apellidoField = new JTextField(20);
        correoField = new JTextField(20);
        telefonoField = new JTextField(10);
        inputField = new JTextField(3);
        filtroApellidoField = new JTextField(15);

        JButton anteriorButton = new JButton("Anterior");
        JButton siguienteButton = new JButton("Siguiente");
        JButton buscarButton = new JButton("Buscar");
        JButton guardarButton = new JButton("Guardar");

        anteriorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (currentRow > 1) {
                        currentRow--;
                        rowSet.absolute(currentRow);
                        mostrarDatos();
                    } else {
                        JOptionPane.showMessageDialog(null, "Ya estás en el primer registro.");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        siguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (currentRow < rowCount) {
                        currentRow++;
                        rowSet.absolute(currentRow);
                        mostrarDatos();
                    } else {
                        JOptionPane.showMessageDialog(null, "Ya estás en el último registro.");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPorApellido();
            }
        });

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarCambios();
            }
        });

        inputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    buscarPorNumero();
                }
            }
        });

        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPorNumero();
            }
        });

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(anteriorButton, gbc);

        gbc.gridx++;
        panel.add(inputField, gbc);

        gbc.gridx++;
        panel.add(new JLabel("de "), gbc);

        gbc.gridx++;
        panel.add(totalRegistrosLabel, gbc);

        gbc.gridx++;
        panel.add(siguienteButton, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        panel.add(new JLabel("Nombre:"), gbc);

        gbc.gridx = 1;
        panel.add(nombreField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Apellido:"), gbc);

        gbc.gridx = 1;
        panel.add(apellidoField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Correo:"), gbc);

        gbc.gridx = 1;
        panel.add(correoField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Nro de Teléfono:"), gbc);

        gbc.gridx = 1;
        panel.add(telefonoField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        panel.add(new JLabel("Búsqueda por Apellido:"), gbc);

        gbc.gridx++;
        panel.add(filtroApellidoField, gbc);

        gbc.gridx++;
        panel.add(buscarButton, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 7;
        panel.add(guardarButton, gbc);

        add(panel);
    }

    private void buscarPorApellido() {
        String filtroApellido = filtroApellidoField.getText();
        try {
            if (!filtroApellido.isEmpty()) {
                rowSet.setCommand("select * from contactos where Apellido like ?");
                rowSet.setString(1, "%" + filtroApellido + "%");
            } else {
                rowSet.setCommand("select * from contactos");
            }
            rowSet.execute();

            rowCount = getRowCount();
            if (rowCount > 0) {
                currentRow = 1;
                rowSet.first();
                mostrarDatos();
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron registros con el apellido proporcionado.");
                inputField.setText(Integer.toString(currentRow));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void buscarPorNumero() {
        try {
            int desiredRow = Integer.parseInt(inputField.getText());
            if (desiredRow > 0 && desiredRow <= rowCount) {
                currentRow = desiredRow;
                rowSet.absolute(currentRow);
                mostrarDatos();
            } else {

                JOptionPane.showMessageDialog(null, "Número de registro no válido.");
                inputField.setText(Integer.toString(currentRow));
            }
        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
            inputField.setText(Integer.toString(currentRow));

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void guardarCambios() {
        try {
            rowSet.updateString("Nombre", nombreField.getText());
            rowSet.updateString("Apellido", apellidoField.getText());
            rowSet.updateString("email", correoField.getText());
            rowSet.updateString("numero_telefono", telefonoField.getText());
            rowSet.updateRow();
            JOptionPane.showMessageDialog(null, "Cambios guardados exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar cambios.");
        }
    }

    private int getRowCount() throws SQLException {
        int count = 0;
        while (rowSet.next()) {
            count++;
        }
        rowSet.beforeFirst();
        return count;
    }

    private void mostrarDatos() {
        try {
            int row = rowSet.getRow();
            totalRegistrosLabel.setText(Integer.toString(rowCount));
            nombreField.setText(rowSet.getString("Nombre"));
            apellidoField.setText(rowSet.getString("Apellido"));
            correoField.setText(rowSet.getString("email"));
            telefonoField.setText(rowSet.getString("numero_telefono"));
            inputField.setText(Integer.toString(row));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUIApp().setVisible(true);
            }
        });
    }
}

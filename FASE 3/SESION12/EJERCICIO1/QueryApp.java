import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class QueryApp extends JFrame {
    private JTextArea txtQuery;
    private JTable tablaresutlado;
    private JScrollPane resultScrollPane;
    private JTextField txtFiltro;

    public QueryApp() {
        setTitle("CONSULTOR SQL");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        txtQuery = new JTextArea(5, 40);
        tablaresutlado = new JTable();
        resultScrollPane = new JScrollPane(tablaresutlado);
        txtFiltro = new JTextField(20);

        JButton executeButton = new JButton("Buscar Consulta");
        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejercutarQuery();
            }
        });

        JLabel btnTag = new JLabel("Filtro:");
        JButton bntFiltro = new JButton("Buscar");
        bntFiltro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecutarFiltro();
            }
        });

        JPanel panel = new JPanel(new BorderLayout());

        JPanel searchPanel = new JPanel();
        searchPanel.add(new JScrollPane(txtQuery));
        searchPanel.add(executeButton);

        JPanel filterPanel = new JPanel();
        filterPanel.add(btnTag);
        filterPanel.add(txtFiltro);
        filterPanel.add(bntFiltro);

        panel.add(searchPanel, BorderLayout.NORTH);
        panel.add(resultScrollPane, BorderLayout.CENTER);
        panel.add(filterPanel, BorderLayout.SOUTH);

        add(panel);
    }

    private void ejercutarQuery() {
        String query = txtQuery.getText();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejercicio1",
                    "root", "gerto2121");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            ResultSetMetaData metaData = resultSet.getMetaData();
            int nColumnas = metaData.getColumnCount();

            String[] columnNames = new String[nColumnas];
            for (int i = 1; i <= nColumnas; i++) {
                columnNames[i - 1] = metaData.getColumnName(i);
            }

            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

            while (resultSet.next()) {
                Object[] rowData = new Object[nColumnas];
                for (int i = 1; i <= nColumnas; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                tableModel.addRow(rowData);
            }

            tablaresutlado.setModel(tableModel);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al ejecutar la consulta:\n" + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void ejecutarFiltro() {
        String filter = txtFiltro.getText();
        if (!filter.isEmpty()) {
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejercicio1",
                        "root", "gerto2121");
                Statement statement = connection.createStatement();
                String filterQuery = "SELECT * FROM personas WHERE " + filter;
                ResultSet resultSet = statement.executeQuery(filterQuery);

                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();

                String[] columnNames = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    columnNames[i - 1] = metaData.getColumnName(i);
                }

                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

                while (resultSet.next()) {
                    Object[] rowData = new Object[columnCount];
                    for (int i = 1; i <= columnCount; i++) {
                        rowData[i - 1] = resultSet.getObject(i);
                    }
                    tableModel.addRow(rowData);
                }

                tablaresutlado.setModel(tableModel);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al ejecutar el filtro:\n" + e.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        } else {
            ejercutarQuery();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new QueryApp().setVisible(true);
            }
        });
    }
}

package com.mycompany.empleadosapp;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadosApp extends JFrame {

    private static final String NOMBRE_ARCHIVO = "empleados.txt";
    private List<Empleado> empleados = new ArrayList<>();

    private JTable table;
    private DefaultTableModel tableModel;

    public EmpleadosApp() {
        super("Empleados");
        cargarEmpleadosDesdeArchivo(); // Inicializar la lista de empleados desde el archivo
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tableModel = new DefaultTableModel(); // Crear la tabla y su modelo
        tableModel.addColumn("Número");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Sueldo");
        table = new JTable(tableModel);
        for (Empleado empleado : empleados) {
            Object[] rowData = {empleado.getNumero(), empleado.getNombre(), empleado.getSueldo()};
            tableModel.addRow(rowData);
        }
        JButton addButton = new JButton("Agregar Empleado");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDialogoAgregarEmpleado();
            }
        });
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(addButton, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void cargarEmpleadosDesdeArchivo() {
        try (BufferedReader br = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String line;
            while ((line = br.readLine()) != null) { // Valida si es que el archivo se puede leer
                String[] datos = line.split(",");
                int numero = Integer.parseInt(datos[0].trim());
                String nombre = datos[1].trim();
                double sueldo = Double.parseDouble(datos[2].trim());
                empleados.add(new Empleado(numero, nombre, sueldo)); // Agrega a los empleados ingresados
                }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe. Se creará uno nuevo al agregar empleados.");
        } catch (IOException | NumberFormatException e) {
            e.getMessage();
        }
    }

    private void guardarEmpleadoEnArchivo(Empleado nuevoEmpleado) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true))) {
            bw.write(nuevoEmpleado.getNumero() + "," + nuevoEmpleado.getNombre() + "," + nuevoEmpleado.getSueldo());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mostrarDialogoAgregarEmpleado() {
        JDialog dialog = new JDialog(this, "Agregar Empleado", true);
        dialog.setSize(300, 200);
        dialog.setLayout(new GridLayout(4, 2));

        JLabel numeroLabel = new JLabel("Número:");
        JTextField numeroField = new JTextField();
        JLabel nombreLabel = new JLabel("Nombre:");
        JTextField nombreField = new JTextField();
        JLabel sueldoLabel = new JLabel("Sueldo:");
        JTextField sueldoField = new JTextField();
        JButton agregarButton = new JButton("Agregar");

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numero = Integer.parseInt(numeroField.getText());
                    String nombre = nombreField.getText();
                    double sueldo = Double.parseDouble(sueldoField.getText());

                    Empleado nuevoEmpleado = new Empleado(numero, nombre, sueldo);
                    empleados.add(nuevoEmpleado);

                    Object[] rowData = {nuevoEmpleado.getNumero(), nuevoEmpleado.getNombre(), nuevoEmpleado.getSueldo()};
                    tableModel.addRow(rowData);

                    guardarEmpleadoEnArchivo(nuevoEmpleado);

                    dialog.dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(dialog, "Ingrese valores válidos para el número y el sueldo.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }); 

        dialog.add(numeroLabel);
        dialog.add(numeroField);
        dialog.add(nombreLabel);
        dialog.add(nombreField);
        dialog.add(sueldoLabel);
        dialog.add(sueldoField);
        dialog.add(new JLabel()); // Espacio en blanco
        dialog.add(agregarButton);

        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EmpleadosApp();
            }
        });
    }
}

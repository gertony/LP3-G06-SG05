package com.mycompany.wordcountapp;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCountApp extends JFrame {

    private JTextArea fileTextArea;
    private JLabel countLabel;

    public WordCountApp() {
        super("Word Count");

        // Configurar la interfaz gráfica
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fileTextArea = new JTextArea();
        countLabel = new JLabel("Número de líneas: 0, Número de palabras: 0, Número de caracteres: 0");

        JButton chooseFileButton = new JButton("Seleccionar Archivo");
        chooseFileButton.addActionListener(e -> seleccionarArchivo());

        // Configurar el diseño de la interfaz
        setLayout(new BorderLayout());

        // Agregar el botón y el área de entrada de texto en la parte superior del panel central
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(chooseFileButton, BorderLayout.NORTH);
        topPanel.add(new JScrollPane(fileTextArea), BorderLayout.CENTER);
        add(topPanel, BorderLayout.CENTER);

        // Agregar la etiqueta de conteo en la parte inferior del panel central
        add(countLabel, BorderLayout.SOUTH);

        // Agregar un DocumentListener para realizar el conteo automáticamente
        fileTextArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                contarPalabras();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                contarPalabras();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                contarPalabras();
            }
        });

        // Hacer visible la interfaz
        setVisible(true);
    }

    private void seleccionarArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de Texto (*.txt)", "txt");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            try (BufferedReader br = new BufferedReader(new FileReader(fileChooser.getSelectedFile()))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    content.append(line).append("\n");
                }
                fileTextArea.setText(content.toString());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error al leer el archivo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void contarPalabras() {
        String content = fileTextArea.getText();

        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        try (BufferedReader br = new BufferedReader(new java.io.StringReader(content))) {
            String line;
            while ((line = br.readLine()) != null) {
                lineCount++;
                charCount += line.length();

                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty() && Character.isLetterOrDigit(word.charAt(0))) {
                        wordCount++;
                    }
                }
            }

            // Actualizar la etiqueta de conteo
            countLabel.setText("Número de líneas: " + lineCount + ", Número de palabras: " + wordCount + ", Número de caracteres: " + charCount);
        } catch (IOException e) {
            countLabel.setText("Error al contar palabras: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(WordCountApp::new);
    }
}

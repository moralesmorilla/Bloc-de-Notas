package mi.almacen.articulos.trabajoenequipo;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Lamina extends JPanel {

    private JTextArea txtArea;
    private boolean isDirty = false;
    private File archivoActual = null;

    public Lamina() {
        setLayout(new BorderLayout());

        txtArea = new JTextArea();
        txtArea.setBackground(Color.white);
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);
        txtArea.setFont(new Font("Arial", Font.ITALIC, 16));

        JScrollPane scroll = new JScrollPane(txtArea);
        add(scroll, BorderLayout.CENTER);

        txtArea.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                markDirty();
            }

            public void removeUpdate(DocumentEvent e) {
                markDirty();
            }

            public void changedUpdate(DocumentEvent e) {
                markDirty();
            }

            private void markDirty() {
                isDirty = true;
            }
        });
    }

    private void markDirty() {
        isDirty = true;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public void setSaved() {
        isDirty = false;
    }

    public void cargarArchivo(File archivo) {
        StringBuilder contenido = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        txtArea.setText(contenido.toString());
        isDirty = false;
        archivoActual = archivo;
    }

    public void guardarArchivo(File archivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            bw.write(txtArea.getText());
            isDirty = false;
            archivoActual = archivo;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
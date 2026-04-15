package mi.almacen.articulos.trabajoenequipo;

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class Lamina extends JPanel {

    private JTextArea txtArea;

    public Lamina() {
        setLayout(new BorderLayout());

        txtArea = new JTextArea();
        txtArea.setBackground(Color.white);
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);
        txtArea.setFont(new Font("Arial", Font.ITALIC, 16));

        JScrollPane scroll = new JScrollPane(txtArea);
        add(scroll, BorderLayout.CENTER);
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
    }

    public void guardarArchivo(File archivo) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            bw.write(txtArea.getText());
        }
    }
}
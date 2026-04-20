/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mi.almacen.articulos.trabajoenequipo.filereader;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Usuario25
 */

public class EditorPanel extends JPanel {

    private JTextArea txtArea;
    private boolean isDirty = false;

    public EditorPanel() {
        setLayout(new BorderLayout());

        txtArea = new JTextArea();
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);
        txtArea.setFont(new Font("Arial", Font.PLAIN, 16));

        txtArea.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                isDirty = true;
            }

            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                isDirty = true;
            }

            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                isDirty = true;
            }
        });

        add(new JScrollPane(txtArea), BorderLayout.CENTER);
    }

    public String getTexto() {
        return txtArea.getText();
    }

    public void setTexto(String texto) {
        txtArea.setText(texto);
        isDirty = false;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public void setSaved() {
        isDirty = false;
    }
}

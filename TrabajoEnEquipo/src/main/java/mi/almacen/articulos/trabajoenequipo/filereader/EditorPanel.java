/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mi.almacen.articulos.trabajoenequipo.filereader;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

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

        txtArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                isDirty = true;
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                isDirty = true;
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
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

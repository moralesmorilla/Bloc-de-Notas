package mi.almacen.articulos.trabajoenequipo;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Lamina extends JPanel {

    private JTextArea txtArea;
    private boolean isDirty = false;

    public Lamina() {
        setLayout(new BorderLayout());

        txtArea = new JTextArea();
        txtArea.setBackground(Color.white);
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);
        txtArea.setFont(new Font("Arial", Font.ITALIC, 16));

        JScrollPane scroll = new JScrollPane(txtArea);
        add(scroll, BorderLayout.CENTER);
        txtArea.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                markDirty();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                markDirty();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                markDirty();
            }
            private void markDirty(){
                isDirty=true;
            }
        });
        
       

        };
    }

    



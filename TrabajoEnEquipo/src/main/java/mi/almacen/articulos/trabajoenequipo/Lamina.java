package mi.almacen.articulos.trabajoenequipo;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Lamina extends JPanel {

    private JTextArea txtArea;
    private ObservadorTexto observador;
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
                avisar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                avisar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                avisar();
            }
            
        });
        
       

        }
    public String getTextoLamina(){
        return txtArea.getText();
    }
    public void setTextoLamina(String nuevoTexto){
        txtArea.setText(nuevoTexto);
    }
    
    public void setObservadorTexto(ObservadorTexto obs){
        this.observador=obs;
    }
    
    private void avisar(){
        if(observador!=null){
            observador.modificarTexto();
        }
    }
    }

    



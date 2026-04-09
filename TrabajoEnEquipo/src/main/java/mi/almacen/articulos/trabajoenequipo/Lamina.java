/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mi.almacen.articulos.trabajoenequipo;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Usuario25
 */
public class Lamina extends JPanel {

    private JTextArea txtArea;

    public Lamina() {
        setLayout(new BorderLayout());

        txtArea = new JTextArea();
        txtArea.setBackground(Color.white);
        txtArea.setLineWrap(true);
        txtArea.setFont(new Font("Arial", Font.ITALIC, 16));

        JScrollPane scroll = new JScrollPane(txtArea);

        add(scroll, BorderLayout.CENTER); 
    }
}
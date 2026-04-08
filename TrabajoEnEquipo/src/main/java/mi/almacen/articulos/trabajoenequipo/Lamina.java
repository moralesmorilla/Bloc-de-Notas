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

    private int ANCHO_PANEL = 885;
    private int ALTO_PANEL = 475;
    private JTextArea txtArea;

    public Lamina() {
        setLayout(null);
        setBounds(0, 0, ANCHO_PANEL, ALTO_PANEL);

        txtArea = new JTextArea();
        txtArea.setBounds(0, 50, ANCHO_PANEL, ALTO_PANEL);
        txtArea.setBackground(Color.white);
        txtArea.setLineWrap(true);
        txtArea.setLineWrap(true);
        txtArea.setFont(new Font("Arial",Font.ITALIC, 26));

        add(txtArea);

        JScrollPane txtAreaConScroll = new JScrollPane(txtArea);
        txtAreaConScroll.setBounds(txtArea.getBounds());
        add(txtAreaConScroll);
    }

}

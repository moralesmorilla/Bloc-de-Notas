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
public class BlocDeNotasCentrado extends JFrame {

    private int ANCHO_FRAME = 900;
    private int ALTO_FRAME = 500;
    private String titulo = "Bloc de notas";

    public BlocDeNotasCentrado() {
        setSize(ANCHO_FRAME, ALTO_FRAME);
        setLocationRelativeTo(null);

        ponerIcono();
        this.setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(titulo);
        setVisible(true);
        
        Lamina lam = new Lamina();
        add(lam);
        setVisible(true);
    }

    private void ponerIcono() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image img = tk.getImage("src/images/descarga.png");
        setIconImage(img);
    }
}

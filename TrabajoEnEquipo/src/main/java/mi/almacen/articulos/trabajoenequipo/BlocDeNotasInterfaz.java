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
import javax.swing.*;
import java.awt.*;

public class BlocDeNotasInterfaz extends JFrame {

    public BlocDeNotasInterfaz() {
        setSize(900, 500);
        setLocationRelativeTo(null);

        ponerIcono();
        setResizable(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Bloc de notas");

        JMenuBar barra = new JMenuBar();

        JMenu archivo = new JMenu("Archivo");
        JMenu editar = new JMenu("Editar");

        JMenuItem nuevo = new JMenuItem("Nuevo");
        JMenuItem abrir = new JMenuItem("Abrir");
        JMenuItem guardar = new JMenuItem("Guardar");
        JMenuItem mayuscula =  new JMenuItem("Pasar a mayusculas");
        JMenuItem minusculas =  new JMenuItem("Pasar a minusculas");
        
        archivo.add(nuevo);
        archivo.add(abrir);
        archivo.add(guardar);
        editar.add(mayuscula);
        editar.add(minusculas);
        
        barra.add(archivo);
        barra.add(editar);

        setJMenuBar(barra);

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
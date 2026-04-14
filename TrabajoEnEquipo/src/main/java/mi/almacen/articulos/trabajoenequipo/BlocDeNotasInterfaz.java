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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

public class BlocDeNotasInterfaz extends JFrame {

    private JMenuItem abrir, guardar, salir;
    private JMenu archivo, editar, paginas;
    private JMenuBar barra;
    private Lamina laminaActual;
    private Lamina lam;

    public BlocDeNotasInterfaz() {
        setSize(900, 500);
        setLocationRelativeTo(null);

        ponerIcono();
        setResizable(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Bloc de notas");

        barra = new JMenuBar();

        archivo = new JMenu("Archivo");
//        editar = new JMenu("Editar");
//        paginas = new JMenu("Paginas");

        abrir = new JMenuItem("Abrir");
        guardar = new JMenuItem("Guardar");
        salir = new JMenuItem("Salir");

        archivo.add(abrir);
        archivo.add(guardar);
        archivo.add(salir);

        barra.add(archivo);
//        barra.add(editar);
//        barra.add(paginas);

        setJMenuBar(barra);

        lam = new Lamina();
        add(lam);

        setVisible(true);

        salir.addActionListener(new ManejadorSalir());
        abrir.addActionListener(new ManejadorAbrir());
        guardar.addActionListener(new ManejadorGuardar());
    }

    private class ManejadorSalir implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
                
            System.out.println("Salir");
            
            System.exit(0);

        }
    }

    private class ManejadorAbrir implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Abrir");
            JFileChooser chooser = new JFileChooser();
            int resultado = chooser.showOpenDialog(null);
            if (resultado == JFileChooser.APPROVE_OPTION) {
                File archivo = chooser.getSelectedFile();
                System.out.println("Archivo abierto " + archivo);
                lam.setVisible(false);
                if(laminaActual!=null){
                    remove(laminaActual);
                }
                laminaActual = new Lamina();
                laminaActual.cargarArchivo(archivo);
                add(laminaActual);
                revalidate();
                repaint();
                
            } else {
                System.out.println("Debes de seleccionar un archivo");
            }

        }
    }

    private class ManejadorGuardar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Guardar");
            JFileChooser chooser = new JFileChooser();
            int resultado = chooser.showSaveDialog(null);
            if(resultado==JFileChooser.APPROVE_OPTION){
                File archivo= chooser.getSelectedFile();
                try {
                    laminaActual.guardarArchivo(archivo);
                } catch (IOException ex) {
                    System.getLogger(BlocDeNotasInterfaz.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
            }

        }
    }

    private void ponerIcono() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image img = tk.getImage("src/images/descarga.png");
        setIconImage(img);
    }

}

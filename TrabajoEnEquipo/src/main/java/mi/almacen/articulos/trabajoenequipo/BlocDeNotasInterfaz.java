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

public class BlocDeNotasInterfaz extends JFrame {
    private JMenuItem abrir,guardar,salir;
    private JMenu archivo,editar,paginas;
    private JMenuBar barra;
    private int i=1;

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

        Lamina lam = new Lamina();
        add(lam);

        setVisible(true);
        
        salir.addActionListener(new ManejadorSalir());
        abrir.addActionListener(new ManejadorAbrir());
        guardar.addActionListener(new ManejadorGuardar());
    }
    private class ManejadorSalir implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
                System.out.println("Salir");
                System.exit(0);
             
        }
    }
    private class ManejadorAbrir implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
                System.out.println("Abrir");
                
             
        }
    }
    private class ManejadorGuardar implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
                System.out.println("Guardar");
                
             
        }
    }

    private void ponerIcono() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image img = tk.getImage("src/images/descarga.png");
        setIconImage(img);
    }
    
   
}
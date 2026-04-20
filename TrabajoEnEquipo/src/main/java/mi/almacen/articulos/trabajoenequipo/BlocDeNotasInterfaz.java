package mi.almacen.articulos.trabajoenequipo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import javax.swing.filechooser.FileNameExtensionFilter;

public class BlocDeNotasInterfaz extends JFrame {

    private JMenuItem abrir, guardar, salir;
    private JMenu archivo;
    private JMenuBar barra;
    private Lamina laminaActual;
    private Lamina lam;
    private boolean isDirty = false;
    private TextArea txtArea;
    private Controlador control;

    public BlocDeNotasInterfaz(Controlador control) {
        this.control = control;
        setSize(900, 500);
        setLocationRelativeTo(null);

        ponerIcono();
        setResizable(true);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setTitle("Bloc de notas");

        barra = new JMenuBar();
        archivo = new JMenu("Archivo");

        abrir = new JMenuItem("Abrir");
        guardar = new JMenuItem("Guardar");
        salir = new JMenuItem("Salir");

        archivo.add(abrir);
        archivo.add(guardar);
        archivo.add(salir);

        barra.add(archivo);

        setJMenuBar(barra);

        lam = new Lamina();
        add(lam);

        setVisible(true);
        
        txtArea.

        salir.addActionListener(new ManejadorSalir());
        abrir.addActionListener(new ManejadorAbrir());
        guardar.addActionListener(new ManejadorGuardar());

    }
    public boolean isDirty(){
        return isDirty;
    }
    
    

    public TextArea getTextArea() {
        return txtArea;
    }

    public void setTxtArea(TextArea txtArea) {
        this.txtArea = txtArea;
    }
    public Lamina getLam() {
        return lam;
    }
    
    private class ManejadorAbrir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            control.abrirFichero();
        }
    }
    
    private class ManejadorSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            control.salirFichero();
        }
    }
    
    private class ManejadorGuardar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            control.guardarFichero();
        }
    }
    
    
    

    private void ponerIcono() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image img = tk.getImage("src/images/descarga.png");
        setIconImage(img);
    }

    
    
}

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
    private TextArea txtArea;
    private Controlador control;

    public BlocDeNotasInterfaz(Controlador control) {
        this.control = control;
        setSize(900, 500);
        setLocationRelativeTo(null);
        ponerIcono();
        setResizable(true);
        setTitle("Bloc de notas");

        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                control.salirFichero();
            }
        });

        
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
        lam.setObservadorTexto(new ObservadorTexto() {
            @Override
            public void modificarTexto() {
                control.textoModificado();
            }
        });
        add(lam);

        abrir.addActionListener(new ManejadorAbrir());
        guardar.addActionListener(new ManejadorGuardar());

        salir.addActionListener(e -> control.salirFichero());

        setVisible(true);
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

    public String getContenido() {
        return lam.getTextoLamina();
    }

    public void setContenido(String nuevoTexto) {
        lam.setTextoLamina(nuevoTexto);
    }

    private class ManejadorAbrir implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            control.abrirFichero();
        }
    }

    private class ManejadorSalir implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            control.salirFichero();
        }
    }

    private class ManejadorGuardar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            control.guardarFichero();
        }
    }

    private void ponerIcono() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image img = tk.getImage("src/images/descarga.png");
        setIconImage(img);
    }

}

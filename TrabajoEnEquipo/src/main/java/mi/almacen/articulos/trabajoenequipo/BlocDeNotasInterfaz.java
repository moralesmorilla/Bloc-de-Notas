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

    private File archivoActual;

    public BlocDeNotasInterfaz() {
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

        salir.addActionListener(new ManejadorSalir());
        abrir.addActionListener(new ManejadorAbrir());
        guardar.addActionListener(new ManejadorGuardar());
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                cerrarAplicacion();
                
            }
        });


    }

    private class ManejadorSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           cerrarAplicacion();

        }
        
        
    }

    
    

    private class ManejadorAbrir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cerrarAplicacion();
        }
    }

    private class ManejadorGuardar implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

        if (archivoActual != null) {
            lam.guardarArchivo(archivoActual);
            System.out.println("Guardado en archivo existente");

        } else {

            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filtro =
                    new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt");

            chooser.setFileFilter(filtro);
            chooser.setAcceptAllFileFilterUsed(false);

            int resultado = chooser.showSaveDialog(null);

            if (resultado == JFileChooser.APPROVE_OPTION) {

                File archivo = chooser.getSelectedFile();

                if (!archivo.getName().toLowerCase().endsWith(".txt")) {
                    archivo = new File(archivo.getAbsolutePath() + ".txt");
                }

                lam.guardarArchivo(archivo);
                archivoActual = archivo;

                System.out.println("Guardado en nuevo archivo .txt");
            }
        }
    }
}
    private void cerrarAplicacion() {
    if (lam.isDirty()) {
        int opcion = JOptionPane.showConfirmDialog(
                this,
                "Hay cambios sin guardar, ¿quieres salir?",
                "Salir",
                JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.NO_OPTION) {
            return;
        }
        dispose();
    }
    dispose();
}
    private void ponerIcono() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image img = tk.getImage("src/images/descarga.png");
        setIconImage(img);
    }
}
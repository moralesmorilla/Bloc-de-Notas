package mi.almacen.articulos.trabajoenequipo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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


    }

    private class ManejadorSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Salir");
            if (lam.isDirty()) {
                int opcion = JOptionPane.showConfirmDialog(BlocDeNotasInterfaz.this, "Hay cambios sin guardar,Quieres salir?",
                        "Salir", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.NO_OPTION) {
                    return;
                }
            }
            dispose();

        }
    }

    private class ManejadorAbrir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser chooser = new JFileChooser();
            int resultado = chooser.showOpenDialog(null);

            if (resultado == JFileChooser.APPROVE_OPTION) {
                File archivo = chooser.getSelectedFile();
                System.out.println("Archivo abierto " + archivo);
                lam.setVisible(false);
                if (laminaActual != null) {
                    remove(laminaActual);
                }
                laminaActual = new Lamina();
                laminaActual.cargarArchivo(archivo);
                add(laminaActual);
                revalidate();
                repaint();
                archivoActual = archivo;
                lam.cargarArchivo(archivo);
            } else {
                System.out.println("Debes seleccionar un archivo");
            }
        }
    }

    private class ManejadorGuardar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
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
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }
    private void ponerIcono() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image img = tk.getImage("src/images/descarga.png");
        setIconImage(img);
    }
}
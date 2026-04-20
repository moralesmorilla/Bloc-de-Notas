/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mi.almacen.articulos.trabajoenequipo.filereader;

import javax.swing.*;
import java.io.File;

/**
 *
 * @author Usuario25
 */
public class BlocDeNotasControlador {

    private BlocDeNotasVista vista;
    private ArchivoServicio servicio;
    private File archivoActual;

    public BlocDeNotasControlador(BlocDeNotasVista vista) {
        this.vista = vista;
        this.servicio = new ArchivoServicio();

        vista.abrir.addActionListener(e -> abrirArchivo());
        vista.guardar.addActionListener(e -> guardarArchivo());
        vista.salir.addActionListener(e -> intentarSalir());
    }

    private void abrirArchivo() {
        JFileChooser chooser = new JFileChooser();

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            archivoActual = chooser.getSelectedFile();
            String contenido = servicio.leerArchivo(archivoActual);
            vista.getEditor().setTexto(contenido);
        }
    }

    private void guardarArchivo() {
        try {
            if (archivoActual == null) {
                JFileChooser chooser = new JFileChooser();

                javax.swing.filechooser.FileNameExtensionFilter filtro
                        = new javax.swing.filechooser.FileNameExtensionFilter("Archivos de texto (*.txt)", "txt");

                chooser.setFileFilter(filtro);
                chooser.setAcceptAllFileFilterUsed(false);

                if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    archivoActual = chooser.getSelectedFile();

                    if (!archivoActual.getName().toLowerCase().endsWith(".txt")) {
                        archivoActual = new File(archivoActual.getAbsolutePath() + ".txt");
                    }
                }
            }

            if (archivoActual != null) {
                servicio.guardarArchivo(archivoActual, vista.getEditor().getTexto());
                vista.getEditor().setSaved();
            }

        } catch (Exception e) {
            System.out.println(e);        }
    }

    // 👉 método usado por botón salir y la X
    public void intentarSalir() {
        if (vista.getEditor().isDirty()) {
            int opcion = JOptionPane.showConfirmDialog(
                    vista,
                    "Hay cambios sin guardar. ¿Quieres salir?",
                    "Advertencia",
                    JOptionPane.YES_NO_OPTION
            );

            if (opcion == JOptionPane.NO_OPTION) {
                return;
            }
        }
        System.exit(0);
    }
}

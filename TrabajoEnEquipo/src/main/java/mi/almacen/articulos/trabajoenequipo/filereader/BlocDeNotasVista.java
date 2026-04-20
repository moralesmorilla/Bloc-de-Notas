/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mi.almacen.articulos.trabajoenequipo.filereader;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Usuario25
 */

public class BlocDeNotasVista extends JFrame {

    JMenuItem abrir, guardar, salir;
    private EditorPanel editor;

    public BlocDeNotasVista() {
        setTitle("Bloc de notas");
        setSize(900, 500);
        setLocationRelativeTo(null);

        // ⚠️ IMPORTANTE para controlar la X
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        JMenuBar barra = new JMenuBar();
        JMenu archivo = new JMenu("Archivo");

        abrir = new JMenuItem("Abrir");
        guardar = new JMenuItem("Guardar");
        salir = new JMenuItem("Salir");

        archivo.add(abrir);
        archivo.add(guardar);
        archivo.add(salir);

        barra.add(archivo);
        setJMenuBar(barra);

        editor = new EditorPanel();
        add(editor);

        setVisible(true);
    }

    public EditorPanel getEditor() {
        return editor;
    }

    public void setControlador(BlocDeNotasControlador controlador) {
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                controlador.intentarSalir();
            }
        });
    }
}

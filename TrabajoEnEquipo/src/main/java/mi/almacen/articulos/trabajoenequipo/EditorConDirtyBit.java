/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mi.almacen.articulos.trabajoenequipo;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Usuario25
 */
public class EditorConDirtyBit extends JFrame {

    private JTextArea textArea;
    private boolean isDirty = false;

    public EditorConDirtyBit() {
        setTitle("Advertencia");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        textArea = new JTextArea();
        add(new JScrollPane(textArea));

        textArea.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                markDirty();
            }

            public void removeUpdate(DocumentEvent e) {
                markDirty();
            }

            public void changedUpdate(DocumentEvent e) {
                markDirty();
            }

            private void markDirty() {
                if (!isDirty) {
                    isDirty = true;
                    setTitle("Advertencia, Cambios sin guardar");

                }

            }

        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (isDirty) {
                    int confirm = JOptionPane.showConfirmDialog(EditorConDirtyBit.this,
                            "Hay cambios sin guardar.¿Deseas salir sin guardar?", "Confirmar Salida", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        dispose();
                    } else if (confirm == JOptionPane.CANCEL_OPTION) {
                        return;
                    } else if (confirm == JOptionPane.NO_OPTION) {
                        if (guardar()) {
                            setTitle("Editor");
                            isDirty = false;
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(EditorConDirtyBit.this, "Error al guardar");
                        }

                    } else {
                        return;
                    }
                }else{
                    dispose();
                }
            }

            private boolean guardar() {

                JFileChooser filechooser = new JFileChooser();
                int opcion = filechooser.showSaveDialog(EditorConDirtyBit.this);

                if (opcion == JFileChooser.APPROVE_OPTION) {
                    System.out.println("Usuario:Aceptar");
                    File archivo = filechooser.getSelectedFile();
                    try {
                        FileWriter writer = new FileWriter(archivo);
                        writer.write(textArea.getText());
                        writer.close();
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                }
                System.out.println("Usuario:Cancelar");
                return false;
            }
        }
        );
    }
}

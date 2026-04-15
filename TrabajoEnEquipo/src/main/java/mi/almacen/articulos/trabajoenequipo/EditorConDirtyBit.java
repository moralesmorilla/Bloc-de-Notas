<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
=======
>>>>>>> 6a4a500 (nuevo)
package mi.almacen.articulos.trabajoenequipo;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
<<<<<<< HEAD
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
=======
import javax.swing.JFrame;
import javax.swing.JOptionPane;
>>>>>>> 6a4a500 (nuevo)
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

<<<<<<< HEAD
/**
 *
 * @author Usuario25
 */
=======
>>>>>>> 6a4a500 (nuevo)
public class EditorConDirtyBit extends JFrame {

    private JTextArea textArea;
    private boolean isDirty = false;

    public EditorConDirtyBit() {
<<<<<<< HEAD
        setTitle("Advertencia");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        textArea = new JTextArea();
        add(new JScrollPane(textArea));

=======
        setTitle("Editor");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        textArea = new JTextArea();
        add(new JScrollPane(textArea));

        // Detectar cambios en el texto
>>>>>>> 6a4a500 (nuevo)
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
<<<<<<< HEAD
                    setTitle("Adevertencia, Cambios sin guardar)");

                }

            }
        });
        
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowsClosing(WindowEvent e){
                if(isDirty){
                    int confirm=JOptionPane.showConfirmDialog(EditorConDirtyBit.this,
                            "Hay cambios sin guardar,¿Deseas salir sin guardar?","Confirmar Salida",
                            JOptionPane.YES_NO_CANCEL_OPTION);
                    if(confirm==JOptionPane.YES_OPTION){
                        System.exit(0);
                    }else if(confirm ==JOptionPane.NO_OPTION){
                        System.out.println("Guardando");
                        isDirty=false;
                        System.exit(0);
                    }
                }else{
                    System.exit(0);
                }
            }
        }
            
            
        });


}
=======
                    setTitle("Advertencia: Cambios sin guardar");
                }
            }
        });

        // Evento al cerrar ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) { // ✅ CORREGIDO
                if (isDirty) {
                    int confirm = JOptionPane.showConfirmDialog(
                            EditorConDirtyBit.this,
                            "Hay cambios sin guardar, ¿Deseas salir sin guardar?",
                            "Confirmar salida",
                            JOptionPane.YES_NO_CANCEL_OPTION
                    );

                    if (confirm == JOptionPane.YES_OPTION) {
                        System.exit(0);

                    } else if (confirm == JOptionPane.NO_OPTION) {
                        return;

                    } else {
                        return;
                    }

                } else {
                    System.exit(0);
                }
            }
        });

        setVisible(true);
    }

    // Método main para ejecutar
    public static void main(String[] args) {
        new EditorConDirtyBit();
    }
}
>>>>>>> 6a4a500 (nuevo)

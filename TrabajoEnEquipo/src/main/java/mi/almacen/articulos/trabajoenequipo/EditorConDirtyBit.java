package mi.almacen.articulos.trabajoenequipo;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class EditorConDirtyBit extends JFrame {

    private JTextArea textArea;
    private boolean isDirty = false;

    public EditorConDirtyBit() {
        setTitle("Editor");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        textArea = new JTextArea();
        add(new JScrollPane(textArea));

        // Detectar cambios en el texto
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
                    setTitle("Advertencia: Cambios sin guardar");
                }
            }
        });

        // Evento al cerrar ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) { // ✔ CORREGIDO
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
                        // Aquí podrías llamar a guardar()
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

    public static void main(String[] args) {
        new EditorConDirtyBit();
    }
}
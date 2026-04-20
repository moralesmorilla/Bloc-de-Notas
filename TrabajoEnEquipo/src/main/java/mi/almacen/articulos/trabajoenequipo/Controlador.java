/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mi.almacen.articulos.trabajoenequipo;

import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.*;

/**
 *
 * @author Usuario25
 */
public class Controlador {
    private BlocDeNotasInterfaz b;
    private AccesoFichero fichero;
    private Lamina lam;
    private TextArea tArea;
    
    
    
    
    public void iniciar() {
        b = new BlocDeNotasInterfaz(this);
        lam=b.getLam();
    }
    
    public String getTextArea(){
        return b.getTextArea().getText();
    }
    

    public void guardarFichero() {
        if (fichero.getArchivo() != null) {
                
                fichero.guardarArchivo(fichero.getArchivo());
                System.out.println("Guardado en archivo existente");

            } else {

                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt");

                chooser.setFileFilter(filtro);
                chooser.setAcceptAllFileFilterUsed(false);

                int resultado = chooser.showSaveDialog(null);

                if (resultado == JFileChooser.APPROVE_OPTION) {

                    File archivo = chooser.getSelectedFile();

                    if (!archivo.getName().toLowerCase().endsWith(".txt")) {
                        archivo = new File(archivo.getAbsolutePath() + ".txt");
                    }

                    fichero.guardarArchivo(archivo);
                    fichero.setArchivoActual(archivo);

                    System.out.println("Guardado en nuevo archivo .txt");
                }
            }
        
    }
    public void abrirFichero(){
        if()
            
        
    }
    
    public void salirFichero(){
        
        
    }

    
    public void setLam(Lamina lam) {
        this.lam = lam;
    }

    
    
    
   
    
}

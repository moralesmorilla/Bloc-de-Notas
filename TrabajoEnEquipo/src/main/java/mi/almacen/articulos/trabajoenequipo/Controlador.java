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
    
    
    
    public void iniciar() {
        b = new BlocDeNotasInterfaz(this);
        fichero=new AccesoFichero();
    }
    
    public void setTextArea(TextArea TextArea){
        b.setTxtArea(TextArea);
    }
    
    public void textoModificado(){
        if(fichero!=null){
            fichero.markDirty();
        }
    }

    public void guardarFichero() {
        String textoGuardar=b.getContenido();
        File archivo=fichero.getArchivoActual();
        
        if(archivo!=null){
            fichero.guardarArchivo(archivo, textoGuardar);
            System.out.println("Guardado en archivo existente");
        }else{
            JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt");
        chooser.setFileFilter(filtro);
        chooser.setAcceptAllFileFilterUsed(false);

        int resultado = chooser.showSaveDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            archivo = chooser.getSelectedFile();

            if (!archivo.getName().toLowerCase().endsWith(".txt")) {
                archivo = new File(archivo.getAbsolutePath() + ".txt");
            }

            // Le damos el archivo nuevo y el texto al mensajero
            fichero.guardarArchivo(archivo, textoGuardar);
            
            fichero.setArchivoActual(archivo); 

            System.out.println("Guardado en nuevo archivo .txt");
        }
        }
        
    }
    public void abrirFichero(){
        JFileChooser chooser = new JFileChooser();
        int resultado = chooser.showOpenDialog(null);
        if(resultado== JFileChooser.APPROVE_OPTION){
            File archivoAbrir = chooser.getSelectedFile();
            String textoArchivo= fichero.abrirArchivo(archivoAbrir);
            b.setContenido(textoArchivo);
        }else{
            return;
        } 
    }
    
    public void salirFichero() {
    
    if (fichero.isDirty()) {
        int respuesta = JOptionPane.showConfirmDialog(null, 
                "¿Desea guardar los cambios antes de salir?", 
                "Salir", 
                JOptionPane.YES_NO_CANCEL_OPTION);
                
        if (respuesta == JOptionPane.YES_OPTION) {
            guardarFichero();
            System.exit(0);
        } else if (respuesta == JOptionPane.NO_OPTION) {
            System.exit(0);
            
        } else {
            return;
        }
        
    } else {
       System.exit(0);
    }
}
    
}

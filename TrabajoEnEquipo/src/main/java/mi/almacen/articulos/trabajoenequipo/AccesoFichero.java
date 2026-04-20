/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mi.almacen.articulos.trabajoenequipo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Usuario25
 */
public class AccesoFichero {
    private File archivoActual;
    private File archivo;
    private boolean isDirty;
    
    
    public AccesoFichero(){
       
    }
    
    public void markDirty() {
        isDirty = true;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public void setSaved() {
        isDirty = false;
    }

    public File getArchivoActual() {
        return archivoActual;
    }

    public void setArchivoActual(File archivoActual) {
        this.archivoActual = archivoActual;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    public String abrirArchivo(File archivo) {
        StringBuilder contenido = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        isDirty = false;
        archivoActual = archivo;
        return contenido.toString();
    }

    public void guardarArchivo(File archivo,String texto) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            bw.write(texto);
            isDirty = false;
            archivoActual = archivo;
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    
}

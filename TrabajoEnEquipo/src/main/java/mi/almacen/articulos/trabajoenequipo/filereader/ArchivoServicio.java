/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mi.almacen.articulos.trabajoenequipo.filereader;

import java.io.*;

/**
 *
 * @author Usuario25
 */
public class ArchivoServicio {

    public String leerArchivo(File archivo) {
        StringBuilder contenido = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            System.out.println(e);        }

        return contenido.toString();
    }

    public void guardarArchivo(File archivo, String texto) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            bw.write(texto);
        } catch (IOException e) {
            System.out.println(e);        }
    }
}

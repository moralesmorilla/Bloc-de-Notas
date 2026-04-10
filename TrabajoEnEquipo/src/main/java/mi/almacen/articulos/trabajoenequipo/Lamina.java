/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mi.almacen.articulos.trabajoenequipo;

import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

/**
 *
 * @author Usuario25
 */
public class Lamina extends JPanel {

    private JTextArea txtArea;

    public Lamina() {
        setLayout(new BorderLayout());

        txtArea = new JTextArea();
        txtArea.setBackground(Color.white);
        txtArea.setLineWrap(true);
        txtArea.setFont(new Font("Arial", Font.ITALIC, 16));

        JScrollPane scroll = new JScrollPane(txtArea);

        add(scroll, BorderLayout.CENTER); 
    }
    
    public void cargarArchivo(File archivo){
        StringBuilder contenido = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(archivo))){
            String linea;
            while((linea=br.readLine()) != null){
                contenido.append(linea).append("\n");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        txtArea.setText(contenido.toString());
    }
    
    public void guardarArchivo(File archivo) throws IOException{
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))){
            bw.write(txtArea.getText());
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    
}
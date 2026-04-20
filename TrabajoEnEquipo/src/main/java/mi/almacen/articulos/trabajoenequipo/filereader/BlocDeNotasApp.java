/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mi.almacen.articulos.trabajoenequipo.filereader;

/**
 *
 * @author Usuario25
 */

public class BlocDeNotasApp {
    public static void main(String[] args) {
        BlocDeNotasVista vista = new BlocDeNotasVista();
        BlocDeNotasControlador controlador = new BlocDeNotasControlador(vista);
        vista.setControlador(controlador);

    }
}

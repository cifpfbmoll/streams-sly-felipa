/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionarpractica7;

/**
 *
 * @author sly
 */
public class MiExcepcion extends Exception {

    private String mensaje;

    public MiExcepcion(String nuevo) {
        super();
        this.mensaje = ".";
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void mostrarMensaje() {
        System.out.println("");
        System.out.println(this.getMensaje());
        System.out.println("");

    }

}

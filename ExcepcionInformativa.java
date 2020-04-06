/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionarpractica7;
//fichero de salida
public class ExcepcionInformativa extends Exception{

    private String mensaje = "\nERROR: El fichero no se encuentra. Intentalo de nuevo.\n";

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public ExcepcionInformativa() {
        super();
        this.setMensaje(mensaje);
    }
}

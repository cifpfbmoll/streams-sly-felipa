/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionarpractica7;

import java.io.*;
import java.sql.Timestamp;
import java.util.Arrays;

public class ExcepcionRutaInvalida extends Exception {

    private String mensaje;

    public ExcepcionRutaInvalida(String nuevo) {
        super();
        this.setMensaje("Error al ingresar los datos.");
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

    public void guardarError(String mensaje, Exception ex) throws IOException {

        try {
            File docErrores = new File("C://Users/sly/Documents/NetBeansProjects/GestionarPractica7/src/gestionarpractica7/errores.txt");
            BufferedWriter escritor = new BufferedWriter(new FileWriter(docErrores, true));
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            // el timestamp se convierte a formato string 
            System.out.println(timestamp.toString() + "\n");
            System.out.println(mensaje + "\n +++++++++++++");

            //getStackTrace obtiene la información de rastreo de la pila.
            System.out.println(Arrays.toString(this.getStackTrace()) + "\n\n");

            escritor.write(timestamp.toString() + "\n");
//            escritor.write(mensaje + "\n", 0, mensaje.length());

            escritor.write(Arrays.toString(this.getStackTrace()) + "\n\n");
            escritor.close();

        } catch (IOException excepcion) {
            System.out.println("Error al leer el archivo");
        }

    }

}

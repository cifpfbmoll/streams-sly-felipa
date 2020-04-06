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
            //el true es para seguir escribiendo sin borrar lo anterior

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            escritor.write(timestamp.toString() + "\n"+ mensaje);

            escritor.write(Arrays.toString(this.getStackTrace()) + "\n\n");
            escritor.close();

            // el timestamp se convierte a formato string 
            System.out.println(timestamp.toString());
            System.out.print(mensaje);
//
            //getStackTrace obtiene la información de rastreo de la pila.
            System.out.println(Arrays.toString(this.getStackTrace()) + "\n\n");
        } catch (IOException excepcion) {

            System.out.println("Error al leer el archivo errores.txt");
        }

    }

}

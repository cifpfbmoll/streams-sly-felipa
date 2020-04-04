/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionarpractica7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author sly
 */
public class LeerFicheroLinea {

    public void leerNuevoFichero() throws IOException {
        File entrada = new File("C:\\Users\\sly\\Documents\\NetBeansProjects\\GestionarPractica7\\src\\gestionarpractica7\\peliOriginal.txt");
        File salida = new File("C:\\Users\\sly\\Documents\\NetBeansProjects\\GestionarPractica7\\src\\gestionarpractica7\\peliFinal.txt");
        BufferedReader lector = new BufferedReader(new FileReader(entrada));
        BufferedWriter escritor = new BufferedWriter(new FileWriter(salida));

        String[] datos = {"Título", "Año", "Director", "Duración",
            "Sinopsis", "Reparto", "Sesión"};
        
        escritor.write("--------------------------------------\n"
                + "       Cartelera de CineFBMoll\n"
                + "--------------------------------------\n\n");
        
        int contador = 0;
        int datosNum = 0;
        escritor.newLine();
        while (lector.ready() != false) { // eof de BufferedReader
            String lineaLeida = lector.readLine();

            lineaLeida = lineaLeida.replace('#', '\n');
            lineaLeida = lineaLeida.replace('{', '\n');
            //la lineaLeida lo paso a un array, la división lo hace por un '\n' 
            String[] texto = lineaLeida.split("\n");

            for (int i = 0; i < texto.length; i++) {
                if (datosNum <= datos.length) {
                    escritor.write(datos[datosNum] + " : " + texto[i]+"\n");
                }
                escritor.write("\n");
                datosNum++;
                contador++;
                if (contador == datos.length) {
                    datosNum = 0;
                    escritor.write("--------------------------------------\n\n");

                }
            }

        }

        lector.close();

        escritor.close();
    }

}

/* REFERENCIAS
    
    http://ayudaitver.blogspot.com/2014/07/uso-basico-del-bufferedreader.html   
    
     
 */

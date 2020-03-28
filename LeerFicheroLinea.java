/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionarpractica7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author sly
 */
public class LeerFicheroLinea {

    public void leerNuevoFichero() throws IOException {
        File entrada = new File("C:/Users/sly/Documents/NetBeansProjects/paraLeer/textoUno.txt");
        BufferedReader lector = new BufferedReader(new FileReader(entrada));
        boolean eof = false;
        String lineaLeida = "";
        String[] espacioTexto = null;

        while (lector.ready() != false) { // eof de BufferedReader
            lineaLeida = lector.readLine();
            espacioTexto = lineaLeida.split(" ");

            if (lineaLeida != null) {
                System.out.println(lineaLeida.length());
//                System.out.println(espacioTexto[5]);
                eof = true;

            } else {
                eof = true;
            }
        }
        lector.close();
    }
}
/* REFERENCIAS
    


- Espacio U+0020
    https://stackoverflow.com/questions/8172420/how-to-convert-a-char-to-a-string
    http://ayudaitver.blogspot.com/2014/07/uso-basico-del-bufferedreader.html
    
    
    
    
    
     */

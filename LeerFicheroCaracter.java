/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionarpractica7;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author sly
 */
public class LeerFicheroCaracter {

    public void LeerCaracter() throws IOException {

//        try {
        FileReader lector = new FileReader("C:\\Users\\sly\\Documents\\NetBeansProjects\\GestionarPractica7\\src\\gestionarpractica7\\peliOriginal.txt");
        FileWriter escritor = new FileWriter("C:\\Users\\sly\\Documents\\NetBeansProjects\\GestionarPractica7\\src\\gestionarpractica7\\peliFinal.txt");

        String[] datos = {"Título", "Año", "Director", "Duración",
            "Sinopsis", "Reparto", "Sesión"};
//
        String cartelera = ("--------------------------------------\n"
                + "       Cartelera de CineFBMoll\n"
                + "--------------------------------------\n\n");

        String linea = "--------------------------------------\n\n";

        //se escribe la cartelera
        for (int i = 0; i < cartelera.length(); i++) {
            escritor.write(cartelera.charAt(i));
        }

        int caracter;
        int contador = 0;
        boolean encontrarSigno = true;

        while ((caracter = lector.read()) != -1) {
            if (((char) caracter) != '#') {
                if (((char) caracter) != '{') {
                    if (encontrarSigno) {
                        for (int i = 0; i < datos[contador].length(); i++) {
                            escritor.write(datos[contador].charAt(i)); // imprimir elemento de datos
                        }
                        escritor.write(": ");
                        encontrarSigno = false;
                    }
                    escritor.write(((char) caracter));
                } else {
                    escritor.write("\n");
                    escritor.write("\n");
                    for (int i = 0; i < linea.length(); i++) {
                        escritor.write(linea.charAt(i));
                    }

                    contador = 0;
                    encontrarSigno = true;
                }
            } else {
                escritor.write("\n");
                escritor.write("\n");
                contador++;
                encontrarSigno = true;
            }
        }//while
        lector.close();// Cierra el archivo 
        escritor.close();// Cierra el archivo 

    }

}

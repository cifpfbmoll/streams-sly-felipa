/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionarpractica7;

import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author sly
 */
public class LeerFicheroCaracter {

    public void LeerCaracter() throws IOException {
        FileReader lector = new FileReader("C:/Users/sly/Documents/NetBeansProjects/paraLeer/textoUno.txt");
        String[] datos = {"Título", "Año", "Director", "Duración",
            "Sinopsis", "Reparto", "Sesión"};
        int caracter;
        int contador = 0;
        boolean verificar = true;
        boolean encontrarSigno = true;

        while ((caracter = lector.read()) != -1) {
            if (((char) caracter) != '#' && ((char) caracter) != '{' && verificar == true) {

                if (verificar) {
                    if (encontrarSigno) {
                        System.out.print(datos[contador] + ": "); // imprimir elemento de datos
                        encontrarSigno = false;
                    }
                    System.out.print(((char) caracter));

                } else {

                }

            } else {
                //encutra #
                // aumenta porque se ha encontrado # , se imprime otro string de datos
                contador++;
                encontrarSigno = true;

                System.out.println("");

            }
        }

        System.out.print((char) caracter);

        lector.close();// Cierra el archivo 
    }

}

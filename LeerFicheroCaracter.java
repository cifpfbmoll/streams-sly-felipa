/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionarpractica7;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.Normalizer;

/**
 *
 * @author sly
 */
public class LeerFicheroCaracter {

    public void LeerCaracter() throws IOException {
        FileInputStream leer = new FileInputStream("C:/Users/sly/Documents/NetBeansProjects/paraLeer/textoUno.txt");
        int c = 0;
        char caracter = ' ';
        while (c != -1) {
            c = leer.read();

//            caracter = Normalizer.normalize(leer.read(), Normalizer.Form.NFD);
//            caracter = (char) c;
            System.out.println(caracter + "---" + c);

        }
        leer.close();
    }

}

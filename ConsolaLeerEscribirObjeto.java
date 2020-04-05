/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionarpractica7;

import java.io.*;

/**
 *
 * @author sly
 */
public class ConsolaLeerEscribirObjeto {

    public void LecturaEscrituraOBjetos() throws ClassNotFoundException, IOException {
        Cartelera listaCartelera[] = new Cartelera[2];
        ObjectInputStream leer = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream("C:/Users/sly/Documents/NetBeansProjects/GestionarPractica7/src/gestionarpractica7/ficheroSalObj.txt")));

        int contador = 0;

        listaCartelera = (Cartelera[]) leer.readObject();
        while (contador <= listaCartelera.length) {
            System.out.println(listaCartelera[contador].mostrarDatos());
            contador++;
        }
        leer.close();

    }

}

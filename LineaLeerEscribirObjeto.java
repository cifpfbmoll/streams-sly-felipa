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
public class LineaLeerEscribirObjeto {

    public void LecturaEscrituraOBjetos() throws IOException {

//devuelve un array de cartelera
        Cartelera listaCartelera[] = Cartelera.cargarDatosCartelera("C:/Users/sly/Documents/NetBeansProjects/GestionarPractica7/src/gestionarpractica7/peliOriginal.txt");
        ObjectOutputStream escribir = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("C:/Users/sly/Documents/NetBeansProjects/GestionarPractica7/src/gestionarpractica7/ficheroSalObj.txt")));

//se escribe un array cartelera
            escribir.writeObject(listaCartelera);
            escribir.close();

    }
}

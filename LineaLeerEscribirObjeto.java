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

    public void LecturaEscrituraOBjetos() throws ClassNotFoundException, IOException {

        ObjectOutputStream escribir = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("C:/Users/sly/Documents/NetBeansProjects/GestionarPractica7/src/gestionarpractica7/ficheroSalObj.txt")));

       

    }

//        escribir.writeObject(new Cartelera(titulo, anyo, director, duracion, sinopsis, reparto, sesion));
//        escribir.writeObject(new Persona("Mario", 50, "202030"));
//        escribir.writeObject(new Persona("Marco", 60, "302030"));
//        escribir.close();
}

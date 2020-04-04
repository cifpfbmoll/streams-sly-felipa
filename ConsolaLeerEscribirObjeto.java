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

        ObjectInputStream leer = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream("C:/Users/sly/Documents/NetBeansProjects/GestionarPractica7/src/gestionarpractica7/ficheroSalObj.txt")));

        while (true) {
            Persona p = (Persona) leer.readObject();
            System.out.println(p.getNombre());
            System.out.println(p.getEdad());
            System.out.println(p.getDni());
            leer.close();

        }

    }

}

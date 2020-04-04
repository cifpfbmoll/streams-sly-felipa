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
public class LeerEscribirObjeto {

    public void LecturaEscrituraOBjetos() throws ClassNotFoundException, IOException {

        try {
            ObjectInputStream leer = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream("C:/Users/sly/Documents/NetBeansProjects/GestionarPractica7/src/gestionarpractica7/ficheroSalObj.txt")));

            ObjectOutputStream escribir = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("C:/Users/sly/Documents/NetBeansProjects/GestionarPractica7/src/gestionarpractica7/ficheroSalObj2.txt")));

            while (true) { //debe leer / imprimir todos los objetos
                Persona p = (Persona) leer.readObject();
                escribir.writeObject((Persona)p);
                System.out.println(p.getNombre());
                System.out.println(p.getEdad());
                System.out.println(p.getDni());
                System.out.println("");

            }
        } catch (Exception e) {
            System.out.println("Fin fichero");

        } finally {
            leer.close();
            escribir.close();
        }

    }

}

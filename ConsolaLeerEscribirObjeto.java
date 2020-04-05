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
                        new FileInputStream("C:/Users/sly/Documents/NetBeansProjects/GestionarPractica7/src/gestionarpractica7/ficheroSalObj2.txt")));

//leo los objetos en el mismo formato en el que fueron escritos
//array de Cartelera
        Cartelera[] listaCartelera = (Cartelera[]) leer.readObject();
        leer.close();

//recorro el array devuelto para imprimir los atributos de los objetos
        for (Cartelera cartelera : listaCartelera) {
            System.out.println(cartelera.mostrarDatos());
        }

    }

}

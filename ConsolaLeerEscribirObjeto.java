/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionarpractica7;

import java.io.*;
import java.util.Scanner;

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

    //lee y escribe desde consola
    public void LecturaEscrituraOBjetosManual() throws IOException {
        ObjectOutputStream escribir = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("C:/Users/sly/Documents/NetBeansProjects/GestionarPractica7/src/gestionarpractica7/ficheroSalObj2.txt")));

        Scanner read = new Scanner(System.in);
        System.out.println("¿Cuántas carteleras agregarás?");
        //se ingresa cantidad de carteleras, para generar el array
        //se crea el array y se piden los datos de cada objeto del array
        //se agrega cada objeto al array y lo devuelve con la información rellenada
        Cartelera[] lista = Cartelera.listaCartelera(read.nextInt());

        //se escribe un array de cartelera. 
        escribir.writeObject(lista);
        escribir.close();
    }
}

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

        while (contador <= listaCartelera.length) {
            Cartelera c = (Cartelera) leer.readObject();
            listaCartelera[contador] = c;
            System.out.println(listaCartelera[contador].mostrarDatos());
//            escribir.writeObject(listaCartelera[contador].getTitulo());
//            escribir.writeObject(listaCartelera[contador].getAnyo());
//            escribir.writeObject(listaCartelera[contador].getDirector());
//            escribir.writeObject(listaCartelera[contador].getDuracion());
//            escribir.writeObject(listaCartelera[contador].getSinopsis());
//            escribir.writeObject(listaCartelera[contador].getReparto());
//            escribir.writeObject(listaCartelera[contador].getSesion());
            contador++;
//            Cartelera c = (Cartelera) leer.readObject();
//            listaCartelera[contador] = c;
//            System.out.println(listaCartelera[contador].mostrarDatos());
//            contador++;

//            Persona p = (Persona) leer.readObject();
////            escribir.writeObject((Persona) p);
//            System.out.println(p.getNombre());
//            System.out.println(p.getEdad());
//            System.out.println(p.getDni());
//            System.out.println("");
            leer.close();
        }

    }

}

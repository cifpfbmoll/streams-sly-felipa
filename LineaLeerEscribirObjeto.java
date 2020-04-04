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

//        File entrada = new File("C:/Users/sly/Documents/NetBeansProjects/GestionarPractica7/src/gestionarpractica7/peliFinal.txt");
//        BufferedReader lector = new BufferedReader(new FileReader(entrada));
//devuelve un array de cartelera
        Cartelera listaCartelera[] = Cartelera.cargarDatosCartelera("C:/Users/sly/Documents/NetBeansProjects/GestionarPractica7/src/gestionarpractica7/peliOriginal.txt");
        ObjectOutputStream escribir = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("C:/Users/sly/Documents/NetBeansProjects/GestionarPractica7/src/gestionarpractica7/ficheroSalObj.txt")));

        int contador = 0;
        while (contador <= listaCartelera.length) {

            escribir.writeObject(listaCartelera[contador].getTitulo());
            escribir.writeObject(listaCartelera[contador].getAnyo());
            escribir.writeObject(listaCartelera[contador].getDirector());
            escribir.writeObject(listaCartelera[contador].getDuracion());
            escribir.writeObject(listaCartelera[contador].getSinopsis());
            escribir.writeObject(listaCartelera[contador].getReparto());
            escribir.writeObject(listaCartelera[contador].getSesion());

//            String lineaLeida = lector.readLine();
//            Cartelera c = (Cartelera) leer.readObject();
//            escribir.writeObject(c.getTitulo());
//            escribir.writeObject(c.getAnyo());
//            escribir.writeObject(c.getDirector());
//            escribir.writeObject(c.getDuracion());
//            escribir.writeObject(c.getSinopsis());
//            escribir.writeObject(c.getReparto());
//            escribir.writeObject(c.getSesion());
            contador++;
            escribir.close();
        }

    }

//        escribir.writeObject(new Cartelera(titulo, anyo, director, duracion, sinopsis, reparto, sesion));
//        escribir.writeObject(new Persona("Mario", 50, "202030"));
//        escribir.writeObject(new Persona("Marco", 60, "302030"));
//        escribir.close();
}

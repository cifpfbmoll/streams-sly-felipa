/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionarpractica7;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Cartelera implements Serializable {

    private String titulo;
    private String anyo;
    private String director;
    private String duracion;
    private String sinopsis;
    private String reparto;
    private String sesion;

    public Cartelera() {
    }

    public Cartelera(String titulo, String anyo, String director, String duracion, String sinopsis, String reparto, String sesion) {
        this.setTitulo(titulo);
        this.setAnyo(anyo);
        this.setDirector(director);
        this.setDuracion(duracion);
        this.setSinopsis(sinopsis);
        this.setReparto(reparto);
        this.setSesion(sesion);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAnyo() {
        return anyo;
    }

    public String getDirector() {
        return director;
    }

    public String getDuracion() {
        return duracion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public String getReparto() {
        return reparto;
    }

    public String getSesion() {
        return sesion;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAnyo(String anyo) {
        this.anyo = anyo;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public void setReparto(String reparto) {
        this.reparto = reparto;
    }

    public void setSesion(String sesion) {
        this.sesion = sesion;
    }

    public static Cartelera[] cargarDatosCartelera(File rutaLeer) throws FileNotFoundException, IOException {
        BufferedReader lector = new BufferedReader(new FileReader(rutaLeer));

        Cartelera listaCartelera[] = new Cartelera[2];

        //se genera los objetos
        for (int i = 0; i < listaCartelera.length; i++) {
            listaCartelera[i] = new Cartelera();
        }

        while (lector.ready() != false) { // eof de BufferedReader
            String lineaLeida = lector.readLine();

            lineaLeida = lineaLeida.replace('#', '\n');
            lineaLeida = lineaLeida.replace('{', '\n');

            //la lineaLeida lo paso a un array, la división lo hace por un '\n' 
            String[] texto = lineaLeida.split("\n");

            int agregarAtributos = 0;
            for (int peli = 0; peli < listaCartelera.length; peli++) {
                listaCartelera[peli].setTitulo(texto[agregarAtributos]);
                agregarAtributos++;
                listaCartelera[peli].setAnyo(texto[agregarAtributos]);
                agregarAtributos++;
                listaCartelera[peli].setDirector(texto[agregarAtributos]);
                agregarAtributos++;
                listaCartelera[peli].setDuracion(texto[agregarAtributos]);
                agregarAtributos++;
                listaCartelera[peli].setSinopsis(texto[agregarAtributos]);
                agregarAtributos++;
                listaCartelera[peli].setReparto(texto[agregarAtributos]);
                agregarAtributos++;
                listaCartelera[peli].setSesion(texto[agregarAtributos]);
                agregarAtributos++;
            }
        }
        lector.close();
        return listaCartelera;
    }

    public static Cartelera[] listaCartelera(int cantidadCartelera) {
//el usuario elige cuántas carteleras ingresa
        Cartelera[] lista = new Cartelera[cantidadCartelera];

        for (int i = 0; i < lista.length; i++) {
//por cada obj, se agregan los datos
            System.out.println("Cartelera " + (i + 1) + " :");
            System.out.println("");
            Cartelera obj = new Cartelera();
            obj.agregarDatosManual();
//se agrega el objeto al array
            lista[i] = obj;
            System.out.println("");
        }
        return lista;
    }

    public void agregarDatosManual() {
        Scanner read = new Scanner(System.in);
        System.out.println("Ingresa el Título de la película");
        this.setTitulo(read.next());
        System.out.println("Ingresa el Año de la película");
        this.setAnyo(read.next());
        System.out.println("Ingresa el Director de la película");
        this.setDirector(read.next());
        System.out.println("Ingresa el Duración de la película");
        this.setDuracion(read.next());
        System.out.println("Ingresa la Sinopsis de la película");
        this.setSinopsis(read.next());
        System.out.println("Ingresa el Reparto de la película");
        this.setReparto(read.next());
        System.out.println("Ingresa la Sesión de la película");
        this.setSesion(read.next());

    }

    public String mostrarDatos() {
        return "*Título:      " + this.getTitulo() + "\n"
                + "*Año:         " + this.getAnyo() + "\n"
                + "*Director:    " + this.getDirector() + "\n"
                + "*Duración:    " + this.getDuracion() + "\n"
                + "*Sinopsis:      " + this.getSinopsis() + "\n"
                + "*Reparto:      " + this.getReparto() + "\n"
                + "*Sesión:      " + this.getSesion() + "\n";
    }

}

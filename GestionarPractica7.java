package gestionarpractica7;

import java.io.*;
import java.util.Scanner;

public class GestionarPractica7 {

    public static void main(String[] args) throws IOException {

        Scanner read = new Scanner(System.in);

//---------------------PRUEBAS---------------------------
        try {
            Cartelera c = new Cartelera();
            Cartelera[] pelis = Cartelera.cargarDatosCartelera("C:/Users/sly/Documents/NetBeansProjects/GestionarPractica7/src/gestionarpractica7/ficheroSalObj2.txt");
               for (Cartelera peli : pelis) {
                System.out.println(peli.mostrarDatos());
            }
//            LineaLeerEscribirObjeto acceder = new LineaLeerEscribirObjeto();
            //            acceder.LecturaEscrituraOBjetos();
            //            LeerEscribirObjeto acceso = new LeerEscribirObjeto();
            //            acceso.LecturaEscrituraOBjetos();
            //            ConsolaLeerEscribirObjeto accediendo = new ConsolaLeerEscribirObjeto();
            //            accediendo.LecturaEscrituraOBjetos();
        } catch (Exception e) {
            System.out.println("Error de lectura ");

        }

        /* 
        

        //------------------------------------------------------  
        // Menú principal
        boolean seguir = true;
        boolean seguirSub = true;
        int op = 0;
        int opSub = 0;

        while (seguir) {
            op = menu();

            if (op == 1) {
                String rutaLeer = pedirRuta("leer");
                System.out.println("");
                String rutaEscribir = pedirRuta("esribir");
                LeerFicheroByte accediendo = new LeerFicheroByte();
                accediendo.LeerByte(rutaLeer, rutaEscribir);
                System.out.println("\n ***** Revisa el fichero modificado. *****\n");
            } else if (op == 2) {
                String rutaLeer = pedirRuta("leer");
                System.out.println("");
                String rutaEscribir = pedirRuta("escribir");
                LeerFicheroCaracter acceso = new LeerFicheroCaracter();
                acceso.LeerCaracter(rutaLeer, rutaEscribir);
                System.out.println("\n ***** Revisa el fichero modificado. *****\n");

            } else if (op == 3) {
                String rutaLeer = pedirRuta("leer");
                System.out.println("");
                String rutaEscribir = pedirRuta("escribir");
                LeerFicheroLinea acceder = new LeerFicheroLinea();
                acceder.leerNuevoFichero(rutaLeer, rutaEscribir);

            } else if (op == 4) {
                while (seguirSub) {
                    opSub = subMenu();
                    if (opSub == 1) {

                    } else if (opSub == 2) {

                    } else if (opSub == 3) {

                    } else if (opSub == 4) {

                    } else if (opSub == 5) {
                        seguirSub = false;

                    } else {
                        System.out.println("Opción no válida");
                    }
                }

            } else if (op == 5) {
                seguir = false;
            } else {
                System.out.println("Opción no válida");
            }
        }
         */
//Lectura y escritura de fichero línea a línea con buffers (character Streams).
//                //String a = "C:\Users\sly\Documents\NetBeansProjects\GestionarPractica7\src\gestionarpractica7\peliOriginal.txt";
//                //String b = "C:\Users\sly\Documents\NetBeansProjects\GestionarPractica7\src\gestionarpractica7\peliFinal.txt";
// C:\Users\sly\Documents\NetBeansProjects\GestionarPractica7\src\gestionarpractica7\peliOriginal.txt
//    C:\Users\sly\Documents\NetBeansProjects\GestionarPractica7\src\gestionarpractica7\peliFinal.txt
    }

    public static String pedirRuta(String palabra) {
        Scanner read = new Scanner(System.in);
        String ruta = "";
        System.out.println("Ingresa la ruta para " + palabra);
        return ruta = read.nextLine();
    }

    public static int subMenu() {
        Scanner read = new Scanner(System.in);
        System.out.println("       *****************************************");
        System.out.println("                        Sub Menú");
        System.out.println("       *****************************************");
        System.out.println("");
        System.out.println("1- Lectura línea a línea y escritura con objetos (obteniendo ficheroSalObj)");
        System.out.println("2- Lectura de objetos(leyendo ficheroSalObj) y escritura de objetos (obteniendo ficheroSalObj2)");
        System.out.println("3- Lectura de objetos(leyendo ficheroSalObj2) y escritura por consola"
                + "(comprobaremos por consola que nos ha escrito bien los objetos en los pasos anteriores)");
        System.out.println("4- Lectura por consola y escritura de objetos.(añadirá objetos al final del fichero existente\n"
                + ", eliminado porque da problemas la adición de objetos");
        System.out.println("5- Volver al menú principal");
        System.out.println("");
        return read.nextInt();
    }

    public static int menu() {
        Scanner read = new Scanner(System.in);

        System.out.println("*****************************************************************");
        System.out.println("                        Menú Principal");
        System.out.println("*****************************************************************");
        System.out.println("");
        System.out.println("1- Lectura y escritura del fichero de cartelera byte a byte");
        System.out.println("2- Lectura y escritura de fichero de cartelera carácter a carácter");
        System.out.println("3- Lectura y escritura de fichero línea a línea con buffers");
        System.out.println("4- Tratamiento de Objetos");
        System.out.println("5- Salir");
        System.out.println("");
        System.out.println("*****************************************************************");
        return read.nextInt();

    }

}

package gestionarpractica7;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class GestionarPractica7 {

    public static void main(String[] args) throws IOException {
        Scanner read = new Scanner(System.in);
        //String a = "C:\Users\sly\Documents\NetBeansProjects\GestionarPractica7\src\gestionarpractica7\peliOriginal.txt";
        //String b = "C:\Users\sly\Documents\NetBeansProjects\GestionarPractica7\src\gestionarpractica7\peliFinal.txt";
//---------------------PRUEBAS---------------------------

//        LeerFicheroCaracter acceso = new LeerFicheroCaracter();
//        LeerFicheroLinea acceder = new LeerFicheroLinea();
        try {
//            letras = accediendo.LeerByte2();
//            acceso.LeerCaracter();
//            acceder.leerNuevoFichero();

        } catch (Exception e) {
            System.out.println("Error de lectura ");

        }

        //------------------------------------------------------  
        // Menú principal
        boolean seguir = true;
        int op = 0;
        int op1 = 0;

        while (seguir) {
            System.out.println("*****************************************************************");
            System.out.println("                        Menú Principal");
            System.out.println("*****************************************************************");
            System.out.println("");
            System.out.println("1- Lectura y escritura del fichero de cartelera byte a byte");
            System.out.println("2- Lectura y escritura de fichero de cartelera carácter a carácter");
            System.out.println("3- Lectura y escritura de fichero línea a línea con buffers");
            System.out.println("4- Salir");
            System.out.println("");

            System.out.println("*****************************************************************");
            op = read.nextInt();
            if (op == 1) {
                String a = pedirDatos("leer");
                System.out.println("");
                String b = pedirDatos("escribir");
                LeerFicheroByte accediendo = new LeerFicheroByte();
                accediendo.LeerByte(a, b);
                System.out.println("");
                System.out.println("Revisa el fichero modificado.");
                System.out.println("");
                //String a = "C:\Users\sly\Documents\NetBeansProjects\GestionarPractica7\src\gestionarpractica7\peliOriginal.txt";
                //String b = "C:\Users\sly\Documents\NetBeansProjects\GestionarPractica7\src\gestionarpractica7\peliFinal.txt";
//                C:\Users\sly\Documents\NetBeansProjects\GestionarPractica7\src\gestionarpractica7\peliOriginal.txt
//                C:\Users\sly\Documents\NetBeansProjects\GestionarPractica7\src\gestionarpractica7\peliFinal.txt
            } else if (op == 2) {
            } else if (op == 3) {
            } else if (op == 4) {
            } else {
                System.out.println("Opción no válida");
            }
        }
//        Lectura y escritura del fichero de cartelera byte a byte (byte Streams).
//Lectura y escritura de fichero de cartelera carácter a carácter (character Streams).
//Lectura y escritura de fichero línea a línea con buffers (character Streams).
    }

    public static String pedirDatos(String palabra) {
        Scanner read = new Scanner(System.in);
        String ruta = "";
        System.out.println("Ingresa la ruta para " + palabra);
        return ruta = read.nextLine();
    }
}

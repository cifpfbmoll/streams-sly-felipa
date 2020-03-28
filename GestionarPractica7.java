package gestionarpractica7;

import java.util.Scanner;

public class GestionarPractica7 {

    public static void main(String[] args) {

        //---------------------PRUEBAS---------------------------
        LeerFicheroByte accediendo = new LeerFicheroByte();
//        LeerFicheroCaracter acceso = new LeerFicheroCaracter();
//        LeerFicheroLinea acceder = new LeerFicheroLinea();
        char[] letras = null;
        try {
//            letras = accediendo.LeerByte2();
            accediendo.LeerByte();
//            acceso.LeerCaracter();
//            acceder.leerNuevoFichero();

        } catch (Exception e) {
            System.out.println("Error de lectura ");

        }

        //------------------------------------------------------  
        // Menú principal
//        Scanner read = new Scanner(System.in);
//        boolean seguir = true;
//        int op = 0;
//        int op1 = 0;
//
//        while (seguir) {
//            System.out.println("*******************************");
//            System.out.println("1- Lectura y escritura del fichero de cartelera byte a byte");
//            System.out.println("2- Lectura y escritura de fichero de cartelera carácter a carácter");
//            System.out.println("3- Lectura y escritura de fichero línea a línea con buffers");
//            System.out.println("4- Salir");
//            System.out.println("*******************************");
//            op = read.nextInt();
//            if (op == 1) {
//                  System.out.println("Ingresa la ruta seleccionada: ");
//                  op1 = read.nextInt();


//            } else if (op == 2) {
//            } else if (op == 3) {
//            } else if (op == 4) {
//            } else {
//                System.out.println("Opción no válida");
//            }
//        }
//        Lectura y escritura del fichero de cartelera byte a byte (byte Streams).
//Lectura y escritura de fichero de cartelera carácter a carácter (character Streams).
//Lectura y escritura de fichero línea a línea con buffers (character Streams).
    }

}

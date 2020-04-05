package gestionarpractica7;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionarPractica7 {

    public static void main(String[] args) throws IOException {

        Scanner read = new Scanner(System.in);

//---------------------PRUEBAS---------------------------
        try {

//            System.out.println("¿Cuántas carteleras agregarás?");
//            Cartelera[]  lista = Cartelera.listaCartelera(read.nextInt());
//            System.out.println(lista.length);
//            Cartelera c = new Cartelera();
//            c.agregarDatosManual();
//            System.out.println(c.mostrarDatos());
//            Cartelera[] pelis = Cartelera.cargarDatosCartelera("C:/Users/sly/Documents/NetBeansProjects/GestionarPractica7/src/gestionarpractica7/ficheroSalObj2.txt");
//               for (Cartelera peli : pelis) {
//                System.out.println(peli.mostrarDatos());
//            LineaLeerEscribirObjeto acceder = new LineaLeerEscribirObjeto();
//            acceder.LecturaEscrituraOBjetos();
//            LeerEscribirObjeto acceso = new LeerEscribirObjeto();
//            acceso.LecturaEscrituraOBjetos();
            ConsolaLeerEscribirObjeto accediendo = new ConsolaLeerEscribirObjeto();
            accediendo.LecturaEscrituraOBjetosManual();
        } catch (Exception e) {
            System.out.println("Error de lectura escritura ");

        }

        /* 
         */
        //------------------------------------------------------  
        // Menú principal
        boolean seguir = true;
        boolean seguirSub = true;
        int op = 0;
        int opSub = 0;

        while (seguir) {
            op = menu();

            if (op == 1) {
                File paraLeer = pedirRuta("leer");
                System.out.println("");
                File paraEscribir = pedirRuta("escribir");
                LeerByte(paraLeer, paraEscribir);
                System.out.println("\n ***** Revisa el fichero modificado. *****\n");
            } else if (op == 2) {
                File paraLeer = pedirRuta("leer");
                System.out.println("");
                File paraEscribir = pedirRuta("escribir");
                LeerCaracter(paraLeer, paraEscribir);
                System.out.println("\n ***** Revisa el fichero modificado. *****\n");
            } else if (op == 3) {
                File paraLeer = pedirRuta("leer");
                System.out.println("");
                File paraEscribir = pedirRuta("escribir");
                LeerFicheroLinea acceder = new LeerFicheroLinea();
                acceder.leerNuevoFichero(paraLeer, paraEscribir);

            } else if (op == 4) {
                while (seguirSub) {
                    opSub = subMenu();
                    if (opSub == 1) {
                        File paraLeer = pedirRuta("leer");
                        System.out.println("");
                        File paraEscribir = pedirRuta("escribir");

                    } else if (opSub == 2) {
                        File paraLeer = pedirRuta("leer");
                        System.out.println("");
                        File paraEscribir = pedirRuta("escribir");

                    } else if (opSub == 3) {
                        File paraLeer = pedirRuta("leer");
                        System.out.println("");
                        File paraEscribir = pedirRuta("escribir");

                    } else if (opSub == 4) {
                        File paraLeer = pedirRuta("leer");
                        System.out.println("");
                        File paraEscribir = pedirRuta("escribir");

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
// C:\Users\sly\Documents\NetBeansProjects\GestionarPractica7\src\gestionarpractica7\peliOriginal.txt
// C:\Users\sly\Documents\NetBeansProjects\GestionarPractica7\src\gestionarpractica7\peliFinal.txt
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

    public static File pedirRuta(String palabra) {
        Scanner read = new Scanner(System.in);
        System.out.println("Ingresa la ruta para " + palabra);
        File documento = new File(read.nextLine());
        return documento;
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

    // lectura y escritura byte a byte
    public static void LeerByte(File rutaLeer, File rutaEscribir) throws IOException {

        try {
            FileInputStream leer = new FileInputStream(rutaLeer);
            FileOutputStream escribir = new FileOutputStream(rutaEscribir);

            char[] letras = new char[numCaracteres(rutaLeer)]; //array para almacenar todos los char
            int b = 0;
//            letras = new char[numCaracteres(rutaLeer)];
            int contador = 0;
            while (b != -1) {
                b = leer.read(); //se lee los bytes
                char c = (char) b; // se convierte a char
                letras[contador] = c;  // se guarda los char
                contador++;
            }

            //leer y escribir 
            String[] datos = {"Título", "Año", "Director", "Duración",
                "Sinopsis", "Reparto", "Sesión"};
            String letra = "";
            String frase = "";
            int contar = 0;
            boolean encontrarSigno = false;
            int data = -1;

            escribir.write("--------------------------------------".getBytes());
            escribir.write('\n');
            escribir.write("       Cartelera de CineFBMoll".getBytes());
            escribir.write('\n');
            escribir.write("--------------------------------------".getBytes());
            escribir.write('\n');

            int corchete = 0;
            for (int i = 0; i < letras.length; i++) {
                if (letras[i] == '{') {
                    corchete = i;
                }
            }
            letras[corchete] = '#'; // en la posición 475 ({) se cambia por #
            while (contar <= letras.length - 1 && encontrarSigno == false) {
                if (letras[contar] != '#' && contar != letras.length - 1) {
                    letra = Character.toString(letras[contar]);
                    frase += letra; // si no es un # se forma una frase

                    contar++;
                } else {
                    encontrarSigno = true;
                    data++;
                    contar++;
                    int espacios = 0;
                    int cortarLinea = 14; //cuenta los espacios ' ' para dar un salto de línea
                    if (encontrarSigno == true) {
                        if (frase.length() < 100) { // si es o no un párrafo
                            escribir.write('\n');
                            escribir.write(datos[data].getBytes());
                            escribir.write(" : ".getBytes());
                            escribir.write(frase.getBytes());
                            escribir.write('\n');

                            encontrarSigno = false;
                            frase = "";
                        } else {
                            escribir.write('\n');
                            escribir.write(datos[data].getBytes()); //sinopsis
                            escribir.write(" : ".getBytes());
                            for (int i = 0; i < frase.length(); i++) {
                                char c = frase.charAt(i);
                                if (c == ' ') {
                                    espacios++;
                                }
                                if (espacios == cortarLinea) { //comprobación para dar salto de línea
                                    escribir.write('\n');
                                    cortarLinea += 15;
                                }
                                escribir.write(c);
                            }
                            escribir.write('\n');
                            encontrarSigno = false;
                            frase = "";
                        }

                        if (data + 1 == datos.length) {
                            data = -1;
                            escribir.write("-----------------------------".getBytes());
                        }
                    }//'#'
                }
            }//while
        } catch (IOException exc) {
            System.out.println("Error de lectura ");
        }

    }

    public static int numCaracteres(File rutaLeer) throws IOException { //números de cacacteres para crear el array
        FileInputStream leer = new FileInputStream(rutaLeer);

        int b = 0;
        int contador = 0;
        while (b != -1) {
            b = leer.read();
            contador++;
        }
        leer.close();
        return contador;
    }

    //lectura y escritura caracter a caracter
    public static void LeerCaracter(File rutaLeer, File rutaEscribir) throws IOException {

        FileReader lector = new FileReader(rutaLeer);
        FileWriter escritor = new FileWriter(rutaEscribir);

        String[] datos = {"Título", "Año", "Director", "Duración",
            "Sinopsis", "Reparto", "Sesión"};
        String cartelera = ("--------------------------------------\n"
                + "       Cartelera de CineFBMoll\n"
                + "--------------------------------------\n\n");

        String linea = "--------------------------------------\n\n";

        //se escribe la cartelera
        for (int i = 0; i < cartelera.length(); i++) {
            escritor.write(cartelera.charAt(i));
        }

        int caracter;
        int contador = 0;
        boolean encontrarSigno = true;

        while ((caracter = lector.read()) != -1) {
            if (((char) caracter) != '#') {
                if (((char) caracter) != '{') {
                    if (encontrarSigno) {
                        for (int i = 0; i < datos[contador].length(); i++) {
                            escritor.write(datos[contador].charAt(i)); // imprimir elemento de datos
                        }
                        escritor.write(": ");
                        encontrarSigno = false;
                    }
                    escritor.write(((char) caracter));
                } else {
                    escritor.write("\n");
                    escritor.write("\n");
                    for (int i = 0; i < linea.length(); i++) {
                        escritor.write(linea.charAt(i));
                    }

                    contador = 0;
                    encontrarSigno = true;
                }
            } else {
                escritor.write("\n");
                escritor.write("\n");
                contador++;
                encontrarSigno = true;
            }
        }//while
        lector.close();// Cierra el archivo 
        escritor.close();// Cierra el archivo 

    }

    //lectura y escritura linea a linea
    public static void LeerFicheroLinea(File rutaLeer, File rutaEscribir) throws IOException {
  
        BufferedReader lector = new BufferedReader(new FileReader(rutaLeer));
        BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaEscribir));

        String[] datos = {"Título", "Año", "Director", "Duración",
            "Sinopsis", "Reparto", "Sesión"};

        escritor.write("--------------------------------------\n"
                + "       Cartelera de CineFBMoll\n"
                + "--------------------------------------\n\n");

        int contador = 0;
        int datosNum = 0;
        escritor.newLine();
        while (lector.ready() != false) { // eof de BufferedReader
            String lineaLeida = lector.readLine();

            lineaLeida = lineaLeida.replace('#', '\n');
            lineaLeida = lineaLeida.replace('{', '\n');
            //la lineaLeida lo paso a un array, la división lo hace por un '\n' 
            String[] texto = lineaLeida.split("\n");
            for (int i = 0; i < texto.length; i++) {
                if (datosNum <= datos.length) {
                    System.out.println(texto[i]);
                }
                datosNum++;
                contador++;
                if (contador == datos.length) {
                    datosNum = 0;
                }
            }
        }
        lector.close();
        escritor.close();
    }

}

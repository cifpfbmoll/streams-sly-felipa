package gestionarpractica7;

import java.io.*;
import java.util.Scanner;

public class GestionarPractica7 {

    public static void main(String[] args) throws IOException {

        Scanner read = new Scanner(System.in);

        // Menú principal
        boolean seguir = true;
        boolean seguirSub = true;
        int op = 0;
        int opSub = 0;

        while (seguir) {
            op = menu();

            if (op == 1) {
                try {
                    File paraLeer = pedirRutaLeer();
                    System.out.println("");
                    File paraEscribir = pedirRutaEscribir();
                    LeerByte(paraLeer, paraEscribir);
                    System.out.println("\n ***** Revisa el fichero modificado. *****\n");
                } catch (ExcepcionRutaInvalida ex) {
                    System.out.println("");
                    System.out.println(ex.getMessage());
                    ex.guardarError(ex.getMessage(), ex);
                }

            } else if (op == 2) {
                try {
                    File paraLeer = pedirRutaLeer();
                    System.out.println("");
                    File paraEscribir = pedirRutaEscribir();
                    LeerCaracter(paraLeer, paraEscribir);
                    System.out.println("\n ***** Revisa el fichero modificado. *****\n");
                } catch (IOException excepcion) {
                    System.out.println("");
                    System.out.println("Error al leer el archivo");
                    System.out.println("");
                } catch (ExcepcionRutaInvalida ex) {
                    System.out.println("");
                    //getMessage devuelve la cadena descriptiva almacenada en una excepción
                    System.out.println(ex.getMessage());
                    ex.guardarError(ex.getMessage(), ex);

                }
            } else if (op == 3) {
                try {
                    File paraLeer = pedirRutaLeer();
                    System.out.println("");
                    File paraEscribir = pedirRutaEscribir();
                    LeerFicheroLinea(paraLeer, paraEscribir);
                } catch (IOException excepcion) {
                    System.out.println("");
                    System.out.println("Error al leer el archivo");
                    System.out.println("");
                } catch (ExcepcionRutaInvalida ex) {
                    System.out.println("");

                    //getMessage devuelve la cadena descriptiva almacenada en una excepción
                    System.out.println(ex.getMessage());
                    ex.guardarError(ex.getMessage(), ex);

                }

            } else if (op == 4) {
                while (seguirSub) {
                    opSub = subMenu();
                    if (opSub == 1) {

                        try {
                            File paraLeer = pedirRutaLeer();
                            System.out.println("");
                            File paraEscribir = pedirRutaEscribir();
                        } catch (Exception e) {
                            System.out.println("Error al leer el archivo");
                        }

                    } else if (opSub == 2) {

                        try {
                            File paraLeer = pedirRutaLeer();
                            System.out.println("");
                            File paraEscribir = pedirRutaEscribir();
                        } catch (Exception e) {
                            System.out.println("Error al leer el archivo");
                        }

                    } else if (opSub == 3) {

                        try {
                            File paraLeer = pedirRutaLeer();
                            System.out.println("");
                            File paraEscribir = pedirRutaEscribir();
                        } catch (Exception e) {
                            System.out.println("Error al leer el archivo");
                        }

                    } else if (opSub == 4) {
                        try {
                            File paraLeer = pedirRutaLeer();
                            System.out.println("");
                            File paraEscribir = pedirRutaEscribir();
                        } catch (Exception e) {
                            System.out.println("Error al leer el archivo");
                        }

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

    public static File pedirRutaLeer() throws ExcepcionRutaInvalida {
        Scanner read = new Scanner(System.in);
        System.out.println("Ingresa la ruta para leer: ");
        File documento = new File(read.nextLine());
        boolean existe = documento.exists();
        if (!existe) {
            throw new ExcepcionRutaInvalida("01");
        }
        return documento;
    }

    public static File pedirRutaEscribir() throws ExcepcionRutaInvalida {
        Scanner read = new Scanner(System.in);
        System.out.println("Ingresa la ruta para escribir: ");
        File documento = new File(read.nextLine());
        boolean existe = documento.exists();
        if (!existe) {
            throw new ExcepcionRutaInvalida("02");
        }
        return documento;
    }

    // lectura y escritura byte a byte
    public static void LeerByte(File rutaLeer, File rutaEscribir) throws IOException {

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
    public static void LeerFicheroLinea(File rutaLeer, File rutaEscribir)
            throws IOException {

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

    //         *************** acciones con objetos **************
    // objeto linea a linea
    public static void LineaLeerEscribirObjeto(File rutaLeer,
            File rutaEscribir) throws IOException {
        //devuelve un array de cartelera
        Cartelera listaCartelera[] = Cartelera.cargarDatosCartelera(rutaLeer);
        ObjectOutputStream escribir = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(rutaEscribir)));

        //se escribe un array cartelera
        escribir.writeObject(listaCartelera);
        escribir.close();
    }

    // objeto : Leer SalObj) y escrituraficheroSalObj2.
    public static void LecturaEscrituraOBjetos(File rutaLeer,
            File rutaEscribir) throws ClassNotFoundException, IOException {

        ObjectInputStream leer = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(rutaLeer)));

        ObjectOutputStream escribir = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(rutaEscribir)));

        //se lee un array de cartelera. 
        Cartelera[] listaCartelera = (Cartelera[]) leer.readObject();
        leer.close();

        //se escribe un array de cartelera. 
        escribir.writeObject(listaCartelera);
        escribir.close();
    }

    //objeto consola : leer ficheroSalObj2 y escritura por consola 
    public void LecturaEscrituraOBjetosConsola(File rutaLeer)
            throws ClassNotFoundException, IOException {
        ObjectInputStream leer = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(rutaLeer)));
        try {
            //leo los objetos en el mismo formato en el que fueron escritos
            //array de Cartelera
            Cartelera[] listaCartelera = (Cartelera[]) leer.readObject();
            leer.close();

            //recorro el array devuelto para imprimir los atributos de los objetos
            for (Cartelera cartelera : listaCartelera) {
                System.out.println(cartelera.mostrarDatos());
            }
        } catch (IOException ex) {
            System.out.println("");
        } catch (ClassNotFoundException ex) {
            System.out.println("Clase no encontrada");
        }

    }

//objeto consola : leer por consola y SOBREescritura ficheroSalObj2 
    public void LecturaEscrituraOBjetosManual(File rutaEscribir) throws IOException {
        ObjectOutputStream escribir = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(rutaEscribir)));

        Scanner read = new Scanner(System.in);
        System.out.println("¿Cuántas carteleras agregarás?");
        //se ingresa cantidad de carteleras, para generar el array
        //se crea el array y se piden los datos de cada objeto
        //se agrega cada objeto al array y lo devuelve con la información rellenada
        Cartelera[] lista = Cartelera.listaCartelera(read.nextInt());

        //se escribe un array de cartelera. 
        escribir.writeObject(lista);
        escribir.close();
    }
}

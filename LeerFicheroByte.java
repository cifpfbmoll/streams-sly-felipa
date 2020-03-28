/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionarpractica7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 *
 * @author sly
 */
public class LeerFicheroByte {

    public void LeerByte() throws IOException {
        FileInputStream leer = new FileInputStream("C:/Users/sly/Documents/NetBeansProjects/paraLeer/textoUno.txt");

        int b = 0;
        char[] letras = new char[numCaracteres()];
        int contador = 0;
        while (b != -1) {
            b = leer.read();
            char c = (char) b;
            letras[contador] = c;
            contador++;
        }
        leer.close();
        mostrarPalabra(letras); // devolverá un array

//            leer.read(palabra.getBytes());
    }

    public int numCaracteres() throws IOException { //números de cacacteres para crear el array
        FileInputStream leer = new FileInputStream("C:/Users/sly/Documents/NetBeansProjects/paraLeer/textoUno.txt");

        int b = 0;
        int contador = 0;
        while (b != -1) {
            b = leer.read();
            contador++;
        }
        leer.close();
        return contador;
    }

    //la idea es que cuando encuentre # cambie de palabra
    public char[] mostrarPalabra(char[] letras) {

        String[] datos = {"Título", "Año", "Director", "Duración",
            "Sinopsis", "Reparto", "Sesión"};
        String letra = "";
        String frase = "";
        int contador = 0;
        boolean encontrarSigno = false;
        int data = -1;
        char[] frases = new char[letras.length]; // falta parsarlo

        System.out.println("--------------------------------------");
        System.out.println("       Cartelera de CineFBMoll");
        System.out.println("--------------------------------------");
        System.out.println("");

        int corchete = 0;
        for (int i = 0; i < letras.length; i++) {
            if (letras[i] == '{') {
                letras[corchete] = '#';
            }
//            System.out.println(letras[i]);
        }
        letras[corchete] = '#'; //475

//        System.out.println(letras.length);
        while (contador <= letras.length - 1 && encontrarSigno == false) {

            if (letras[contador] != '#' && contador != letras.length - 1) {

                letra = Character.toString(letras[contador]);
                frase += letra;

                contador++;
            } else {
//                System.out.println(letras[contador] + "-" + contador);
                encontrarSigno = true;
                data++;
                contador++;
                int espacios = 0;
                int cortarLinea = 14;
                if (encontrarSigno == true) {
                    if (frase.length() < 100) {
                        System.out.println("");
                        System.out.println(datos[data] + " : " + frase);
//                        System.out.println(frase);
                        encontrarSigno = false;
                        frase = "";
                    } else {
                        System.out.println("");
                        System.out.println(datos[data] + " : ");//sinopsis
                        for (int i = 0; i < frase.length(); i++) {
                            char c = frase.charAt(i);
                            if (c == ' ') {
                                espacios++;
                            }
                            if (espacios == cortarLinea) {
                                System.out.print("\n");
                                cortarLinea += 15;
                            }
                            System.out.print(c);
                        }
                        System.out.println("");
                        encontrarSigno = false;
                        frase = "";
                    }

                    if (data + 1 == datos.length) {
                        data = -1;
                        System.out.println("-----------------------------");
                    }
                }
            }//'#'

        }//while
        return frases;

    }

    public void escribirByte() throws IOException {
        FileInputStream leer = new FileInputStream("C:/Users/sly/Documents/NetBeansProjects/paraLeer/textoUno.txt");
        FileOutputStream escribir = new FileOutputStream("C:/Users/sly/Documents/NetBeansProjects/paraEscribir/textoDos.txt");

    }

}


/* REFERENCIAS
    


- Espacio U+0020
https://javadesdecero.es/avanzado/streams-de-bytes/
    
    
    
    
    
 */

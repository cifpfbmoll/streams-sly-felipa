/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionarpractica7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class LeerFicheroByte {

    public void LeerByte(String rutaLeer, String rutaEscribir) throws IOException {

        try {
            FileInputStream leer = new FileInputStream(rutaLeer); //se pasa un ruta 
            FileOutputStream escribir = new FileOutputStream(rutaEscribir);

            char[] letras = new char[numCaracteres()]; //array para almacenar todos los char
            int b = 0;
            letras = new char[numCaracteres()];
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

    public int numCaracteres() throws IOException { //números de cacacteres para crear el array
        FileInputStream leer = new FileInputStream("C:\\Users\\sly\\Documents\\NetBeansProjects\\GestionarPractica7\\src\\gestionarpractica7\\peliOriginal.txt");

        int b = 0;
        int contador = 0;
        while (b != -1) {
            b = leer.read();
            contador++;
        }
        leer.close();
        return contador;
    }
}


/* REFERENCIAS
    

https://javadesdecero.es/avanzado/streams-de-bytes/
   
    
 */

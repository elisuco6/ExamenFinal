package Examen1.ejercicio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Pre: ---
 * Post: fichero Divorcios.csv, que contiene la información sobre los divorcios
 * en España según exista o no separación previa, separado por localidades y años (estos datos
 * pertenecen al Instituto Nacional de Estadística). Queremos desarrollar un programa Java que sea
 * capaz de mostrar por pantalla ciertos datos filtrados.
 */
public class Ejercicio2 {
    /**
     * Pre: ---
     * Post: Este metodo es muy simple unicamente enviamos la ruta del fichero a usar
     * hacia otro metodo.
     */
    public static void main(String[] args) {
        leerFichero("C:\\Users\\elisa\\Desktop\\Divorcios.csv");
    }

    /**
     * Pre: ---
     * Post: Metodo que crea el objeto file apartir de la ruta, capaz de splitear la informacion para asi
     * poder filtrarla, enviamos los datos al metodo insertAccidentally explicado posteriormente
     * y por ultimo llamamos al metodo sort para que nos ordene el array y lo muestre.
     */
    public static void leerFichero(String fichero) {
        File file = new File(fichero);
        try {
            /*
             * Se crea un objeto [Formatter] al que se asocia un fichero deno-
             * minado [file].
             */
            Scanner f = new Scanner(file);
            f.nextLine();
            while (f.hasNextLine()) {
                String next = f.nextLine();
                String ciudad = next.split(";")[0];
                String ano = next.split(";")[2];
                String aceptacion = next.split(";")[1];
                String totales = next.split(";")[3];

                if (ano.equalsIgnoreCase("2019")&&aceptacion.equalsIgnoreCase("si")){
                    System.out.println(ciudad + " " + aceptacion + " " + ano + " " + totales);
                }else if (ano.equalsIgnoreCase("2018")&&aceptacion.equalsIgnoreCase("no")){
                    System.out.println(ciudad + " " + aceptacion + " " + ano + " " + totales);
                }

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
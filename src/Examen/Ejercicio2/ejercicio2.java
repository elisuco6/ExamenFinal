package Examen.Ejercicio2;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Pre: ---
 * Post: fichero Divorcios.csv, que contiene la información sobre los divorcios
 * en España según exista o no separación previa, separado por localidades y años (estos datos
 * pertenecen al Instituto Nacional de Estadística). Queremos desarrollar un programa Java que sea
 * capaz de mostrar por pantalla ciertos datos filtrados.
 */
public class ejercicio2 {
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
        ArrayList<Tupla> natList = new ArrayList<Tupla>();
        try {
            /*
             * Se crea un objeto [Formatter] al que se asocia un fichero deno-
             * minado [file].
             */
            Scanner f = new Scanner(file);
            f.nextLine();
            while (f.hasNextLine()) {
                String next = f.nextLine();
                String acidentality = next.split(";")[2].replace("\"", "").trim();
                String totales = next.split(";")[3];
                insertAccidentality(natList, acidentality, totales);
            }

            /*
             * aqui ordenamos el array y mostramos la informacion filtrada por años
             * obtenida del metodo posteriror insertAccidentality
             */
            Collections.sort(natList);
            for (int i = 0; i < natList.size(); i++) {
                if (natList.get(i).getAccidentality().equalsIgnoreCase("2019"))
                    System.out.println("Nat: " + natList.get(i).getAccidentality() + " -> " +
                            natList.get(i).getOccurrences() + " registros de divorcio");
                if (natList.get(i).getAccidentality().equalsIgnoreCase("2018"))
                    System.out.println("Nat: " + natList.get(i).getAccidentality() + " -> " +
                            natList.get(i).getOccurrences() + " registros de divorcio");
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Pre: ---
     * Post: metodo encargado de recorrer el array de nombre natList y unir los atributos
     * que coincidan con el String accidentality para asi filtrarlos por año en este caso
     */
    public static void insertAccidentality(ArrayList<Tupla> natList, String accidentality, String totales) {
        //si esta vacio comenzamos a agregar datos.
        if (natList.size() == 0) {
            natList.add(new Tupla(accidentality, 1));
        } else {
            /*
             * en caso de no estar vacio va comprobando y si se repite incrementa la variable ocurrences
             * cuando termina se acaba el proceso
             */
            boolean find = false;
            for (int i = 0; i < natList.size(); i++) {
                if (natList.get(i).getAccidentality().equalsIgnoreCase(accidentality)) {
                    natList.get(i).setOccurrences(natList.get(i).getOccurrences() + 1);
                    find = true;
                    break;
                }
            }
            if (!find) {
                natList.add(new Tupla(accidentality, 1));
            }
        }
    }
}

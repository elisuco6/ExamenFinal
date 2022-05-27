package Examen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Pre: ---
 * Post: En el metodo main mandamos al metodo leerFichero nuestra ruta
 */
public class ejercicio2 {
    public static void main(String[] args) {
        leerFichero("C:\\Users\\elisa\\Desktop\\Divorcios.csv");
    }

    /**
     * Pre: ---
     * Post: leemos el fichero mandado y lo spliteamos en este caso por ";" posteriormente
     *
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
                String con = next.split(";")[1].replace("\"", "").trim();
                insertAccidentality(natList, acidentality, con);
            }
            Collections.sort(natList);
            for (int i =0; i<natList.size();i++) {
                if (natList.get(i).getAccidentality().equalsIgnoreCase("2019")){
                    System.out.println("Año: " + natList.get(i).getAccidentality() + " -> "
                            + natList.get(i).getOccurrences() + " separaciones"
                            + " con: " + natList.get(i).getCon());
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertAccidentality(ArrayList<Tupla> natList, String accidentality, String con) {
        if (natList.size() == 0) {
            natList.add(new Tupla(accidentality, 1, con));
        } else {
            boolean find = false;
            for (int i = 0; i < natList.size(); i++) {
                if (natList.get(i).getAccidentality().equalsIgnoreCase(natList.get(i).getAccidentality())) {
                    natList.get(i).setOccurrences(natList.get(i).getOccurrences());
                }
            }
            if (!find) {
                natList.add(new Tupla(accidentality, 1, con));
            }
        }
    }
}
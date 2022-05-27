package Examen.Ejercicio2;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {
        leerFichero("C:\\Users\\elisa\\Desktop\\Divorcios.csv");
    }

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
                insertAccidentality(natList, acidentality,totales);
            }

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

    public static void insertAccidentality(ArrayList<Tupla> natList, String accidentality, String totales) {
        if (natList.size() == 0) {
            natList.add(new Tupla(accidentality, 1));
        } else {
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

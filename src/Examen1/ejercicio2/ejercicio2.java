package Examen1.ejercicio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
            ArrayList<Tupla> divorciaciones = new ArrayList<Tupla>();
            Scanner f = new Scanner(file);
            f.nextLine();
            int contador = 0;
            int sumtotal = 0;
            int contador2 = 0;
            int sumtotal2 = 0;
            int contador3 = 0;
            int posicion = 0;
            boolean encontrado = false;

            while (f.hasNextLine()) {
                String next = f.nextLine();
                String ciudad = next.split(";")[0];
                String aceptacion = next.split(";")[1];
                String ano = next.split(";")[2];
                String totales = next.split(";")[3].replaceAll("\\.", "");

                if (!totales.equalsIgnoreCase("")) {
                    if (ano.equalsIgnoreCase("2019") && aceptacion.equalsIgnoreCase("si")) {
                        contador = Integer.parseInt(totales);
                        sumtotal = sumtotal + contador;
                    } else if (ano.equalsIgnoreCase("2018") && aceptacion.equalsIgnoreCase("no")) {
                        contador2 = Integer.parseInt(totales);
                        sumtotal2 = sumtotal2 + contador2;
                    }
                    if (divorciaciones.size() == 0) {
                        Tupla divorces = new Tupla(ciudad.substring(4, ciudad.length()), Integer.parseInt(totales));
                        divorciaciones.add(divorces);
                    } else {
                        Tupla divorces = new Tupla(ciudad, Integer.parseInt(totales));
                        //suma de totales por localidad
                        for (int i = 0; i < divorciaciones.size(); i++) {
                            //System.out.println(divorciaciones.toString());
                            //System.out.println(ciudad + " " + divorciaciones.get(i).getLocalidad());
                            //System.out.println((ciudad.substring(3, ciudad.length())));
                            //System.out.println(divorciaciones.get(i).getLocalidad());
                            //System.out.println(ciudad);
                            //System.out.println(divorciaciones.get(i).getLocalidad());
                            if (ciudad.equalsIgnoreCase(divorciaciones.get(i).getLocalidad())
                                    && Integer.parseInt(ano) >= 2013 && Integer.parseInt(ano) <= 2019) {
                                encontrado = true;
                                //System.out.println("True");
                                posicion = i;
                                break;
                            }
                        }
                        if (encontrado) {
                            contador3 = Integer.parseInt(totales);
                            divorciaciones.get(posicion).setPoblacion(divorciaciones.get(posicion).getPoblacion()
                                    + contador3);
                            encontrado = false;
                        } else {
                            divorciaciones.add(divorces);
                        }
                    }
                }
            }
            String poblacion = "";
            int divorcios = 0;
            int pose = 0;
            poblacion = divorciaciones.get(posicion).getLocalidad();
            divorcios = divorciaciones.get(posicion).getPoblacion();
            for (int i = 0; i < divorciaciones.size(); i++) {
                if (divorciaciones.get(i).getPoblacion() > divorcios) {
                    poblacion = divorciaciones.get(i).getLocalidad();
                    divorcios = divorciaciones.get(i).getPoblacion();
                }
            }

            //for (int i = 0; i < divorciaciones.size(); i++) {
            //  System.out.println(divorciaciones.get(i));
           // }
            System.out.println("poblacion mayor: " + poblacion.substring(3,poblacion.length()) + " " + divorcios);
            System.out.println("2019 " + sumtotal);
            System.out.println("2018 " + sumtotal2);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
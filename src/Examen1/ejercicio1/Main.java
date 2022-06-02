package Examen1.ejercicio1;

import java.io.File;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Main {

    static MySQLAccess conexion = new MySQLAccess();

    public static void main(String[] args) {
        String letra = "c";
        leerFichero("C:\\Users\\elisa\\Desktop\\HablanosDelDon.txt", letra);
    }

    public static void leerFichero(String fichero, String letra) {
        File file = new File(fichero);
        int contador = 0;
        try {
            Scanner f = new Scanner(file);
            while (f.hasNextLine()) {
                contador++;
                String linea = f.nextLine();
                String[] palabra = linea.split(" ");
                for (int i = 0; i < palabra.length; i++) {
                    palabra[i] = palabra[i]
                            .replace(",", "").replace(".", "")
                            .replace("?", "").replace("¿", "")
                            .replace(";", "");
                    if (palabra[i].substring(0, 1).equalsIgnoreCase(letra) || palabra[i]
                            .substring(palabra[i].length() - 1).equalsIgnoreCase(letra)) {
                        System.out.println("La palabra " + palabra[i] + " esta en la linea " + contador);
                        insertarDatos(letra, palabra[i], contador);
                    }
                }
            }
            f.close();
        } catch (Exception e) {
            System.out.println("El fichero " + fichero + " no ha podido ser leido con exito");
        }
    }

    private static void insertarDatos(String letra, String palabra, int contador) {
        try {

            conexion.conectarBD();
            PreparedStatement preparedStatement = conexion.getConnect()
                    .prepareStatement("insert into registros(letra, palabra, linea) values (?, ?, ?)");
            preparedStatement.setString(1, letra);
            preparedStatement.setString(2, palabra);
            preparedStatement.setInt(3, contador);
            preparedStatement.executeUpdate();
            conexion.cerrarBD();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
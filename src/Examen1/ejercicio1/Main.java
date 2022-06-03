package Examen1.ejercicio1;

import java.io.File;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 * Pre: ---
 * Post: Programa Java que sea capaz de analizar la información de un
 *      fichero de texto. El algoritmo recibe como parámetro la dirección de un fichero de texto junto a una
 *      letra del abecedario. El resultado debe mostrar por pantalla cada una de las palabras del texto que
 *      empiezan o terminan con dicha letra, junto a la línea en la que se encuentran.
 */
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
                String linea = f.nextLine();
                contador++;
                String[] palabra = linea.split(" ");
                for (int i = 0; i < palabra.length; i++) {
                    palabra[i] = palabra[i]
                            .replace(",", "").replace(".", "")
                            .replace("?", "").replace("¿", "")
                            .replace(";", "");
                    if (palabra[i].substring(0, 1).equalsIgnoreCase(letra) || palabra[i]
                            .substring(palabra[i].length() - 1).equalsIgnoreCase(letra)) {
                        insertarDatos(letra, palabra[i], contador);
                        System.out.println("La palabra " + palabra[i] + " esta en la linea " + contador);
                    }
                }
            }
            f.close();
        } catch (Exception e) {
            System.out.println("El fichero " + fichero + " no ha podido ser leido con exito");
        }
    }

    /**
     * Pre: ---
     * Post: metodo para insertar datos
     */
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
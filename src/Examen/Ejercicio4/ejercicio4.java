package Examen.Ejercicio4;

import java.util.Scanner;

/**
 * Pre: ---
 * Post: Implementa un método recursivo en Java llamado tablaMultiplicar() que muestre por
 *      pantalla la tabla de multiplicar (únicamente de los multiplicadores pares) del
 *      número solicitado (hasta multiplicar por 100).
 */
public class ejercicio4 {

    /**
     * Pre: ---
     * Post: En el metodo main primero pedimos al usuario un numero para multiplicar
     *      posteriormente damos el valor maximo de veces que deseamos multiplicar nuestro numero
     *      en este caso 100, y mandamos al metodo multiplicar las dos variables.
     */
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce la tabla que quieres mostrar: ");
        int tabla = entrada.nextInt();
        int numVeces = 100;
        System.out.println("\n\tTabla del " + tabla);
        System.out.println("****************************\n");
        multiplicar(tabla, numVeces);
    }

    /**
     * Pre: ---
     * Post: en este metodo comprobamos el numero de veces si es mayor que 1 en este caso si es 100
     *      va a comenzar a descender (99,98,97) pero antes de avanzar y mostrar por pantalla le
     *      pedimos que solo muestre los pares mediante la formula que hay en la condicion.
     */
    public static void multiplicar(int tabla, int numVeces){
        if(numVeces>1){
            multiplicar(tabla, numVeces-1);
        }
        //comprobacion de numero par si es divisible a dos y da positivo es par.
        if (numVeces%2==0)
        System.out.println("\t" + tabla + " x " + numVeces + " = " + (tabla * numVeces) );
    }
}

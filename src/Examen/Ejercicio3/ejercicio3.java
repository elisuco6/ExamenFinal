package Examen.Ejercicio3;

import java.util.Scanner;

public class ejercicio3 {

    /**
     * Pre: ---
     * Post: En el metodo main pedimos un numero al usuario y lo almacenamos en una variable
     * posteriormente se comprobara si es mayor que 0 y lo mandamos al metodo calcular
     */
    public static void main(String[] args) {
        System.out.println ("Introduzca el número para multiplicar:");
        Scanner entrada = new Scanner(System.in);
        int n = entrada.nextInt();
        if(n < 0){
            System.out.println ("Numero no valido");
            return ;
        }
        int sum = calcular(n);
        System.out.println(sum);
    }

    /**
     * Pre: ---
     * Post: Al ser recursivo va recorrer el numero tantas veces como tiene determinado
     *      en la condicion, para ir haciendo el calculo
     */
    public static int calcular(int n){
        if(n == 1){
            return 1;
        }else{
            return n * calcular(n-1);
        }
    }
}

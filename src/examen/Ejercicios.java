package examen;

/*
 * Esta clase contiene todos los ejercicios del examen de la
 * 3º evaluacion de la asignatura de Entornos de Desarrollo.
 *
 * Debes realizar todas las pruebas de jUnit necesaria para asegurar
 * el correcto funcionamiento de los 3 algoritmos. Si crees que alguno
 * de ellos tiene algun error, indicalo, marcando el test que no pasa
 * y explicando el por qué.
 *
 * Pruebas algoritmo numeroPalabras() -> 3,5 puntos
 * Pruebas algoritmo sinVocales() -> 3,5 puntos
 * Pruebas algoritmo quicksort() -> 3 puntos
 */
public class Ejercicios {

    /**
     * Pre: ---
     * Post: devuelve un entero [nPalabras] que indica
     * el numero de palabras que contiene la variable
     * [texto] pasada como parametro.
     */
    public static int numeroPalabras(String texto) {
        String[] palabras = texto.split(" ");
        int nPalabras = 0;
        for (String p : palabras) {
            nPalabras++;
        }
        return nPalabras;
    }

    /**
     * Pre: [texto] no debe contener vocales mayusculas
     * Post: devuelve un String formado unicamente por las
     * consonantes de la variable [texto] pasada como parametro.
     */
    public static String sinVocales(String texto) {
        return texto.replaceAll("[aeiu]", "");
    }

    /**
     * Pre: en la primera llamada al metodo [izq] debe tener
     * valor 0 y [der] debe tener valor [matrix.length - 1]
     * Post: divide recurvisamente el vector en partes iguales,
     * indicando un elemento de inicio [izq] y de fin [der]. Una vez
     * dividida ordena de forma optima los elementos de nuestro
     * array siguiendo el metodo quicksort.
     */
    public static void quicksort(int matrix[], int izq, int der) {
        int pivote = matrix[izq]; // tomamos primer elemento como pivote
        int i = izq;                // i realiza la búsqueda de izquierda a derecha
        int j = der;                // j realiza la búsqueda de derecha a izquierda
        int aux;
        while (i < j) {                                    // mientras no se crucen las búsquedas
            while (matrix[i] <= pivote && i < j) i++;    // busca elemento mayor que pivote
            while (matrix[j] > pivote) j--;            // busca elemento menor que pivote
            if (i < j) {                                // si no se han cruzado
                aux = matrix[i];                        // los intercambia
                matrix[i] = matrix[j];
                matrix[j] = aux;
            }
        }
        matrix[izq] = matrix[j];     // se coloca el pivote en su lugar de forma que tendremos
        matrix[j] = pivote;             // los menores a su izquierda y los mayores a su derecha
        if (izq < j - 1) quicksort(matrix, izq, j - 1);        // ordenamos subarray izquierdo
        if (j + 1 < der) quicksort(matrix, j + 1, der);        // ordenamos subarray derecho
    }
}

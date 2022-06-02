package examen;

import static org.testng.AssertJUnit.assertEquals;
public class TestEje1 {

    @org.testng.annotations.Test
    public void test1Palabras() {
        String comprobante = "hola me llamo ralph";//frase para ejecutar el test
        int resultado = Ejercicios.numeroPalabras(comprobante);//valores para realizar la operacion
        assertEquals(4, resultado);//comparacion de resultado deseado frente al obtenido
    }

    /**
     * pre: ---
     * post: Este da error debido a que cuenta el guin como palabra.
     */
    @org.testng.annotations.Test
    public void test2Palabras() {
        String comprobante = "hola, me llaman jose - manuel";//frase para ejecutar el test
        int resultado = Ejercicios.numeroPalabras(comprobante);//valores para realizar la operacion
        assertEquals(5, resultado);//comparacion de resultado deseado frente al obtenido
    }

    /**
     * Pre:---
     * Post: detecta los numero como palabra.
     */
    @org.testng.annotations.Test
    public void test3Palabras() {
        String comprobante = "soy alumno de 1 HV";//frase para ejecutar el test
        int resultado = Ejercicios.numeroPalabras(comprobante);//valores para realizar la operacion
        assertEquals(4, resultado);//comparacion de resultado deseado frente al obtenido
    }
}

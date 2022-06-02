package examen;

import static org.testng.AssertJUnit.assertEquals;

public class TestEje2 {

    /**
     * Pre: ---
     * Post: No detecta la vocal o
     */
    @org.testng.annotations.Test
    public void test1Vocales() {
        String comprobante = "hola soy elis";//frase para ejecutar el test
        int resultado = Integer.parseInt(Ejercicios.sinVocales(comprobante));//valores para realizar la operacion
        assertEquals("hl sy ls", resultado);//comparacion de resultado deseado frente al obtenido
    }

    /**
     * Pre: ---
     * Post: No detecta vocales mayusculas
     */
    @org.testng.annotations.Test
    public void test2Vocales() {
        String comprobante = "HOLA SOY ELIS";//frase para ejecutar el test
        int resultado = Integer.parseInt(Ejercicios.sinVocales(comprobante));//valores para realizar la operacion
        assertEquals("HL SY LS", resultado);//comparacion de resultado deseado frente al obtenido
    }

    /**
     * Pre: ---
     * Post: unicamente no detecta la o
     */
    @org.testng.annotations.Test
    public void test3Vocales() {
        String comprobante = "AEIOU aeiou a-e-i-o-u a.e.i.o.u";//frase para ejecutar el test
        int resultado = Integer.parseInt(Ejercicios.sinVocales(comprobante));//valores para realizar la operacion
        assertEquals("", resultado);//comparacion de resultado deseado frente al obtenido
    }
}

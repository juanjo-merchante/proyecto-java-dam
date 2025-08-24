package com.juanjomerchante.pajareria;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PajaroTest {

    @Test
    void testCreacionPajaroYGetters() {
        Pajaro pajaro = new Pajaro("Canario", "Amarillo", 25.50, 10);

        assertEquals("Canario", pajaro.getEspecie());
        assertEquals("Amarillo", pajaro.getColor());
        assertEquals(25.50, pajaro.getPrecio());
        assertEquals(10, pajaro.getCantidad());
    }

    @Test
    void testSetters() {
        Pajaro pajaro = new Pajaro("Periquito", "Azul", 15.00, 5);

        pajaro.setPrecio(18.25);
        pajaro.setCantidad(3);

        assertEquals(18.25, pajaro.getPrecio());
        assertEquals(3, pajaro.getCantidad());
    }

    @Test
    void testToString() {
        Pajaro pajaro = new Pajaro("Agapornis", "Verde", 30.00, 8);
        String resultadoToString = pajaro.toString();
        
        assertTrue(resultadoToString.contains("Agapornis"));
        assertTrue(resultadoToString.contains("30,00"));
        assertTrue(resultadoToString.contains("8"));
    }
}
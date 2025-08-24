package com.juanjomerchante.pajareria;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void testCreacionClienteYGetters() {
        // 1. PREPARACIÓN: Creamos un objeto de la clase que queremos probar.
        Cliente cliente = new Cliente("Juan Perez", "12345678A", "600112233", "juan.perez@email.com");

        // 2. COMPROBACIÓN (Assertions): Verificamos que los métodos funcionan como esperamos.
        assertEquals("Juan Perez", cliente.getNombre(), "El nombre del cliente no es el esperado.");
        assertEquals("12345678A", cliente.getDni(), "El DNI del cliente no es el esperado.");
        assertEquals("600112233", cliente.getTelefono(), "El teléfono del cliente no es el esperado.");
        assertEquals("juan.perez@email.com", cliente.getEmail(), "El email del cliente no es el esperado.");
    }

    @Test
    void testSetters() {
        // 1. PREPARACIÓN: Creamos un cliente inicial.
        Cliente cliente = new Cliente("Ana Garcia", "87654321B", "699887766", "ana.garcia@email.com");

        // 2. ACCIÓN: Usamos los setters para cambiar sus datos.
        cliente.setNombre("Ana Garcia Lopez");
        cliente.setTelefono("611223344");

        // 3. COMPROBACIÓN: Verificamos que los datos han cambiado correctamente.
        assertEquals("Ana Garcia Lopez", cliente.getNombre(), "El setter de nombre no funcionó.");
        assertEquals("611223344", cliente.getTelefono(), "El setter de teléfono no funcionó.");
    }
}
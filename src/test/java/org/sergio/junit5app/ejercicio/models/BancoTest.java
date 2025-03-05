package org.sergio.junit5app.ejercicio.models;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class BancoTest {

    @Test
    void testTransferirDineroCuentas() {
        Cuenta juan = new Cuenta("Juan Antonio", new BigDecimal("2025"));
        Cuenta andres = new Cuenta("Andres Roberto", new BigDecimal("500"));

        Banco banco = new Banco();
        banco.setNombre("Banco de espania");
        banco.transferir(andres, juan, new BigDecimal(500));
        assertEquals("2525", juan.getSaldo().toPlainString());
        assertEquals("0", andres.getSaldo().toPlainString());
    }

    @Test
    void testRelacionBancoCuentas() {
        Cuenta juan = new Cuenta("Juan Antonio", new BigDecimal("2025"));
        Cuenta andres = new Cuenta("Andres Roberto", new BigDecimal("500"));

        Banco banco = new Banco();
        banco.addCuenta(juan);
        banco.addCuenta(andres);
        banco.setNombre("Banco de espania");

        assertEquals(2, banco.getCuentas().size());
        assertEquals("Banco de espania", juan.getBanco().getNombre());
        assertEquals("Andres Roberto", banco.getCuentas().stream()
                .filter(c -> c.getPersona().equals("Andres Roberto"))
                .findFirst().
                get().getPersona());

        assertTrue(banco.getCuentas().stream()
                .anyMatch(c -> c.getPersona().equals("Juan Antonio")));

        assertFalse(banco.getCuentas().stream()
                .anyMatch(c -> c.getPersona().equals("Juan Rodrigo")));

    }
}

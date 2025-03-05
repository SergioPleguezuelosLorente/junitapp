package org.sergio.junit5app.ejercicio.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;


class CuentaTest {

    @Test
    void testNombreCuenta() {
        Cuenta cuenta = new Cuenta("Juan", new BigDecimal(1000.000));
        String esperado = "Juan";
        String real = cuenta.getPersona();

        assertNotNull(real);
        assertEquals(esperado, real);
    }

    @Test
    void saldoCuenta() {
        Cuenta cuenta = new Cuenta("Juan", new BigDecimal(1.22));
        assertNotNull(cuenta.getSaldo());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        assertEquals(1.22, cuenta.getSaldo().doubleValue());
    }


    @Test
    void testReferenciaCuenta() {
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal(123.2134));
        Cuenta cuenta2 = new Cuenta("Andres", new BigDecimal(123.2134));

        assertEquals(cuenta, cuenta2);
    }

    @Test
    void testDebitoCuenta() {
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("20.14"));
        cuenta.debito(new BigDecimal(10));

        assertNotNull(cuenta.getSaldo());
        assertEquals(10, cuenta.getSaldo().intValue());
        assertEquals("10.14", cuenta.getSaldo().toPlainString());
    }

    @Test
    void testCreditoCuenta() {
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("20.14"));
        cuenta.credito(new BigDecimal(10));

        assertNotNull(cuenta.getSaldo());
        assertEquals(30, cuenta.getSaldo().intValue());
        assertEquals("30.14", cuenta.getSaldo().toPlainString());
    }

}
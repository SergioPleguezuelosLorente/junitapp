package org.sergio.junit5app.ejercicio.exceptions;

public class DineroInsuficienteException extends RuntimeException{
    public DineroInsuficienteException(String mensaje) {
        super(mensaje);
    }
}

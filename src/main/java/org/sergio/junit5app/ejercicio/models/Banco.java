package org.sergio.junit5app.ejercicio.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Cuenta> cuentas;
    private String nombre;

    public Banco() {
        this.cuentas = new ArrayList<Cuenta>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public void addCuenta(Cuenta cuenta){
        cuentas.add(cuenta);
        cuenta.setBanco(this);
    }

    public void transferir(Cuenta origen, Cuenta destino, BigDecimal cantidad){
        origen.debito(cantidad);
        destino.credito(cantidad);
    }
}

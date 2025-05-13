package com.proyectoscg.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Contenedor {
    private String codigoContenedor;
    private int capacidadContenedor;

    public Contenedor(String codigoContenedor, int capacidad) {
        this.codigoContenedor = codigoContenedor;
        this.capacidadContenedor = capacidad;
    }

    public Contenedor(String codigo) {
        this.codigoContenedor = codigo;
    }

    @Override
    public boolean equals(Object obj) {
        Contenedor c = (Contenedor) obj;
        return this.codigoContenedor.equalsIgnoreCase(c.getCodigoContenedor());
    }
    // Getters
    public String getCodigoContenedor() {
        return codigoContenedor;
    }

    public int getCapacidadContenedor() {
        return capacidadContenedor;
    }
    
     public String[] toArrayContenedores() {
        return new String[] {codigoContenedor, String.valueOf(capacidadContenedor)};
    }







}


package com.proyectoscg.model;

import java.util.HashMap;

public class Contenedor {
    private String codigoContenedor;
    private int capacidadContenedor;
    private HashMap<Herramienta, Integer> inventario; // Cambié esto a privado para mantener el encapsulamiento

    public Contenedor(String codigoContenedor, int capacidad) {
        this.codigoContenedor = codigoContenedor;
        this.capacidadContenedor = capacidad;
        this.inventario = new HashMap<>();
    }

    public Contenedor(String codigo) {
        this.codigoContenedor = codigo;
    }

    @Override
    public boolean equals(Object obj) {
        Contenedor c = (Contenedor) obj;
        return this.codigoContenedor.equalsIgnoreCase(c.getCodigoContenedor());
    }

    public String getCodigoContenedor() {
        return codigoContenedor;
    }

    public int getCapacidad() {
        return capacidadContenedor;
    }

    // Método getter para acceder al inventario
    public HashMap<Herramienta, Integer> getInventario() {
        return inventario;
    }

    @Override
    public String toString() {
        return String.format(
                "+-------------------+---------------------------------------+\n" +
                        "| Propiedad         | Valor                                 |\n" +
                        "+-------------------+---------------------------------------+\n" +
                        "| Código Contenedor | %-35s |\n" +
                        "| Capacidad         | %-35d m²                       |\n" +
                        "+-------------------+---------------------------------------+",
                codigoContenedor, capacidadContenedor);
    }

}


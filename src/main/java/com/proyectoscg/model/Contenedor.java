package com.proyectoscg.model;

import java.util.HashMap;

public class Contenedor {
    private String codigoContenedor;
    private int capacidadContenedor;
    private int capacidadUtilizada;
    private HashMap<Herramienta, Integer> inventario; // Cambié esto a privado para mantener el encapsulamiento

    public Contenedor(String codigoContenedor, int capacidad) {
        this.codigoContenedor = codigoContenedor;
        this.capacidadContenedor = capacidad;
        this.capacidadUtilizada = 0;
        this.inventario = new HashMap<>();
    }

    public Contenedor(String codigoContenedor, int capacidadContenedor, int capacidadUtilizada) {
        this.codigoContenedor = codigoContenedor;
        this.capacidadContenedor = capacidadContenedor;
        this.capacidadUtilizada = capacidadUtilizada;
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
    // Getters
    public String getCodigoContenedor() {
        return codigoContenedor;
    }

    public int getCapacidadContenedor() {
        return capacidadContenedor;
    }

    public int getCapacidadUtilizada() {
        return capacidadUtilizada;
    }

    //Setters
    public void setCapacidadUtilizada(int capacidadUtilizada) {
        this.capacidadUtilizada = capacidadUtilizada;
    }

    // Método getter para acceder al inventario , esto hay que revisarlo
    public HashMap<Herramienta, Integer> getInventario() {
        return inventario;
    }  //método a revisar

    @Override
    public String toString() {
        return String.format(
                "+-------------------+---------------------------------------+\n" +
                        "| Propiedad                     | Valor           \n" +
                        "+-------------------------------+---------------------------+\n" +
                        "| Código Contenedor             | %-35s  \n" +
                        "| Capacidad Máxima de Unidades  | %-35s  \n" +
                        "| Unidades Guardadas            | %-35s  \n" +
                        "+-------------------------------+---------------------------+\n",
                codigoContenedor, capacidadContenedor,capacidadUtilizada);
    }

}


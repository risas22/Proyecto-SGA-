package com.proyectoscg.model;

/**
 * @author KevinColl
 * @author KristinaLlamas
 * @author VictorMedina
 *
 * */

public class Inventario {
    private Herramienta h;
    private int cantidad;

    public Inventario(Herramienta h, int cantidad) {
        this.h = h;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Herramienta getHerramienta() {
        return h;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}

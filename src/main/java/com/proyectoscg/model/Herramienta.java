package com.proyectoscg.model;

/**
 * @author KevinColl
 * @author KristinaLlamas
 * @author VictorMedina
 *
 * */
public abstract class Herramienta {
    private String nombre;
    private String codigoHerramienta;

    public Herramienta(String nombre, String codigoHerramienta) {
        this.nombre = nombre;
        this.codigoHerramienta = codigoHerramienta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigoHerramienta() {
        return codigoHerramienta;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Herramienta h = (Herramienta) obj;
        return codigoHerramienta.equalsIgnoreCase(h.getCodigoHerramienta());
    }

    @Override
    public String toString() {
        return String.format("| Nombre: %-20s | Código: %-10s |", nombre, codigoHerramienta);
    }
}

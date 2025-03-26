package com.proyectoscg.model;

public class Herramienta {
    private String nombre;
    private String codigoHerramienta;
    private boolean isSmall;

    public Herramienta(String nombre, String codigoHerramienta, boolean isSmall) {
        this.nombre = nombre;
        this.codigoHerramienta = codigoHerramienta;
        this.isSmall = isSmall;
    }

    public Herramienta(String codigoHerramienta) {
        this.codigoHerramienta = codigoHerramienta;
    }

    @Override
    public boolean equals(Object obj) {
        Herramienta h = (Herramienta) obj;
        return this.codigoHerramienta.equalsIgnoreCase(h.getCodigoHerramienta()) ;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }
    public String getCodigoHerramienta() {
        return codigoHerramienta;
    }
    public boolean isSmall() {
        return isSmall;
    }


    @Override
    public String toString() {
        return String.format(
                "+---------------------------+-------------------------------+\n" +
                        "| Propiedad         | Valor                               |\n" +
                        "+-------------------+---------------------------------------+\n" +
                        "| Nombre            | %-35s |\n" +
                        "| Código Herramienta| %-35s |\n" +
                        "| Es pequeño        | %-35s |\n" +
                        "+-------------------+---------------------------------------+\n",
                nombre, codigoHerramienta, isSmall ? "SI" : "NO");
    }
}
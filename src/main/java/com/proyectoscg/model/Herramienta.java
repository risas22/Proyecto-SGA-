package com.proyectoscg.model;

public class Herramienta {
    private String nombre;
    private String codigoHerramienta;
    private double volumen;
    private boolean isGrande;

    public Herramienta(String nombre, String codigoHerramienta, double volumen, boolean isGrande) {
        this.nombre = nombre;
        this.codigoHerramienta = codigoHerramienta;
        this.volumen = volumen;
        this.isGrande = isGrande;
    }

    public Herramienta(String codigoHerramienta) {
        this.codigoHerramienta = codigoHerramienta;
    }

    @Override
    public boolean equals(Object obj) {
        Herramienta h = (Herramienta) obj;
        return this.codigoHerramienta.equalsIgnoreCase(h.getCodigoHerramienta()) ;
    }


    public String getNombre() {
        return nombre;
    }
    public String getCodigoHerramienta() {
        return codigoHerramienta;
    }



    public double getVolumen() {
        return volumen;
   }

    public boolean isGrande() {
        return isGrande;
    }


    @Override
    public String toString() {
        return String.format(
                "+-------------------+---------------------------------------+\n" +
                        "| Propiedad         | Valor                                 |\n" +
                        "+-------------------+---------------------------------------+\n" +
                        "| Nombre            | %-35s |\n" +
                        "| Código Herramienta| %-35s |\n" +
                        "| Volumen (cm)      | %-35s |\n" +
                        "| Es grande         | %-35s |\n" +
                        "+-------------------+---------------------------------------+",
                nombre, codigoHerramienta, volumen, isGrande ? "SI" : "NO");
    }
}

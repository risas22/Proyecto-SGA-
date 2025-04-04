package com.proyectoscg.model;

public class Herramienta {
    private String nombreHerramienta;
    private String codigoHerramienta;
    private boolean isSmall;

    public Herramienta(String nombreHerramienta, String codigoHerramienta, boolean isSmall) {
        this.nombreHerramienta = nombreHerramienta;
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
    public String getNombreHerramienta() {
        return nombreHerramienta;
    }
    public String getCodigoHerramienta() {
        return codigoHerramienta;
    }
    public boolean isSmall() {
        return isSmall;
    }

    public String[] toArrayHerramientas(){
        return new String[]{codigoHerramienta,nombreHerramienta,Boolean.toString(isSmall)};
    }
}

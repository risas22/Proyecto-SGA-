package com.proyectoscg.model;

public class HerramientaP extends Herramienta {
    private boolean isSmall;

    public HerramientaP(String nombre, String codigoHerramienta) {
        super(nombre, codigoHerramienta);
    }

    public boolean isSmall() {
        return isSmall;
    }

    // Setter público para isSmall
    public void setSmall(boolean isSmall) {
        this.isSmall = isSmall;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        HerramientaP that = (HerramientaP) obj;
        return getCodigoHerramienta().equals(that.getCodigoHerramienta());
    }
}


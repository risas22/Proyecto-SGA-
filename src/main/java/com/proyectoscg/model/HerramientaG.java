package com.proyectoscg.model;

public class HerramientaG extends Herramienta {

    public HerramientaG(String nombre, String codigoHerramienta) {
        super(nombre, codigoHerramienta);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        HerramientaG that = (HerramientaG) obj;
        return getCodigoHerramienta().equals(that.getCodigoHerramienta());
    }
}


package com.proyectoscg.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Contenedor {
    private String codigoContenedor;
    private int capacidadContenedor;
    private HashMap<Herramienta,Integer> inventario; // Cambié esto a privado para mantener el encapsulamiento

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
    // Getters
    public String getCodigoContenedor() {
        return codigoContenedor;
    }

    public int getCapacidadContenedor() {
        return capacidadContenedor;
    }



    public int capacidadRestante(){
        int disponible = capacidadContenedor;
        for (Herramienta h : inventario.keySet()) {
            disponible -= inventario.get(h); //
        }
        return disponible;
    }

    public void anadirHerramienta (Herramienta h,int cantidad){
             if (inventario.containsKey(h)){
                 inventario.put(h, inventario.get(h) + cantidad);
             }
             else{
                 inventario.put(h, cantidad);
             }

    }


}


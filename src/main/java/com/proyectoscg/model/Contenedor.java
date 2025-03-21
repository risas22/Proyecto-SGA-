package com.proyectoscg.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author KevinColl
 * @author KristinaLlamas
 * @author VictorMedina
 *
 * */

public class Contenedor {
    private String codigoContenedor;
    private int capacidadContenedor;
    private HashMap<Herramienta, Integer> inventario;

    public Contenedor(String codigoContenedor, int capacidad) {
        this.codigoContenedor = codigoContenedor;
        this.capacidadContenedor = capacidad;
        this.inventario = new HashMap<>();
    }

    public HashMap<Herramienta, Integer> getInventario() {
        return inventario;
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

    public int capacidadRestante() {
        int ocupado = 0;
        for (Integer cantidad : inventario.values()) {
            ocupado += cantidad;
        }
        return capacidadContenedor - ocupado;
    }

    public void anadirHerramienta(Herramienta h, int cantidad) {
        if (inventario.containsKey(h)) {
            int cantidadActual = inventario.get(h);
            inventario.put(h, cantidadActual + cantidad);
        } else {
            inventario.put(h, cantidad);
        }
    }



    @Override
    public String toString() {
        return String.format(
                "+-------------------+---------------------------------------+\n" +
                        "| Propiedad                     | Valor           \n" +
                        "+-------------------------------+---------------------------+\n" +
                        "| Código Contenedor             | %-35s  \n" +
                        "| Capacidad Máxima de Unidades  | %-35s  \n" +
                        "| Capacidad Disponible          | %-35s  \n" +
                        "+-------------------------------+---------------------------+\n",
                codigoContenedor, capacidadContenedor, capacidadRestante());
    }

    public String mostrarInventario() {
        if (inventario.isEmpty()) {
            return "*** ESTE CONTENEDOR NO TIENE INVENTARIO ***\n";
        }
        StringBuilder info = new StringBuilder();
        info.append("*** INVENTARIO DEL CONTENEDOR ").append(codigoContenedor).append(" ***\n");
        info.append("+----------------------+----------+\n");
        info.append("| Herramienta          | Cantidad |\n");
        info.append("+----------------------+----------+\n");
        inventario.forEach((herramienta, cantidad) ->
                info.append(String.format("| %-20s | %-8d |\n", herramienta.getNombre(), cantidad))
        );
        info.append("+----------------------+----------+\n");
        return info.toString();
    }



}


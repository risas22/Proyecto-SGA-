package com.proyectoscg.model;

import java.util.ArrayList;

public class Contenedor {
    private String codigoContenedor;
    private int capacidadContenedor;
    private ArrayList<Inventario> inventario; // Cambié esto a privado para mantener el encapsulamiento

    public Contenedor(String codigoContenedor, int capacidad) {
        this.codigoContenedor = codigoContenedor;
        this.capacidadContenedor = capacidad;
        this.inventario = new ArrayList<>();
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
        for (Inventario i : inventario) {
            disponible -= i.getCantidad();
        }
        return disponible;
    }

    public void anadirHerramienta (Herramienta h,int cantidad){       //método para añadir electros a la lista, lo tenemos que llamar aquí para utilizarlo en el main
        Inventario i = new Inventario(h, cantidad);
        inventario.add(i);                                      // ya que en el main solo existe la lista de de contenedores y herramientas
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

    public String mostrarInventario(){
        System.out.println("*** INVENTARIO DEL CONTENEDOR " + codigoContenedor + " ***");
        if (inventario.isEmpty()) {
            return "*** ESTE CONTENEDOR NO TIENE INVENTARIO ***\n";

        }
        String info = "";
        for (Inventario i : inventario) {
            info += String.format(
                    "+-------------------+---------------------------------------+\n" +
                            "| Propiedad        | Valor           \n" +
                            "+-------------------------------+---------------------------+\n" +
                            "| Herramienta      | %-35s  \n" +
                            "| Cantidad         | %-35s  \n" +
                            "+-------------------------------+---------------------------+\n",
                    i.getHerramienta().getNombre(), i.getCantidad());
        }
        return info;
    }



}

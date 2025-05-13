package com.proyectoscg.model;

import com.proyectoscg.persistencia.LaHerratecaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Herramienta {
    private String nombreHerramienta;
    private String codigoHerramienta;
    private boolean isSmall;
    private LaHerratecaDAO dao;
    private String cantidadHerramientas;
    private List<Contenedor> contenedoresAsociados = new ArrayList<>();

    public Herramienta(String nombreHerramienta, String codigoHerramienta, boolean isSmall) {
        this.nombreHerramienta = nombreHerramienta;
        this.codigoHerramienta = codigoHerramienta;
        this.isSmall = isSmall;
        dao = new LaHerratecaDAO();
    }
    
    public Herramienta(String nombreHerramienta, String codigoHerramienta, String cantidadHerramientas ) {
        this.nombreHerramienta = nombreHerramienta;
        this.codigoHerramienta = codigoHerramienta;
        this.cantidadHerramientas = cantidadHerramientas;
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
    
    public void addContenedor(Contenedor c) {
        contenedoresAsociados.add(c);
    }

    public List<Contenedor> getContenedoresAsociados() {
        return contenedoresAsociados;
    }

    public void setContenedoresAsociados(List<Contenedor> contenedoresAsociados) {
        this.contenedoresAsociados = contenedoresAsociados;
    }
    


    public String[] toArrayHerramientas(){
        String peque = "";
        if (isSmall) {
            peque = "Contenedor";
        } else {
            peque = "Estantería";
        }
        return new String[]{codigoHerramienta,nombreHerramienta,peque};
    }
    
    public String[] toArrayHerramientasContenedores(){
        return new String[]{codigoHerramienta,nombreHerramienta,cantidadHerramientas};
    }
    

}

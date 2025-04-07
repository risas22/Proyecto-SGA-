/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoscg.controlador;

import com.proyectoscg.model.Contenedor;
import com.proyectoscg.model.Herramienta;
import java.util.HashMap;

/**
 *
 * @author kevin
 */
public class Controlador {

    private HashMap<String, Herramienta> herramientas;
    private HashMap<String, Contenedor> contenedores;
    private static Controlador controlador;

    private Controlador() {
        herramientas = new HashMap<>();
        contenedores = new HashMap<>();
    }

    public static Controlador getInstance() {
        if (controlador == null) {
            controlador = new Controlador();
        }
        return controlador;
    }

    public boolean comprobarCodigoFormatoHerramienta(String codigoHerramienta) throws Excepciones {
        if (codigoHerramienta == null || !codigoHerramienta.matches("^[A-Z]{3}-[A-Z]{2}-[0-9]{3}$")) {
            throw new Excepciones(8);
        }
        return codigoHerramienta.matches("^[A-Z]{3}-[A-Z]{2}-[0-9]{3}$");
    }

    public boolean comprobarCodigoFormatoContenedor(String codigoContenedor) throws Excepciones {
        if (codigoContenedor == null || !codigoContenedor.matches("^[A-Z]{3}-[A-Z]{1}[0-9]{1}-[0-9]{3}$")) {
            throw new Excepciones(9);
        }
        return codigoContenedor.matches("^[A-Z]{3}-[A-Z]{1}[0-9]{1}-[0-9]{3}$");
    }

    public void addHerramientaIfNoExist(String codigoHerramienta, Herramienta h) throws Excepciones {
        if (herramientas.containsKey(codigoHerramienta.toUpperCase())) {
            throw new Excepciones(1);
        } else {
            herramientas.put(codigoHerramienta.toUpperCase(), h);
        }
    }
    
    public boolean isEmptyHerramientas(){
       return (herramientas.isEmpty());
    }
    
    public boolean isEmptyContenedores(){
       return (contenedores.isEmpty());
    }

    public HashMap<String, Herramienta> getHerramientas() {
        return herramientas;
    }
        
    

}

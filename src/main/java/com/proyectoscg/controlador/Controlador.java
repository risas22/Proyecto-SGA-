/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoscg.controlador;

import com.proyectoscg.model.Contenedor;
import com.proyectoscg.model.Herramienta;
import com.proyectoscg.persistencia.LaHerratecaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author kevin
 */
public class Controlador {

   
    private static Controlador controlador;
    private LaHerratecaDAO dao;

    private Controlador() {
        dao = new LaHerratecaDAO();
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
    
    public void addHerramienta(Herramienta h) throws  Excepciones, SQLException {
        if (dao.existHerramienta(h)) {
            throw new Excepciones(1);
        }
        dao.insertHerramienta(h);
    }
    
    public void addContenedor(Contenedor c) throws  Excepciones, SQLException {
        if (dao.existContenedor(c)) {
            throw new Excepciones(2);
        }
        dao.insertContenedor(c);
    }
    
    public void addInventario(Herramienta h , Contenedor c, int unidadesAdd) throws SQLException{
//        if (dao.existHerramienta(h)){  //aquí deberíamos hacer un update porque no se puede repetir el mismo código dentro del inventario
//            dao.updateInventario(h , c , unidadesAdd);
//        }
//        if{
            dao.insertInventario(h , c , unidadesAdd);
//        }
        
    }
    
    public boolean isCabenUnidades (Contenedor c , int unidadesAdd) throws SQLException, Excepciones{
        if (dao.sumaUnidadesContenedor(c) + unidadesAdd > c.getCapacidadContenedor()){
            throw new Excepciones(5);     
        }
        return true;
    }
    
//    public int capacidadDisponible (Contenedor c) throws SQLException{
//        return (c.getCapacidadContenedor() - dao.sumaUnidadesContenedor(c) );
//    } 
//    
    public List<Herramienta> getAllHerramientas() throws SQLException {
        return dao.selectAllHerramientas();
    }
    
     public List<Contenedor> getAllContenedores() throws SQLException {
        return dao.selectAllContenedores();
    }
    
    
        
    

}

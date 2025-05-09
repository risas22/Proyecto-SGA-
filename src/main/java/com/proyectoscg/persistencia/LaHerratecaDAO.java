/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoscg.persistencia;

import com.proyectoscg.model.Contenedor;
import com.proyectoscg.model.Herramienta;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class LaHerratecaDAO {
     public void insertHerramienta(Herramienta h) throws SQLException {
        Connection c = conectar();
        PreparedStatement ps = c.prepareStatement("insert into herramienta values (?, ?, ?);");
        ps.setString(1, h.getNombreHerramienta());
        ps.setString(2,h.getCodigoHerramienta());
        ps.setBoolean(3, h.isSmall());
        ps.executeUpdate();
        ps.close();
        desconectar(c);
    }
   
    public boolean existHerramienta(Herramienta h) throws SQLException {
        Connection c = conectar();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("select * from herramienta where codigoherramienta = '" + h.getCodigoHerramienta() +"';");
        boolean existe = rs.next();
        rs.close();
        st.close();
        desconectar(c);
        return existe;
    }
    
    public void insertContenedor(Contenedor c) throws SQLException {
        Connection cn = conectar();
        PreparedStatement ps = cn.prepareStatement("insert into contenedor values (?, ?);");
        ps.setString(1,c.getCodigoContenedor());
        ps.setInt(2, c.getCapacidadContenedor());
        ps.executeUpdate();
        ps.close();
        desconectar(cn);
    }
   
    public boolean existContenedor(Contenedor c) throws SQLException {
        Connection cn = conectar();
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("select * from contenedor where codigocontenedor = '" + c.getCodigoContenedor() + "';");
        boolean existe = rs.next();
        rs.close();
        st.close();
        desconectar(cn);
        return existe;
    }
    
    public void insertInventario(Herramienta h,Contenedor c, int unidadesAdd) throws SQLException {
        Connection cn = conectar();
        PreparedStatement ps = cn.prepareStatement("insert into inventario values (?, ?, ?);");
        ps.setString(1,h.getCodigoHerramienta());
        ps.setString(2,c.getCodigoContenedor());
        ps.setInt(3, unidadesAdd);
        ps.executeUpdate();
        ps.close();
        desconectar(cn);
    }
    
    public void updateInventario(Herramienta h,Contenedor c, int unidadesAdd){
        
    }
    
    public int sumaUnidadesContenedor(Contenedor c) throws SQLException{
        Connection cn = conectar();
        Statement st = cn.createStatement();
        int sumaUnidadesTotal = 0;
        ResultSet rs = st.executeQuery("select SUM(cantidaddeherramientas) as sumaTotal from inventario where codigocontenedor = '" + c.getCodigoContenedor() + "';");
        if (rs.next()) {
            sumaUnidadesTotal = rs.getInt("sumaTotal");
        }
        rs.close();
        st.close();
        desconectar(cn);
        return sumaUnidadesTotal;
        }
    
    public List<Herramienta> selectAllHerramientas() throws SQLException {
        List<Herramienta> herramientas = new ArrayList<>();
        Connection cj = conectar();
        Statement st = cj.createStatement();
        ResultSet rs = st.executeQuery("select * from herramienta;");
        while (rs.next()) {
            String nombreHerramienta = rs.getString("nombreherramienta");
            String codigoHerramienta = rs.getString("codigoherramienta");
            Boolean isSmall = rs.getBoolean("issmall");
            Herramienta newHerramienta = new Herramienta(nombreHerramienta,codigoHerramienta, isSmall);
            herramientas.add(newHerramienta);
        }
        rs.close();
        st.close();
        desconectar(cj);
        return herramientas;
    }
    
    public List<Contenedor> selectAllContenedores() throws SQLException {
        List<Contenedor> contenedores = new ArrayList<>();
        Connection cj = conectar();
        Statement st = cj.createStatement();
        ResultSet rs = st.executeQuery("select * from contenedor;");
        while (rs.next()) {
            String codigoContenedor = rs.getString("codigocontenedor");
            Integer capacidadContenedor = rs.getInt("capacidadcontenedor");
            Contenedor newContenedor = new Contenedor(codigoContenedor,capacidadContenedor);
            contenedores.add(newContenedor);
        }
        rs.close();
        st.close();
        desconectar(cj);
        return contenedores;
    }
    
   
   
     private Connection conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/laherrateca";
        String user = "root";
        String pass = "Asdqwe123";
        Connection c = DriverManager.getConnection(url, user, pass);
        return c;
    }
   
    private void desconectar(Connection c) throws SQLException {
        c.close();
    }
}


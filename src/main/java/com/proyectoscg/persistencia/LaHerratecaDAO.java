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
    
    public void updateInventario(Herramienta h,Contenedor c, int unidadesAdd) throws SQLException{
        Connection cn = conectar();
        Statement st = cn.createStatement();
        st.executeUpdate("update inventario set cantidaddeherramientas = cantidaddeherramientas + " + unidadesAdd + " where codigocontenedor = '" + c.getCodigoContenedor() + "' and codigoherramienta = '" + h.getCodigoHerramienta() + "' ;");
        st.close();
        desconectar(cn);
    }
    
    public boolean comprobarHerramientaContenedor(Herramienta h , Contenedor c) throws SQLException{
        Connection cn = conectar();
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("select * from inventario where codigocontenedor = '" + c.getCodigoContenedor() + "' and codigoherramienta = '" + h.getCodigoHerramienta() + "';");
        boolean existe = rs.next();
        rs.close();
        st.close();
        desconectar(cn);
        return existe;
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
    
    public List<Herramienta> selectAllHerramientasSmall() throws SQLException {
        List<Herramienta> herramientas = new ArrayList<>();
        Connection cj = conectar();
        Statement st = cj.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM herramienta;");

        while (rs.next()) {
            String nombreHerramienta = rs.getString("nombreherramienta");
            String codigoHerramienta = rs.getString("codigoherramienta");
            boolean isSmall = rs.getBoolean("issmall");

            Herramienta nueva = new Herramienta(nombreHerramienta, codigoHerramienta, isSmall);

            if (isSmall) {
                PreparedStatement ps = cj.prepareStatement(
                    "SELECT c.* FROM inventario i JOIN contenedor c ON i.codigocontenedor = c.codigocontenedor WHERE i.codigoherramienta = ?"
                );
                ps.setString(1, codigoHerramienta);
                ResultSet rsCont = ps.executeQuery();

                while (rsCont.next()) {
                    String codCont = rsCont.getString("codigocontenedor");
                    int capacidad = rsCont.getInt("capacidadcontenedor");
                    Contenedor c = new Contenedor(codCont, capacidad);
                    nueva.addContenedor(c);
                }

                rsCont.close();
                ps.close();
            }

            herramientas.add(nueva);
        }

        rs.close();
        st.close();
        desconectar(cj);
        return herramientas;
    }
    
    public List<Herramienta> obtenerPorContenedor(Contenedor contenedor) throws SQLException {
        List<Herramienta> herramientas = new ArrayList<>();
        Connection cj = conectar();
        String sql = "SELECT h.codigoherramienta, h.nombreherramienta, i.cantidaddeherramientas " +
                     "FROM herramienta h " +
                     "JOIN inventario i ON h.codigoherramienta = i.codigoherramienta " +
                     "WHERE i.codigocontenedor = ?";

        PreparedStatement ps = cj.prepareStatement(sql);
        ps.setString(1, contenedor.getCodigoContenedor());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String nombreHerramienta = rs.getString("nombreherramienta");
            String codigoHerramienta = rs.getString("codigoherramienta");
            String cantidadHerramientas = rs.getString("cantidaddeherramientas");
            Herramienta herramienta = new Herramienta(nombreHerramienta, codigoHerramienta, cantidadHerramientas);
            herramientas.add(herramienta);
        }

        rs.close();
        ps.close();
        desconectar(cj);
        return herramientas;
    }
    
     public void removeHerramienta(String codigoH, Herramienta h) throws SQLException {
        Connection cn = conectar();
        Statement st = cn.createStatement();
        removeContenedorInInventario(codigoH);
        removeHerramientaInInventario(codigoH, h);
        st.executeUpdate("DELETE FROM herramienta WHERE codigoherramienta = '" + codigoH + "';");
        st.close();
        desconectar(cn);
    }

    private void removeHerramientaInInventario(String codigoH, Herramienta h) throws SQLException {
        Connection cn = conectar();
        Statement st = cn.createStatement();
        removeContenedorInInventario(codigoH);
        st.executeUpdate("DELETE FROM inventario WHERE codigoherramienta = '" + codigoH + "';");
        st.close();
        desconectar(cn);
    }
    
     public void removeContenedor(String codigoC, Contenedor c) throws SQLException {
        Connection cn = conectar();
        Statement st = cn.createStatement();
        removeContenedorInInventario(codigoC);
        st.executeUpdate("DELETE FROM contenedor WHERE codigocontenedor = '" + codigoC + "';");
        st.close();
        desconectar(cn);
    }

    private void removeContenedorInInventario(String codigoC) throws SQLException {
        Connection cn = conectar();
        Statement st = cn.createStatement();
        st.executeUpdate("DELETE FROM inventario WHERE codigoContenedor = '" + codigoC + "';");
        st.close();
        desconectar(cn);
    }


    
   
   
     private Connection conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/laherrateca";
        String user = "root";
        String pass = "";
        Connection c = DriverManager.getConnection(url, user, pass);
        return c;
    }
   
    private void desconectar(Connection c) throws SQLException {
        c.close();
    }
}


package com.proyectoscg.view;

import com.proyectoscg.controlador.Controlador;
import com.proyectoscg.controlador.Excepciones;
import com.proyectoscg.model.Herramienta;
import java.sql.SQLException;

public class Main {

    private static JFramePrincipal view;

    public static void main(String[] args) {
        view = new JFramePrincipal();
        view.setVisible(true);
    }
}
          
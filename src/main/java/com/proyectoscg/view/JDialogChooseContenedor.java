/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.proyectoscg.view;

import com.proyectoscg.controlador.Controlador;
import com.proyectoscg.controlador.Excepciones;
import com.proyectoscg.model.Contenedor;
import com.proyectoscg.model.Herramienta;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author krisl
 */
public class JDialogChooseContenedor extends javax.swing.JDialog {

    private Controlador controlador;
    private List<Contenedor> contenedores;


    public JDialogChooseContenedor(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        controlador = Controlador.getInstance();
        initComponents();

        contenedores = controlador.getAllContenedores();
        jComboBoxMostrarContenedores.removeAllItems();
        for (Contenedor c : contenedores) {
            jComboBoxMostrarContenedores.addItem(c.getCodigoContenedor());
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBoxMostrarContenedores = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        jLabel1.setText("***SELECCIONE EL CONTENEDOR QUE DESEA CONSULTAR***");

        jComboBoxMostrarContenedores.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxMostrarContenedores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jComboBoxMostrarContenedores, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(254, 254, 254))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(306, 306, 306))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxMostrarContenedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            int indexContenedor = jComboBoxMostrarContenedores.getSelectedIndex();
            if (indexContenedor < 0 || indexContenedor >= contenedores.size()) {
                JOptionPane.showMessageDialog(this, "Seleccione un contenedor", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
            
            Contenedor contenedorSeleccionado = contenedores.get(indexContenedor);
            List<Herramienta> herramientasContenedor = controlador.getHerramientasPorContenedor(contenedorSeleccionado);
            
            if (herramientasContenedor.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Este contenedor no tiene herramientas asociadas", "Sin herramientas", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JDialogTableInventarioContenedor dialog = new JDialogTableInventarioContenedor(null, true, herramientasContenedor);
                dialog.setVisible(true);  
            }
            
        } catch (SQLException ex) {
              System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxMostrarContenedores;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}

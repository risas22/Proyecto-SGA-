/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.proyectoscg.view;

import com.proyectoscg.model.Herramienta;
import com.proyectoscg.controlador.Controlador;
import com.proyectoscg.controlador.Excepciones;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class JDialogBorrarHerramienta extends javax.swing.JDialog {

    private Controlador controlador;
    private JFramePrincipal jFramePrincipal;
    private List <Herramienta> herramientas;

    public JDialogBorrarHerramienta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {
            initComponents();
            jFramePrincipal = (JFramePrincipal) parent;
            controlador = Controlador.getInstance();
            herramientas = controlador.getAllHerramientas();
            jButtonAceptarBorrarHerramienta.setEnabled(false);
            
            for (Herramienta h : herramientas){
                jComboBoxMostrarHerramientas.addItem(h.getCodigoHerramienta() + " - " + h.getNombreHerramienta());
            }
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void comprobarjButtonAceptarBorrarHerramienta() {
        if (jComboBoxMostrarHerramientas.getSelectedIndex() > 0) {
            jButtonAceptarBorrarHerramienta.setEnabled(true);
        } else {
            jButtonAceptarBorrarHerramienta.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButtonAceptarBorrarHerramienta = new javax.swing.JButton();
        jButtonCancelarBorrarHerramienta = new javax.swing.JButton();
        jComboBoxMostrarHerramientas = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Añadir Herramienta");

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("***APARTADO DE BORRAR HERRAMIENTA***");

        jLabel2.setText("Código de la herramienta a borrar :");

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jButtonAceptarBorrarHerramienta.setText("Aceptar");
        jButtonAceptarBorrarHerramienta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarBorrarHerramientaActionPerformed(evt);
            }
        });

        jButtonCancelarBorrarHerramienta.setText("Cerrar");
        jButtonCancelarBorrarHerramienta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarBorrarHerramientaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jButtonAceptarBorrarHerramienta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCancelarBorrarHerramienta)
                .addGap(95, 95, 95))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelarBorrarHerramienta)
                    .addComponent(jButtonAceptarBorrarHerramienta))
                .addGap(26, 26, 26))
        );

        jComboBoxMostrarHerramientas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el código de la Herramienta" }));
        jComboBoxMostrarHerramientas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMostrarHerramientasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jComboBoxMostrarHerramientas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 70, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxMostrarHerramientas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarBorrarHerramientaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarBorrarHerramientaActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarBorrarHerramientaActionPerformed

    private void jButtonAceptarBorrarHerramientaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarBorrarHerramientaActionPerformed

        try {
            int indexHerramientas = jComboBoxMostrarHerramientas.getSelectedIndex()-1;
            Herramienta herramientaSeleccionada = herramientas.get(indexHerramientas);
            controlador.removeHerramienta(herramientaSeleccionada.getCodigoHerramienta(), herramientaSeleccionada);
            JOptionPane.showMessageDialog(this, "Herramienta eliminada con éxito", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        
        }
    }//GEN-LAST:event_jButtonAceptarBorrarHerramientaActionPerformed

    private void jComboBoxMostrarHerramientasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMostrarHerramientasActionPerformed
        comprobarjButtonAceptarBorrarHerramienta();
    }//GEN-LAST:event_jComboBoxMostrarHerramientasActionPerformed
    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButtonAceptarBorrarHerramienta;
    private javax.swing.JButton jButtonCancelarBorrarHerramienta;
    private javax.swing.JComboBox<String> jComboBoxMostrarHerramientas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

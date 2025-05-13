/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.proyectoscg.view;

import com.proyectoscg.model.Herramienta;
import com.proyectoscg.controlador.Controlador;
import com.proyectoscg.controlador.Excepciones;
import com.proyectoscg.model.Contenedor;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class JDialogBorrarContenedor extends javax.swing.JDialog {

    private Controlador controlador;
    private JFramePrincipal jFramePrincipal;
    private List<Contenedor> contenedores;

    public JDialogBorrarContenedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {
            initComponents();
            jFramePrincipal = (JFramePrincipal) parent;
            controlador = Controlador.getInstance();
            contenedores = controlador.getAllContenedores();
            jButtonAceptarBorrarContenedor.setEnabled(false);
        
            for (Contenedor c : contenedores){
                    jComboBoxMostrarContenedores.addItem(c.getCodigoContenedor());
                }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void comprobarjButtonAceptarBorrarContenedor() {
        if (jComboBoxMostrarContenedores.getSelectedIndex() > 0) {
            jButtonAceptarBorrarContenedor.setEnabled(true);
        } else {
            jButtonAceptarBorrarContenedor.setEnabled(false);
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
        jButtonAceptarBorrarContenedor = new javax.swing.JButton();
        jButtonCancelarBorrarContenedor = new javax.swing.JButton();
        jComboBoxMostrarContenedores = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Añadir Herramienta");

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("***APARTADO DE BORRAR CONTENEDOR***");

        jLabel2.setText("Código del contenedor a borrar :");

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jButtonAceptarBorrarContenedor.setText("Aceptar");
        jButtonAceptarBorrarContenedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarBorrarContenedorActionPerformed(evt);
            }
        });

        jButtonCancelarBorrarContenedor.setText("Cerrar");
        jButtonCancelarBorrarContenedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarBorrarContenedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jButtonAceptarBorrarContenedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCancelarBorrarContenedor)
                .addGap(95, 95, 95))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelarBorrarContenedor)
                    .addComponent(jButtonAceptarBorrarContenedor))
                .addGap(26, 26, 26))
        );

        jComboBoxMostrarContenedores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el código del Contenedor" }));
        jComboBoxMostrarContenedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMostrarContenedoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBoxMostrarContenedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
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
                    .addComponent(jComboBoxMostrarContenedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarBorrarContenedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarBorrarContenedorActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarBorrarContenedorActionPerformed

    private void jButtonAceptarBorrarContenedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarBorrarContenedorActionPerformed
        try {
            int indexContenedor = jComboBoxMostrarContenedores.getSelectedIndex()-1;
            Contenedor contenedorSeleccionado = contenedores.get(indexContenedor);
            controlador.removeContenedor(contenedorSeleccionado.getCodigoContenedor(), contenedorSeleccionado);
            JOptionPane.showMessageDialog(this, "Contenedor eliminado con éxito", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
            dispose();
                    
         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        
         }
        
    }//GEN-LAST:event_jButtonAceptarBorrarContenedorActionPerformed

    private void jComboBoxMostrarContenedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMostrarContenedoresActionPerformed
        comprobarjButtonAceptarBorrarContenedor();
    }//GEN-LAST:event_jComboBoxMostrarContenedoresActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButtonAceptarBorrarContenedor;
    private javax.swing.JButton jButtonCancelarBorrarContenedor;
    private javax.swing.JComboBox<String> jComboBoxMostrarContenedores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

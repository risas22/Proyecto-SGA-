/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.proyectoscg.view;

import controlador.Excepciones;
import com.proyectoscg.model.Herramienta;
import controlador.Controlador;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class JDialogAddHerramienta extends javax.swing.JDialog {
    private Controlador controlador;
    public JFramePrincipal jFramePrincipal;
    public HashMap<String,Herramienta>herramientas;
    
    
    public JDialogAddHerramienta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jFramePrincipal = (JFramePrincipal) parent;
        controlador = Controlador.getInstance();
        herramientas = new HashMap<>();
        jButtonAceptarCrearHerramienta.setEnabled(false);
    }
    
    public void comprobarjButtonAceptarCrearHerramienta(){
    if(jTextFieldCodigoHerramienta.getText().length()>8 && jTextFieldNombreHerramienta.getText().length()>1 && jComboBoxBooleanSmall.getSelectedIndex()>0){
       jButtonAceptarCrearHerramienta.setEnabled(true); 
    }
    else{
        jButtonAceptarCrearHerramienta.setEnabled(false);
    }
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCodigoHerramienta = new javax.swing.JTextField();
        jTextFieldNombreHerramienta = new javax.swing.JTextField();
        jComboBoxBooleanSmall = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jButtonAceptarCrearHerramienta = new javax.swing.JButton();
        jButtonCancelarCrearHerramienta = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Añadir Herramienta");

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel1.setText("***APARTADO DE CREAR HERRAMIENTAS***");

        jLabel2.setText("Código para la nueva herramienta:");

        jLabel3.setText("Nombre de la nueva herramienta:");

        jTextFieldCodigoHerramienta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodigoHerramientaActionPerformed(evt);
            }
        });
        jTextFieldCodigoHerramienta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCodigoHerramientaKeyTyped(evt);
            }
        });

        jTextFieldNombreHerramienta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNombreHerramientaKeyTyped(evt);
            }
        });

        jComboBoxBooleanSmall.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el tamaño de la herramienta", "herramienta pequeña", "herramienta grande" }));
        jComboBoxBooleanSmall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxBooleanSmallActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jButtonAceptarCrearHerramienta.setText("Aceptar");
        jButtonAceptarCrearHerramienta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarCrearHerramientaActionPerformed(evt);
            }
        });

        jButtonCancelarCrearHerramienta.setText("Cerrar");
        jButtonCancelarCrearHerramienta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarCrearHerramientaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jButtonAceptarCrearHerramienta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 292, Short.MAX_VALUE)
                .addComponent(jButtonCancelarCrearHerramienta)
                .addGap(95, 95, 95))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelarCrearHerramienta)
                    .addComponent(jButtonAceptarCrearHerramienta))
                .addGap(26, 26, 26))
        );

        jLabel4.setText("Formato Adecuado: AAA-AA-000");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(23, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldNombreHerramienta, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                                    .addComponent(jTextFieldCodigoHerramienta))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jComboBoxBooleanSmall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(204, 204, 204))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldCodigoHerramienta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNombreHerramienta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(34, 34, 34)
                .addComponent(jComboBoxBooleanSmall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxBooleanSmallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxBooleanSmallActionPerformed
        comprobarjButtonAceptarCrearHerramienta();
    }//GEN-LAST:event_jComboBoxBooleanSmallActionPerformed

    private void jButtonCancelarCrearHerramientaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarCrearHerramientaActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarCrearHerramientaActionPerformed

    private void jTextFieldCodigoHerramientaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigoHerramientaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodigoHerramientaActionPerformed

    private void jTextFieldCodigoHerramientaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodigoHerramientaKeyTyped
        comprobarjButtonAceptarCrearHerramienta(); 
    }//GEN-LAST:event_jTextFieldCodigoHerramientaKeyTyped

    private void jTextFieldNombreHerramientaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNombreHerramientaKeyTyped
        comprobarjButtonAceptarCrearHerramienta();
    }//GEN-LAST:event_jTextFieldNombreHerramientaKeyTyped

    private void jButtonAceptarCrearHerramientaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarCrearHerramientaActionPerformed
        boolean isSmall;
        String codigoHerramienta = (String) jTextFieldCodigoHerramienta.getText();
        String nombreHerramienta = jTextFieldNombreHerramienta.getText();
        String herramientaisSmall = jComboBoxBooleanSmall.getSelectedItem().toString();
        if (herramientaisSmall.equalsIgnoreCase("herramienta pequeña")){
             isSmall = (true);
        }
        else {
             isSmall = (false);
        }
        if (controlador.comprobarCodigoFormatoHerramienta(codigoHerramienta)){
            Herramienta newHerramienta = new Herramienta(codigoHerramienta,nombreHerramienta,isSmall);
            try {
                controlador.addHerramientaIfNoExist(codigoHerramienta, newHerramienta);
                JOptionPane.showMessageDialog(this, "Herramienta creada con éxito", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
                cleanField();
            } 
            catch (Excepciones ex) {
                JOptionPane.showMessageDialog(this, ex.getMensajeError(1), "ERROR", JOptionPane.ERROR_MESSAGE);
                jTextFieldCodigoHerramienta.requestFocus();
                jTextFieldCodigoHerramienta.selectAll();
            }
        }
        else {
            JOptionPane.showMessageDialog(this,"ERROR:EL formato no es el adecuado recuerda que tiene que ser  AAA-AA-000" , "ERROR EN FORMATO DEL CÓDIGO",JOptionPane.ERROR_MESSAGE);
            jTextFieldCodigoHerramienta.requestFocus();
            jTextFieldCodigoHerramienta.selectAll();
        }
         
    }//GEN-LAST:event_jButtonAceptarCrearHerramientaActionPerformed

    private void cleanField(){
        jTextFieldCodigoHerramienta.setText("");
        jTextFieldCodigoHerramienta.requestFocus();
        jTextFieldNombreHerramienta.setText("");
        jComboBoxBooleanSmall.setSelectedIndex(0);
        
        
    }
    
    
   
       

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButtonAceptarCrearHerramienta;
    private javax.swing.JButton jButtonCancelarCrearHerramienta;
    private javax.swing.JComboBox<String> jComboBoxBooleanSmall;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldCodigoHerramienta;
    private javax.swing.JTextField jTextFieldNombreHerramienta;
    // End of variables declaration//GEN-END:variables
}

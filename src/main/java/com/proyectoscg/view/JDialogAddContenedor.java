/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.proyectoscg.view;

import com.proyectoscg.controlador.Controlador;
import com.proyectoscg.controlador.Excepciones;
import com.proyectoscg.model.Contenedor;
import com.proyectoscg.model.Herramienta;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public class JDialogAddContenedor extends javax.swing.JDialog {

    private Controlador controlador;
    private JFramePrincipal jFramePrincipal;
    private HashMap<String, Contenedor> contenedores;

    public JDialogAddContenedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jFramePrincipal = (JFramePrincipal) parent;
        controlador = Controlador.getInstance();
        contenedores = new HashMap<>();
        jButtonAceptarCrearContenedor.setEnabled(false);
    }

    public void comprobarjButtonAceptarCrearContenedor() {
        if (jTextFieldCodigoContenedor.getText().length() > 8) {
            jButtonAceptarCrearContenedor.setEnabled(true);
        } else {
            jButtonAceptarCrearContenedor.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonAceptarCrearContenedor = new javax.swing.JButton();
        jButtonCancelarCrearContenedor = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCodigoContenedor = new javax.swing.JTextField();
        jSpinnerCapacidadContenedor = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Añadir Contenedor");

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jButtonAceptarCrearContenedor.setText("Aceptar");
        jButtonAceptarCrearContenedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarCrearContenedorActionPerformed(evt);
            }
        });

        jButtonCancelarCrearContenedor.setText("Cerrar");
        jButtonCancelarCrearContenedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarCrearContenedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jButtonAceptarCrearContenedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 292, Short.MAX_VALUE)
                .addComponent(jButtonCancelarCrearContenedor)
                .addGap(95, 95, 95))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelarCrearContenedor)
                    .addComponent(jButtonAceptarCrearContenedor))
                .addGap(26, 26, 26))
        );

        jLabel4.setText("Formato Adecuado: AAA-A1-111");

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel1.setText("***APARTADO DE CREAR CONTENEDORES***");

        jLabel2.setText("Código para el nuevo contenedor :");

        jLabel3.setText("Capacidad máxima de unidades :");

        jTextFieldCodigoContenedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodigoContenedorActionPerformed(evt);
            }
        });
        jTextFieldCodigoContenedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCodigoContenedorKeyTyped(evt);
            }
        });

        jSpinnerCapacidadContenedor.setModel(new javax.swing.SpinnerNumberModel(10, 1, 999, 5));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldCodigoContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinnerCapacidadContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldCodigoContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jSpinnerCapacidadContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAceptarCrearContenedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarCrearContenedorActionPerformed
//        try {
//            String codigoContenedor = (String) jTextFieldCodigoContenedor.getText();
//            int capacidadContenedor = (int) jSpinnerCapacidadContenedor.getValue();
//
//            if (controlador.comprobarCodigoFormatoContenedor(codigoContenedor)) {
//                Contenedor newContenedor = new Contenedor(codigoContenedor, capacidadContenedor);
//                controlador.addHerramientaIfNoExist(codigoContenedor, newContenedor);
//                JOptionPane.showMessageDialog(this, "Herramienta creada con éxito", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
//                cleanField();
//            } else {
//                JOptionPane.showMessageDialog(this, "ERROR:EL formato no es el adecuado recuerda que tiene que ser  AAA-AA-000", "ERROR EN FORMATO DEL CÓDIGO", JOptionPane.ERROR_MESSAGE);
//                jTextFieldCodigoContenedor.requestFocus();
//                jTextFieldCodigoContenedor.selectAll();
//            }
//        } catch (Excepciones ex) {
//            JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
//            jTextFieldCodigoContenedor.requestFocus();
//            jTextFieldCodigoContenedor.selectAll();
//        }

    }//GEN-LAST:event_jButtonAceptarCrearContenedorActionPerformed

    private void jButtonCancelarCrearContenedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarCrearContenedorActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarCrearContenedorActionPerformed

    private void jTextFieldCodigoContenedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigoContenedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodigoContenedorActionPerformed

    private void jTextFieldCodigoContenedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodigoContenedorKeyTyped
        comprobarjButtonAceptarCrearContenedor();
    }//GEN-LAST:event_jTextFieldCodigoContenedorKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptarCrearContenedor;
    private javax.swing.JButton jButtonCancelarCrearContenedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinnerCapacidadContenedor;
    private javax.swing.JTextField jTextFieldCodigoContenedor;
    // End of variables declaration//GEN-END:variables
}

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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public class JDialogAddInventario extends javax.swing.JDialog {
    private List <Herramienta> herramientas;
    private List <Contenedor> contenedores;
    private Controlador controlador;

    public JDialogAddInventario(java.awt.Frame parent, boolean modal) {
        super(parent, false);
        try {
            initComponents();
            controlador = Controlador.getInstance();
            herramientas = controlador.getAllHerramientas();
            contenedores = controlador.getAllContenedores();
            String peque = "";
            for (Herramienta h : herramientas){
                if (h.isSmall()){
                    peque = " herramienta.Pequeña";
                    
                }
                else {
                    peque = " herramienta.Grande";
                }
                jComboBoxMostrarHerramientas.addItem(h.getCodigoHerramienta() + " - " + h.getNombreHerramienta() + " - " + peque ) ;
            }
            
            for (Contenedor c : contenedores){
                jComboBoxMostrarContenedores.addItem(c.getCodigoContenedor() + " - capacidad disponible: " + controlador.capacidadDisponible(c));
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        jButtonAceptarAddHerramienta.setEnabled(false);
    }
    
     public void comprobarjButtonAceptarAddHerramienta() {
        if (jComboBoxMostrarHerramientas.getSelectedIndex() > 0 && jComboBoxMostrarContenedores.getSelectedIndex() > 0 ) {
            jButtonAceptarAddHerramienta.setEnabled(true);
        } else {
            jButtonAceptarAddHerramienta.setEnabled(false);
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBoxMostrarHerramientas = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jButtonAceptarAddHerramienta = new javax.swing.JButton();
        jButtonCancelarCrearHerramienta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSpinnerUnidadesAdd = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxMostrarContenedores = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Añadir Inventario");

        jComboBoxMostrarHerramientas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el código de la Herramienta" }));
        jComboBoxMostrarHerramientas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMostrarHerramientasActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 102));

        jButtonAceptarAddHerramienta.setText("Aceptar");
        jButtonAceptarAddHerramienta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarAddHerramientaActionPerformed(evt);
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
                .addComponent(jButtonAceptarAddHerramienta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 325, Short.MAX_VALUE)
                .addComponent(jButtonCancelarCrearHerramienta)
                .addGap(95, 95, 95))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelarCrearHerramienta)
                    .addComponent(jButtonAceptarAddHerramienta))
                .addGap(26, 26, 26))
        );

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel1.setText("***APARTADO DE AÑADIR INVENTARIO***");

        jLabel2.setText("Código de la Herramienta :");

        jLabel5.setText("Cantidad de Unidades a Añadir:");

        jSpinnerUnidadesAdd.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        jLabel3.setText("Código del Contenedor :");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxMostrarHerramientas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxMostrarContenedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinnerUnidadesAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxMostrarHerramientas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jSpinnerUnidadesAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxMostrarContenedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAceptarAddHerramientaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarAddHerramientaActionPerformed

        try {
            int indexHerramienta = jComboBoxMostrarHerramientas.getSelectedIndex()-1;
            Herramienta herramientaSeleccionada = herramientas.get(indexHerramienta);
             if (!herramientaSeleccionada.isSmall()) {
                JOptionPane.showMessageDialog(this, "Solo se puede asignar una herramienta pequeña a un contenedor", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
            else{
                int unidadesAdd = (int) jSpinnerUnidadesAdd.getValue();
                int indexContenedor = jComboBoxMostrarContenedores.getSelectedIndex()-1;
                Contenedor contenedorSeleccionado = contenedores.get(indexContenedor);
                if (controlador.isCabenUnidades(contenedorSeleccionado , unidadesAdd)){
                    controlador.addInventario(herramientaSeleccionada, contenedorSeleccionado,unidadesAdd);
                    JOptionPane.showMessageDialog(this, "Inventario añadido con éxito", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
                    cleanField();
                } 
            }
            
        }

        catch (Excepciones ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage() , "ERROR", JOptionPane.ERROR_MESSAGE);
           }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        
        }

    }//GEN-LAST:event_jButtonAceptarAddHerramientaActionPerformed

    private void cleanField() {
        jSpinnerUnidadesAdd.setValue(1);
        jComboBoxMostrarHerramientas.setSelectedIndex(0);
        jComboBoxMostrarContenedores.setSelectedIndex(0);
    }
    
    private void jButtonCancelarCrearHerramientaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarCrearHerramientaActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarCrearHerramientaActionPerformed

    private void jComboBoxMostrarHerramientasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMostrarHerramientasActionPerformed
        comprobarjButtonAceptarAddHerramienta();
    }//GEN-LAST:event_jComboBoxMostrarHerramientasActionPerformed

    private void jComboBoxMostrarContenedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMostrarContenedoresActionPerformed
        comprobarjButtonAceptarAddHerramienta();
    }//GEN-LAST:event_jComboBoxMostrarContenedoresActionPerformed

  
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptarAddHerramienta;
    private javax.swing.JButton jButtonCancelarCrearHerramienta;
    private javax.swing.JComboBox<String> jComboBoxMostrarContenedores;
    private javax.swing.JComboBox<String> jComboBoxMostrarHerramientas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinnerUnidadesAdd;
    // End of variables declaration//GEN-END:variables
}

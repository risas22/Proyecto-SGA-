/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.proyectoscg.view;

import com.proyectoscg.controlador.Controlador;
import com.proyectoscg.model.Herramienta;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author krisl
 */
public class JDialogTableInventarioContenedor extends javax.swing.JDialog {
    
      private Controlador controlador;

    public JDialogTableInventarioContenedor(java.awt.Frame parent, boolean modal, List<Herramienta> herramientas) {
        super(parent, modal);
        try {
            controlador = Controlador.getInstance();
            initComponents();
            updateTable(herramientas);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void updateTable (List<Herramienta> herramientas)  throws SQLException {
    DefaultTableModel modelo = (DefaultTableModel) jTableInventarioContenedor.getModel();
    modelo.setColumnIdentifiers(new String[]{"Código herramienta", "Nombre herramienta", "Unidades herramienta"});
    modelo.setRowCount(0);
    jTableInventarioContenedor.getColumnModel().getColumn(0).setPreferredWidth(130);
    jTableInventarioContenedor.getColumnModel().getColumn(1).setPreferredWidth(130);
    jTableInventarioContenedor.getColumnModel().getColumn(2).setPreferredWidth(20); 
    for (Herramienta h : herramientas) {
        modelo.addRow(h.toArrayHerramientasContenedores());
    }
}


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableInventarioContenedor = new javax.swing.JTable();
        jButtonCancelarCrearHerramienta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        jLabel3.setFont(new java.awt.Font("Yu Gothic Medium", 1, 24)); // NOI18N
        jLabel3.setText("***HERRAMIENTAS DEL CONTENEDOR***");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(94, 94, 94))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(14, 14, 14))
        );

        jTableInventarioContenedor.setAutoCreateRowSorter(true);
        jTableInventarioContenedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código herramienta", "Nombre herramienta", "Unidades herramienta"
            }
        ));
        jScrollPane3.setViewportView(jTableInventarioContenedor);

        jButtonCancelarCrearHerramienta.setText("Cerrar");
        jButtonCancelarCrearHerramienta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarCrearHerramientaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(325, 325, 325)
                                .addComponent(jButtonCancelarCrearHerramienta)))
                        .addGap(0, 56, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCancelarCrearHerramienta)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarCrearHerramientaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarCrearHerramientaActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarCrearHerramientaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelarCrearHerramienta;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableInventarioContenedor;
    // End of variables declaration//GEN-END:variables
}

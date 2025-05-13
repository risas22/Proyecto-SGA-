/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.proyectoscg.view;

import com.proyectoscg.controlador.Controlador;
import com.proyectoscg.model.Herramienta;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class JFramePrincipal extends javax.swing.JFrame {
    private Controlador controlador;
    
    public JFramePrincipal() {
        initComponents();
        controlador = Controlador.getInstance();
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu8 = new javax.swing.JMenu();
        jMenuAddHerramienta = new javax.swing.JMenuItem();
        jMenuAddContenedor = new javax.swing.JMenuItem();
        jMenuAddInventario = new javax.swing.JMenuItem();
        jEliminarContenedor = new javax.swing.JMenu();
        jMenuMostrarHerramientas = new javax.swing.JMenuItem();
        jMenuMostrarContenedores = new javax.swing.JMenuItem();
        jMenuMostrarInventarioPorContenedor = new javax.swing.JMenuItem();
        jDeleteHerramienta = new javax.swing.JMenuItem();
        jDeleteContenedor = new javax.swing.JMenuItem();
        jMenuSalir = new javax.swing.JMenuItem();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu7.setText("jMenu7");

        jMenuItem6.setText("jMenuItem6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LA HERRATECA");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("La Herrateca");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Escoja una opción del menú de la barra superior");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Adobe Express - file (3).png"))); // NOI18N

        jMenuBar3.setBackground(new java.awt.Color(153, 153, 153));

        jMenu8.setText("Menú Principal");
        jMenu8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu8ActionPerformed(evt);
            }
        });

        jMenuAddHerramienta.setText("Crear Herramienta");
        jMenuAddHerramienta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAddHerramientaActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuAddHerramienta);

        jMenuAddContenedor.setText("Crear Contenedor");
        jMenuAddContenedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAddContenedorActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuAddContenedor);

        jMenuAddInventario.setText("Añadir Inventario de Herramientas");
        jMenuAddInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAddInventarioActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuAddInventario);

        jMenuBar3.add(jMenu8);

        jEliminarContenedor.setText("+ Opciones");
        jEliminarContenedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEliminarContenedorActionPerformed(evt);
            }
        });

        jMenuMostrarHerramientas.setText("Tabla de Herramientas");
        jMenuMostrarHerramientas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuMostrarHerramientasActionPerformed(evt);
            }
        });
        jEliminarContenedor.add(jMenuMostrarHerramientas);

        jMenuMostrarContenedores.setText("Tabla de Contenedores");
        jMenuMostrarContenedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuMostrarContenedoresActionPerformed(evt);
            }
        });
        jEliminarContenedor.add(jMenuMostrarContenedores);

        jMenuMostrarInventarioPorContenedor.setText("Mostrar Inventario por Contenedores");
        jMenuMostrarInventarioPorContenedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuMostrarInventarioPorContenedorActionPerformed(evt);
            }
        });
        jEliminarContenedor.add(jMenuMostrarInventarioPorContenedor);

        jDeleteHerramienta.setText("Eliminar Herramienta");
        jDeleteHerramienta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteHerramientaActionPerformed(evt);
            }
        });
        jEliminarContenedor.add(jDeleteHerramienta);

        jDeleteContenedor.setText("Eliminar Contenedor");
        jDeleteContenedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteContenedorActionPerformed(evt);
            }
        });
        jEliminarContenedor.add(jDeleteContenedor);

        jMenuSalir.setText("Salir");
        jMenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSalirActionPerformed(evt);
            }
        });
        jEliminarContenedor.add(jMenuSalir);

        jMenuBar3.add(jEliminarContenedor);

        setJMenuBar(jMenuBar3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jEliminarContenedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEliminarContenedorActionPerformed

    }//GEN-LAST:event_jEliminarContenedorActionPerformed

    private void jMenuMostrarInventarioPorContenedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuMostrarInventarioPorContenedorActionPerformed
        try {
            JDialogChooseContenedor dialog = new JDialogChooseContenedor(this, true);
            dialog.setVisible(true);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jMenuMostrarInventarioPorContenedorActionPerformed

    private void jMenuMostrarContenedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuMostrarContenedoresActionPerformed

        try {
            JDialogTableContenedores jDialogTableContenedores = new JDialogTableContenedores(this,false);

            if (controlador.getAllContenedores().isEmpty()){
                JOptionPane.showMessageDialog(this,"No hay contenedores creados actualmente","ERROR: TABLA VACÍA", JOptionPane.INFORMATION_MESSAGE);
                jDialogTableContenedores.setVisible(false);
            }
            else{
                jDialogTableContenedores.setVisible(true);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jMenuMostrarContenedoresActionPerformed

    private void jMenuMostrarHerramientasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuMostrarHerramientasActionPerformed
        try {
            JDialogTableHerramientas jDialogTableHerramientas = new JDialogTableHerramientas(this,false);

            if (controlador.getAllHerramientas().isEmpty()){
                JOptionPane.showMessageDialog(this,"No hay herramientas creadas actualmente","ERROR: TABLA VACÍA", JOptionPane.INFORMATION_MESSAGE);
                jDialogTableHerramientas.setVisible(false);
            }
            else{
                jDialogTableHerramientas.setVisible(true);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jMenuMostrarHerramientasActionPerformed

    private void jDeleteHerramientaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeleteHerramientaActionPerformed
         try {
            JDialogBorrarHerramienta JDialogBorrarHerramienta = new JDialogBorrarHerramienta(this,true);
        
            if (controlador.getAllHerramientas().isEmpty()){
                JOptionPane.showMessageDialog(this,"No hay herramientas creadas actualmente","ERROR: SIN HERRAMIENTAS", JOptionPane.INFORMATION_MESSAGE);
                JDialogBorrarHerramienta.setVisible(false);
            } else{ 
            JDialogBorrarHerramienta.setVisible(true);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jDeleteHerramientaActionPerformed

    private void jDeleteContenedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeleteContenedorActionPerformed
        try {
            JDialogBorrarContenedor JDialogBorrarContenedor = new JDialogBorrarContenedor(this,true);
        
            if (controlador.getAllHerramientas().isEmpty()){
                JOptionPane.showMessageDialog(this,"No hay contenedores creados actualmente","ERROR: SIN CONTENEDORES", JOptionPane.INFORMATION_MESSAGE);
                JDialogBorrarContenedor.setVisible(false);
            } else{ 
            JDialogBorrarContenedor.setVisible(true);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jDeleteContenedorActionPerformed

    private void jMenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuSalirActionPerformed

    private void jMenu8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu8ActionPerformed

    }//GEN-LAST:event_jMenu8ActionPerformed

    private void jMenuAddInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAddInventarioActionPerformed
        JDialogAddInventario jDialogAddInventario = new JDialogAddInventario(this,true);
        jDialogAddInventario.setVisible(true);
    }//GEN-LAST:event_jMenuAddInventarioActionPerformed

    private void jMenuAddContenedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAddContenedorActionPerformed
        JDialogAddContenedor jDialogAddContenedor = new JDialogAddContenedor(this,true);
        jDialogAddContenedor.setVisible(true);
    }//GEN-LAST:event_jMenuAddContenedorActionPerformed

    private void jMenuAddHerramientaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAddHerramientaActionPerformed
        JDialogAddHerramienta jDialogAddHerramienta = new JDialogAddHerramienta(this,true);
        jDialogAddHerramienta.setVisible(true);

    }//GEN-LAST:event_jMenuAddHerramientaActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jDeleteContenedor;
    private javax.swing.JMenuItem jDeleteHerramienta;
    private javax.swing.JMenu jEliminarContenedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuItem jMenuAddContenedor;
    private javax.swing.JMenuItem jMenuAddHerramienta;
    private javax.swing.JMenuItem jMenuAddInventario;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuMostrarContenedores;
    private javax.swing.JMenuItem jMenuMostrarHerramientas;
    private javax.swing.JMenuItem jMenuMostrarInventarioPorContenedor;
    private javax.swing.JMenuItem jMenuSalir;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    // End of variables declaration//GEN-END:variables
}

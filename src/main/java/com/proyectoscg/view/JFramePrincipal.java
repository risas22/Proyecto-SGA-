/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.proyectoscg.view;

import controlador.Controlador;
import javax.swing.JOptionPane;



public class JFramePrincipal extends javax.swing.JFrame {
    private Controlador controlador;
    
    public JFramePrincipal() {
        initComponents();
        controlador = Controlador.getInstance();
    }
     
    
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu8 = new javax.swing.JMenu();
        jMenuAddHerramienta = new javax.swing.JMenuItem();
        jMenuAddContenedor = new javax.swing.JMenuItem();
        jMenuAddInventario = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuMostrarHerramientas = new javax.swing.JMenuItem();
        jMenuMostrarContenedores = new javax.swing.JMenuItem();
        jMenuMostrarInventario = new javax.swing.JMenuItem();
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
        jLabel2.setText("Seleccione una opción del menú de la barra superior");

        jMenu8.setText("Menú Principal");

        jMenuAddHerramienta.setText("Crear Herramienta");
        jMenuAddHerramienta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAddHerramientaActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuAddHerramienta);

        jMenuAddContenedor.setText("Crear Contenedor");
        jMenu8.add(jMenuAddContenedor);

        jMenuAddInventario.setText("Añadir Inventario de Herramientas");
        jMenu8.add(jMenuAddInventario);

        jMenuBar3.add(jMenu8);

        jMenu9.setText("+ Opciones");

        jMenuMostrarHerramientas.setText("Mostrar Herramientas");
        jMenuMostrarHerramientas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuMostrarHerramientasActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuMostrarHerramientas);

        jMenuMostrarContenedores.setText("Mostrar Contendores");
        jMenuMostrarContenedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuMostrarContenedoresActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuMostrarContenedores);

        jMenuMostrarInventario.setText("Mostrar Inventario por Contenedores");
        jMenu9.add(jMenuMostrarInventario);

        jMenuSalir.setText("Salir");
        jMenu9.add(jMenuSalir);

        jMenuBar3.add(jMenu9);

        setJMenuBar(jMenuBar3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuAddHerramientaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAddHerramientaActionPerformed
      JDialogAddHerramienta jDialogAddHerramienta = new JDialogAddHerramienta(this,true);
      jDialogAddHerramienta.setVisible(true);
        
    }//GEN-LAST:event_jMenuAddHerramientaActionPerformed

    private void jMenuMostrarContenedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuMostrarContenedoresActionPerformed

    }//GEN-LAST:event_jMenuMostrarContenedoresActionPerformed

    private void jMenuMostrarHerramientasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuMostrarHerramientasActionPerformed
        JDialogTableHerramientas jDialogTableHerramientas = new JDialogTableHerramientas(this,false);
        
        if (controlador.isEmptyHerramientas()){
            JOptionPane.showMessageDialog(this,"No hay herramientas creadas actualmente","ERROR: TABLA VACÍA", JOptionPane.INFORMATION_MESSAGE);
            jDialogTableHerramientas.setVisible(false);
        }
        else{
            jDialogTableHerramientas.setVisible(true);
        }
    }//GEN-LAST:event_jMenuMostrarHerramientasActionPerformed

 
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuItem jMenuAddContenedor;
    private javax.swing.JMenuItem jMenuAddHerramienta;
    private javax.swing.JMenuItem jMenuAddInventario;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuMostrarContenedores;
    private javax.swing.JMenuItem jMenuMostrarHerramientas;
    private javax.swing.JMenuItem jMenuMostrarInventario;
    private javax.swing.JMenuItem jMenuSalir;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Functions.ReadFunctions;
import classes.HashTable;
import classes.Resumen;

/**
 *
 * @author Mario
 */
public class Home extends javax.swing.JFrame {

    HashTable hashTable;
    ReadFunctions rf;
    /**
     * Creates new form Home
     * @param hashTable
     */
    public Home(HashTable hashTable) {
        initComponents();
        this.setLocationRelativeTo(null);

        this.hashTable = hashTable;
        this.rf = new ReadFunctions();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        frontText = new javax.swing.JLabel();
        agregar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        busqueda = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        busqueda1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        frontText.setFont(new java.awt.Font("Phosphate", 1, 36)); // NOI18N
        frontText.setForeground(new java.awt.Color(255, 153, 51));
        frontText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        frontText.setText("METRO MENDELEY");
        frontText.setToolTipText("");
        frontText.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        frontText.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        frontText.setInheritsPopupMenu(false);
        jPanel1.add(frontText, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 440, 90));

        agregar.setText("Agregar resumen");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });
        jPanel1.add(agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 140, 40));

        jButton2.setText("Analizar resumen");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 140, 40));

        busqueda.setText("Buscar Autor");
        busqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busquedaActionPerformed(evt);
            }
        });
        jPanel1.add(busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 140, 40));

        salir.setText("Salir del sistema");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jPanel1.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, -1, 40));

        busqueda1.setText("Palabra Clave");
        busqueda1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busqueda1ActionPerformed(evt);
            }
        });
        jPanel1.add(busqueda1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 140, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Analyze analyze = new Analyze(this.hashTable);

        analyze.setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        Resumen nuevo = rf.read();
        if(nuevo != null){
            hashTable.insertar(nuevo);
        }
    }//GEN-LAST:event_agregarActionPerformed

    private void busquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busquedaActionPerformed
        AutorForm autor = new AutorForm(this.hashTable, "ASd");
        
        autor.setVisible(true);
    }//GEN-LAST:event_busquedaActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        rf.guardar(hashTable);
        System.exit(1);
    }//GEN-LAST:event_salirActionPerformed

    private void busqueda1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busqueda1ActionPerformed
        Palabra palabra = new Palabra(this.hashTable, "ASDASD");

        palabra.setVisible(true);
    }//GEN-LAST:event_busqueda1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JButton busqueda;
    private javax.swing.JButton busqueda1;
    private javax.swing.JLabel frontText;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}

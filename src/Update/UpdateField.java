/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Update;

import CRUD.FieldCRUD;
import FileHandler.FieldFile;
import Frames.BaseForm;
import Panels.Dashboard;
import Panels.ViewField;
import Source.Field;
import javax.swing.JOptionPane;

/**
 *
 * @author Vincent Dialing
 */
public class UpdateField extends javax.swing.JFrame {

    public UpdateField() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        size = new javax.swing.JTextField();
        location = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        size.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        size.setText(Dashboard.field.getSize());
        size.setBorder(null);
        getContentPane().add(size, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 400, 30));

        location.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        location.setText(Dashboard.field.getLocation());
        location.setBorder(null);
        getContentPane().add(location, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 400, 40));

        cancelButton.setBorderPainted(false);
        cancelButton.setContentAreaFilled(false);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 490, 60, 30));

        okButton.setBorderPainted(false);
        okButton.setContentAreaFilled(false);
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        getContentPane().add(okButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 490, 60, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourcse/Update Field.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        int response = JOptionPane.showConfirmDialog(null, 
            "Are you sure you want to cancel?", 
            "Confirmation", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE);
        if(response == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        String newsize = size.getText();
        String newlocation = location.getText();
        
        Field newfield = new Field(newsize, newlocation, BaseForm.farmerid, Dashboard.fieldid, Dashboard.field.getActualyield(), Dashboard.field.getPredictedyield());
        FieldCRUD.updateField(Dashboard.field, newfield);
        FieldFile.write();
        this.dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setLocationRelativeTo(null);
    }//GEN-LAST:event_formWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField location;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField size;
    // End of variables declaration//GEN-END:variables
}

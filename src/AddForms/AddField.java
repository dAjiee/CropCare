/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AddForms;

import CRUD.FieldCRUD;
import FileHandler.FieldFile;
import Frames.BaseForm;
import Source.Field;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author Vincent Dialing
 */
public class AddField extends javax.swing.JFrame {

    public AddField() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        size = new javax.swing.JTextField();
        location = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        size.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        size.setBorder(null);
        getContentPane().add(size, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 400, 40));

        location.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        location.setBorder(null);
        getContentPane().add(location, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 400, 30));

        id.setEditable(false);
        id.setBackground(new java.awt.Color(255, 255, 255));
        id.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        id.setForeground(new java.awt.Color(102, 102, 102));
        id.setText(Integer.toString(generateId()));
        id.setBorder(null);
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 400, 30));

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourcse/Add field.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Center JFrame
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setLocationRelativeTo(null);
    }//GEN-LAST:event_formWindowOpened
    
    //Press Field ID
    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        Toolkit.getDefaultToolkit().beep();
    }//GEN-LAST:event_idActionPerformed
    
    //Cancel
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
    
    //Create
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        int idnum = Integer.parseInt(id.getText());
        String sizenum = size.getText();
        String locationnum = location.getText();
        
        Field field = new Field(sizenum, locationnum, BaseForm.farmerid,idnum, 0, 0);
        FieldCRUD.createField(field);
        FieldFile.write();
        this.dispose();
    }//GEN-LAST:event_okButtonActionPerformed
    
    //Generate ID
    private int generateId(){
        int id = 1;
        for(Field field : FieldCRUD.fieldList){
            if(field.getFarmerid() == BaseForm.farmerid){
                id++;
            }
        }
        return id;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField location;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField size;
    // End of variables declaration//GEN-END:variables
}

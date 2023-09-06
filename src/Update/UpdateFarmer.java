/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Update;

import CRUD.FarmerCRUD;
import FileHandler.FarmerFile;
import Frames.BaseForm;
import Panels.Dashboard;
import Source.Farmer;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Vincent Dialing
 */
public class UpdateFarmer extends javax.swing.JFrame {

    
    public UpdateFarmer() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        firstname = new javax.swing.JTextField();
        lastname = new javax.swing.JTextField();
        contactNumber = new javax.swing.JTextField();
        age = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        firstname.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        firstname.setText(BaseForm.farmer.getFname());
        firstname.setBorder(null);
        getContentPane().add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 400, 30));

        lastname.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lastname.setText(BaseForm.farmer.getLname());
        lastname.setBorder(null);
        getContentPane().add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 275, 400, -1));

        contactNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        contactNumber.setText(BaseForm.farmer.getContact());
        contactNumber.setBorder(null);
        getContentPane().add(contactNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 400, 30));

        age.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        age.setText(Integer.toString(BaseForm.farmer.getAge()));
        age.setBorder(null);
        getContentPane().add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, 400, 30));

        okButton.setBorderPainted(false);
        okButton.setContentAreaFilled(false);
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        getContentPane().add(okButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 520, 60, 40));

        cancelButton.setBorderPainted(false);
        cancelButton.setContentAreaFilled(false);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 520, 60, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourcse/Update Profile.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Confirm Button
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        String fname = firstname.getText();
        String lname = lastname.getText();
        String contactnum = contactNumber.getText();
        int newage = Integer.parseInt(age.getText());
        
        Farmer newfarmer = new Farmer(fname, lname, contactnum, BaseForm.farmerid, newage);
        FarmerCRUD.updateFarmer(BaseForm.farmer, newfarmer);
        FarmerFile.write();
        this.dispose();
    }//GEN-LAST:event_okButtonActionPerformed
    
    //Cancel Button
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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setLocationRelativeTo(null);
    }//GEN-LAST:event_formWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField age;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField contactNumber;
    private javax.swing.JTextField firstname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField lastname;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
}

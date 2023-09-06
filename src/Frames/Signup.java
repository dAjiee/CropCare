/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import CRUD.FarmerCRUD;
import FileHandler.FarmerFile;
import Source.Farmer;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author Vincent Dialing
 */
public class Signup extends javax.swing.JFrame {

    public Signup() {
        initComponents();
        error.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        signupButton = new javax.swing.JButton();
        id = new javax.swing.JTextField();
        firstname = new javax.swing.JTextField();
        lastname1 = new javax.swing.JTextField();
        age = new javax.swing.JTextField();
        contact1 = new javax.swing.JTextField();
        error = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        signupButton.setBorderPainted(false);
        signupButton.setContentAreaFilled(false);
        signupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupButtonActionPerformed(evt);
            }
        });
        getContentPane().add(signupButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 500, 220, 50));

        id.setEditable(false);
        id.setBackground(new java.awt.Color(255, 255, 255));
        id.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        id.setForeground(new java.awt.Color(102, 102, 102));
        id.setText(Integer.toString(FarmerCRUD.farmerList.get(FarmerCRUD.farmerList.size() - 1).getId() + 1));
        id.setBorder(null);
        id.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                idMouseClicked(evt);
            }
        });
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 425, 340, 30));

        firstname.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        firstname.setActionCommand("<Not Set>");
        firstname.setBorder(null);
        getContentPane().add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 155, 340, 30));

        lastname1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lastname1.setBorder(null);
        getContentPane().add(lastname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 225, 340, 30));

        age.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        age.setBorder(null);
        getContentPane().add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 340, 30));

        contact1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        contact1.setBorder(null);
        getContentPane().add(contact1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 340, 30));

        error.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        error.setForeground(java.awt.Color.red);
        error.setText("Enter Appropriate Age!");
        getContentPane().add(error, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, 170, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourcse/Sign Up.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //CenterJFrame
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setLocationRelativeTo(null);
    }//GEN-LAST:event_formWindowOpened

    private void idMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_idMouseClicked
        Toolkit.getDefaultToolkit().beep();
    }//GEN-LAST:event_idMouseClicked
    
    //Sign-Up
    private void signupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupButtonActionPerformed
        try{
            int age1 = 0;
            int id1 = 0;
            String fname = firstname.getText();
            String lname = lastname1.getText();
            age1 = Integer.parseInt(age.getText());
            String contact = contact1.getText();
            id1 = Integer.parseInt(id.getText());

            Farmer farmer = new Farmer(fname, lname, contact, id1, age1);
            FarmerCRUD.createFarmer(farmer);
            FarmerFile.write();
            JOptionPane.showMessageDialog(null, "Account Successfully Created!", "Account Created!", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            Login login = new Login();
            login.setVisible(true);
        } catch (java.lang.NumberFormatException e) {
            Toolkit.getDefaultToolkit().beep();
            error.setVisible(true);
        }
    }//GEN-LAST:event_signupButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField age;
    private javax.swing.JTextField contact1;
    private javax.swing.JLabel error;
    private javax.swing.JTextField firstname;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField lastname1;
    private javax.swing.JButton signupButton;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import CRUD.FarmerCRUD;
import Source.Farmer;
import java.awt.Toolkit;

/**
 *
 * @author Vincent Dialing
 */
public class Login extends javax.swing.JFrame {
    
    public Login() {
        initComponents();
        error.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        error = new javax.swing.JLabel();
        signup = new javax.swing.JButton();
        fullname = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        loginButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        error.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        error.setForeground(java.awt.Color.red);
        error.setText("Account does not Exist!");
        getContentPane().add(error, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 170, -1));

        signup.setBorderPainted(false);
        signup.setContentAreaFilled(false);
        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });
        getContentPane().add(signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 510, 180, 20));

        fullname.setBackground(new java.awt.Color(171, 194, 182));
        fullname.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        fullname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fullname.setBorder(null);
        getContentPane().add(fullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 340, 30));

        id.setBackground(new java.awt.Color(171, 194, 182));
        id.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id.setActionCommand("null");
        id.setBorder(null);
        id.setDisabledTextColor(new java.awt.Color(171, 194, 182));
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 340, 30));

        loginButton1.setBorderPainted(false);
        loginButton1.setContentAreaFilled(false);
        loginButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(loginButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, 220, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourcse/LogIn.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Center Jframe
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setLocationRelativeTo(null);
    }//GEN-LAST:event_formWindowOpened
    
    //Dont Have an Account
    private void signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupActionPerformed
        this.dispose();
        Signup signup = new Signup();
        signup.setVisible(true);
    }//GEN-LAST:event_signupActionPerformed
    
    //Log-In
    private void loginButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButton1ActionPerformed
        try{
            for(Farmer farmer : FarmerCRUD.farmerList){
                if(Integer.parseInt(id.getText()) == farmer.getId() && fullname.getText().equalsIgnoreCase(farmer.getCname())){
                    BaseForm base = new BaseForm(Integer.parseInt(id.getText()));
                    base.setVisible(true);
                    this.dispose();
                    return;
                }
            }
            Toolkit.getDefaultToolkit().beep();
            error.setVisible(true);
        } catch (java.lang.NumberFormatException e){
            Toolkit.getDefaultToolkit().beep();
            error.setVisible(true);
        }
    }//GEN-LAST:event_loginButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel error;
    private javax.swing.JTextField fullname;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton loginButton1;
    private javax.swing.JButton signup;
    // End of variables declaration//GEN-END:variables
}

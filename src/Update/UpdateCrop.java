/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Update;

import AddForms.*;
import CRUD.CropCRUD;
import FileHandler.CropFile;
import Frames.BaseForm;
import Panels.Dashboard;
import Panels.ViewField;
import Source.Crop;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Vincent Dialing
 */
public class UpdateCrop extends javax.swing.JFrame {

    /**
     * Creates new form AddField
     */
    public UpdateCrop() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        growthPeriod = new javax.swing.JTextField();
        description = new javax.swing.JTextField();
        prediction = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();
        yield = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        growthPeriod.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        growthPeriod.setText(ViewField.crop.getGrowthperiod());
        growthPeriod.setBorder(null);
        getContentPane().add(growthPeriod, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 180, 40));

        description.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        description.setText(ViewField.crop.getDescription());
        description.setBorder(null);
        getContentPane().add(description, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 320, 40));

        prediction.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        prediction.setText(Integer.toString(ViewField.crop.getPredictedyield()));
        prediction.setBorder(null);
        getContentPane().add(prediction, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 250, 40));

        name.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        name.setText(ViewField.crop.getName());
        name.setBorder(null);
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 550, 30));

        cancelButton.setBorderPainted(false);
        cancelButton.setContentAreaFilled(false);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 520, 70, 40));

        yield.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        yield.setText(Integer.toString(ViewField.crop.getActualyield()));
        yield.setBorder(null);
        getContentPane().add(yield, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 440, 250, 40));

        okButton.setBorderPainted(false);
        okButton.setContentAreaFilled(false);
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        getContentPane().add(okButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 520, 70, 40));

        jDateChooser1.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooser1.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 240, 30));

        jDateChooser2.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooser2.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 352, 250, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourcse/Update Crop.png"))); // NOI18N
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
        String name1 = name.getText();
        String description1 = description.getText();
        String growth = growthPeriod.getText();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String plantdate = dateFormat.format(jDateChooser2.getDate());
        String harvestdate = dateFormat.format(jDateChooser1.getDate());
        
        int prediction1 = Integer.parseInt(prediction.getText());
        int yield1 = Integer.parseInt(yield.getText());
        
        Crop newcrop = new Crop(name1, description1, growth, plantdate, 
                harvestdate, BaseForm.farmerid, Dashboard.fieldid, ViewField.cropid, 
                prediction1, yield1);
        CropCRUD.updateCrop(ViewField.crop, newcrop);
        CropFile.write();
        this.dispose();
    }//GEN-LAST:event_okButtonActionPerformed
    
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setLocationRelativeTo(null);
    }//GEN-LAST:event_formWindowOpened

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField description;
    private javax.swing.JTextField growthPeriod;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField name;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField prediction;
    private javax.swing.JTextField yield;
    // End of variables declaration//GEN-END:variables
}

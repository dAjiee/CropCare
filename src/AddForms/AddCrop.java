/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AddForms;

import CRUD.CropCRUD;
import FileHandler.CropFile;
import Frames.BaseForm;
import Panels.Dashboard;
import Source.Crop;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Vincent Dialing
 */
public class AddCrop extends javax.swing.JFrame {

    public AddCrop() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        growthPeriod = new javax.swing.JTextField();
        description = new javax.swing.JTextField();
        prediction = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        id1 = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();
        yield = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        harvestDate = new com.toedter.calendar.JDateChooser();
        plantDate = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        growthPeriod.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        growthPeriod.setBorder(null);
        getContentPane().add(growthPeriod, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 180, 40));

        description.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        description.setBorder(null);
        getContentPane().add(description, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 320, 40));

        prediction.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        prediction.setBorder(null);
        getContentPane().add(prediction, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 250, 40));

        name.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        name.setBorder(null);
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 280, 30));

        id1.setEditable(false);
        id1.setBackground(new java.awt.Color(255, 255, 255));
        id1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        id1.setForeground(new java.awt.Color(102, 102, 102));
        id1.setText(Integer.toString(generateId()));
        id1.setBorder(null);
        id1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id1ActionPerformed(evt);
            }
        });
        getContentPane().add(id1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 220, 30));

        cancelButton.setBorderPainted(false);
        cancelButton.setContentAreaFilled(false);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 520, 70, 40));

        yield.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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

        harvestDate.setBackground(new java.awt.Color(255, 255, 255));
        harvestDate.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(harvestDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 240, 30));

        plantDate.setBackground(new java.awt.Color(255, 255, 255));
        plantDate.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(plantDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 352, 250, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourcse/Add Crop.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
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

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        int id = generateId();
        String name1 = name.getText();
        String description1 = description.getText();
        String growthperiod = growthPeriod.getText();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String plantdate = dateFormat.format(plantDate.getDate());
        String harvestdate = dateFormat.format(harvestDate.getDate());
        
        
        int prediction1 = Integer.parseInt(prediction.getText());
        int yield1 = Integer.parseInt(yield.getText());
        
        Crop crop = new Crop(name1, description1, growthperiod, plantdate, 
                harvestdate, BaseForm.farmerid, Dashboard.fieldid, id, 
                prediction1, yield1);
        CropCRUD.createCrop(crop);
        CropFile.write();
        this.dispose();
    }//GEN-LAST:event_okButtonActionPerformed
    
    //Make Sound (Working)
    private void id1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id1ActionPerformed
        Toolkit.getDefaultToolkit().beep();
    }//GEN-LAST:event_id1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField description;
    private javax.swing.JTextField growthPeriod;
    private com.toedter.calendar.JDateChooser harvestDate;
    private javax.swing.JTextField id1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField name;
    private javax.swing.JButton okButton;
    private com.toedter.calendar.JDateChooser plantDate;
    private javax.swing.JTextField prediction;
    private javax.swing.JTextField yield;
    // End of variables declaration//GEN-END:variables

    //Generate ID
    private int generateId(){
        int id = 1;
        for(Crop crop : CropCRUD.cropList){
            if(crop.getFarmerid() == BaseForm.farmerid && crop.getFieldid() == Dashboard.fieldid){
                id++;
            }
        }
        return id;
    }
}

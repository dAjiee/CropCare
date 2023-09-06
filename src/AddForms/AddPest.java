/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AddForms;

import CRUD.PestCRUD;
import FileHandler.PestFile;
import Frames.BaseForm;
import Panels.Dashboard;
import Panels.ViewField;
import Source.Pest;
import javax.swing.JOptionPane;

/**
 *
 * @author Vincent Dialing
 */
public class AddPest extends javax.swing.JFrame {

    public AddPest() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        description = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        id1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        symptoms = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        prevention = new javax.swing.JTextArea();
        id = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        description.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        description.setBorder(null);
        getContentPane().add(description, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 450, 40));

        name.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        name.setBorder(null);
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 220, 30));

        cancelButton.setBorderPainted(false);
        cancelButton.setContentAreaFilled(false);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 510, 70, 40));

        okButton.setBorderPainted(false);
        okButton.setContentAreaFilled(false);
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        getContentPane().add(okButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 510, 70, 40));

        id1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        id1.setForeground(new java.awt.Color(102, 102, 102));
        id1.setText(Integer.toString(generateId()));
        id1.setBorder(null);
        getContentPane().add(id1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 190, 40));

        symptoms.setColumns(20);
        symptoms.setRows(5);
        jScrollPane2.setViewportView(symptoms);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 190, 110));

        prevention.setColumns(20);
        prevention.setRows(5);
        jScrollPane1.setViewportView(prevention);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, 220, 110));

        id.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourcse/Add Pest.png"))); // NOI18N
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Okay
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        int id = generateId();
        String name1 = name.getText();
        String description1 = description.getText();
        String symptomstext = symptoms.getText();
        String preventiontext = prevention.getText();
        
        String symptoms1 = symptomstext.replace("\n", "^").replace("\r", "•");
        String prevention1 = preventiontext.replace("\n", "^").replace("\r", "•");
        
        Pest pest = new Pest(name1, description1, symptoms1, prevention1, BaseForm.farmerid, Dashboard.fieldid, ViewField.cropid, id);
        PestCRUD.createPest(pest);
        PestFile.write();
        this.dispose();
    }//GEN-LAST:event_okButtonActionPerformed
    
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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setLocationRelativeTo(null);
    }//GEN-LAST:event_formWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField description;
    private javax.swing.JLabel id;
    private javax.swing.JTextField id1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField name;
    private javax.swing.JButton okButton;
    private javax.swing.JTextArea prevention;
    private javax.swing.JTextArea symptoms;
    // End of variables declaration//GEN-END:variables

    //Generate ID
    private int generateId(){
        int id = 1;
        for(Pest pest : PestCRUD.pestList){
            if(pest.getFarmerid() == BaseForm.farmerid && pest.getFieldid() == Dashboard.fieldid
                    && pest.getCropid() == ViewField.cropid){
                id++;
            }
        }
        return id;
    }
}

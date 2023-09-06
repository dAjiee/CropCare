/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Panels;

import Frames.BaseForm;
import Update.UpdatePest;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Vincent Dialing
 */
public class ViewPest extends javax.swing.JPanel {
    //Reference to Board Panel and BaseForm
    private Board boardPanel;
    private BaseForm baseForm;
    
    public ViewPest() {
        initComponents();
    }
    
    public ViewPest(Board boardPanel, BaseForm baseForm) {
        //Panel Components
        initComponents();
        
        //Instantiate BaseForm and Panel
        this.baseForm = baseForm;
        this.boardPanel = boardPanel;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        MenuBar = new javax.swing.JButton();
        updateInformations = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        pestName = new javax.swing.JLabel();
        pestnameCode = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText(ViewCrop.pest.getDescription());
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 460, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Pest Description:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

        MenuBar.setBorderPainted(false);
        MenuBar.setContentAreaFilled(false);
        MenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBarActionPerformed(evt);
            }
        });
        add(MenuBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 40, 30));

        updateInformations.setBorderPainted(false);
        updateInformations.setContentAreaFilled(false);
        updateInformations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateInformationsActionPerformed(evt);
            }
        });
        add(updateInformations, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, 220, 50));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(22, 144, 83));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jTextArea1.setText(restoreOriginal(ViewCrop.pest.getPrevention()));
        jTextArea1.setBorder(null);
        jScrollPane3.setViewportView(jTextArea1);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 260, 270, 270));

        pestName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pestName.setForeground(new java.awt.Color(0, 51, 43));
        pestName.setText("Pest Name:");
        add(pestName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));

        pestnameCode.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        pestnameCode.setText(ViewCrop.pest.getName());
        add(pestnameCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 150, -1));

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new java.awt.Color(16, 73, 45));
        jTextArea2.setColumns(20);
        jTextArea2.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea2.setRows(5);
        jTextArea2.setText(restoreOriginal(ViewCrop.pest.getSymptoms()));
        jTextArea2.setBorder(null);
        jScrollPane4.setViewportView(jTextArea2);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 270, 270));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourcse/View Pest.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents
    
    //MenuBar (Working)
    private void MenuBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBarActionPerformed
        if (BaseForm.num == 0 && boardPanel != null) {
            boardPanel.show();
            boardPanel.setSize(BaseForm.num, 600);
            Thread th = new Thread() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i <= BaseForm.num; i++) {
                            Thread.sleep(1);
                            boardPanel.setSize(i, 600);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            };
            th.start();
            BaseForm.num = 320;
        }
    }//GEN-LAST:event_MenuBarActionPerformed
    
    //Update Information (Working)
    private void updateInformationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateInformationsActionPerformed
        UpdatePest update = new UpdatePest();
        update.setVisible(true);
        update.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e) {
                refreshPestLabels();
            }
        });
    }//GEN-LAST:event_updateInformationsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MenuBar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel pestName;
    private javax.swing.JLabel pestnameCode;
    private javax.swing.JButton updateInformations;
    // End of variables declaration//GEN-END:variables

    //Refresh Labels
    public void refreshPestLabels(){
        pestnameCode.setText(ViewCrop.pest.getName());
        jTextArea2.setText(restoreOriginal(ViewCrop.pest.getSymptoms()));
        jTextArea1.setText(restoreOriginal(ViewCrop.pest.getPrevention()));
        jLabel3.setText(ViewCrop.pest.getDescription());
    }
    
    //Restore Original Text
    public String restoreOriginal(String text){
        String newtext = text.replace("^", "\n").replace("•", "\r");
        return newtext;
    }
    
}

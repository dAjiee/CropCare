/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Panels;

import Frames.BaseForm;
import Frames.Login;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Vincent Dialing
 */
public class Board extends javax.swing.JPanel {
    private BaseForm baseForm; 
    
    public Board(){
        initComponents();
    }
    
    public Board(BaseForm baseForm) {
        this.baseForm = baseForm;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logout = new javax.swing.JButton();
        leaderboard = new javax.swing.JButton();
        dashboard = new javax.swing.JButton();
        MenuBar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logout.setBorderPainted(false);
        logout.setContentAreaFilled(false);
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 220, 50));

        leaderboard.setBorderPainted(false);
        leaderboard.setContentAreaFilled(false);
        leaderboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaderboardActionPerformed(evt);
            }
        });
        add(leaderboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 220, 50));

        dashboard.setBorderPainted(false);
        dashboard.setContentAreaFilled(false);
        dashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardActionPerformed(evt);
            }
        });
        add(dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 220, 50));

        MenuBar.setBorderPainted(false);
        MenuBar.setContentAreaFilled(false);
        MenuBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBarActionPerformed(evt);
            }
        });
        add(MenuBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 40, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourcse/Bar Overlay.png"))); // NOI18N
        jLabel1.setOpaque(true);
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents
    
    //Menu Bar
    private void MenuBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBarActionPerformed
        JPanel boardPanel = (JPanel) MenuBar.getParent();
        
        if(BaseForm.num == 320){
            boardPanel.setSize(320, 600);
            Thread th = new Thread(){
                @Override
                public void run(){
                    try{
                        for (int i = 320; i >= 0; i--){
                            Thread.sleep(1);
                            boardPanel.setSize(i, 600);
                        }
                    } catch (Exception e){
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            };th.start();
            BaseForm.num = 0;
        }
    }//GEN-LAST:event_MenuBarActionPerformed
    
    //Dashboard
    private void dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardActionPerformed
        // Show the Dashboard panel and hide the Leaderboard panel
        baseForm.getDashBoard().setVisible(true);
        
        baseForm.getLeaderBoard().setVisible(false);
        baseForm.getViewField().setVisible(false);
        baseForm.getViewCrop().setVisible(false);
        baseForm.getViewPest().setVisible(false);
        baseForm.getLeaderBoardView().setVisible(false);
        
        //Refresh ViewPest Details
        ViewPest viewpest = (ViewPest) baseForm.getViewPest();
        viewpest.refreshPestLabels();
        
        //Refresh ViewCrop Labels and Table
        ViewCrop viewcrop = (ViewCrop) baseForm.getViewCrop();
        viewcrop.refreshCropLabels();
        viewcrop.refreshTable();
        
        //Refresh ViewField Labels and Table
        ViewField viewfield = (ViewField) baseForm.getViewField();
        viewfield.refreshCropTable();
        viewfield.refreshWeatherTable();
        viewfield.refreshFieldLabels();
        viewfield.updateYields();
        
        //Refresh Dashboard Labels and Table
        Dashboard board = (Dashboard) baseForm.getDashBoard();
        board.refreshFarmerLabels();
        board.refreshTable();
        
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resourcse/Bar Overlay.png")));
    }//GEN-LAST:event_dashboardActionPerformed

    //Leaderboard
    private void leaderboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaderboardActionPerformed
        // Show the Leaderboard panel and hide the Dashboard panel
        baseForm.getLeaderBoard().setVisible(true);
        
        baseForm.getViewField().setVisible(false);
        baseForm.getDashBoard().setVisible(false);
        baseForm.getViewCrop().setVisible(false);
        baseForm.getViewPest().setVisible(false);
        baseForm.getLeaderBoardView().setVisible(false);
        
        //Refresh Table
        Leaderboard board = (Leaderboard) baseForm.getLeaderBoard();
        board.refreshTable();
        
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resourcse/Bar Overlay Inverted.png")));
    }//GEN-LAST:event_leaderboardActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        JFrame base = (JFrame) SwingUtilities.getWindowAncestor(this);
        
        int option = JOptionPane.showConfirmDialog(null,
            "Do you want to continue to Log Out?",
            "Confirmation",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.ERROR_MESSAGE);
        if(option == JOptionPane.YES_OPTION){
            base.dispose();
            Login login = new Login();
            login.setVisible(true);
        }
    }//GEN-LAST:event_logoutActionPerformed
      
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MenuBar;
    private javax.swing.JButton dashboard;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton leaderboard;
    private javax.swing.JButton logout;
    // End of variables declaration//GEN-END:variables
}

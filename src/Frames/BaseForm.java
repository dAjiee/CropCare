/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import CRUD.FarmerCRUD;
import Source.Farmer;
import javax.swing.JPanel;

/**
 *
 * @author Alexander
 */
public class BaseForm extends javax.swing.JFrame {

    public static int farmerid;
    public static Farmer farmer = new Farmer("", "", "", 0, 0);
    public static int num;
    
    public BaseForm (int farmerid) {
        //Get Farmer ID
        BaseForm.farmerid = farmerid;
        num = 320;
        
        //Get Farmer from Farmer ID
        for(Farmer farmer : FarmerCRUD.farmerList){
            if(farmer.getId() == farmerid){
                this.farmer = farmer;
                break;
            }
        }
        
        //Frame Call
        initComponents();
        
        //Initial setVisible
        leaderboard1.setVisible(false);
        viewField1.setVisible(false);
        viewCrop1.setVisible(false);
        viewPest1.setVisible(false);
        leaderBoardView1.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        board1 = new Panels.Board(this);
        dashboard1 = new Panels.Dashboard(board1, this);
        leaderboard1 = new Panels.Leaderboard(board1, this);
        viewField1 = new Panels.ViewField(board1, this);
        viewCrop1 = new Panels.ViewCrop(board1, this);
        viewPest1 = new Panels.ViewPest(board1, this);
        leaderBoardView1 = new Panels.LeaderBoardView(board1, this);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane1.setLayer(board1, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(board1);
        board1.setBounds(0, 0, 320, 600);
        jLayeredPane1.add(dashboard1);
        dashboard1.setBounds(0, 0, 960, 600);
        jLayeredPane1.setLayer(leaderboard1, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(leaderboard1);
        leaderboard1.setBounds(0, 0, 960, 600);
        jLayeredPane1.setLayer(viewField1, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(viewField1);
        viewField1.setBounds(0, 0, 960, 600);
        jLayeredPane1.add(viewCrop1);
        viewCrop1.setBounds(0, 0, 960, 600);
        jLayeredPane1.setLayer(viewPest1, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(viewPest1);
        viewPest1.setBounds(0, 0, 960, 600);
        jLayeredPane1.setLayer(leaderBoardView1, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(leaderBoardView1);
        leaderBoardView1.setBounds(0, 0, 960, 600);

        getContentPane().add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Center JFrame
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setLocationRelativeTo(null);
    }//GEN-LAST:event_formWindowOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Panels.Board board1;
    private Panels.Dashboard dashboard1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private Panels.LeaderBoardView leaderBoardView1;
    private Panels.Leaderboard leaderboard1;
    private Panels.ViewCrop viewCrop1;
    private Panels.ViewField viewField1;
    private Panels.ViewPest viewPest1;
    // End of variables declaration//GEN-END:variables

    public JPanel getLeaderBoard(){
        return leaderboard1;
    }
    public JPanel getDashBoard(){
        return dashboard1;
    }
    public JPanel getViewField(){
        return viewField1;
    }
    public JPanel getViewCrop(){
        return viewCrop1;
    }
    public JPanel getViewPest(){
        return viewPest1;
    }
    public JPanel getLeaderBoardView(){
        return leaderBoardView1;
    }
}

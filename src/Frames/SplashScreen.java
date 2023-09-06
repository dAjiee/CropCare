/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;


import javax.swing.JOptionPane;

/**
 *
 * @author Vincent Dialing
 */
public class SplashScreen extends javax.swing.JFrame {

    /**
     * Creates new form SplashScreen
     */
    public SplashScreen() {
        initComponents();
        LoadingBar.setUI(new javax.swing.plaf.basic.BasicProgressBarUI());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoadingBar = new javax.swing.JProgressBar();
        LoadingValue = new javax.swing.JLabel();
        Loading = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LoadingBar.setBackground(new java.awt.Color(204, 204, 204));
        LoadingBar.setForeground(new java.awt.Color(73, 156, 84));
        getContentPane().add(LoadingBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 960, 10));

        LoadingValue.setForeground(new java.awt.Color(73, 156, 84));
        LoadingValue.setText("0%");
        getContentPane().add(LoadingValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 570, 40, -1));

        Loading.setForeground(new java.awt.Color(73, 156, 84));
        Loading.setText("  Loading...");
        getContentPane().add(Loading, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 290, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourcse/CropCareLogo.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Loading;
    private javax.swing.JProgressBar LoadingBar;
    private javax.swing.JLabel LoadingValue;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    public void getLoadingValue(int i) {
        LoadingValue.setText(i + "%");
    }

    public void getLoading(String string) {
        Loading.setText(string);
    }

    public void getLoadingBar(int i) {
        LoadingBar.setValue(i);
    }
}

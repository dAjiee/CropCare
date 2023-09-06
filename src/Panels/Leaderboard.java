/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Panels;

import CRUD.CropCRUD;
import CRUD.FarmerCRUD;
import Frames.BaseForm;
import static Panels.Dashboard.fieldid;
import Source.Crop;
import Source.Farmer;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Vincent Dialing
 */
public class Leaderboard extends javax.swing.JPanel {
    private Board boardPanel;
    private BaseForm baseForm;
    
    public static Farmer farmer = new Farmer("", "", "", 0, 0);
    public static int farmerid;
    
    public Leaderboard(){
        initComponents();
    }
    
    public Leaderboard(Board boardPanel, BaseForm baseForm) {
        initComponents();
        Search.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        Search.repaint();
        
        this.boardPanel = boardPanel;
        this.baseForm = baseForm;
        
        //Table Sorter
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(Table.getModel());
        Table.setRowSorter(sorter);
        Search.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                filter();
                Search.repaint();
            }
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                filter();
                Search.repaint();
            }
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                filter();
                Search.repaint();
            }
            private void filter() {
                String text = Search.getText();
                int columnIndex = Sort.getSelectedIndex();
                if (text.isEmpty()) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, columnIndex));
                }
                Search.repaint();
            }
        });
        
        //Populate JTable
        populateJTable(Table);
        
        //Initially Disable Buttons
        view.setEnabled(false);
        
        //Enable Buttons When a Row is Pressed
        Table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                // Check if a row is selected
                if(Table.getSelectedRow() != -1){
                    // Enable the buttons
                    view.setEnabled(true);
                    int selectedRowIndex = Table.getSelectedRow();
                    farmerid = (int) Table.getValueAt(selectedRowIndex, 0);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        view = new javax.swing.JButton();
        Search = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        menuBarButton = new javax.swing.JButton();
        Sort = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        view.setBorderPainted(false);
        view.setContentAreaFilled(false);
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });
        add(view, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 495, 130, 50));

        Search.setBackground(new java.awt.Color(186, 189, 188));
        Search.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Search.setText("Search");
        add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 400, 30));

        searchButton.setBorderPainted(false);
        searchButton.setContentAreaFilled(false);
        add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 40, 50));

        menuBarButton.setBorderPainted(false);
        menuBarButton.setContentAreaFilled(false);
        menuBarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBarButtonActionPerformed(evt);
            }
        });
        add(menuBarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 40, 30));

        Sort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Farmer ID", "Farmer Name", "Actual Yield", "Predicted Yield" }));
        add(Sort, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 170, 30));

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Farmer ID", "Farmer Name", "Actual Yield", "Predicted Yield"
            }
        ));
        jScrollPane1.setViewportView(Table);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 840, 270));

        jLabel1.setBackground(new java.awt.Color(16, 73, 45));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(16, 73, 45));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourcse/Leaderboard.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents
    
    //Menu Bar
    private void menuBarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBarButtonActionPerformed
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
    }//GEN-LAST:event_menuBarButtonActionPerformed
    
    //View Button
    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
        //Set Fieldid
        int farmerid = (int)Table.getValueAt(Table.getSelectedRow(), 0);
        this.farmerid = farmerid;
        
        //Set Field
        for(Farmer farmer: FarmerCRUD.farmerList){
            if(farmer.getId() == farmerid){
                this.farmer = farmer;
            }
        }
        
        LeaderBoardView view = (LeaderBoardView) baseForm.getLeaderBoardView();
        view.refreshFarmerLabels();
        view.refreshTable();
        
        baseForm.getLeaderBoardView().setVisible(true);
        baseForm.getLeaderBoard().setVisible(false);
    }//GEN-LAST:event_viewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Search;
    private javax.swing.JComboBox<String> Sort;
    private javax.swing.JTable Table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton menuBarButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton view;
    // End of variables declaration//GEN-END:variables

    private void populateJTable(JTable yourJTable) {
        // Get the jTable1 model from the JTable
        DefaultTableModel model = (DefaultTableModel) yourJTable.getModel();
        
        // Inform the model that data is going to change
        model.fireTableDataChanged();
        
        // Clear the existing rows in the jTable1 model
        model.setRowCount(0);

        // Iterate through the ArrayList and add each object as a new row in the jTable1 model
        for (Farmer farmer : FarmerCRUD.farmerList) {
            int predicted = 0;
            int actual = 0;
            for(Crop crop : CropCRUD.cropList){
                if(crop.getFarmerid() == farmer.getId()){
                    predicted += crop.getPredictedyield();
                    actual += crop.getActualyield();
                }
            }
            
            Object[] rowData = {
                farmer.getId(),
                farmer.getCname(),
                actual,
                predicted,
            };
        model.addRow(rowData);
        }
        
        // Inform the model that data has changed
        model.fireTableDataChanged();
    }
    
    //Method for Refreshing Table After Updates
    public void refreshTable() {
        // Clear and repopulate the JTable with the updated data
        populateJTable(Table);
    }
    
}

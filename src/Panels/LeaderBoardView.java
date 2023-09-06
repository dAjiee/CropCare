/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Panels;

import CRUD.CropCRUD;
import CRUD.FieldCRUD;
import Frames.BaseForm;
import static Frames.BaseForm.farmer;
import Source.Crop;
import Source.Field;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class LeaderBoardView extends javax.swing.JPanel {
    //Reference to Board Panel and BaseForm
    private Board boardPanel;
    private BaseForm baseForm;
    
    //Values Chosen
    public static int fieldid;
    public static Field field = new Field("", "", 0, 0, 0, 0);
    
    //Empty Constructor
    public LeaderBoardView(){
        initComponents();
    }
    
    //Constructor
    public LeaderBoardView(Board boardPanel, BaseForm baseForm) {
        //Panel Contents
        initComponents();
        
        //Set SearchBar Border
        Search.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        Search.repaint();
        
        //Instantiate Panel and Frame
        this.baseForm = baseForm;
        this.boardPanel = boardPanel;
        
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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Search = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        menuBarButton = new javax.swing.JButton();
        Sort = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        nameCode = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        kGradientPanel3 = new com.k33ptoo.components.KGradientPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        age = new javax.swing.JLabel();
        ageCode = new javax.swing.JLabel();
        Id = new javax.swing.JLabel();
        idCode = new javax.swing.JLabel();
        contact = new javax.swing.JLabel();
        contactCode = new javax.swing.JLabel();
        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Search.setBackground(new java.awt.Color(186, 189, 188));
        Search.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Search.setText("Search");
        add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 400, 30));

        searchButton.setBorderPainted(false);
        searchButton.setContentAreaFilled(false);
        add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 40, 40));

        menuBarButton.setBorderPainted(false);
        menuBarButton.setContentAreaFilled(false);
        menuBarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBarButtonActionPerformed(evt);
            }
        });
        add(menuBarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 40, 30));

        Sort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Field ID", "Location", "Predicted Yield", "Actual Yield" }));
        add(Sort, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 330, 30));

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Field ID", "Location", "Predicted Yield", "Actual Yield"
            }
        ));
        jScrollPane1.setViewportView(Table);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 570, 230));

        nameCode.setText(Leaderboard.farmer.getCname());
        add(nameCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 180, -1));

        Name.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Name.setForeground(new java.awt.Color(0, 51, 43));
        Name.setText("Name:");
        add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, -1, -1));

        kGradientPanel3.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel3.setkBorderRadius(60);
        kGradientPanel3.setkEndColor(new java.awt.Color(102, 255, 102));
        kGradientPanel3.setkStartColor(new java.awt.Color(0, 51, 51));
        kGradientPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Overall Predicted Yield");
        kGradientPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 20));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText(Integer.toString(getOverAllPredictedYield()));
        kGradientPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 240, 60));

        add(kGradientPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, 260, 100));

        age.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        age.setForeground(new java.awt.Color(0, 51, 43));
        age.setText("Age:");
        add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, -1, -1));

        ageCode.setText(Integer.toString(Leaderboard.farmer.getAge())
        );
        add(ageCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 190, -1));

        Id.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Id.setForeground(new java.awt.Color(0, 51, 43));
        Id.setText("Farmer ID:");
        add(Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 60, -1));

        idCode.setText(Integer.toString(Leaderboard.farmer.getId()));
        add(idCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 160, -1));

        contact.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        contact.setForeground(new java.awt.Color(0, 51, 43));
        contact.setText("Contact Number:");
        add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 100, -1));

        contactCode.setText(Leaderboard.farmer.getContact());
        add(contactCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 120, -1));

        kGradientPanel2.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setkBorderRadius(60);
        kGradientPanel2.setkEndColor(new java.awt.Color(102, 255, 102));
        kGradientPanel2.setkStartColor(new java.awt.Color(0, 51, 51));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Overall Actual Yield");
        kGradientPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 20));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText(Integer.toString(getOverAllActualYield()));
        kGradientPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 230, 60));

        add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 260, 100));

        jLabel1.setBackground(new java.awt.Color(16, 73, 45));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(16, 73, 45));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourcse/Farmer Details.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    //Menu Bar (Working)
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
    
    //Get Overall Actual Yield (Working)
    private int getOverAllActualYield(){
        int actual = 0;
        for(Crop crop : CropCRUD.cropList){
            if(crop.getFarmerid() == Leaderboard.farmerid){
                actual += crop.getActualyield();
            }
        }
        return actual;
    }
    
    //Get Overall Predicted Yield (Working)
    private int getOverAllPredictedYield(){
        int predicted = 0;
            for(Crop crop : CropCRUD.cropList){
                if(crop.getFarmerid() == Leaderboard.farmerid){
                    predicted += crop.getPredictedyield();
                }
            }
            return predicted;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Id;
    private javax.swing.JLabel Name;
    private javax.swing.JTextField Search;
    private javax.swing.JComboBox<String> Sort;
    private javax.swing.JTable Table;
    private javax.swing.JLabel age;
    private javax.swing.JLabel ageCode;
    private javax.swing.JLabel contact;
    private javax.swing.JLabel contactCode;
    private javax.swing.JLabel idCode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private com.k33ptoo.components.KGradientPanel kGradientPanel3;
    private javax.swing.JButton menuBarButton;
    private javax.swing.JLabel nameCode;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables

    //Method For Populating Table (Working)
    public void populateJTable(JTable yourJTable) {
        // Get the jTable1 model from the JTable
        DefaultTableModel model = (DefaultTableModel) yourJTable.getModel();
        
        // Inform the model that data is going to change
        model.fireTableDataChanged();
        
        // Clear the existing rows in the jTable1 model
        model.setRowCount(0);

        // Iterate through the ArrayList and add each object as a new row in the jTable1 model
        for (Field field : FieldCRUD.fieldList) {
            if(field.getFarmerid() != Leaderboard.farmerid){continue;}
            Object[] rowData = {
                field.getId(),
                field.getLocation(),
                field.getPredictedyield(),
                field.getActualyield(),
            };
        model.addRow(rowData);
        }
        
        // Inform the model that data has changed
        model.fireTableDataChanged();
    }
    
    //Method for Refreshing Table After Updates (Working)
    public void refreshTable() {
        // Clear and repopulate the JTable with the updated data
        populateJTable(Table);
    }
    
    //Refresh Farmer Labels (Working)
    public void refreshFarmerLabels() {
        //Farmer Details
        nameCode.setText(Leaderboard.farmer.getFname() + " " + Leaderboard.farmer.getLname());
        ageCode.setText(Integer.toString(Leaderboard.farmer.getAge()));
        contactCode.setText(Leaderboard.farmer.getContact());
        idCode.setText(Integer.toString(Leaderboard.farmer.getId()));
        
        //Update Overall Actual Yield and Overall Predicted Yield
        jLabel2.setText(Integer.toString(getOverAllActualYield()));
        jLabel5.setText(Integer.toString(getOverAllPredictedYield()));
    }
}

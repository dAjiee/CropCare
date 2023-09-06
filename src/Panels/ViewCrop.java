/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Panels;

import AddForms.AddPest;
import CRUD.PestCRUD;
import FileHandler.PestFile;
import Frames.BaseForm;
import Source.Pest;
import Update.UpdateCrop;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ViewCrop extends javax.swing.JPanel {
    //Reference to Board Panel and BaseForm
    private Board boardPanel;
    private BaseForm baseForm;

    //Values Chosen
    public static int pestid;
    public static Pest pest = new Pest("", "", "", "", 0, 0, 0, 0);
    
    //Empty Constructor
    public ViewCrop(){
        initComponents();
    }
    
    //Constructor
    public ViewCrop(Board boardPanel, BaseForm baseForm) {
        //Panel Components
        initComponents();
        
        //Instantiate BaseForm and Panel
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
                int columnIndex = sort.getSelectedIndex();
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
        delete.setEnabled(false);
        
        //Enable Buttons When a Row is Pressed
        Table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                // Check if a row is selected
                if(Table.getSelectedRow() != -1){
                    // Enable the buttons
                    view.setEnabled(true);
                    delete.setEnabled(true);
                }
            }
        });
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sort = new javax.swing.JComboBox<>();
        cropsearchButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        dashboardButton = new javax.swing.JButton();
        updateInformations = new javax.swing.JButton();
        add = new javax.swing.JButton();
        view = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Search = new javax.swing.JTextField();
        kGradientPanel3 = new com.k33ptoo.components.KGradientPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Crop Name", "Growth Period", "Pest" }));
        add(sort, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, 190, 30));

        cropsearchButton1.setBorderPainted(false);
        cropsearchButton1.setContentAreaFilled(false);
        add(cropsearchButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 40, 40));

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Pest ID", "Pest Name", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(Table);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, 570, 180));

        dashboardButton.setBorderPainted(false);
        dashboardButton.setContentAreaFilled(false);
        dashboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardButtonActionPerformed(evt);
            }
        });
        add(dashboardButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 40, 30));

        updateInformations.setBorderPainted(false);
        updateInformations.setContentAreaFilled(false);
        updateInformations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateInformationsActionPerformed(evt);
            }
        });
        add(updateInformations, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, 210, 40));

        add.setBorderPainted(false);
        add.setContentAreaFilled(false);
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 500, 60, 40));

        view.setBorderPainted(false);
        view.setContentAreaFilled(false);
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });
        add(view, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 500, 70, 40));

        delete.setBorderPainted(false);
        delete.setContentAreaFilled(false);
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 500, 60, 40));

        kGradientPanel2.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setkBorderRadius(60);
        kGradientPanel2.setkEndColor(new java.awt.Color(102, 255, 102));
        kGradientPanel2.setkStartColor(new java.awt.Color(0, 51, 51));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Actual Yield");
        kGradientPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 150, 20));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText(Integer.toString(ViewField.crop.getActualyield()));
        kGradientPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 190, 60));

        add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 230, 120));

        Search.setBackground(new java.awt.Color(187, 187, 187));
        Search.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Search.setForeground(new java.awt.Color(51, 51, 51));
        Search.setText("Search");
        Search.setBorder(null);
        add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 400, 40));

        kGradientPanel3.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel3.setkBorderRadius(60);
        kGradientPanel3.setkEndColor(new java.awt.Color(102, 255, 102));
        kGradientPanel3.setkStartColor(new java.awt.Color(0, 51, 51));
        kGradientPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Predicted Yield");
        kGradientPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 150, 20));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText(Integer.toString(ViewField.crop.getPredictedyield()));
        kGradientPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 190, 60));

        add(kGradientPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 230, 120));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Crop Name:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText(ViewField.crop.getName());
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 130, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Crop Description:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText(ViewField.crop.getDescription());
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 240, 390, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("Growth Period:");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setText(ViewField.crop.getGrowthperiod());
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, 130, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Plant Date:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText(ViewField.crop.getPlantdate());
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 180, 120, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Harvest Date:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 210, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText(ViewField.crop.getHarvestdate());
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 210, 140, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourcse/View Crop.png"))); // NOI18N
        jLabel1.setText("       10v/   0    ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, -1));
    }// </editor-fold>//GEN-END:initComponents
    
    //Delete Button (Working)
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int option = JOptionPane.showConfirmDialog(null,
            "Do you want to continue to Delete Pest?",
            "Confirmation",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.ERROR_MESSAGE);
        if(option == JOptionPane.YES_OPTION){
            if(Table.getSelectedRow() != -1){
                int pestid = (int)Table.getValueAt(Table.getSelectedRow(), 0);
                //Delete Pest
                for(Pest pest : PestCRUD.pestList){
                    if(pest.getFarmerid() == BaseForm.farmerid && pest.getFieldid() == Dashboard.fieldid
                            && pest.getCropid() == ViewField.cropid
                            && pest.getId() == pestid){
                        PestCRUD.deletePest(pest);
                        PestFile.write();
                        break;
                    }
                }
                refreshTable();
                refreshCropLabels();
                view.setEnabled(false);
                delete.setEnabled(false);
            }
            JOptionPane.showMessageDialog(null, "Pest Successfully deleted", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_deleteActionPerformed
    
    //Menu Bar (Working)
    private void dashboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardButtonActionPerformed
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
    }//GEN-LAST:event_dashboardButtonActionPerformed
    
    //View Pest Button (Working)
    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
        //Set Pestid
        int pestid = (int)Table.getValueAt(Table.getSelectedRow(), 0);
        this.pestid = pestid;
        //Set Pest
        for(Pest pest: PestCRUD.pestList){
            if(pest.getFarmerid() == BaseForm.farmerid 
                    && pest.getFieldid() == Dashboard.fieldid
                    && pest.getCropid() == ViewField.cropid
                    && pest.getId() == pestid){
                this.pest = pest;
            }
        }
        
        ViewPest view = (ViewPest) baseForm.getViewPest();
        view.refreshPestLabels();
        
        baseForm.getViewCrop().setVisible(false);
        baseForm.getViewPest().setVisible(true);
    }//GEN-LAST:event_viewActionPerformed
    
    //Add Button (Working)
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        AddPest add = new AddPest();
        add.setVisible(true);
        add.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e) {
                Table.clearSelection();
                view.setEnabled(false);
                delete.setEnabled(false);
                refreshTable();
                refreshCropLabels();
            }
        });
    }//GEN-LAST:event_addActionPerformed
    
    //Update Crop (Working)
    private void updateInformationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateInformationsActionPerformed
        UpdateCrop update = new UpdateCrop();
        update.setVisible(true);
        update.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e) {
                refreshCropLabels();
            }
        });
    }//GEN-LAST:event_updateInformationsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Search;
    public javax.swing.JTable Table;
    private javax.swing.JButton add;
    private javax.swing.JButton cropsearchButton1;
    private javax.swing.JButton dashboardButton;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private com.k33ptoo.components.KGradientPanel kGradientPanel3;
    private javax.swing.JComboBox<String> sort;
    private javax.swing.JButton updateInformations;
    private javax.swing.JButton view;
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
        for (Pest pest : PestCRUD.pestList) {
            if(pest.getFarmerid() == BaseForm.farmerid &&
                    pest.getFieldid() == Dashboard.fieldid &&
                    pest.getCropid() == ViewField.cropid){
                Object[] rowData = {
                    pest.getId(),
                    pest.getName(),
                    pest.getDescription(),
                };
                model.addRow(rowData);
            }
        }
        
        // Inform the model that data has changed
        model.fireTableDataChanged();
    }
    
    //Method for Refreshing Table After Updates (Working)
    public void refreshTable(){
        populateJTable(Table);
    } 
    
    //Refresh Crop Labels
    public void refreshCropLabels(){
        jLabel5.setText(Integer.toString(ViewField.crop.getPredictedyield()));
        jLabel2.setText(Integer.toString(ViewField.crop.getActualyield()));
        jLabel9.setText(ViewField.crop.getName());
        jLabel10.setText(ViewField.crop.getDescription());
        jLabel15.setText(ViewField.crop.getGrowthperiod());
        jLabel8.setText(ViewField.crop.getPlantdate());
        jLabel13.setText(ViewField.crop.getHarvestdate());
    }
}

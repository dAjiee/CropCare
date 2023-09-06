/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Panels;

import AddForms.AddCrop;
import AddForms.AddWeather;
import CRUD.CropCRUD;
import CRUD.PestCRUD;
import CRUD.WeatherCRUD;
import FileHandler.CropFile;
import FileHandler.FieldFile;
import FileHandler.PestFile;
import FileHandler.WeatherFile;
import Frames.BaseForm;
import Source.Crop;
import Source.Pest;
import Source.Weather;
import Update.UpdateField;
import Update.UpdateWeather;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
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
public class ViewField extends javax.swing.JPanel {
    //Reference to Board Panel and BaseForm
    private Board boardPanel;
    private BaseForm baseForm;
    
    //Values Chosen
    public static Crop crop = new Crop("", "", "", "", "", 0, 0, 0, 0, 0);
    public static int cropid;
    
    //Chosen Weather
    public static Weather weather;
    public static int weatherid;
    
    //Empty Constructor
    public ViewField(){
        initComponents();
    }
    
    //Constructor
    public ViewField(Board boardPanel, BaseForm baseForm) {
        //Panel Components
        initComponents();
        
        //Instantiate BaseForm and Panel
        this.baseForm = baseForm;
        this.boardPanel = boardPanel;
        
        //For Crop
            //Table Sorter
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(cropTable.getModel());
            cropTable.setRowSorter(sorter);
            Search1.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
                public void changedUpdate(javax.swing.event.DocumentEvent e) {
                    filter();
                    Search1.repaint();
                }
                public void removeUpdate(javax.swing.event.DocumentEvent e) {
                    filter();
                    Search1.repaint();
                }
                public void insertUpdate(javax.swing.event.DocumentEvent e) {
                    filter();
                    Search1.repaint();
                }
                private void filter() {
                    String text = Search1.getText();
                    int columnIndex = cropcombobox.getSelectedIndex();
                    if (text.isEmpty()) {
                        sorter.setRowFilter(null);
                    } else {
                        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, columnIndex));
                    }
                    Search1.repaint();
                }
            });
            //Populate JTable
            populateJTableCrop(cropTable);
            //Initially Disable Buttons
            cropremoveButton.setEnabled(false);
            cropviewButton.setEnabled(false);
            //Enable Buttons When a Row is Pressed
            cropTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
                public void valueChanged(ListSelectionEvent event) {
                    // Check if a row is selected
                    if(cropTable.getSelectedRow() != -1){
                        // Enable the buttons
                        cropremoveButton.setEnabled(true);
                        cropviewButton.setEnabled(true);
                        int selectedRowIndex = cropTable.getSelectedRow();
                        cropid = (int) cropTable.getValueAt(selectedRowIndex, 0);
                    }
                }
            });
            
        //For Weather
            //Table Sorter
            TableRowSorter<TableModel> sorter2 = new TableRowSorter<>(weatherTable.getModel());
            weatherTable.setRowSorter(sorter2);
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
                    int columnIndex = weathercombobox.getSelectedIndex();
                    if (text.isEmpty()) {
                        sorter.setRowFilter(null);
                    } else {
                        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, columnIndex));
                    }
                    Search.repaint();
                }
            });
            //Populate JTable
            populateJTableWeather(weatherTable);  
            //Initially Disable Buttons
            weatherremoveButton.setEnabled(false);
            weatherupdateButton.setEnabled(false);
            //Enable Buttons When a Row is Pressed
            weatherTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
                public void valueChanged(ListSelectionEvent event) {
                    // Check if a row is selected
                    if(weatherTable.getSelectedRow() != -1){
                        // Enable the buttons
                        weatherremoveButton.setEnabled(true);
                        weatherupdateButton.setEnabled(true);
                        int selectedRowIndex = weatherTable.getSelectedRow();
                        weatherid = (int) weatherTable.getValueAt(selectedRowIndex, 0);
                    }
                }
            });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        weathersearchButton = new javax.swing.JButton();
        cropcombobox = new javax.swing.JComboBox<>();
        cropsearchButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        weatherTable = new javax.swing.JTable();
        Search = new javax.swing.JTextField();
        weathercombobox = new javax.swing.JComboBox<>();
        dashboardButton = new javax.swing.JButton();
        updateInformations = new javax.swing.JButton();
        cropaddButton = new javax.swing.JButton();
        weatheraddButton = new javax.swing.JButton();
        cropremoveButton = new javax.swing.JButton();
        weatherremoveButton = new javax.swing.JButton();
        cropviewButton = new javax.swing.JButton();
        weatherupdateButton = new javax.swing.JButton();
        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Search1 = new javax.swing.JTextField();
        kGradientPanel3 = new com.k33ptoo.components.KGradientPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cropTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        weathersearchButton.setBorderPainted(false);
        weathersearchButton.setContentAreaFilled(false);
        add(weathersearchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 40, 40));

        cropcombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Field ID", "Name", "Actual Yield", "Predicted Yield" }));
        add(cropcombobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 190, 30));

        cropsearchButton1.setBorderPainted(false);
        cropsearchButton1.setContentAreaFilled(false);
        add(cropsearchButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 40, 40));

        weatherTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Weather ID", "Date (MM/dd/yyyy)", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(weatherTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 340, 280, 130));

        Search.setBackground(new java.awt.Color(187, 187, 187));
        Search.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Search.setForeground(new java.awt.Color(51, 51, 51));
        Search.setText("Weather");
        Search.setBorder(null);
        add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 400, 40));

        weathercombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Weather ID", "Date", "Status" }));
        add(weathercombobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 290, 190, 30));

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

        cropaddButton.setBorderPainted(false);
        cropaddButton.setContentAreaFilled(false);
        cropaddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cropaddButtonActionPerformed(evt);
            }
        });
        add(cropaddButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 500, 60, 40));

        weatheraddButton.setBorderPainted(false);
        weatheraddButton.setContentAreaFilled(false);
        weatheraddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weatheraddButtonActionPerformed(evt);
            }
        });
        add(weatheraddButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 500, 60, 40));

        cropremoveButton.setBorderPainted(false);
        cropremoveButton.setContentAreaFilled(false);
        cropremoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cropremoveButtonActionPerformed(evt);
            }
        });
        add(cropremoveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 500, 70, 40));

        weatherremoveButton.setBorderPainted(false);
        weatherremoveButton.setContentAreaFilled(false);
        weatherremoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weatherremoveButtonActionPerformed(evt);
            }
        });
        add(weatherremoveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 500, 70, 40));

        cropviewButton.setBorderPainted(false);
        cropviewButton.setContentAreaFilled(false);
        cropviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cropviewButtonActionPerformed(evt);
            }
        });
        add(cropviewButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 500, 60, 40));

        weatherupdateButton.setBorderPainted(false);
        weatherupdateButton.setContentAreaFilled(false);
        weatherupdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weatherupdateButtonActionPerformed(evt);
            }
        });
        add(weatherupdateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 500, 60, 40));

        kGradientPanel2.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setkBorderRadius(60);
        kGradientPanel2.setkEndColor(new java.awt.Color(102, 255, 102));
        kGradientPanel2.setkStartColor(new java.awt.Color(0, 51, 51));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Total Actual Yield");
        kGradientPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 150, 20));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText(Integer.toString(getTotalActualYield()));
        kGradientPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 190, 60));

        add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 230, 120));

        Search1.setBackground(new java.awt.Color(187, 187, 187));
        Search1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Search1.setForeground(new java.awt.Color(51, 51, 51));
        Search1.setText("Crop");
        Search1.setBorder(null);
        add(Search1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 400, 40));

        kGradientPanel3.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel3.setkBorderRadius(60);
        kGradientPanel3.setkEndColor(new java.awt.Color(102, 255, 102));
        kGradientPanel3.setkStartColor(new java.awt.Color(0, 51, 51));
        kGradientPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total Predicted Yield");
        kGradientPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 150, 20));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText(Integer.toString(getTotalPredictedYield()));
        kGradientPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 190, 60));

        add(kGradientPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 230, 120));

        cropTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Crop ID", "Name", "Actual Yield", "Predicted Yield"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(cropTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, 280, 130));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Field Size:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText(Dashboard.field.getSize());
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 200, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText(Dashboard.field.getLocation());
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Field Location:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourcse/View Field.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    //Menu Bar Button (Working)
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

    //Update Field (Working)
    private void updateInformationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateInformationsActionPerformed
        UpdateField update = new UpdateField();
        update.setVisible(true);
        update.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e) {
                refreshFieldLabels();
            }
        });
    }//GEN-LAST:event_updateInformationsActionPerformed

    //Add Crop (Working)
    private void cropaddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cropaddButtonActionPerformed
        AddCrop add = new AddCrop();
        add.setVisible(true);
        add.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e) {
                cropTable.clearSelection();
                cropremoveButton.setEnabled(false);
                cropviewButton.setEnabled(false);
                refreshCropTable();
                refreshFieldLabels();
                updateYields();
            }
        });
    }//GEN-LAST:event_cropaddButtonActionPerformed
    
    //Remove Crop (Working)
    private void cropremoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cropremoveButtonActionPerformed
        int option = JOptionPane.showConfirmDialog(null,
            "Do you want to continue to Delete Crop?",
            "Confirmation",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.ERROR_MESSAGE);
        if(option == JOptionPane.YES_OPTION){
            int cropid = (int)cropTable.getValueAt(cropTable.getSelectedRow(), 0);
            
            //Delete Crop
            for(Crop crop : CropCRUD.cropList) {
                if((crop.getId() == cropid) && (crop.getFieldid() == Dashboard.fieldid)) {
                    if (crop.getFarmerid() == BaseForm.farmerid) {
                        CropCRUD.deleteCrop(crop);
                        CropFile.write();
                        break;
                    }
                }
            }
            
            //Delete Pest
            List<Pest> deletePest = new ArrayList<>();
            for(Pest pest : PestCRUD.pestList){
                if(pest.getFarmerid() == BaseForm.farmerid 
                        && pest.getFieldid() == Dashboard.fieldid
                        && pest.getCropid() == cropid){
                    deletePest.add(pest);
                }
            }
            for(Pest pest : deletePest){
                PestCRUD.deletePest(pest);  
            }
            PestFile.write();
            
            cropremoveButton.setEnabled(false);
            cropviewButton.setEnabled(false);
            refreshCropTable();
            refreshFieldLabels();
            updateYields();
            JOptionPane.showMessageDialog(null, "Crop Successfully deleted", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_cropremoveButtonActionPerformed

    //Add Weather (Working)
    private void weatheraddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weatheraddButtonActionPerformed
        AddWeather add = new AddWeather();
        add.setVisible(true);
        add.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e) {
                weatherTable.clearSelection();
                weatherremoveButton.setEnabled(false);
                weatherupdateButton.setEnabled(false);
                refreshWeatherTable();
                refreshFieldLabels();
            }
        });
    }//GEN-LAST:event_weatheraddButtonActionPerformed
    
    //Remove Weather (Working)
    private void weatherremoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weatherremoveButtonActionPerformed
        int option = JOptionPane.showConfirmDialog(null,
            "Do you want to continue to Delete Weather?",
            "Confirmation",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.ERROR_MESSAGE);
        if(option == JOptionPane.YES_OPTION){
            int weatherid = (int)weatherTable.getValueAt(weatherTable.getSelectedRow(), 0);
            for(Weather weather : WeatherCRUD.weatherList){
                if(weather.getFarmerid() == BaseForm.farmerid && weather.getFieldid() == Dashboard.fieldid
                        && weather.getId() == weatherid){
                    WeatherCRUD.deleteWeather(weather);
                    WeatherFile.write();
                    break;
                }
            }
            weatherremoveButton.setEnabled(false);
            weatherupdateButton.setEnabled(false);
            refreshWeatherTable();
            refreshFieldLabels();
            JOptionPane.showMessageDialog(null, "Weather Successfully deleted", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_weatherremoveButtonActionPerformed
    
    //View Crop (Working)
    private void cropviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cropviewButtonActionPerformed
        //Set Cropid
        int cropid = (int)cropTable.getValueAt(cropTable.getSelectedRow(), 0);
        this.cropid = cropid;
        //Set Crop
        for(Crop crop: CropCRUD.cropList){
            if(crop.getFarmerid() == BaseForm.farmerid && crop.getFieldid() == Dashboard.fieldid
                    && crop.getId() == cropid){
                this.crop = crop;
            }
        }
        
        ViewCrop view = (ViewCrop) baseForm.getViewCrop();
        view.populateJTable(view.Table);
        view.refreshCropLabels();
        
        baseForm.getViewField().setVisible(false);
        baseForm.getViewCrop().setVisible(true);
    }//GEN-LAST:event_cropviewButtonActionPerformed
    
    //Update Weather (Working)
    private void weatherupdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weatherupdateButtonActionPerformed
        //Set Fieldid
        int weatherid = (int)weatherTable.getValueAt(weatherTable.getSelectedRow(), 0);
        this.weatherid = weatherid;
        
        //Set Field
        for(Weather weather: WeatherCRUD.weatherList){
            if(weather.getFarmerid() == BaseForm.farmerid && weather.getId() == weatherid){
                this.weather = weather;
            }
        }
        
        UpdateWeather update = new UpdateWeather();
        update.setVisible(true);
        update.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e) {
                refreshFieldLabels();
                refreshWeatherTable();
            }
        });
    }//GEN-LAST:event_weatherupdateButtonActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Search;
    private javax.swing.JTextField Search1;
    public javax.swing.JTable cropTable;
    private javax.swing.JButton cropaddButton;
    private javax.swing.JComboBox<String> cropcombobox;
    private javax.swing.JButton cropremoveButton;
    private javax.swing.JButton cropsearchButton1;
    private javax.swing.JButton cropviewButton;
    private javax.swing.JButton dashboardButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private com.k33ptoo.components.KGradientPanel kGradientPanel3;
    private javax.swing.JButton updateInformations;
    public javax.swing.JTable weatherTable;
    private javax.swing.JButton weatheraddButton;
    private javax.swing.JComboBox<String> weathercombobox;
    private javax.swing.JButton weatherremoveButton;
    private javax.swing.JButton weathersearchButton;
    private javax.swing.JButton weatherupdateButton;
    // End of variables declaration//GEN-END:variables
    
    //Populate JTableCrop (Working)
    public void populateJTableCrop(JTable yourJTable){
        // Get the jTable1 model from the JTable
        DefaultTableModel model = (DefaultTableModel) yourJTable.getModel();
        
        // Inform the model that data is going to change
        model.fireTableDataChanged();
        
        // Clear the existing rows in the jTable1 model
        model.setRowCount(0);

        // Iterate through the ArrayList and add each object as a new row in the jTable1 model
        for (Crop crop : CropCRUD.cropList) {
            if(crop.getFarmerid() == BaseForm.farmerid && crop.getFieldid() == Dashboard.fieldid){
            Object[] rowData = {
                crop.getId(),
                crop.getName(),
                crop.getPredictedyield(),
                crop.getActualyield(),
            };
            model.addRow(rowData);
            }
        }
        
        // Inform the model that data has changed
        model.fireTableDataChanged();
    }
    
    //Populate JTableWeather (Working)
    public void populateJTableWeather(JTable yourJTable){
        // Get the jTable1 model from the JTable
        DefaultTableModel model = (DefaultTableModel) yourJTable.getModel();
        
        // Inform the model that data is going to change
        model.fireTableDataChanged();
        
        // Clear the existing rows in the jTable1 model
        model.setRowCount(0);

        // Iterate through the ArrayList and add each object as a new row in the jTable1 model
        for (Weather weather : WeatherCRUD.weatherList) {
            if(weather.getFarmerid() == BaseForm.farmerid && weather.getFieldid() == Dashboard.fieldid){
            Object[] rowData = {
                weather.getId(),
                weather.getDate(),
                weather.getStatus()
            };
            model.addRow(rowData);
            }
        }
        // Inform the model that data has changed
        model.fireTableDataChanged();
    }
    
    //Get Total Actual Yield (Working)
    private int getTotalActualYield(){
        int actual = 0;
        for(Crop crop : CropCRUD.cropList){
            if(crop.getFarmerid() == BaseForm.farmerid 
                    && crop.getFieldid() == Dashboard.fieldid){
                actual += crop.getActualyield();
            }
        }
        return actual;
    }
    
    //Get Total Predicted Yield (Working)
    private int getTotalPredictedYield(){
        int predicted = 0;
        for(Crop crop : CropCRUD.cropList){
            if(crop.getFarmerid() == BaseForm.farmerid
                    && crop.getFieldid() == Dashboard.fieldid){
                predicted += crop.getPredictedyield();
            }
        }
        return predicted;
    }
    
    //Refresh Crop Table (Working)
    public void refreshCropTable(){
        populateJTableCrop(cropTable);
    }
    
    //Refresh Weather Table (Working)
    public void refreshWeatherTable() {
        populateJTableWeather(weatherTable);
    }
    
    //Refresh Field Labels
    public void refreshFieldLabels() {
        jLabel5.setText(Integer.toString(getTotalPredictedYield()));
        jLabel2.setText(Integer.toString(getTotalActualYield()));
        jLabel9.setText(Dashboard.field.getLocation());
        jLabel8.setText(Dashboard.field.getSize());
    }
    
    //Update Yields (Working)
    public void updateYields(){
        Dashboard.field.setActualyield(getTotalActualYield());
        Dashboard.field.setPredictedyield(getTotalPredictedYield());
        FieldFile.write();
    }
}

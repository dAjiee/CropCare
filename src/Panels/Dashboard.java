/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Panels;

import AddForms.AddField;
import CRUD.CropCRUD;
import CRUD.FieldCRUD;
import CRUD.PestCRUD;
import CRUD.WeatherCRUD;
import FileHandler.CropFile;
import FileHandler.FieldFile;
import FileHandler.PestFile;
import FileHandler.WeatherFile;
import Frames.BaseForm;
import static Frames.BaseForm.farmer;
import Frames.Login;
import Source.Crop;
import Source.Field;
import Source.Pest;
import Source.Weather;
import Update.UpdateFarmer;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Dashboard extends javax.swing.JPanel {
    //Reference to Board Panel and BaseForm
    private Board boardPanel;
    private BaseForm baseForm;
    
    //Values Chosen
    public static int fieldid;
    public static Field field = new Field("", "", 0, 0, 0, 0);
    
    //Empty Constructor
    public Dashboard(){
        initComponents();
    }
    
    //Constructor
    public Dashboard(Board boardPanel, BaseForm baseForm) {
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
        
        //Initially Disable Buttons
        cleanButton1.setEnabled(false);
        viewButton.setEnabled(false);
        
        //Enable Buttons When a Row is Pressed
        Table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                // Check if a row is selected
                if(Table.getSelectedRow() != -1){
                    // Enable the buttons
                    cleanButton1.setEnabled(true);
                    viewButton.setEnabled(true);
                    int selectedRowIndex = Table.getSelectedRow();
                    fieldid = (int) Table.getValueAt(selectedRowIndex, 0);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addButton = new javax.swing.JButton();
        Search = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        viewButton = new javax.swing.JButton();
        updatedetailsButton = new javax.swing.JButton();
        cleanButton1 = new javax.swing.JButton();
        menuBarButton = new javax.swing.JButton();
        logoutButton1 = new javax.swing.JButton();
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

        addButton.setBorderPainted(false);
        addButton.setContentAreaFilled(false);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 130, 110, 30));

        Search.setBackground(new java.awt.Color(186, 189, 188));
        Search.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Search.setText("Search");
        add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 400, 30));

        searchButton.setBorderPainted(false);
        searchButton.setContentAreaFilled(false);
        add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 40, 40));

        viewButton.setBorderPainted(false);
        viewButton.setContentAreaFilled(false);
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });
        add(viewButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 500, 110, 40));

        updatedetailsButton.setBorderPainted(false);
        updatedetailsButton.setContentAreaFilled(false);
        updatedetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatedetailsButtonActionPerformed(evt);
            }
        });
        add(updatedetailsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 240, 40));

        cleanButton1.setBorderPainted(false);
        cleanButton1.setContentAreaFilled(false);
        cleanButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleanButton1ActionPerformed(evt);
            }
        });
        add(cleanButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 500, 110, 40));

        menuBarButton.setBorderPainted(false);
        menuBarButton.setContentAreaFilled(false);
        menuBarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBarButtonActionPerformed(evt);
            }
        });
        add(menuBarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 40, 30));

        logoutButton1.setBorderPainted(false);
        logoutButton1.setContentAreaFilled(false);
        logoutButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButton1ActionPerformed(evt);
            }
        });
        add(logoutButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, 230, 40));

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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 570, 230));

        nameCode.setText(BaseForm.farmer.getCname());
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
        kGradientPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 240, 20));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText(Integer.toString(getOverAllPredictedYield()));
        kGradientPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 240, 60));

        add(kGradientPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 440, 160, 100));

        age.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        age.setForeground(new java.awt.Color(0, 51, 43));
        age.setText("Age:");
        add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, -1, -1));

        ageCode.setText(Integer.toString(BaseForm.farmer.getAge())
        );
        add(ageCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 190, -1));

        Id.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Id.setForeground(new java.awt.Color(0, 51, 43));
        Id.setText("Farmer ID:");
        add(Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 60, -1));

        idCode.setText(Integer.toString(BaseForm.farmer.getId()));
        add(idCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 160, -1));

        contact.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        contact.setForeground(new java.awt.Color(0, 51, 43));
        contact.setText("Contact Number:");
        add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 100, -1));

        contactCode.setText(BaseForm.farmer.getContact());
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

        add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 440, 160, 100));

        jLabel1.setBackground(new java.awt.Color(16, 73, 45));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(16, 73, 45));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourcse/Farmer Details(Dashboard).png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    //Logout Button (Working)
    private void logoutButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButton1ActionPerformed
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
    }//GEN-LAST:event_logoutButton1ActionPerformed
    
    //Add Button (Working)
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        AddField add = new AddField();
        add.setVisible(true);
        add.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e) {
                Table.clearSelection();
                cleanButton1.setEnabled(false);
                viewButton.setEnabled(false);
                refreshTable();
                refreshFarmerLabels();
            }
        });
    }//GEN-LAST:event_addButtonActionPerformed
    
    //Delete Button (Working)
    private void cleanButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleanButton1ActionPerformed
        int option = JOptionPane.showConfirmDialog(null,
            "Do you want to continue to Delete Field?",
            "Confirmation",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.ERROR_MESSAGE);
        if(option == JOptionPane.YES_OPTION){
            if(Table.getSelectedRow() != -1){
                int fieldid = (int)Table.getValueAt(Table.getSelectedRow(), 0);
                
                //Delete Field
                for(Field field : FieldCRUD.fieldList){
                    if(field.getFarmerid() == BaseForm.farmerid && field.getId() == fieldid){
                        FieldCRUD.deleteField(field);
                        FieldFile.write();
                        break;
                    }
                }
                
                //Delete Crop
                List<Crop> deleteCrop = new ArrayList<>();
                for(Crop crop : CropCRUD.cropList){
                    if(crop.getFarmerid() == BaseForm.farmerid && crop.getFieldid() == fieldid){
                        deleteCrop.add(crop);
                    }
                }
                for(Crop crop : deleteCrop){
                    CropCRUD.deleteCrop(crop);
                }
                CropFile.write();
                
                //Delete Weather
                List<Weather> deleteWeather = new ArrayList<>();
                for(Weather weather : WeatherCRUD.weatherList){
                    if(weather.getFarmerid() == BaseForm.farmerid && weather.getFieldid() == fieldid){
                        deleteWeather.add(weather);
                    }
                }
                for(Weather weather : deleteWeather){
                    WeatherCRUD.deleteWeather(weather);
                }
                WeatherFile.write();
                
                //Delete Pest
                List<Pest> deletePest = new ArrayList<>();
                for(Pest pest : PestCRUD.pestList){
                    if(pest.getFarmerid() == BaseForm.farmerid && pest.getFieldid() == fieldid){
                        deletePest.add(pest);
                    }
                }
                for(Pest pest : deletePest){
                  PestCRUD.deletePest(pest);  
                }
                PestFile.write();
                
                
                refreshTable();
                refreshFarmerLabels();
                cleanButton1.setEnabled(false);
                viewButton.setEnabled(false);
            }
            JOptionPane.showMessageDialog(null, "Field Successfully deleted", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_cleanButton1ActionPerformed

    //View Field (Working)
    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
        //Set Fieldid
        int fieldid = (int)Table.getValueAt(Table.getSelectedRow(), 0);
        this.fieldid = fieldid;
        
        //Set Field
        for(Field field: FieldCRUD.fieldList){
            if(field.getFarmerid() == BaseForm.farmerid && field.getId() == fieldid){
                this.field = field;
            }
        }
        
        ViewField view = (ViewField) baseForm.getViewField();
        view.populateJTableCrop(view.cropTable);
        view.populateJTableWeather(view.weatherTable);
        view.refreshFieldLabels();
        
        baseForm.getViewField().setVisible(true);
        baseForm.getDashBoard().setVisible(false);
    }//GEN-LAST:event_viewButtonActionPerformed
    
    //Update Button (Working)
    private void updatedetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatedetailsButtonActionPerformed
        UpdateFarmer update = new UpdateFarmer();
        update.setVisible(true);
        update.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e) {
                refreshFarmerLabels();
            }
        });
    }//GEN-LAST:event_updatedetailsButtonActionPerformed
    
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
            if(crop.getFarmerid() == BaseForm.farmerid){
                actual += crop.getActualyield();
            }
        }
        return actual;
    }
    
    //Get Overall Predicted Yield (Working)
    private int getOverAllPredictedYield(){
        int predicted = 0;
            for(Crop crop : CropCRUD.cropList){
                if(crop.getFarmerid() == BaseForm.farmerid){
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
    private javax.swing.JButton addButton;
    private javax.swing.JLabel age;
    private javax.swing.JLabel ageCode;
    private javax.swing.JButton cleanButton1;
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
    private javax.swing.JButton logoutButton1;
    private javax.swing.JButton menuBarButton;
    private javax.swing.JLabel nameCode;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton updatedetailsButton;
    private javax.swing.JButton viewButton;
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
            if(field.getFarmerid() != BaseForm.farmerid){continue;}
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
        nameCode.setText(BaseForm.farmer.getFname() + " " + BaseForm.farmer.getLname());
        ageCode.setText(Integer.toString(BaseForm.farmer.getAge()));
        contactCode.setText(BaseForm.farmer.getContact());
        idCode.setText(Integer.toString(BaseForm.farmer.getId()));
        
        //Update Overall Actual Yield and Overall Predicted Yield
        jLabel2.setText(Integer.toString(getOverAllActualYield()));
        jLabel5.setText(Integer.toString(getOverAllPredictedYield()));
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileHandler;

import CRUD.FarmerCRUD;
import Source.Farmer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexander
 */
public class FarmerFile {
    private static final String filename = "Farmer.txt";

    public static void read() {
        try (BufferedReader bufferedreader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = bufferedreader.readLine()) != null) {
                if (line.isEmpty() || line.isBlank() || line.charAt(0) == ';') { continue; }
                String[] arr = line.split(";");
                if(arr.length != 5){
                    continue; // skips lines that do not have exactly 5 fields
                }
                int id = Integer.parseInt(arr[0]);
                String fname = arr[1];
                String lname = arr[2];
                String contact = arr[3];
                int age = Integer.parseInt(arr[4]);
                Farmer farmer = new Farmer(fname, lname, contact, id, age);
                FarmerCRUD.createFarmer(farmer);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error Reading File!\n" + Arrays.toString(e.getStackTrace()), "Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    public static void write() {
        try (FileWriter filewriter = new FileWriter(filename)) {
            for (Farmer farmer : FarmerCRUD.farmerList) {
                filewriter.write(farmer.toString());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error Updating File!\n" + Arrays.toString(e.getStackTrace()), "Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}

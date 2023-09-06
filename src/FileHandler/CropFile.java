/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileHandler;

import CRUD.CropCRUD;
import Source.Crop;
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
public class CropFile {
    private static final String filename = "Crop.txt";

    public static void read() {
        try (BufferedReader bufferedreader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = bufferedreader.readLine()) != null) {
                if (line.isEmpty() || line.isBlank() || line.charAt(0) == ';') { continue; }
                String[] arr = line.split(";");
                if(arr.length != 10){
                    continue; // skips lines that do not have exactly 10 fields
                }
                int farmerid = Integer.parseInt(arr[0]);
                int fieldid = Integer.parseInt(arr[1]);
                int id = Integer.parseInt(arr[2]);
                String name = arr[3];
                String description = arr[4];
                String growthperiod = arr[5];
                String plantdate = arr[6];
                String harvestdate = arr[7];
                int predictedyield = Integer.parseInt(arr[8]);
                int actualyield = Integer.parseInt(arr[9]);
                Crop crop = new Crop(name, description, growthperiod, plantdate, harvestdate, farmerid, fieldid, id, predictedyield, actualyield);
                CropCRUD.createCrop(crop);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error Reading File!\n" + Arrays.toString(e.getStackTrace()), "Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }



    public static void write() {
        try (FileWriter filewriter = new FileWriter(filename)) {
            for (Crop crop : CropCRUD.cropList) {
                filewriter.write(crop.toString());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error Updating File!\n" + Arrays.toString(e.getStackTrace()), "Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}

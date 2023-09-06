/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileHandler;

import CRUD.PestCRUD;
import Source.Pest;
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
public class PestFile {
    private static final String filename = "Pest.txt";

    public static void read() {
        try (BufferedReader bufferedreader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = bufferedreader.readLine()) != null) {
                if (line.isEmpty() || line.isBlank() || line.charAt(0) == ';') { continue; }
                String[] arr = line.split(";");
                if(arr.length != 8){
                    continue; // skips lines that do not have exactly 8 fields
                }
                int farmerid = Integer.parseInt(arr[0]);
                int fieldid = Integer.parseInt(arr[1]);
                int cropid = Integer.parseInt(arr[2]);
                int id = Integer.parseInt(arr[3]);
                String name = arr[4];
                String description = arr[5];
                String symptoms = arr[6];
                String prevention = arr[7];
                Pest pest = new Pest(name, description, symptoms, prevention, farmerid, fieldid, cropid, id);
                PestCRUD.createPest(pest);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error Reading File!\n" + Arrays.toString(e.getStackTrace()), "Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }



    public static void write() {
        try (FileWriter filewriter = new FileWriter(filename)) {
            for (Pest pest : PestCRUD.pestList) {
                filewriter.write(pest.toString());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error Updating File!\n" + Arrays.toString(e.getStackTrace()), "Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}

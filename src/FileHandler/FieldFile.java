/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileHandler;

import CRUD.FieldCRUD;
import Source.Field;
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
public class FieldFile {
    private static final String filename = "Field.txt";

    //reader
    public static void read(){
        try (BufferedReader bufferedreader = new BufferedReader(new FileReader(filename))){
            String line;
            while((line = bufferedreader.readLine()) != null){
                if(line.isEmpty() || line.isBlank() || line.charAt(0) == ';'){continue;}
                String[] arr = line.split(";");
                if(arr.length != 6){
                    continue; //skips lines that do not have exactly 6 fields
                }
                int farmerid = Integer.parseInt((arr[0]));
                int id = Integer.parseInt((arr[1]));
                String size = (arr[2]);
                String location = (arr[3]);
                int totalactualyield = Integer.parseInt((arr[4]));
                int totalpredictedyield = Integer.parseInt((arr[5]));
                Field field = new Field(size, location, farmerid, id, totalactualyield, totalpredictedyield);
                FieldCRUD.createField(field);
            }
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error Reading File!\n" + Arrays.toString(e.getStackTrace()), "Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);}
    }

    //writer
    public static void write(){
        try (FileWriter filewriter = new FileWriter(filename)) {
            for(Field field : FieldCRUD.fieldList){
                filewriter.write(field.toString());}
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error Updating File!\n" + Arrays.toString(e.getStackTrace()), "Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);}
    }
}

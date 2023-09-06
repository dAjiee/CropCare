/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileHandler;

import CRUD.WeatherCRUD;
import Source.Weather;
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
public class WeatherFile {
    private static final String filename = "Weather.txt";

    public static void read() {
        try (BufferedReader bufferedreader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = bufferedreader.readLine()) != null) {
                if (line.isEmpty() || line.isBlank() || line.charAt(0) == ';') { continue; }
                String[] arr = line.split(";");
                if(arr.length != 5){
                    continue; // skips lines that do not have exactly 5 fields
                }
                int farmerid = Integer.parseInt(arr[0]);
                int fieldid = Integer.parseInt(arr[1]);
                int id = Integer.parseInt(arr[2]);
                String date = arr[3];
                String status = arr[4];
                Weather weather = new Weather(date, status, id, fieldid, farmerid);
                WeatherCRUD.createWeather(weather);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error Reading File!\n" + Arrays.toString(e.getStackTrace()), "Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }


    public static void write() {
        try (FileWriter filewriter = new FileWriter(filename)) {
            for (Weather weather : WeatherCRUD.weatherList) {
                filewriter.write(weather.toString());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error Updating File!\n" + Arrays.toString(e.getStackTrace()), "Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}

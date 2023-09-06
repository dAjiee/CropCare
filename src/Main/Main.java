/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import FileHandler.CropFile;
import FileHandler.FarmerFile;
import FileHandler.FieldFile;
import FileHandler.PestFile;
import FileHandler.WeatherFile;
import Frames.Login;
import Frames.SplashScreen;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexander
 */
public class Main {
    public static void main(String[] args) {
        //Load File
        FarmerFile.read();
        CropFile.read();
        FieldFile.read();
        PestFile.read();
        WeatherFile.read();
        
        //Open SplashScreen
        SplashScreen sp = new SplashScreen();
        sp.setVisible(true);
        try{
            for(int i=0;i<=100;i++){
                Thread.sleep(5);
                sp.getLoadingValue(i);
                
                if(i==10){
                    sp.getLoading("Gathering Informations...");
                    }
                if(i==20){
                    sp.getLoading("Loading Informations...");
                    }
                if(i==50){
                    sp.getLoading("Connecting to Database...");
                    }
                if(i==70){
                    sp.getLoading("Connection Successful!");
                    }
                if(i==80){
                    sp.getLoading("Launching Crop Care...");
                    }
                sp.getLoadingBar(i);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        //Close Splashscreen
        sp.dispose();
        
        //Open Login Page
        Login login = new Login();
        login.setVisible(true);
        
        
    }
}

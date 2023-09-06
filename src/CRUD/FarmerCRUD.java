/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

import Source.Farmer;
import java.util.ArrayList;

/**
 *
 * @author Alexander
 */
public class FarmerCRUD {
    public static ArrayList<Farmer> farmerList = new ArrayList<>();

    public static void createFarmer(Farmer farmer) {
        farmerList.add(farmer);
    }

    public static Farmer retrieveFarmer(Farmer farmer) {
        for (Farmer f: farmerList) {
            if (f.equals(farmer)) return f;
        }
        return null;
    }

    public static void updateFarmer(Farmer farmer, Farmer newFarmer) {
        Farmer tempFarmer = retrieveFarmer(farmer);
        if (tempFarmer != null) {
            tempFarmer.setFname(newFarmer.getFname());
            tempFarmer.setLname(newFarmer.getLname());
            tempFarmer.setContact(newFarmer.getContact());
            tempFarmer.setId(newFarmer.getId());
            tempFarmer.setAge(newFarmer.getAge());
        }
    }

    public static void deleteFarmer(Farmer farmer) {
        boolean found = false;
        for (int i = 0; i < farmerList.size() && !found; i++) {
            found = farmerList.get(i).equals(farmer);
            if (found) {
                farmerList.remove(i);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Farmer farmer: farmerList) {
            str.append(farmer.getId()).append(";")
               .append(farmer.getFname()).append(";")
               .append(farmer.getLname()).append(";")
               .append(farmer.getContact()).append(";")
               .append(farmer.getAge()).append("\n");
        }
        return str.toString();
    }
}

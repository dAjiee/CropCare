/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

import Source.Pest;
import java.util.ArrayList;

/**
 *
 * @author Alexander
 */
public class PestCRUD {
    public static ArrayList<Pest> pestList = new ArrayList<>();

    public static void createPest(Pest pest) {
        pestList.add(pest);
    }

    public static Pest retrievePest(Pest pest) {
        for (Pest p: pestList) {
            if (p.equals(pest)) return p;
        }
        return null;
    }

    public static void updatePest(Pest pest, Pest newPest) {
        Pest tempPest = retrievePest(pest);
        if (tempPest != null) {
            tempPest.setName(newPest.getName());
            tempPest.setDescription(newPest.getDescription());
            tempPest.setSymptoms(newPest.getSymptoms());
            tempPest.setPrevention(newPest.getPrevention());
            tempPest.setFarmerid(newPest.getFarmerid());
            tempPest.setFieldid(newPest.getFieldid());
            tempPest.setCropid(newPest.getCropid());
            tempPest.setId(newPest.getId());
        }
    }

    public static void deletePest(Pest pest) {
        boolean found = false;
        for (int i = 0; i < pestList.size() && !found; i++) {
            found = pestList.get(i).equals(pest);
            if (found) {
                pestList.remove(i);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Pest pest: pestList) {
            str.append(pest.getFarmerid()).append(";")
               .append(pest.getFieldid()).append(";")
               .append(pest.getCropid()).append(";")
               .append(pest.getName()).append(";")
               .append(pest.getDescription()).append(";")
               .append(pest.getId()).append(";")
               .append(pest.getSymptoms()).append(";")
               .append(pest.getPrevention()).append("\n");
        }
        return str.toString();
    }
}

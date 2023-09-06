/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

import Source.Crop;
import java.util.ArrayList;

/**
 *
 * @author Alexander
 */
public class CropCRUD {
    public static ArrayList<Crop> cropList = new ArrayList<>();

    public static void createCrop(Crop crop) {
        cropList.add(crop);
    }

    public static Crop retrieveCrop(Crop crop) {
        for (Crop c: cropList) {
            if (c.equals(crop)) return c;
        }
        return null;
    }

    public static void updateCrop(Crop crop, Crop newCrop) {
        Crop tempCrop = retrieveCrop(crop);
        if (tempCrop != null) {
            tempCrop.setName(newCrop.getName());
            tempCrop.setDescription(newCrop.getDescription());
            tempCrop.setGrowthperiod(newCrop.getGrowthperiod());
            tempCrop.setPlantdate(newCrop.getPlantdate());
            tempCrop.setHarvestdate(newCrop.getHarvestdate());
            tempCrop.setFarmerid(newCrop.getFarmerid());
            tempCrop.setFieldid(newCrop.getFieldid());
            tempCrop.setId(newCrop.getId());
            tempCrop.setPredictedyield(newCrop.getPredictedyield());
            tempCrop.setActualyield(newCrop.getActualyield());
        }
    }

    public static void deleteCrop(Crop crop) {
        boolean found = false;
        for (int i = 0; i < cropList.size() && !found; i++) {
            found = cropList.get(i).equals(crop);
            if (found) {
                cropList.remove(i);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Crop crop: cropList) {
            str.append(crop.getFarmerid()).append(";")
               .append(crop.getFieldid()).append(";")
               .append(crop.getId()).append(";")
               .append(crop.getName()).append(";")
               .append(crop.getDescription()).append(";")
               .append(crop.getGrowthperiod()).append(";")
               .append(crop.getPlantdate()).append(";")
               .append(crop.getHarvestdate()).append(";")
               .append(crop.getPredictedyield()).append(";")
               .append(crop.getActualyield()).append("\n");
        }
        return str.toString();
    }
}

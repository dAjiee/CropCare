/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Source;

import java.util.Objects;

/**
 *
 * @author Alexander
 */
public class Crop extends Organism{
    private String growthperiod, plantdate, harvestdate;
    private int farmerid, fieldid, id, predictedyield, actualyield;
    
    public Crop(String name, String description, String growthperiod, String plantdate, 
                String harvestdate, int farmerid, int fieldid, int id, 
                int predictedyield, int actualyield) {
        super(name, description);
        this.growthperiod = growthperiod;
        this.plantdate = plantdate;
        this.harvestdate = harvestdate;
        this.farmerid = farmerid;
        this.fieldid = fieldid;
        this.id = id;
        this.predictedyield = predictedyield;
        this.actualyield = actualyield;
    }

    public String getGrowthperiod() {
        return growthperiod;
    }

    public void setGrowthperiod(String growthperiod) {
        this.growthperiod = growthperiod;
    }

    public String getPlantdate() {
        return plantdate;
    }

    public void setPlantdate(String plantdate) {
        this.plantdate = plantdate;
    }

    public String getHarvestdate() {
        return harvestdate;
    }

    public void setHarvestdate(String harvestdate) {
        this.harvestdate = harvestdate;
    }

    public int getFarmerid() {
        return farmerid;
    }

    public void setFarmerid(int farmerid) {
        this.farmerid = farmerid;
    }

    public int getFieldid() {
        return fieldid;
    }

    public void setFieldid(int fieldid) {
        this.fieldid = fieldid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPredictedyield() {
        return predictedyield;
    }

    public void setPredictedyield(int predictedyield) {
        this.predictedyield = predictedyield;
    }

    public int getActualyield() {
        return actualyield;
    }

    public void setActualyield(int actualyield) {
        this.actualyield = actualyield;
    }

    @Override
    public String toString() {
        return farmerid + ";" + fieldid + ";" + id + ";" + super.getName() + ";" + super.getDescription() + ";" + growthperiod + ";" + plantdate + ";" + harvestdate + ";" 
               + predictedyield + ";" + actualyield + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Crop crop = (Crop) obj;
        return farmerid == crop.farmerid &&
                id == crop.id &&
                fieldid == crop.fieldid &&
                super.getName().equalsIgnoreCase(crop.getName()) &&
                super.getDescription().equalsIgnoreCase(crop.getDescription()) &&
                predictedyield == crop.predictedyield &&
                actualyield == crop.actualyield &&
                Objects.equals(growthperiod, crop.growthperiod) &&
                Objects.equals(plantdate, crop.plantdate) &&
                Objects.equals(harvestdate, crop.harvestdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getName(), super.getDescription(),growthperiod, plantdate, harvestdate, farmerid, fieldid, id, predictedyield, actualyield);
    }
    
}

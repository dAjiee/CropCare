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
public class Pest extends Organism{
    private String symptoms, prevention;
    private int farmerid, fieldid, cropid, id;

    public Pest(String name, String description, String symptoms, String prevention,
                int farmerid, int fieldid, int cropid, int id) {
        super(name, description);
        this.symptoms = symptoms;
        this.prevention = prevention;
        this.farmerid = farmerid;
        this.fieldid = fieldid;
        this.cropid = cropid;
        this.id = id;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getPrevention() {
        return prevention;
    }

    public void setPrevention(String prevention) {
        this.prevention = prevention;
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

    public int getCropid() {
        return cropid;
    }

    public void setCropid(int cropid) {
        this.cropid = cropid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return farmerid + ";" + fieldid + ";" + cropid + ";" + id + ";" + super.getName() + ";" + super.getDescription() + ";" + symptoms + ";" + prevention + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Pest pest = (Pest) obj;
        return farmerid == pest.farmerid &&
                id == pest.id &&
                fieldid == pest.fieldid &&
                cropid == pest.cropid &&
                Objects.equals(super.getName(), pest.getName()) &&
                Objects.equals(super.getDescription(), pest.getDescription()) &&
                Objects.equals(symptoms, pest.symptoms) &&
                Objects.equals(prevention, pest.prevention);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getDescription(), super.getName(), symptoms, prevention, farmerid, fieldid, cropid, id);
    }
}

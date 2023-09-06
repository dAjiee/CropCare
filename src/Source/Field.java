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
public class Field {
    private String size, location;
    private int farmerid, id, totalactualyield, totalpredictedyield;
    
    public Field(String size, String location, int farmerid, int id, int totalactualyield, int totalpredictedyield) {
        this.size = size;
        this.location = location;
        this.farmerid = farmerid;
        this.id = id;
        this.totalactualyield = totalactualyield;
        this.totalpredictedyield = totalpredictedyield;
    }
    
    // Setters and Getters
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getFarmerid() {
        return farmerid;
    }

    public void setFarmerid(int farmerid) {
        this.farmerid = farmerid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getActualyield() {
        return totalactualyield;
    }

    public void setActualyield(int totalactualyield) {
        this.totalactualyield = totalactualyield;
    }

    public int getPredictedyield() {
        return totalpredictedyield;
    }

    public void setPredictedyield(int totalpredictedyield) {
        this.totalpredictedyield = totalpredictedyield;
    }

    @Override
    public String toString() {
        return farmerid + ";" + id + ";" + size + ";" + location + ";" + totalactualyield + ";" + totalpredictedyield + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Field field = (Field) obj;
        return farmerid == field.farmerid &&
                id == field.id &&
                totalactualyield == field.totalactualyield &&
                totalpredictedyield == field.totalpredictedyield &&
                Objects.equals(size, field.size) &&
                Objects.equals(location, field.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, location, farmerid, id, totalactualyield, totalpredictedyield);
    }
}

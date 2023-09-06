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
public class Weather {
    private String date, status;
    private int id, farmerid, fieldid;

    public Weather(String date, String status, int id, int farmerid, int fieldid) {
        this.date = date;
        this.status = status;
        this.id = id;
        this.farmerid = farmerid;
        this.fieldid = fieldid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return farmerid + ";" + fieldid + ";" + id + ";" + date + ";" + status + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Weather weather = (Weather) obj;
        return farmerid == weather.farmerid &&
                id == weather.id &&
                fieldid == weather.fieldid &&
                Objects.equals(date, weather.date) &&
                Objects.equals(status, weather.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, status, farmerid, id, fieldid);
    }
}

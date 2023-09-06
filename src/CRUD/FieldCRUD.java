/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

import Source.Field;
import java.util.ArrayList;

/**
 *
 * @author Alexander
 */
public class FieldCRUD {
    public static ArrayList<Field> fieldList = new ArrayList<>();

    public static void createField(Field field) {
        fieldList.add(field);
    }

    public static Field retrieveField(Field field) {
        for (Field f: fieldList) {
            if (f.equals(field)) return f;
        }
        return null;
    }

    public static void updateField(Field field, Field newField) {
        Field tempField = retrieveField(field);
        if (tempField != null) {
            tempField.setSize(newField.getSize());
            tempField.setLocation(newField.getLocation());
            tempField.setFarmerid(newField.getFarmerid());
            tempField.setId(newField.getId());
            tempField.setActualyield(newField.getActualyield());
            tempField.setPredictedyield(newField.getPredictedyield());
        }
    }

    public static void deleteField(Field field) {
        boolean found = false;
        for (int i = 0; i < fieldList.size() && !found; i++) {
            found = fieldList.get(i).equals(field);
            if (found) {
                fieldList.remove(i);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Field field: fieldList) {
            str.append(field.getFarmerid()).append(";")
               .append(field.getId()).append(";")
               .append(field.getSize()).append(";")
               .append(field.getLocation()).append(";")
               .append(field.getActualyield()).append(";")
               .append(field.getPredictedyield()).append("\n");
        }
        return str.toString();
    }
}

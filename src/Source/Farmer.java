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
public class Farmer {
    private String fname, lname, contact;
    private int id, age;
    
    // Constructor
    public Farmer(String fname, String lname, String contact, int id, int age) {
        this.fname = fname;
        this.lname = lname;
        this.contact = contact;
        this.id = id;
        this.age = age;
    }

    public Farmer() {
        this.fname = "";
        this.lname = "";
        this.contact = "";
        this.id = 0;
        this.age = 0;
    }
    
    // Getter and Setter for 'fname'
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    // Getter and Setter for 'lname'
    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    // Getter and Setter for 'contact'
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    // Getter and Setter for 'id'
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for 'age'
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    //Get Cname
    public String getCname(){
        return fname + " " + lname;
    }
    
    @Override
    public String toString(){
        return id + ";" + fname + ";" + lname + ";" + contact + ";" + age + "\n";
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Farmer farmer = (Farmer) obj;
        return id == farmer.id &&
                age == farmer.age &&
                Objects.equals(fname, farmer.fname) &&
                Objects.equals(lname, farmer.lname) &&
                Objects.equals(contact, farmer.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fname, lname, contact, id, age);
    }
}

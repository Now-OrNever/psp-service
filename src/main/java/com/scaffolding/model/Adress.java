package com.scaffolding.model;

import jakarta.persistence.*;

@Entity
@Table(name = "jap_mapping_adress")
public class Adress {
    @Id
    private int adressID;
    private String street;
    private String city;
    private String country;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public int getAdressID() {
        return adressID;
    }

    public void setAdressID(int adressID) {
        this.adressID = adressID;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Student getStudent() {
        return student;
    }
//
    public void setStudent(Student student) {
        this.student = student;
    }

    public Adress(int adressID, String street, String city, String country, Student student) {
        this.adressID = adressID;
        this.street = street;
        this.city = city;
        this.country = country;
        this.student = student;
    }

    public Adress(){

    }

}

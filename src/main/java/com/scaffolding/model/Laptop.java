package com.scaffolding.model;

import jakarta.persistence.*;

@Entity
@Table(name = "JPA_mapping_laptop")
public class Laptop {
    @Id
    private int laptopID;
    private String modelNumber;
    private String brand;

    public Laptop() {

    }

    public Laptop(int laptopID, String modelNumber, String brand, Student student) {
        this.laptopID = laptopID;
        this.modelNumber = modelNumber;
        this.brand = brand;
        this.student = student;
    }

    public int getLaptopID() {
        return laptopID;
    }

    public void setLaptopID(int laptopID) {
        this.laptopID = laptopID;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;
}

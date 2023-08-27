package com.scaffolding.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "JPA_mapping_student")
public class Student {
    @Id
    private int studentID;
    private String studentName;
    private String about;

    // student is defined in Laptop entity
    // cascade property will save laptop details in laptop table automatically when
    // laptop will be saved in student
    // then we don't need to manually save laptop in its table
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Laptop laptop;

    // Many adresses
    @OneToMany (mappedBy = "student", cascade = CascadeType.ALL)
    private List<Adress> adressList = new ArrayList<>();




    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }
    public List<Adress> getAdressList() {
        return adressList;
    }

    public void setAdressList(List<Adress> adressList) {
        this.adressList = adressList;
    }

    public Student(){

    }

    public Student(int studentID, String studentName, String about, Laptop laptop, List<Adress> adressList) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.about = about;
        this.laptop = laptop;
        this.adressList = adressList;
    }
}

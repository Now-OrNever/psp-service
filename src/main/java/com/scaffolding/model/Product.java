package com.scaffolding.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jpa_mapping_product")
public class Product {
    @Id
    private String pId;
    private String pName;
    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private List<Category> categoryList = new ArrayList<>();

    public Product() {

    }

    public Product(String pId, String pName) {
        this.pId = pId;
        this.pName = pName;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

}

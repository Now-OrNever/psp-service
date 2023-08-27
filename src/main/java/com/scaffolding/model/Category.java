package com.scaffolding.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jpa_mapping_category")
public class Category {
        @Id
        private String cId;
        private String title;
        @ManyToMany(mappedBy = "categoryList", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        @Fetch(FetchMode.JOIN)
        private List<Product> productList = new ArrayList<>();

        public Category(String cId, String title) {
                this.cId = cId;
                this.title = title;
        }


        public Category() {
        }

        public String getcId() {
                return cId;
        }

        public void setcId(String cId) {
                this.cId = cId;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public List<Product> getProductList() {
                return productList;
        }

        public void setProductList(List<Product> productList) {
                this.productList = productList;
        }
}

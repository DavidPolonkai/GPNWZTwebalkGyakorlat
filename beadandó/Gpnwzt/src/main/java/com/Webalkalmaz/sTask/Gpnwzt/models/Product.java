package com.Webalkalmaz.sTask.Gpnwzt.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pname;
    private int prodprice;
    private Long sizeclass;


    public Product() {
    }

    public Product(Long id, String pname, int prodprice, Long sizeclass) {
        this.id = id;
        this.pname = pname;
        this.prodprice = prodprice;
        this.sizeclass = sizeclass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getProdprice() {
        return prodprice;
    }

    public void setProdprice(int prodprice) {
        this.prodprice = prodprice;
    }

    public Long getSizeclass() {
        return sizeclass;
    }

    public void setSizeclass(Long sizeclass) {
        this.sizeclass = sizeclass;
    }


}

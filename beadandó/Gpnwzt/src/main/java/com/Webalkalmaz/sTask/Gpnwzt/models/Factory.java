package com.Webalkalmaz.sTask.Gpnwzt.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Factory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fname;
    private int size;
    private String city;

    public Factory(Long id, String fname, int size, String city) {
        this.id = id;
        this.fname = fname;
        this.size = size;
        this.city = city;
    }

    public Factory() {
        this.id=null;
        this.fname=null;
        this.size=0;
        this.city=null;
    }

    public void setFname(String name) {
        this.fname = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

 
 
}

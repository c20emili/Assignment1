package com.example.appproject;

import com.google.gson.annotations.SerializedName;

public class Lake {
    @SerializedName("ID")
    private String id;
    private String name;
    private String company;
    private int size;
    private int cost;
    private String location;
    private String category;
    private AuxData auxdata;

    public Lake(String id, String name, String company, int size, int cost, String location, String category, AuxData auxdata) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.size = size;
        this.cost = cost;
        this.location = location;
        this.category = category;
        this.auxdata = auxdata;
    }
    public Lake(String id, String name, String company, int size, int cost, String location, String category) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.size = size;
        this.cost = cost;
        this.location = location;
        this.category = category;
        this.auxdata = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public AuxData getAuxdata() {
        return auxdata;
    }

    public void setAuxdata(AuxData auxdata) {
        this.auxdata = auxdata;
    }

    @Override
    public String toString() {
        return "" + name + " i " + location;
    }
}
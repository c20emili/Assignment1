package com.example.appproject;

public class Lake {
    private long id;
    private String name;
    private String company;
    private int size;
    private int cost;
    private String location;
    private String category;
    private AuxData auxdata;


    public Lake(long id, String name, String company, int size, int cost, String location, String category, AuxData auxdata) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.size = size;
        this.cost = cost;
        this.location = location;
        this.category = category;
        this.auxdata = auxdata;
    }

    public AuxData getAuxdata() {
        return auxdata;
    }

    public String getCategory() {
        return category;
    }

    public String getLocation() {
        return location;
    }

    public int getCost() {
        return cost;
    }

    public int getSize() {
        return size;
    }

    public String getCompany() {
        return company;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setAuxdata(AuxData auxdata) {
        this.auxdata = auxdata;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }
}

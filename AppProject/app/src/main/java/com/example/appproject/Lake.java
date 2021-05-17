package com.example.appproject;

public class Lake {
    private long ID;
    private String Name;
    private String Company;
    private int Size;
    private int Cost;
    private String Location;
    private String Category;
    private AuxData Auxdata;

    public Lake(long ID, String name, String company, int size, int cost, String location, String category, com.example.appproject.AuxData auxdata) {
        this.ID = ID;
        Name = name;
        Company = company;
        Size = size;
        Cost = cost;
        Location = location;
        Category = category;
        Auxdata = auxdata;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int size) {
        Size = size;
    }

    public int getCost() {
        return Cost;
    }

    public void setCost(int cost) {
        Cost = cost;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public com.example.appproject.AuxData getAuxData() {
        return Auxdata;
    }

    public void setAuxData(com.example.appproject.AuxData auxdata) {
        Auxdata = auxdata;
    }
}

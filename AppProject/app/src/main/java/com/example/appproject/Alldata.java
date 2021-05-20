package com.example.appproject;

public class Alldata {
    private String id;
    private String name;
    private String company;
    private int size;
    private int cost;
    private String location;
    private String category;
    private String depth;
    private String wiki;

    public Alldata(String id, String name, String company, int size, int cost, String location, String category, String depth, String wiki) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.size = size;
        this.cost = cost;
        this.location = location;
        this.category = category;
        this.depth = depth;
        this.wiki = wiki;
    }

    public String getAllId() {
        return id;
    }

    public void setAllId(String id) {
        this.id = id;
    }

    public String getAllName() {
        return name;
    }

    public void setAllName(String name) {
        this.name = name;
    }

    public String getAllCompany() {
        return company;
    }

    public void setAllCompany(String company) {
        this.company = company;
    }

    public int getAllSize() {
        return size;
    }

    public void setAllSize(int size) {
        this.size = size;
    }

    public int getAllCost() {
        return cost;
    }

    public void setAllCost(int cost) {
        this.cost = cost;
    }

    public String getAllLocation() {
        return location;
    }

    public void setAllLocation(String location) {
        this.location = location;
    }

    public String getAllCategory() {
        return category;
    }

    public void setAllCategory(String category) {
        this.category = category;
    }

    public String getAllDepth() {
        return depth;
    }

    public void setAllDepth(String depth) {
        this.depth = depth;
    }

    public String getAllWiki() {
        return wiki;
    }

    public void setAllWiki(String wiki) {
        this.wiki = wiki;
    }
}

package com.example.appproject;

import java.util.ArrayList;

public class AuxData {
    private String wiki;
    private String img;
    private ArrayList<Fish> fishes;

    public AuxData(String wiki, String img, ArrayList<Fish> fishes) {
        this.wiki = wiki;
        this.img = img;
        this.fishes = fishes;
    }

    public String getWiki() {
        return wiki;
    }

    public void setWiki(String wiki) {
        this.wiki = wiki;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public ArrayList<Fish> getFishes() {
        return fishes;
    }

    public void setFishes(ArrayList<Fish> fishes) {
        this.fishes = fishes;
    }
}

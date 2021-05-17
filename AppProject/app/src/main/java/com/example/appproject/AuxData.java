package com.example.appproject;

import java.util.ArrayList;

public class AuxData {
    private String Wiki;
    private String Img;
    private Fish fish;

    public AuxData(String wiki, String img, Fish fish) {
        Wiki = wiki;
        Img = img;
        this.fish = fish;
    }

    public String getWiki() {
        return Wiki;
    }

    public void setWiki(String wiki) {
        Wiki = wiki;
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String img) {
        Img = img;
    }

    public Fish getFish() {
        return fish;
    }

    public void setFish(Fish fish) {
        this.fish = fish;
    }
}

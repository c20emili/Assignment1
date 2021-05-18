package com.example.appproject;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AuxData {
    @SerializedName("Djup")
    private String depth;
    @SerializedName("Wiki")
    private String wiki;
    @SerializedName("Img")
    private String img;
    private Fish fish;

    public AuxData(String depth, String wiki, String img, Fish fish) {
        this.depth = depth;
        this.wiki = wiki;
        this.img = img;
        this.fish = fish;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
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

    public Fish getFish() {
        return fish;
    }

    public void setFish(Fish fish) {
        this.fish = fish;
    }
}

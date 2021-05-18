package com.example.appproject;

import com.google.gson.annotations.SerializedName;

public class AuxData {
    @SerializedName("Djup")
    private String depth;
    @SerializedName("Wiki")
    private String wiki;
    @SerializedName("Fiskar")
    private Fishes fishes;

    public AuxData(String depth, String wiki, Fishes fishes) {
        this.depth = depth;
        this.wiki = wiki;
        this.fishes = fishes;
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



    public Fishes getFishes() {
        return fishes;
    }

    public void setFishes(Fishes fishes) {
        this.fishes = fishes;
    }

    @Override
    public String toString() {
        return "Djup " + depth + "meter\n" + fishes;
    }
}

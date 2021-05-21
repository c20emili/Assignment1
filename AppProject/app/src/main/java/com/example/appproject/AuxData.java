package com.example.appproject;

import com.google.gson.annotations.SerializedName;

public class AuxData {
    @SerializedName("Djup")
    private int depth;
    @SerializedName("Wiki")
    private String wiki;

    public AuxData(int depth, String wiki) {
        this.depth = depth;
        this.wiki = wiki;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String getWiki() {
        return wiki;
    }

    public void setWiki(String wiki) {
        this.wiki = wiki;
    }


    @Override
    public String toString() {
        return ""+depth+"";
    }
}

package com.example.appproject;

import com.google.gson.annotations.SerializedName;

public class AuxData {
    @SerializedName("Djup")
    private String depth;
    @SerializedName("Wiki")
    private String wiki;

    public AuxData(String depth, String wiki) {
        this.depth = depth;
        this.wiki = wiki;
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


    @Override
    public String toString() {
        return "Djup " + depth + "meter";
    }
}

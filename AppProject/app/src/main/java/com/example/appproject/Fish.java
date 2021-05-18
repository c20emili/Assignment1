package com.example.appproject;

import com.google.gson.annotations.SerializedName;

public class Fish {
    @SerializedName("MinLength")
    private int minLength;
    @SerializedName("MaxLength")
    private int maxLength;
    @SerializedName("MinWeight")
    private int minWeight;
    @SerializedName("MaxWeight")
    private int maxWeight;
    @SerializedName("Latin")
    private String latin;

    public Fish(int minLength, int maxLength, int minWeight, int maxWeight, String latin) {
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.latin = latin;
    }

    public int getMinLength() {
        return minLength;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public int getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(int minWeight) {
        this.minWeight = minWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public String getLatin() {
        return latin;
    }

    public void setLatin(String latin) {
        this.latin = latin;
    }

    @Override
    public String toString() {
        return  latin + ":( \n" +
                "Minimum längd : " + minLength + "cm, s" +
                "Max längd : " + maxLength + "cm, " +
                "Minimum vikt : " + minWeight + "kg, " +
                "Max vikt : " + maxWeight + "kg \n)";
    }
}

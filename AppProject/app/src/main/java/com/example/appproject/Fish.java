package com.example.appproject;

public class Fish {
    private int MinLength;
    private int MaxLength;
    private int MinWeight;
    private int MaxWeight;
    private String Latin;

    public Fish(int minLength, int maxLength, int minWeight, int maxWeight, String latin) {
        MinLength = minLength;
        MaxLength = maxLength;
        MinWeight = minWeight;
        MaxWeight = maxWeight;
        Latin = latin;
    }

    public int getMinLength() {
        return MinLength;
    }

    public void setMinLength(int minLength) {
        MinLength = minLength;
    }

    public int getMaxLength() {
        return MaxLength;
    }

    public void setMaxLength(int maxLength) {
        MaxLength = maxLength;
    }

    public int getMinWeight() {
        return MinWeight;
    }

    public void setMinWeight(int minWeight) {
        MinWeight = minWeight;
    }

    public int getMaxWeight() {
        return MaxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        MaxWeight = maxWeight;
    }

    public String getLatin() {
        return Latin;
    }

    public void setLatin(String latin) {
        Latin = latin;
    }
}

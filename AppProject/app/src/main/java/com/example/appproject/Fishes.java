package com.example.appproject;

import com.google.gson.annotations.SerializedName;

public class Fishes {
    @SerializedName("Fisk1")
    private Fish fish1;
    @SerializedName("Fisk2")
    private Fish fish2;
    @SerializedName("Fisk3")
    private Fish fish3;
    @SerializedName("Fisk4")
    private Fish fish4;
    @SerializedName("Fisk5")
    private Fish fish5;

    public Fishes(Fish fish1, Fish fish2, Fish fish3, Fish fish4, Fish fish5) {
        this.fish1 = fish1;
        this.fish2 = fish2;
        this.fish3 = fish3;
        this.fish4 = fish4;
        this.fish5 = fish5;
    }

    public Fish getFish1() {
        return fish1;
    }

    public void setFish1(Fish fish1) {
        this.fish1 = fish1;
    }

    public Fish getFish2() {
        return fish2;
    }

    public void setFish2(Fish fish2) {
        this.fish2 = fish2;
    }

    public Fish getFish3() {
        return fish3;
    }

    public void setFish3(Fish fish3) {
        this.fish3 = fish3;
    }

    public Fish getFish4() {
        return fish4;
    }

    public void setFish4(Fish fish4) {
        this.fish4 = fish4;
    }

    public Fish getFish5() {
        return fish5;
    }

    public void setFish5(Fish fish5) {
        this.fish5 = fish5;
    }

    @Override
    public String toString() {
        return "Fishes{" +
                "fish1=" + fish1 +
                ", fish2=" + fish2 +
                ", fish3=" + fish3 +
                ", fish4=" + fish4 +
                ", fish5=" + fish5 +
                '}';
    }
}

package com.colanconnon.fishtrackerandroid;

import java.util.Date;

/**
 * Created by colanconnon on 7/19/15.
 */
public class FishCatch {
    private int Id;
    private double longitude;
    private double latitude;
    private int temperature;
    private double weight;
    private Date time;
    private int LakeId;

    public FishCatch() {
    }

    public FishCatch(int id, double longitude, double latitude, int temperature, double weight, Date time, int lakeId) {

        Id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.temperature = temperature;
        this.weight = weight;
        this.time = time;
        LakeId = lakeId;
    }

    public int getId() {

        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getLakeId() {
        return LakeId;
    }

    public void setLakeId(int lakeId) {
        LakeId = lakeId;
    }
}

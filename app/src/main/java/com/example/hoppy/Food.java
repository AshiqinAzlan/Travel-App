package com.example.hoppy;

public class Food {

    //declare variable
    public String details;
    public String id;
    public String imageUrl;
    public String name;
    public String location;
    public String operatinghrs;

    //set empty constructor to retrieve data from firebase

    public Food(){

    }

    //variable constructor
    public Food(String details, String id, String imageUrl, String name, String location, String operatinghrs) {
        this.details = details;
        this.id = id;
        this.imageUrl = imageUrl;
        this.name = name;
        this.location = location;
        this.operatinghrs = operatinghrs;
    }

    //variables setter and getter (Set and retrieve data to firebase)
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOperatinghrs() {
        return operatinghrs;
    }

    public void setOperatinghrs(String operatinghrs) {
        this.operatinghrs = operatinghrs;
    }
}

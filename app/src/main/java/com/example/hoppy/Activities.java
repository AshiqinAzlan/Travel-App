package com.example.hoppy;

public class Activities {
    public String details;
    public String id;
    public String imageUrl;
    public String location;
    public String name;
    public String openinghrs;
    public String price;

    public Activities(){

    }

    public Activities(String details, String id, String imageUrl, String location, String name, String openinghrs, String price) {
        this.details = details;
        this.id = id;
        this.imageUrl = imageUrl;
        this.location = location;
        this.name = name;
        this.openinghrs = openinghrs;
        this.price = price;
    }

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpeninghrs() {
        return openinghrs;
    }

    public void setOpeninghrs(String openinghrs) {
        this.openinghrs = openinghrs;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

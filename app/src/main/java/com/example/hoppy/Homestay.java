package com.example.hoppy;

public class Homestay {
    public String homestayname;
    public String imageUrl;
    public String homestaydestination;
    public String price;
    public String details;
    public String id;


    public Homestay(){

    }

    public Homestay(String homestayname, String imageUrl, String homestaydestination, String price,String details,String id) {
        this.homestayname = homestayname;
        this.imageUrl = imageUrl;
        this.homestaydestination = homestaydestination;
        this.price = price;
        this.details = details;
        this.id = id;
    }

    public String getHomestayname() {
        return homestayname;
    }

    public void setHomestayname(String homestayname) {
        this.homestayname = homestayname;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getHomestaydestination() {
        return homestaydestination;
    }

    public void setHomestaydestination(String homestaydestination) {
        this.homestaydestination = homestaydestination;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
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
}

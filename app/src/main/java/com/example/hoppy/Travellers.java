package com.example.hoppy;

public class Travellers {
    public String fName;
    public String lName;
    public String email;
    public String num;
    public String booking;
    public String homestayid;

    public Travellers(){

    }

    public Travellers(String fName, String lName, String email, String num, String booking, String homestayid) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.num = num;
        this.booking = booking;
        this.homestayid = homestayid;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getBooking() {
        return booking;
    }

    public void setBooking(String booking) {
        this.booking = booking;
    }

    public String getHomestayid() {
        return homestayid;
    }

    public void setHomestayid(String homestayid) {
        this.homestayid = homestayid;
    }
}

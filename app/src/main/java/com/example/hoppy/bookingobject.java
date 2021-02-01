package com.example.hoppy;

public class bookingobject {

    public String booking;
    public String email;
    public String fName;
    public String homestayid;
    public String lName;
    public String num;

    public bookingobject(){

    }

    public bookingobject(String booking, String email, String fName, String homestayid, String lName, String num) {
        this.booking = booking;
        this.email = email;
        this.fName = fName;
        this.homestayid = homestayid;
        this.lName = lName;
        this.num = num;
    }

    public String getBooking() {
        return booking;
    }

    public void setBooking(String booking) {
        this.booking = booking;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getHomestayid() {
        return homestayid;
    }

    public void setHomestayid(String homestayid) {
        this.homestayid = homestayid;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}

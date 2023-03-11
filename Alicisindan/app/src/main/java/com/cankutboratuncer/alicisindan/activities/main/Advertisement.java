package com.cankutboratuncer.alicisindan.activities.main;
public class Advertisement {

    // User advertisementOwner;
    // Category advertisementCategory;
    String title, description, price;
    int image;
    // int advertisementID;

    /*  after completing other classes, use this constructor instead.
        also change advertisementTest class members according to the new design

    public Advertisement(User advertisementOwner, Category advertisementCategory, String title, String description, String price, int image, int advertisementID) {
        this.advertisementOwner = advertisementOwner;
        this.advertisementCategory = advertisementCategory;
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
        this.advertisementID = advertisementID;
    }
    */

    public Advertisement(String title, String description, int image, String price) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
    }
}


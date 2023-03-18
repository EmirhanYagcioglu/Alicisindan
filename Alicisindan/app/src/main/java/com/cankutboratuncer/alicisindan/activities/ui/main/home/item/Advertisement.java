package com.cankutboratuncer.alicisindan.activities.ui.main.home.item;

public class Advertisement {

    // User advertisementOwner;
    // Category advertisementCategory;
    String title, description, price;
    int image;
    int advertisementID;

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

    public Advertisement(String title, String description, int image, String price, int advertisementID) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
        this.advertisementID = advertisementID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getAdvertisementID() {
        return advertisementID;
    }

    public void setAdvertisementID(int advertisementID) {
        this.advertisementID = advertisementID;
    }
}
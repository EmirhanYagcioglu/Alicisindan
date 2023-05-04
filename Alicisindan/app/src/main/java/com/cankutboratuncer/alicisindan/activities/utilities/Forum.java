package com.cankutboratuncer.alicisindan.activities.utilities;

public class Forum {

    String title, description, price;
    int image;
    int advertisementID;


    public Forum(String title, String description, int image, String price, int advertisementID) {
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

}

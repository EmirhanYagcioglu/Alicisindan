package com.cankutboratuncer.alicisindan.activities.utilities;

import java.util.Date;

public class ChatMessage {
    public String senderId, receiverId, message, dateTime;
    public Date dateObject;
    public String conversionId, conversionName, conversionImage;
    public String productTitle, productDescription, userId, userName, productId, location, price, image, brand;


    public void loadAdvertisement(Advertisement advertisement){
        productTitle = advertisement.getTitle();
        productDescription = advertisement.getDescription();
        userId = advertisement.getUserID();
        userName = advertisement.getUsername();
        productId = advertisement.getAdvertisementID();
        location = advertisement.getLocation();
        price = advertisement.getPrice();
        image = advertisement.getImage();
        brand = advertisement.getBrand();
    }

    public String getSenderId() {
        return senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public String getMessage() {
        return message;
    }

    public String getDateTime() {
        return dateTime;
    }

    public Date getDateObject() {
        return dateObject;
    }

    public String getConversionId() {
        return conversionId;
    }

    public String getConversionName() {
        return conversionName;
    }

    public String getConversionImage() {
        return conversionImage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getProductId() {
        return productId;
    }

    public String getLocation() {
        return location;
    }

    public String getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public String getBrand() {
        return brand;
    }
}

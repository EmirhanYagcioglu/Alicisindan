package com.cankutboratuncer.alicisindan.activities;

import com.cankutboratuncer.alicisindan.activities.ui.main.advertisement.Advertisement;

public class User {

    private String name, email, phoneNumber;
    private Advertisement[] userAdvertisements;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Advertisement[] getUserAdvertisements() {
        return userAdvertisements;
    }

    public void setUserAdvertisements(Advertisement[] userAdvertisements) {
        this.userAdvertisements = userAdvertisements;
    }
}

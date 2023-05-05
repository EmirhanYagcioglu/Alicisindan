package com.cankutboratuncer.alicisindan.activities.utilities;

public class Subcategory {

    String name;
    Category parentCategory;
    int image;

    public Subcategory(String name, Category parentCategory, int image) {
        this.name = name;
        this.parentCategory = parentCategory;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
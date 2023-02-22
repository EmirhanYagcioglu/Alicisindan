package com.alicisindan;

import java.util.ArrayList;

public class CategoryTest {
    public static ArrayList<Category> categories = createSampleCategories();
    public static ArrayList<Category> createSampleCategories() {
        ArrayList<Category> categoryArrayList= new ArrayList<>();
        categoryArrayList.add(new Category("Cars"));
        categoryArrayList.add(new Category("Houses"));
        categoryArrayList.add(new Category("Phones"));
        categoryArrayList.add(new Category("Tablets"));
        categoryArrayList.add(new Category("Home Appliances"));
        categoryArrayList.add(new Category("Laptops"));
        categoryArrayList.add(new Category("Books"));
        categoryArrayList.add(new Category("Other"));
        return categoryArrayList;
    }
}

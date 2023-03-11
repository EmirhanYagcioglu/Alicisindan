package com.example.alicisindan_v2.ui;

import com.example.alicisindan_v2.R;

import java.util.ArrayList;

public class CategoryTest {
    public static ArrayList<Category> categories = createSampleCategories();
    public static ArrayList<Category> createSampleCategories() {
        ArrayList<Category> categoryArrayList= new ArrayList<>();
        categoryArrayList.add(new Category("Cars", R.drawable.ic_launcher_background));
        categoryArrayList.add(new Category("Houses", R.drawable.ic_launcher_background));
        categoryArrayList.add(new Category("Phones", R.drawable.ic_launcher_background));
        categoryArrayList.add(new Category("Tablets", R.drawable.ic_launcher_background));
        categoryArrayList.add(new Category("Home Appliances", R.drawable.ic_launcher_background));
        categoryArrayList.add(new Category("Laptops", R.drawable.ic_launcher_background));
        categoryArrayList.add(new Category("Books", R.drawable.ic_launcher_background));
        categoryArrayList.add(new Category("Other", R.drawable.ic_launcher_background));
        return categoryArrayList;
    }
}


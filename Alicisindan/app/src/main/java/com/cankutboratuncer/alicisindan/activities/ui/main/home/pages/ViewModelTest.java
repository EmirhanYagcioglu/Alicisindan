package com.cankutboratuncer.alicisindan.activities.ui.main.home.pages;

import androidx.lifecycle.ViewModel;

import com.cankutboratuncer.alicisindan.activities.utilities.Advertisement;
import com.cankutboratuncer.alicisindan.activities.utilities.AllCategories;

import java.util.ArrayList;

public class ViewModelTest extends ViewModel {
    // Define your data variables here
    // For example:
    private ArrayList<Advertisement> advertisements;
    private ArrayList<AllCategories> categories;

    public ArrayList<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(ArrayList<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }

    public ArrayList<AllCategories> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<AllCategories> categories) {
        this.categories = categories;
    }

    // Add any other methods or variables as needed
}

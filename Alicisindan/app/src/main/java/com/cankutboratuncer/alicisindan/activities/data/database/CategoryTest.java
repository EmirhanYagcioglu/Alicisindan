package com.cankutboratuncer.alicisindan.activities.data.database;

import com.cankutboratuncer.alicisindan.R;
import com.cankutboratuncer.alicisindan.activities.utilities.Category;
import com.cankutboratuncer.alicisindan.activities.utilities.Constants;
import com.cankutboratuncer.alicisindan.activities.utilities.Subcategory;

import java.util.ArrayList;

public class CategoryTest {

    public static ArrayList<Category> categories = createCategories();
    public static ArrayList<Subcategory> subcategories = createSubCategories();
    // subcategories arraylist stores the subcategories for each category index


    public static ArrayList<Category> createCategories() {
        ArrayList<Category> categoryArrayList = new ArrayList<>();
        for ( int i = 0; i < 12; i++ )
        {
            categoryArrayList.add(new Category(Constants.categories.get(i), Constants.categoryImages.get(i)));
        }
        return categoryArrayList;
    }

    public static ArrayList<Subcategory> createSubCategories() {
        ArrayList<Subcategory> subcategoryArrayList = new ArrayList<>();
        for ( int i = 0; i < 12; i++ )
        {
            if (Constants.findSubCategory(  Constants.categories.get(i) ) != null)
            {
                for ( int j = 0; j < Constants.findSubCategory(  Constants.categories.get(i) ).size(); j++ )
                {
                    if (Constants.findSubCategory(  Constants.categories.get(i) ).get(j) != null)
                    {
                        subcategoryArrayList.add(new Subcategory(Constants.findSubCategory(  Constants.categories.get(i) ).get(j), categories.get(i), R.drawable.product_image));
                    }
                    else
                    {
                        subcategoryArrayList.add(null);
                    }
                }
            }
            else
            {
                subcategoryArrayList.add(null);
            }
        }
        return subcategoryArrayList;
    }

}
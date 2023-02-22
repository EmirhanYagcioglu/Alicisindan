package com.alicisindan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        LinearLayoutManager horizontalRecyclerViewLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        RecyclerView recyclerViewForAdvertisements = findViewById(R.id.recycler_view_advertisements);
        RecyclerView recyclerViewForCategories = findViewById(R.id.recycler_view_categories);

        ArrayList<Advertisement> advertisements = AdvertisementTest.advertisements;
        ArrayList<Category> categories = CategoryTest.categories;

        recyclerViewForCategories.setLayoutManager(horizontalRecyclerViewLayoutManager);

        AdvertisementAdapter advertisementAdapter = new AdvertisementAdapter(advertisements);
        CategoryAdapter categoryAdapter = new CategoryAdapter(categories);
        recyclerViewForAdvertisements.setAdapter(advertisementAdapter);
        recyclerViewForCategories.setAdapter(categoryAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_homepage, menu);

        MenuItem menuItem = menu.findItem(R.id.actionSearch);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Type here to search");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
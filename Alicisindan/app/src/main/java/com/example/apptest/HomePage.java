package com.example.apptest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HomePage extends AppCompatActivity {

    private ListView listView;
    private ListView advertisements;
    String[] categories = {"Car", "House", "Laptop", "Tablet", "Phone", "Home Appliances", "Book"};
    String[] ads = {"Car1", "Car2", "Car3", "Car4", "House1", "House2", "House3", "House4",
            "Tablet1", "Tablet2", "Tablet3", "Tablet4"};

    ArrayAdapter<String> arrayAdapter;
    ArrayAdapter<String> arrayAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        listView = findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                categories);
        listView.setAdapter(arrayAdapter);
        listView.setVisibility(View.GONE);

        advertisements = findViewById(R.id.advertisements);
        arrayAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                ads);
        advertisements.setAdapter(arrayAdapter2);
        advertisements.setVisibility(View.VISIBLE);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem menuItem = menu.findItem(R.id.actionSearch);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Type here to search");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                listView.setVisibility(View.GONE);
                advertisements.setVisibility(View.VISIBLE);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                arrayAdapter.getFilter().filter(newText);
                listView.setVisibility(View.VISIBLE);
                advertisements.setVisibility(View.GONE);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
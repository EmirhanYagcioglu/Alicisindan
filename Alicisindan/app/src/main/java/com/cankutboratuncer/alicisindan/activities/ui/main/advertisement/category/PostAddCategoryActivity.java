package com.cankutboratuncer.alicisindan.activities.ui.main.advertisement.category;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;

import com.cankutboratuncer.alicisindan.activities.utilities.Constants;
import com.cankutboratuncer.alicisindan.activities.utilities.LocalSave;
import com.cankutboratuncer.alicisindan.databinding.ActivityPostAddCategoryBinding;

import java.util.List;

public class PostAddCategoryActivity extends AppCompatActivity implements CategoryListener {

    private ActivityPostAddCategoryBinding binding;
    private LocalSave localSave;
    private List<String> categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPostAddCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        categories = Constants.categories;
        loadCategories();
    }

    private void loadCategories() {
        CategoryAdapter usersAdapter = new CategoryAdapter(categories, this);
        binding.categoriesRecyclerView.setAdapter(usersAdapter);
        binding.categoriesRecyclerView.setVisibility(View.VISIBLE);
        binding.categoriesRecyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(),
                DividerItemDecoration.VERTICAL));
    }

    @Override
    public void onUserClicked(String category) {
       Intent intent = new Intent(getApplicationContext(), PostAddSubCategoryActivity.class);
       intent.putExtra("category", category);
       startActivity(intent);
       finish();
    }
}
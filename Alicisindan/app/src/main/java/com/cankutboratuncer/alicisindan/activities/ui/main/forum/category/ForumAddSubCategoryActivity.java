package com.cankutboratuncer.alicisindan.activities.ui.main.forum.category;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;

import com.cankutboratuncer.alicisindan.activities.ui.main.advertisement.advertisement.PostEditActivity;
import com.cankutboratuncer.alicisindan.activities.utilities.Constants;
import com.cankutboratuncer.alicisindan.activities.utilities.LocalSave;
import com.cankutboratuncer.alicisindan.databinding.ActivityPostAddSubCategoryBinding;

import java.util.List;

public class ForumAddSubCategoryActivity extends AppCompatActivity implements ForumCategoryListener {

    private ActivityPostAddSubCategoryBinding binding;
    private String category;
    private List<String> subCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPostAddSubCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        category = intent.getStringExtra("category");
        subCategories = Constants.findSubCategory(category);
        loadSubCategories();
    }

    private void loadSubCategories() {
        ForumCategoryAdapter usersAdapter = new ForumCategoryAdapter(subCategories, this);
        binding.categoriesRecyclerView.setAdapter(usersAdapter);
        binding.categoriesRecyclerView.setVisibility(View.VISIBLE);
        binding.categoriesRecyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
    }

    @Override
    public void onUserClicked(String subCategory) {
        Intent intent = new Intent(getApplicationContext(), ForumEditActivity.class);
        intent.putExtra("category", category + "/" + subCategory);
        startActivity(intent);
        finish();
    }
}
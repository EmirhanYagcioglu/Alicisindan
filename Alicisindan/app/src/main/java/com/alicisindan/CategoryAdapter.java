package com.alicisindan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private ArrayList<Category> categories;

    public CategoryAdapter(ArrayList<Category> categories) {
        this.categories = categories;
    }

    @Override
    public int getItemCount() {
        return this.categories.size();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.bind(categories.get(position));
    }

    static class CategoryViewHolder extends RecyclerView.ViewHolder {

        private TextView categoryTitle;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            this.categoryTitle = itemView.findViewById(R.id.text_view_category_title);
        }

        public void bind(Category category) {
            this.categoryTitle.setText(category.title);
        }
    }
}

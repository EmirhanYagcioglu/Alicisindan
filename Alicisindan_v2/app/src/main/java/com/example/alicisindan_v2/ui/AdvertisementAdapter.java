package com.example.alicisindan_v2.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alicisindan_v2.R;

import java.util.ArrayList;

public class AdvertisementAdapter extends RecyclerView.Adapter<AdvertisementAdapter.AdvertisementViewHolder> {

    private ArrayList<Advertisement> advertisements;

    public AdvertisementAdapter(ArrayList<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }

    @Override
    public int getItemCount() {
        return this.advertisements.size();
    }

    @NonNull
    @Override
    public AdvertisementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_advertisement, parent, false);
        return new AdvertisementViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdvertisementViewHolder holder, int position) {
        holder.bind(advertisements.get(position));
    }

    static class AdvertisementViewHolder extends RecyclerView.ViewHolder {

        private TextView advertisementTitle;
        private ImageView advertisementImage;

        public AdvertisementViewHolder(@NonNull View itemView) {
            super(itemView);
            this.advertisementTitle = itemView.findViewById(R.id.itemAdvertisement_textView_title);
            this.advertisementImage = itemView.findViewById(R.id.itemAdvertisement_imageView_image);
        }

        public void bind(Advertisement advertisement) {
            this.advertisementTitle.setText(advertisement.title);
            this.advertisementImage.setImageResource(advertisement.image);
        }
    }
}


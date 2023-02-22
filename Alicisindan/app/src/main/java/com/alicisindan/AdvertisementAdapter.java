package com.alicisindan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        private TextView advertisementDescription;
        private ImageView advertisementImage;
        private TextView advertisementPrice;

        public AdvertisementViewHolder(@NonNull View itemView) {
            super(itemView);
            this.advertisementTitle = itemView.findViewById(R.id.text_view_advertisement_title);
            this.advertisementDescription = itemView.findViewById(R.id.text_view_advertisement_description);
            this.advertisementImage = itemView.findViewById(R.id.image_view_advertisement_image);
            this.advertisementPrice = itemView.findViewById(R.id.text_view_advertisement_price);
        }

        public void bind(Advertisement advertisement) {
            this.advertisementTitle.setText(advertisement.title);
            this.advertisementDescription.setText(advertisement.description);
            this.advertisementImage.setImageResource(advertisement.image);
            this.advertisementPrice.setText(advertisement.price);
        }
    }
}

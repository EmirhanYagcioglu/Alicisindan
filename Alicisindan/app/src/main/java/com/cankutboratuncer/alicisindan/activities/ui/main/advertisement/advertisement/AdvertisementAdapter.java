package com.cankutboratuncer.alicisindan.activities.ui.main.advertisement.advertisement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cankutboratuncer.alicisindan.R;
import com.cankutboratuncer.alicisindan.activities.utilities.Advertisement;

import java.util.ArrayList;

public class AdvertisementAdapter extends RecyclerView.Adapter<AdvertisementAdapter.AdvertisementViewHolder> {

    private final AdvertisementInterface advertisementInterface;
    ArrayList<Advertisement> advertisements;

    public AdvertisementAdapter(ArrayList<Advertisement> advertisements, AdvertisementInterface advertisementInterface) {
        this.advertisements = advertisements;
        this.advertisementInterface = advertisementInterface;
    }

    @Override
    public int getItemCount() {
        return this.advertisements.size();
    }

    @NonNull
    @Override
    public AdvertisementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_advertisement, parent, false);
        return new AdvertisementViewHolder(view, advertisementInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull AdvertisementViewHolder holder, int position) {
        holder.bind(advertisements.get(position));
    }

    static class AdvertisementViewHolder extends RecyclerView.ViewHolder {

        TextView advertisementTitle;
        ImageView advertisementImage;

        public AdvertisementViewHolder(@NonNull View itemView, AdvertisementInterface advertisementInterface) {
            super(itemView);
            this.advertisementTitle = itemView.findViewById(R.id.itemAdvertisement_textView_title);
            this.advertisementImage = itemView.findViewById(R.id.itemAdvertisement_imageView_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (advertisementInterface != null) {
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION) {
                            advertisementInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }

        public void bind(Advertisement advertisement) {
            this.advertisementTitle.setText(advertisement.getTitle());
            this.advertisementImage.setImageResource(advertisement.getImage());
        }
    }
}


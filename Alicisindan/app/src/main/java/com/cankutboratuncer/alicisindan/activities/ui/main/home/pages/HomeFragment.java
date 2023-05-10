package com.cankutboratuncer.alicisindan.activities.ui.main.home.pages;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cankutboratuncer.alicisindan.R;
import com.cankutboratuncer.alicisindan.activities.data.database.AdvertisementTest;
import com.cankutboratuncer.alicisindan.activities.data.database.CategoryTest;
import com.cankutboratuncer.alicisindan.activities.ui.main.advertisement.advertisement.AdvertisementFragment;
import com.cankutboratuncer.alicisindan.activities.ui.main.advertisement.advertisement.AdvertisementAdapter;
import com.cankutboratuncer.alicisindan.activities.ui.main.advertisement.advertisement.AdvertisementInterface;
import com.cankutboratuncer.alicisindan.activities.utilities.Advertisement;
import com.cankutboratuncer.alicisindan.activities.ui.main.advertisement.category.PostAddCategoryActivity;
import com.cankutboratuncer.alicisindan.activities.utilities.AllCategories;
import com.cankutboratuncer.alicisindan.activities.utilities.Category;
import com.cankutboratuncer.alicisindan.activities.ui.main.home.category.CategoryAdapter;
import com.cankutboratuncer.alicisindan.activities.ui.main.home.category.CategoryFragment;
import com.cankutboratuncer.alicisindan.activities.utilities.Constants;
import com.cankutboratuncer.alicisindan.activities.utilities.LocalSave;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Arrays;

import Alicisindan.Listing;

public class HomeFragment extends Fragment implements AdvertisementInterface {

    ArrayList<Advertisement> advertisements;
    ArrayList<AllCategories> categories;
    LocalSave localSave;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(int advertisementID) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        localSave = new LocalSave(getContext());
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        view.findViewById(R.id.buttonCreatePost).setOnClickListener(v -> {
            startActivity(new Intent(getContext(), PostAddCategoryActivity.class));
                });

        LinearLayoutManager horizontalRecyclerViewLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false) {
            @Override
            public boolean checkLayoutParams(RecyclerView.LayoutParams lp) {
                // force height of viewHolder here, this will override layout_height from xml
                lp.width = (int) (getWidth() / 4);
                return true;
            }
        };

        RecyclerView recyclerViewForAdvertisements = view.findViewById(R.id.homeFragment_recyclerView_advertisements);
        RecyclerView recyclerViewForCategories = view.findViewById(R.id.homeFragment_recyclerView_categories);

        advertisements = new ArrayList<>();
        try {
            Listing[] listings = Listing.searchListings(localSave.getString(Constants.KEY_USER_ID), "", "", "","", "");
                for(Listing listing : listings){
                    if(listing.getListingImages() != null){
                        Log.d("imamag", String.valueOf(listing.getListingImages().length));
                        Advertisement advertisement = new Advertisement(listing.getTitle(), listing.getDescription(), listing.getListingImages()[0], listing.getPrice(), listing.getID());
                        advertisements.add(advertisement);
                    }
                }
        } catch (Exception e) {
            Advertisement advertisementTest = new Advertisement("Test", "Test", null, "Test", "123");
            advertisements.add(advertisementTest);
        }
        categories = CategoryTest.categories;

        recyclerViewForAdvertisements.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        recyclerViewForCategories.setLayoutManager(horizontalRecyclerViewLayoutManager);

        AdvertisementAdapter advertisementAdapter = new AdvertisementAdapter(advertisements, this);
        CategoryAdapter categoryAdapter = new CategoryAdapter(categories);
        recyclerViewForAdvertisements.setAdapter(advertisementAdapter);
        recyclerViewForCategories.setAdapter(categoryAdapter);

        TextView textView_seeAll = view.findViewById(R.id.homeFragment_textView_seeAll);
        textView_seeAll.setOnClickListener(v -> {
            Fragment fragment = new CategoryFragment();
            loadFragment(fragment);
        });

        return view;
    }

    void loadFragment(Fragment fragment) {
        //to attach fragment
        getParentFragmentManager().beginTransaction().replace(R.id.mainActivity_frameLayout_main, fragment).addToBackStack(null).commit();
    }

    @Override
    public void onItemClick(int position) {
        Fragment fragment = AdvertisementFragment.newInstance(advertisements.get(position).getAdvertisementID());
        loadFragment(fragment);
    }
}
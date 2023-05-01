package com.cankutboratuncer.alicisindan.activities.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cankutboratuncer.alicisindan.R;
import com.cankutboratuncer.alicisindan.activities.data.AdvertisementTest;
import com.cankutboratuncer.alicisindan.activities.data.CategoryTest;
import com.cankutboratuncer.alicisindan.activities.ui.main.adapter.AdvertisementAdapter;
import com.cankutboratuncer.alicisindan.activities.ui.main.adapter.AdvertisementInterface;
import com.cankutboratuncer.alicisindan.activities.ui.main.adapter.CategoryAdapter;
import com.cankutboratuncer.alicisindan.activities.ui.main.item.Advertisement;
import com.cankutboratuncer.alicisindan.activities.ui.main.item.Category;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements AdvertisementInterface {

    ArrayList<Advertisement> advertisements;
    ArrayList<Category> categories;

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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

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

        advertisements = AdvertisementTest.advertisements;
        categories = CategoryTest.categories;

        recyclerViewForAdvertisements.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        recyclerViewForCategories.setLayoutManager(horizontalRecyclerViewLayoutManager);

        AdvertisementAdapter advertisementAdapter = new AdvertisementAdapter(advertisements, this);
        CategoryAdapter categoryAdapter = new CategoryAdapter(categories);
        recyclerViewForAdvertisements.setAdapter(advertisementAdapter);
        recyclerViewForCategories.setAdapter(categoryAdapter);

        TextView textView_seeAll = view.findViewById(R.id.homeFragment_textView_seeAll);
        textView_seeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new CategoryFragment();
                loadFragment(fragment);
            }
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
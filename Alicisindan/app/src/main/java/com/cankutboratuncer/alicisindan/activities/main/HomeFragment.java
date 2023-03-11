package com.cankutboratuncer.alicisindan.activities.main;

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

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        LinearLayoutManager horizontalRecyclerViewLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);

        RecyclerView recyclerViewForAdvertisements = view.findViewById(R.id.homeFragment_recyclerView_advertisements);
        RecyclerView recyclerViewForCategories = view.findViewById(R.id.homeFragment_recyclerView_categories);

        ArrayList<Advertisement> advertisements = AdvertisementTest.advertisements;
        ArrayList<Category> categories = CategoryTest.categories;

        recyclerViewForAdvertisements.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        recyclerViewForCategories.setLayoutManager(horizontalRecyclerViewLayoutManager);

        AdvertisementAdapter advertisementAdapter = new AdvertisementAdapter(advertisements);
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
        getParentFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
    }
}
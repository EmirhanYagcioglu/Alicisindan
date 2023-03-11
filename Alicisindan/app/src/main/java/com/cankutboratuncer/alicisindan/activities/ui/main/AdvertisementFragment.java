package com.cankutboratuncer.alicisindan.activities.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.cankutboratuncer.alicisindan.R;
import com.cankutboratuncer.alicisindan.activities.ui.main.adapter.AdvertisementImageSliderAdapter;

import java.util.ArrayList;

public class AdvertisementFragment extends Fragment {

    private static final String ADVERTISEMENT_ID = "Advertisement ID";

    private int advertisementID;
    private ArrayList<Integer> images = new ArrayList<>();

    public AdvertisementFragment() {
        // Required empty public constructor
    }

    public static AdvertisementFragment newInstance(int advertisementID) {
        AdvertisementFragment fragment = new AdvertisementFragment();
        Bundle args = new Bundle();
        args.putInt(ADVERTISEMENT_ID, advertisementID);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            advertisementID = getArguments().getInt(ADVERTISEMENT_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_advertisement, container, false);

        ViewPager2 advertisement_viewPager2 = view.findViewById(R.id.advertisementFragment_viewPager);
        images.add(R.drawable.ic_launcher_background);
        images.add(R.drawable.ic_launcher_foreground);
        images.add(R.drawable.ic_launcher_background);
        images.add(R.drawable.ic_launcher_foreground);
        AdvertisementImageSliderAdapter MyAdapter = new AdvertisementImageSliderAdapter(this.getContext(), images);

        advertisement_viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        advertisement_viewPager2.setAdapter(MyAdapter);
        advertisement_viewPager2.setOffscreenPageLimit(3);

        float pageMargin = getResources().getDimensionPixelOffset(com.intuit.sdp.R.dimen._24sdp);
        float pageOffset = getResources().getDimensionPixelOffset(com.intuit.sdp.R.dimen._24sdp);

        advertisement_viewPager2.setPageTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float myOffset = position * -(2 * pageOffset + pageMargin);
                if (advertisement_viewPager2.getOrientation() == ViewPager2.ORIENTATION_HORIZONTAL) {
                    if (ViewCompat.getLayoutDirection(advertisement_viewPager2) == ViewCompat.LAYOUT_DIRECTION_RTL) {
                        page.setTranslationX(-myOffset);
                    } else {
                        page.setTranslationX(myOffset);
                    }
                } else {
                    page.setTranslationY(myOffset);
                }
            }
        });

        return view;
    }
}
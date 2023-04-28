package com.cankutboratuncer.alicisindan.activities.ui.main.advertisement;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.cankutboratuncer.alicisindan.R;
import com.cankutboratuncer.alicisindan.activities.data.AdvertisementTest;
import com.cankutboratuncer.alicisindan.activities.ui.adapter.AdvertisementAdapter;
import com.cankutboratuncer.alicisindan.activities.ui.adapter.AdvertisementImageSliderAdapter;
import com.cankutboratuncer.alicisindan.activities.ui.adapter.AdvertisementInterface;
import com.cankutboratuncer.alicisindan.activities.ui.item.Advertisement;

import java.util.ArrayList;

public class AdvertisementFragment extends Fragment implements AdvertisementInterface {

    private static final String ADVERTISEMENT_ID = "Advertisement ID";
    ArrayList<Advertisement> advertisements;
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

        LinearLayoutManager horizontalRecyclerViewLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false) {
            @Override
            public boolean checkLayoutParams(RecyclerView.LayoutParams lp) {
                // force height of viewHolder here, this will override layout_height from xml
                lp.width = (int) (getWidth() / 2.5);
                return true;
            }
        };
        RecyclerView recyclerViewForAdvertisements = view.findViewById(R.id.advertisementFragment_recyclerView_relatedItems);
        advertisements = AdvertisementTest.advertisements;
        recyclerViewForAdvertisements.setLayoutManager(horizontalRecyclerViewLayoutManager);
        AdvertisementAdapter advertisementAdapter = new AdvertisementAdapter(advertisements, this);
        recyclerViewForAdvertisements.setAdapter(advertisementAdapter);

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
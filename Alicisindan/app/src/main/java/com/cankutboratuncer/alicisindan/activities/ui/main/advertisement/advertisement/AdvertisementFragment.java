package com.cankutboratuncer.alicisindan.activities.ui.main.advertisement.advertisement;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cankutboratuncer.alicisindan.R;
import com.cankutboratuncer.alicisindan.activities.ui.main.profile.database.AdvertisementTest;
import com.cankutboratuncer.alicisindan.activities.ui.login.SignInActivity;
import com.cankutboratuncer.alicisindan.activities.ui.messaging.activities.ChatActivity;
import com.cankutboratuncer.alicisindan.activities.ui.messaging.models.Advertisement;
import com.cankutboratuncer.alicisindan.activities.utilities.Constants;
import com.cankutboratuncer.alicisindan.activities.utilities.LocalSave;

import java.util.ArrayList;

public class AdvertisementFragment extends Fragment implements AdvertisementInterface {

    private static final String ADVERTISEMENT_ID = "Advertisement ID";
    ArrayList<com.cankutboratuncer.alicisindan.activities.utilities.Advertisement> advertisements;
    private int advertisementID;
    private ArrayList<Integer> images = new ArrayList<>();
    private LocalSave localSave;
    public AdvertisementFragment() {

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
        localSave = new LocalSave(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_advertisement, container, false);

        view.findViewById(R.id.buttonMessage).setOnClickListener(v -> {

            if (localSave.getBoolean(Constants.KEY_IS_SIGNED_IN)){
                Advertisement advertisement = new Advertisement();

                advertisement.title = "Samsung Galaxy Tab S8 Ultra | Az Kullanılmış";
                advertisement.userId = "123";
                advertisement.userName = "Bora Tuncer";
                advertisement.id = ADVERTISEMENT_ID;
                advertisement.location = "Ankara/ Çankaya";
                advertisement.price = "$123.1";
                advertisement.token = "ads";
                advertisement.image = "1231231";

                localSave.putString(Constants.KEY_ADVERTISEMENT_TITLE, advertisement.title);
                localSave.putString(Constants.KEY_ADVERTISEMENT_USERID, advertisement.userId);
                localSave.putString(Constants.KEY_ADVERTISEMENT_USERNAME, advertisement.userName);
                localSave.putString(Constants.KEY_ADVERTISEMENT_ID, advertisement.id);
                localSave.putString(Constants.KEY_ADVERTISEMENT_LOCATION, advertisement.location);
                localSave.putString(Constants.KEY_ADVERTISEMENT_PRICE, advertisement.price);
                localSave.putString(Constants.KEY_ADVERTISEMENT_TOKEN, advertisement.token);

                startActivity(new Intent(getContext(), ChatActivity.class));
            } else {
                showToast("You have to sign in first");
                localSave.putBoolean(Constants.KEY_IS_USER_SKIP, false);
                startActivity(new Intent(getContext(), SignInActivity.class));
            }


        });

        LinearLayoutManager horizontalRecyclerViewLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false) {
            @Override
            public boolean checkLayoutParams(RecyclerView.LayoutParams lp) {
                // force height of viewHolder here, this will override layout_height from xml
                lp.width = (int) (getWidth() / 2.5);
                return true;
            }
        };




        RecyclerView recyclerViewForAdvertisements = view.findViewById(R.id.relatedProducts);
        advertisements = AdvertisementTest.advertisements;
        recyclerViewForAdvertisements.setLayoutManager(horizontalRecyclerViewLayoutManager);
        AdvertisementAdapter advertisementAdapter = new AdvertisementAdapter(advertisements, this);
        recyclerViewForAdvertisements.setAdapter(advertisementAdapter);

//        ViewPager2 advertisement_viewPager2 = view.findViewById(R.id.advertisementFragment_viewPager);
//        images.add(R.drawable.ic_launcher_background);
//        images.add(R.drawable.ic_launcher_foreground);
//        images.add(R.drawable.ic_launcher_background);
//        images.add(R.drawable.ic_launcher_foreground);
//        AdvertisementImageSliderAdapter MyAdapter = new AdvertisementImageSliderAdapter(this.getContext(), images);
//
//        advertisement_viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
//
//        advertisement_viewPager2.setAdapter(MyAdapter);
//        advertisement_viewPager2.setOffscreenPageLimit(3);
//
//        float pageMargin = getResources().getDimensionPixelOffset(com.intuit.sdp.R.dimen._24sdp);
//        float pageOffset = getResources().getDimensionPixelOffset(com.intuit.sdp.R.dimen._24sdp);
//
//        advertisement_viewPager2.setPageTransformer((page, position) -> {
//            float myOffset = position * -(2 * pageOffset + pageMargin);
//            if (advertisement_viewPager2.getOrientation() == ViewPager2.ORIENTATION_HORIZONTAL) {
//                if (ViewCompat.getLayoutDirection(advertisement_viewPager2) == ViewCompat.LAYOUT_DIRECTION_RTL) {
//                    page.setTranslationX(-myOffset);
//                } else {
//                    page.setTranslationX(myOffset);
//                }
//            } else {
//                page.setTranslationY(myOffset);
//            }
//        });
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

    private void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

}
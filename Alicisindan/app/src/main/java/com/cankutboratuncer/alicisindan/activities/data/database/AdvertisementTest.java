package com.cankutboratuncer.alicisindan.activities.data.database;

import com.cankutboratuncer.alicisindan.R;
import com.cankutboratuncer.alicisindan.activities.utilities.Advertisement;
import com.cankutboratuncer.alicisindan.activities.utilities.Constants;
import com.cankutboratuncer.alicisindan.activities.utilities.LocalSave;

import java.util.ArrayList;
import java.util.List;

import Alicisindan.Listing;
import Alicisindan.Password;

public class AdvertisementTest {
    public static ArrayList<Advertisement> advertisements;

    static {
        try {
            advertisements = createSampleAdvertisements();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    LocalSave localSave;
    public static ArrayList<Advertisement> createSampleAdvertisements() throws Exception {
        ArrayList<Advertisement> ads = new ArrayList<>();

        Listing[] listing = Listing.searchListings(Password.emailToID("bora1@gmail.com"), "","","","", "");

//        ads.add(new Advertisement(listing[0].getOwnerID().toString(), "I want the best car of all time", R.drawable.ic_launcher_background, "5.000.000 TL", 1));
//        ads.add(new Advertisement("I want the best Car", "I want the best car of all time", R.drawable.ic_launcher_background, "5.000.000 TL", 1));
//        ads.add(new Advertisement("I want a very good car", "I want the second best car of all time", R.drawable.ic_launcher_background, "4.000.000 TL", 2));
//        ads.add(new Advertisement("I want a good car", "I want the third best car of all time", R.drawable.ic_launcher_background, "3.000.000 TL", 3));
//        ads.add(new Advertisement("I want a car", "I want the fourth best car of all time", R.drawable.ic_launcher_background, "2.000.000 TL", 4));
//        ads.add(new Advertisement("car", "I want the fifth best car of all time", R.drawable.ic_launcher_background, "1.000.000 TL", 5));
//        ads.add(new Advertisement("Classic car", "I want the best classic car of all time", R.drawable.ic_launcher_background, "20.000.000 TL", 6));
//        ads.add(new Advertisement("Fast car", "I want the fastest car of all time", R.drawable.ic_launcher_background, "8.000.000 TL", 7));
//        ads.add(new Advertisement("Flying car", "I want the best flying car of all time", R.drawable.ic_launcher_background, "100.000.000 TL", 8));
        return ads;
    }
}



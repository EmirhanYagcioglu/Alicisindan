package com.cankutboratuncer.alicisindan.activities.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import com.cankutboratuncer.alicisindan.R;

public interface SearchBar {
    public void createSearchBar(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);
    public void findFromList(String text, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);
}

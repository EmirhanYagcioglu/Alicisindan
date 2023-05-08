package com.cankutboratuncer.alicisindan.activities.ui.main.forum.forum;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cankutboratuncer.alicisindan.R;
import com.cankutboratuncer.alicisindan.activities.data.database.ForumTest;
import com.cankutboratuncer.alicisindan.activities.ui.main.advertisement.category.PostAddCategoryActivity;
import com.cankutboratuncer.alicisindan.activities.ui.main.forum.category.ForumAddCategoryActivity;
import com.cankutboratuncer.alicisindan.activities.utilities.Forum;

import java.util.ArrayList;

public class ForumFragment extends Fragment implements ForumInterface {

    ArrayList<Forum> forums;

    public ForumFragment() {
        // Required empty public constructor
    }

    public static ForumFragment newInstance(String param1, String param2) {
        ForumFragment fragment = new ForumFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_forum, container, false);
        view.findViewById(R.id.buttonCreateForumPost).setOnClickListener(v -> {
            startActivity(new Intent(getContext(), ForumAddCategoryActivity.class));
        });
        RecyclerView recyclerViewForForums = view.findViewById(R.id.recyclerViewForum);
        forums = ForumTest.forums;

        recyclerViewForForums.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        ForumAdapter forumAdapter = new ForumAdapter(forums, this);
        recyclerViewForForums.setAdapter(forumAdapter);
        return view;
    }

    void loadFragment(Fragment fragment) {
        //to attach fragment
        getParentFragmentManager().beginTransaction().replace(R.id.mainActivity_frameLayout_main, fragment).addToBackStack(null).commit();
    }

    @Override
    public void onItemClick(int position) {
        startActivity(new Intent(getContext(), ForumChatActivity.class));
    }

}
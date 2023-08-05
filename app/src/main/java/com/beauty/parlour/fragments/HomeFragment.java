package com.beauty.parlour.fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beauty.parlour.R;
import com.beauty.parlour.adapter.CategoryAdapter;
import com.beauty.parlour.model.Category;

import java.util.ArrayList;


public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    ArrayList<Category> categories = new ArrayList<>();
    Activity activity;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        activity=getActivity();

        recyclerView=root.findViewById(R.id.rv_category);
        LinearLayoutManager layoutManager =new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(layoutManager);
        categories.add(new Category("Massage","Spa Massage"));
        categories.add(new Category("HairCut","Staylish "));
        CategoryAdapter categoryAdapter=new CategoryAdapter(categories,activity);
        recyclerView.setAdapter(categoryAdapter);



        return root;
    }
}
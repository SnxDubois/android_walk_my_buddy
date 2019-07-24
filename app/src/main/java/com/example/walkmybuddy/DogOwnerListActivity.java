package com.example.walkmybuddy;

import android.app.Application;
import android.support.v4.util.Consumer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.walkmybuddy.adapter.DogWalkerAdapter;
import com.example.walkmybuddy.model.DogWalker;

import java.util.ArrayList;
import java.util.List;

public class DogOwnerListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_owner_list);
        VolleySingleton.getInstance(DogOwnerListActivity.this).getAllDogWalkers(new Consumer<List<DogWalker>>() {
            @Override
            public void accept(List<DogWalker> dogWalkerList) {
                RecyclerView mRecyclerView;
                RecyclerView.Adapter mAdapter;
                RecyclerView.LayoutManager layoutManager;
                mRecyclerView = findViewById(R.id.rvDogWalkerList);
                layoutManager = new LinearLayoutManager(getApplicationContext());
                mRecyclerView.setLayoutManager(layoutManager);
                mAdapter = new DogWalkerAdapter(dogWalkerList);
                mRecyclerView.setAdapter(mAdapter);
            }
        });

    }
}

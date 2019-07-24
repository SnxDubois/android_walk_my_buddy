package com.example.walkmybuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.Consumer;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.walkmybuddy.adapter.DogWalkerAdapter;
import com.example.walkmybuddy.model.DogWalker;
import com.example.walkmybuddy.singleton.VolleySingleton;

import java.util.List;

public class DogOwnerListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_owner_list);
        VolleySingleton.getInstance(DogOwnerListActivity.this).getAllDogWalkers(new Consumer<List<DogWalker>>() {
            @Override
            public void accept(List<DogWalker> dogWalkerList) {
                RecyclerView mRecyclerView = findViewById(R.id.rvDogWalkerList);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                mRecyclerView.setAdapter(new DogWalkerAdapter(dogWalkerList));
            }
        });
        Button logOut = findViewById(R.id.btLogOut);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DogOwnerListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

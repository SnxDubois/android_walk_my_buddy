package com.example.walkmybuddy;

import android.content.Intent;
import android.support.v4.util.Consumer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.walkmybuddy.adapter.DogAdapter;
import com.example.walkmybuddy.adapter.DogWalkerAdapter;
import com.example.walkmybuddy.model.Dog;
import com.example.walkmybuddy.model.DogWalker;
import com.example.walkmybuddy.singleton.DogWalkerSingleton;
import com.example.walkmybuddy.singleton.VolleySingleton;

import java.util.List;

public class DogWalkerListActivity extends AppCompatActivity {

    private DogWalkerSingleton dogWalkerSingleton = DogWalkerSingleton.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_walker_list);
        VolleySingleton.getInstance(DogWalkerListActivity.this).getAllDogsByWalker(dogWalkerSingleton.getDogWalker(), new Consumer<List<Dog>>() {
            @Override
            public void accept(List<Dog> dogList) {
                RecyclerView mRecyclerView = findViewById(R.id.rvDog);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                mRecyclerView.setAdapter(new DogAdapter(dogList));
            }
        });
        Button logOut = findViewById(R.id.btLogOutDogWalker);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DogWalkerListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

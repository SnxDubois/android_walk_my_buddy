package com.example.walkmybuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton registerDogOwner = findViewById(R.id.ibDogOwner);
        registerDogOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterUserActivity.class);
                intent.putExtra("isOwner", true);
                startActivity(intent);
            }
        });
        Button signInDogOwner = findViewById(R.id.btDogOwnerSignIn);
        signInDogOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignInActivity.class);
                intent.putExtra("isOwner", true);
                startActivity(intent);
            }
        });
        ImageButton registerDogWalker = findViewById(R.id.ibDogWalker);
        registerDogWalker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterUserActivity.class);
                startActivity(intent);
            }
        });
        Button signInDogWalker = findViewById(R.id.btDogWalkerSignIn);
        signInDogWalker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });
    }
}

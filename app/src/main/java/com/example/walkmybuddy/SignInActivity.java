package com.example.walkmybuddy;

import android.content.Intent;
import android.support.v4.util.Consumer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.walkmybuddy.model.DogOwner;
import com.example.walkmybuddy.model.DogWalker;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Intent intent = getIntent();
        final boolean isOwner = intent.getBooleanExtra("isOwner", false);
        Button signIn = findViewById(R.id.btSignIn);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etEmail = findViewById(R.id.etEmailSignIn);
                EditText etPpassword = findViewById(R.id.etPasswordSignIn);
                String email = etEmail.getText().toString();
                String password = etPpassword.getText().toString();
                if (isOwner) {
                    DogOwner dogOwner = new DogOwner();
                    dogOwner.setEmail(email);
                    dogOwner.setPassword(password);
                    VolleySingleton.getInstance(SignInActivity.this).dogOwnerSignIn(dogOwner, new Consumer<DogOwner>() {
                        @Override
                        public void accept(DogOwner dogOwner) {
                            DogOwnerSingleton.getInstance().setDogOwner(dogOwner);
                            Intent goToRegisterDog = new Intent(SignInActivity.this, RegisterDogActivity.class);
                            startActivity(goToRegisterDog);
                        }
                    });
                } else {
                    DogWalker dogWalker = new DogWalker();
                    dogWalker.setEmail(email);
                    dogWalker.setPassword(password);
                    VolleySingleton.getInstance(SignInActivity.this).dogWalkerSignIn(dogWalker, new Consumer<DogWalker>() {
                        @Override
                        public void accept(DogWalker dogWalker) {
                            DogWalkerSingleton.getInstance().setDogWalker(dogWalker);
                            Intent goToDogWalkerList = new Intent(SignInActivity.this, DogWalkerListActivity.class);
                            startActivity(goToDogWalkerList);
                        }
                    });
                }
            }
        });
    }
}

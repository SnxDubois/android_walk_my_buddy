package com.example.walkmybuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.Consumer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.walkmybuddy.model.DogOwner;
import com.example.walkmybuddy.model.DogWalker;
import com.example.walkmybuddy.singleton.DogOwnerSingleton;
import com.example.walkmybuddy.singleton.DogWalkerSingleton;
import com.example.walkmybuddy.singleton.VolleySingleton;

public class RegisterUserActivity extends AppCompatActivity {

    private static final int MIN_PASSWORD_LENGTH = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        Intent intent = getIntent();
        final boolean isOwner = intent.getBooleanExtra("isOwner", false);
        Button register = findViewById(R.id.btRegister);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etName = findViewById(R.id.etName);
                EditText etEmail = findViewById(R.id.etEmail);
                EditText etPassword = findViewById(R.id.etPassword);
                if (etName.getText().toString().isEmpty() || etEmail.getText().toString().isEmpty()
                        || etPassword.getText().toString().isEmpty() || etPassword.getText().toString().length() < MIN_PASSWORD_LENGTH) {
                    new AlertDialog.Builder(RegisterUserActivity.this)
                            .setTitle(R.string.error)
                            .setMessage(R.string.fill_your_details)
                            .show();
                    return;
                } else {
                    if (isOwner) {
                        DogOwner dogOwner = new DogOwner();
                        dogOwner.setName(etName.getText().toString());
                        dogOwner.setEmail(etEmail.getText().toString());
                        dogOwner.setPassword(etPassword.getText().toString());
                        VolleySingleton.getInstance(RegisterUserActivity.this).dogOwnerSignUp(dogOwner, new Consumer<DogOwner>() {
                            @Override
                            public void accept(DogOwner dogOwner) {
                                DogOwnerSingleton.getInstance().setDogOwner(dogOwner);
                                Intent intent = new Intent(RegisterUserActivity.this, RegisterDogActivity.class);
                                startActivity(intent);
                            }
                        });
                    } else {
                        DogWalker dogWalker = new DogWalker();
                        dogWalker.setName(etName.getText().toString());
                        dogWalker.setEmail(etEmail.getText().toString());
                        dogWalker.setPassword(etPassword.getText().toString());
                        VolleySingleton.getInstance(RegisterUserActivity.this).dogWalkerSignUp(dogWalker, new Consumer<DogWalker>() {
                            @Override
                            public void accept(DogWalker dogWalker) {
                                DogWalkerSingleton.getInstance().setDogWalker(dogWalker);
                                Intent intent = new Intent(RegisterUserActivity.this, RegisterDogActivity.class);
                                startActivity(intent);
                            }
                        });
                    }
                }
            }
        });
    }
}

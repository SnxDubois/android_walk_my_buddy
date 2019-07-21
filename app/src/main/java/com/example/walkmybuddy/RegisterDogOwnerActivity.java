package com.example.walkmybuddy;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.walkmybuddy.model.DogOwner;

public class RegisterDogOwnerActivity extends AppCompatActivity {

    private static final int MIN_PASSWORD_LENGTH = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_dog_owner);

        Button register = findViewById(R.id.btRegister);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etName = findViewById(R.id.etName);
                EditText etEmail = findViewById(R.id.etEmail);
                EditText etPassword = findViewById(R.id.etPassword);
                if (etName.getText().toString().isEmpty() || etEmail.getText().toString().isEmpty() || etPassword.getText().toString().isEmpty()
                        || etPassword.getText().toString().length() < MIN_PASSWORD_LENGTH) {
                    new AlertDialog.Builder(RegisterDogOwnerActivity.this)
                            .setTitle("Error")
                            .setMessage("Please fill in all your details")
                            .show();
                    return;
                }
                DogOwner dogOwner = new DogOwner();
                dogOwner.setName(etName.getText().toString());
                dogOwner.setEmail(etEmail.getText().toString());
                dogOwner.setPassword(etPassword.getText().toString());


            }
        });
    }
}

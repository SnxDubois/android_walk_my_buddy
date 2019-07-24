package com.example.walkmybuddy;

import android.content.Intent;
import android.support.v4.util.Consumer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.walkmybuddy.model.Dog;
import com.example.walkmybuddy.model.DogOwner;
import com.example.walkmybuddy.singleton.DogOwnerSingleton;
import com.example.walkmybuddy.singleton.VolleySingleton;

public class RegisterDogActivity extends AppCompatActivity {

    private DogOwner dogOwner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_dog);
        Button btRegisterDog = findViewById(R.id.btRegisterDog);
        btRegisterDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etDogName = findViewById(R.id.etDogName);
                EditText etDogBreed = findViewById(R.id.etDogBreed);
                String dogName = etDogName.getText().toString();
                String dogBreed = etDogBreed.getText().toString();
                Dog dog = new Dog();
                dog.setName(dogName);
                dog.setType(dogBreed);
                dogOwner = DogOwnerSingleton.getInstance().getDogOwner();
                if (dogOwner != null) {
                    VolleySingleton.getInstance(RegisterDogActivity.this).dogSignUp(dogOwner, dog, new Consumer<Dog>() {
                        @Override
                        public void accept(Dog dog) {
                            Intent intent = new Intent(RegisterDogActivity.this, DogOwnerListActivity.class);
                            startActivity(intent);
                        }
                    });
                } else {
                    new AlertDialog.Builder(RegisterDogActivity.this)
                            .setTitle(R.string.error)
                            .setMessage(R.string.something_wrong)
                            .show();
                    return;
                }
            }
        });
        Button btSkip = findViewById(R.id.btSkip);
        btSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterDogActivity.this, DogOwnerListActivity.class);
                startActivity(intent);
            }
        });
    }
}

package com.example.walkmybuddy;

import com.example.walkmybuddy.model.DogOwner;

public class DogOwnerSingleton {

    private static DogOwnerSingleton instance;
    private DogOwner dogOwner;

    private DogOwnerSingleton() {
    }

    public static DogOwnerSingleton getInstance() {
        if (instance == null) {
            instance = new DogOwnerSingleton();
        }
        return instance;
    }

    public DogOwner getDogOwner() {
        return dogOwner;
    }

    public void setDogOwner(DogOwner dogOwner) {
        this.dogOwner = dogOwner;
    }
}

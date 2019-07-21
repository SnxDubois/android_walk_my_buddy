package com.example.walkmybuddy;

import com.example.walkmybuddy.model.DogWalker;

public class DogWalkerSingleton {

    private static DogWalkerSingleton instance;
    private DogWalker dogWalker;

    public DogWalkerSingleton() {
    }

    public DogWalkerSingleton getInstance() {
        if (instance == null) {
            instance = new DogWalkerSingleton();
        }
        return instance;
    }

    public DogWalker getDogWalker() {
        return dogWalker;
    }

    public void setDogWalker(DogWalker dogWalker) {
        this.dogWalker = dogWalker;
    }
}

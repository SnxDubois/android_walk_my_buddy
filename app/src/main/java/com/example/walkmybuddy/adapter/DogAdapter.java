package com.example.walkmybuddy.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.walkmybuddy.R;
import com.example.walkmybuddy.model.Dog;

import java.util.List;

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.DogViewHolder> {

    private List<Dog> dogList;

    public DogAdapter(List<Dog> dogList) { this.dogList = dogList;}

    @NonNull
    @Override
    public DogViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dog_item, viewGroup, false);
        return new DogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DogViewHolder dogViewHolder, int i) {
        Dog dog = dogList.get(i);
        dogViewHolder.tvDogName.setText(dog.getName());
        dogViewHolder.tvDogBreed.setText(dog.getType());
    }

    @Override
    public int getItemCount() {
        return dogList.size();
    }

    public class DogViewHolder extends RecyclerView.ViewHolder {

        public TextView tvDogName;
        public TextView tvDogBreed;

        public DogViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDogName = itemView.findViewById(R.id.tvDogName);
            tvDogBreed = itemView.findViewById(R.id.tvDogBreed);
        }
    }
}

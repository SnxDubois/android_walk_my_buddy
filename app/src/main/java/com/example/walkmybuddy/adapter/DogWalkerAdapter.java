package com.example.walkmybuddy.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.walkmybuddy.R;
import com.example.walkmybuddy.model.DogWalker;

import java.util.List;

public class DogWalkerAdapter extends RecyclerView.Adapter<DogWalkerAdapter.DogWalkerViewHolder> {

    List<DogWalker> dogWalkerList;

    public DogWalkerAdapter(List<DogWalker> dogWalkerList) {
        this.dogWalkerList = dogWalkerList;
    }

    @NonNull
    @Override
    public DogWalkerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dog_walker_item, viewGroup, false);
        return new DogWalkerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DogWalkerViewHolder dogWalkerViewHolder, int i) {
        DogWalker dogWalker = dogWalkerList.get(i);
        dogWalkerViewHolder.tvDogWalkerName.setText(dogWalker.getName());
    }

    @Override
    public int getItemCount() {
        return dogWalkerList.size();
    }

    public class DogWalkerViewHolder extends RecyclerView.ViewHolder{
        public TextView tvDogWalkerName;

        public DogWalkerViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDogWalkerName = itemView.findViewById(R.id.tvDogWalkerName);
        }
    }
}

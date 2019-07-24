package com.example.walkmybuddy.adapter;

import android.support.annotation.NonNull;
import android.support.v4.util.Consumer;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.walkmybuddy.singleton.DogOwnerSingleton;
import com.example.walkmybuddy.R;
import com.example.walkmybuddy.singleton.VolleySingleton;
import com.example.walkmybuddy.model.DogWalker;

import java.util.List;

public class DogWalkerAdapter extends RecyclerView.Adapter<DogWalkerAdapter.DogWalkerViewHolder> {

    private List<DogWalker> dogWalkerList;
    private DogOwnerSingleton dogOwnerSingleton = DogOwnerSingleton.getInstance();

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
    public void onBindViewHolder(@NonNull final DogWalkerViewHolder dogWalkerViewHolder, int i) {
        final DogWalker dogWalker = dogWalkerList.get(i);
        dogWalkerViewHolder.tvDogWalkerName.setText(dogWalker.getName());
        dogWalkerViewHolder.cbValidate.setChecked(false);
        dogWalkerViewHolder.cbValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dogWalkerViewHolder.cbValidate.isChecked()){
                    VolleySingleton.getInstance(dogWalkerViewHolder.cbValidate.getContext()).validateDogWalker(dogOwnerSingleton.getDogOwner(), dogWalker, new Consumer<DogWalker>() {
                        @Override
                        public void accept(DogWalker dogWalker) {
                        }
                    });
                } else {
                    dogWalker.setValidated(false);
                }
            }
        });
        if (dogWalkerViewHolder.cbValidate.isChecked()){
         dogWalker.setValidated(true);
        } else {
            dogWalker.setValidated(false);
        }
    }

    @Override
    public int getItemCount() {
        return dogWalkerList.size();
    }

    public class DogWalkerViewHolder extends RecyclerView.ViewHolder{
        public TextView tvDogWalkerName;
        public CheckBox cbValidate;

        public DogWalkerViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDogWalkerName = itemView.findViewById(R.id.tvDogWalkerName);
            cbValidate = itemView.findViewById(R.id.cbValidate);
        }
    }
}

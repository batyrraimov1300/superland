package com.example.superland.Categories;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.superland.Activity.MainActivity;
import com.example.superland.Adapter.AnimatorsAdapter;
import com.example.superland.Adapter.PizzaAdapter;
import com.example.superland.Domain.AnimatorsDomain;
import com.example.superland.Domain.PizzaDomain;
import com.example.superland.Interfaces.ItemClickListener;
import com.example.superland.R;
import com.example.superland.databinding.FragmentAnimatorsBinding;

import java.util.ArrayList;


public class AnimatorsFragment extends Fragment {

    FragmentAnimatorsBinding binding;
    private RecyclerView.Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAnimatorsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewAnimators();

        Button back_home = view.findViewById(R.id.back_home);
        back_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    private void recyclerViewAnimators() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext(),
                LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerAnimators = binding.recyclerAnimators;
        recyclerAnimators.setLayoutManager(linearLayoutManager);
        ArrayList<AnimatorsDomain> animatorsList = new ArrayList<>();
        animatorsList.add(new AnimatorsDomain("Бэтмен", "", "Описание", "2000 ₽"));
        animatorsList.add(new AnimatorsDomain("Человек-паук", "", "Описание", "2000 ₽"));
        animatorsList.add(new AnimatorsDomain("Железный человек", "", "Описание", "2000 ₽"));
        adapter = new AnimatorsAdapter(new ClickListener(), animatorsList);
        recyclerAnimators.setAdapter(adapter);
    }

    public class ClickListener implements ItemClickListener<AnimatorsDomain> {

        @Override
        public void click(AnimatorsDomain item) {


            switch (item.getPic()) {
                case "pepperoni_one": {

                }

                case "cheese_pizza": {

                }

            }
        }
    }

}
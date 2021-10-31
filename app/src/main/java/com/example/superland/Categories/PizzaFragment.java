package com.example.superland.Categories;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.superland.Activity.MainActivity;
import com.example.superland.Adapter.PizzaAdapter;
import com.example.superland.Domain.FoodDomain;
import com.example.superland.Domain.PizzaDomain;
import com.example.superland.Helper.ManagementCart;
import com.example.superland.Interfaces.ItemClickListener;
import com.example.superland.R;
import com.example.superland.databinding.FragmentPizzaBinding;

import java.util.ArrayList;

public class PizzaFragment extends Fragment {



    FragmentPizzaBinding binding;
    private RecyclerView.Adapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPizzaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewPizza();
        Button back_home = view.findViewById(R.id.back_home);
        back_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        getBundle();
    }

    private void getBundle() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    private void recyclerViewPizza() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext(),
                LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerPizza = binding.recyclerPizza;
        recyclerPizza.setLayoutManager(linearLayoutManager);
        ArrayList<PizzaDomain> pizzaList = new ArrayList<>();
        pizzaList.add(new PizzaDomain("Пепперони", "pepperoni_one", "Описание пепперони", "460 ₽", "30 см"));
        pizzaList.add(new PizzaDomain("Сырная", "", "Описание сырной", "460 ₽", "30 см"));
        pizzaList.add(new PizzaDomain("Карбонаро", "", "Описание карбонары", "460 ₽", "30 см"));
        pizzaList.add(new PizzaDomain("Поло", "", "Описание полы", "460 ₽", "30 см"));
        adapter = new PizzaAdapter(new ClickListener(), pizzaList);
        recyclerPizza.setAdapter(adapter);

    }

    //
    public class ClickListener implements ItemClickListener<PizzaDomain> {

        @Override
        public void click(PizzaDomain item) {

            switch (item.getPic()) {
                case "pepperoni_one": {
                }
                case "cheese_pizza": {

                }

            }
        }
    }

}
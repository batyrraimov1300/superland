package com.example.superland.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.superland.Categories.PizzaFragment;
import com.example.superland.Domain.PizzaDomain;
import com.example.superland.R;

import java.util.ArrayList;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.ViewHolder> {


    PizzaFragment.ClickListener clickListener;
    ArrayList<PizzaDomain> pizzaDomains;

    public PizzaAdapter(PizzaFragment.ClickListener clickListener, ArrayList<PizzaDomain> pizzaList) {
        this.pizzaDomains = pizzaList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_pizza, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titlePizza.setText(pizzaDomains.get(position).getTitle());
        holder.sizePizza.setText(pizzaDomains.get(position).getSize());
        holder.pricePizza.setText(pizzaDomains.get(position).getPrice());
        holder.descriptionPizza.setText(pizzaDomains.get(position).getDescription());

        String picUrl = "";
        switch (position) {
            case 0: {
                picUrl = "pepperoni_one";
                holder.mainPizza.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.card_background));
                break;
            }
            case 1: {
                picUrl = "cheese_pizza";
                holder.mainPizza.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.card_background));
                break;
            }
            case 2: {
                picUrl = "karbonaro_pizza";
                holder.mainPizza.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.card_background));
                break;
            }
//            case 3: {
//                picUrl = "hamburger";
//                holder.mainPizza.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.card_background));
//                break;
//            }
        }

        int drawableResourceId = holder.itemView
                .getContext()
                .getResources()
                .getIdentifier(picUrl, "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.picPizza);

    }


    @Override
    public int getItemCount() {
        return pizzaDomains.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titlePizza;
        TextView descriptionPizza;
        TextView sizePizza;
        TextView pricePizza;
        ImageView picPizza;
        ConstraintLayout mainPizza;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sizePizza = itemView.findViewById(R.id.size_pizza);
            descriptionPizza = itemView.findViewById(R.id.description_pizza);
            pricePizza = itemView.findViewById(R.id.price_pizza);
            titlePizza = itemView.findViewById(R.id.title_pizza);
            picPizza = itemView.findViewById(R.id.pic_pizza);
            mainPizza = itemView.findViewById(R.id.mainAnimator);
        }
    }
}

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
import com.example.superland.Categories.AnimatorsFragment;
import com.example.superland.Categories.PizzaFragment;
import com.example.superland.Domain.AnimatorsDomain;
import com.example.superland.R;

import java.util.ArrayList;

public class AnimatorsAdapter extends RecyclerView.Adapter<AnimatorsAdapter.ViewHolder> {


    AnimatorsFragment.ClickListener clickListener;
    ArrayList<AnimatorsDomain> animatorsDomain;


    public AnimatorsAdapter(AnimatorsFragment.ClickListener clickListener, ArrayList<AnimatorsDomain> animatorsList) {
        this.animatorsDomain = animatorsList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_animators, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titleAnimators.setText(animatorsDomain.get(position).getTitle());
        holder.priceAnimator.setText(animatorsDomain.get(position).getPrice());
        holder.descriptionAnimator.setText(animatorsDomain.get(position).getDescription());

        String picUrl = "";
        switch (position) {
            case 0: {
                picUrl = "batman";
                holder.mainAnimator.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.card_background));
                break;
            }
            case 1: {
                picUrl = "spider_man";
                holder.mainAnimator.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.card_background));
                break;
            }
            case 2: {
                picUrl = "iron_man";
                holder.mainAnimator.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.card_background));
                break;
            }
//            case 3: {
//                picUrl = "hamburger";
//                holder.mainAnimator.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.card_background));
//                break;
//            }
        }

        int drawableResourceId = holder.itemView
                .getContext()
                .getResources()
                .getIdentifier(picUrl, "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.picAnimator);

    }


    @Override
    public int getItemCount() {
        return animatorsDomain.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleAnimators;
        TextView descriptionAnimator;
        TextView priceAnimator;
        ImageView picAnimator;
        ConstraintLayout mainAnimator;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            descriptionAnimator = itemView.findViewById(R.id.description_animator);
            priceAnimator = itemView.findViewById(R.id.price_animator);
            titleAnimators = itemView.findViewById(R.id.title_animator);
            picAnimator = itemView.findViewById(R.id.pic_animator);
            mainAnimator = itemView.findViewById(R.id.mainAnimator);
        }
    }
}

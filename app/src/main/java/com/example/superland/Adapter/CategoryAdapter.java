package com.example.superland.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.superland.Domain.CategoryDomain;
import com.example.superland.MainFragment;
import com.example.superland.MainFragmentDirections;
import com.example.superland.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    public CategoryAdapter(MainFragment.ClickListener clickListener, ArrayList<CategoryDomain> categoryDomains) {
        this.categoryDomains = categoryDomains;
        this.clickListener = clickListener;
    }

    MainFragment.ClickListener clickListener;
    ArrayList<CategoryDomain> categoryDomains;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.categoryName.setText(categoryDomains.get(position).getTitle());

        holder.itemView.setOnClickListener(
                view -> clickListener.click(categoryDomains.get(position))
        );

//        holder.itemView.setOnClickListener(view -> {
//            NavDirections action = MainFragmentDirections.startPizzaFragment();
//            Navigation.findNavController(view).navigate(action);
//        });

        String picUrl = "";
        switch (position) {
            case 0: {
                picUrl = "ic_animator";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.bg_category));
                break;
            }
            case 1: {
                picUrl = "ic_cake";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.bg_category));
                break;
            }
            case 2: {
                picUrl = "ic_pizza";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.bg_category));
                break;
            }
            case 3: {
                picUrl = "ic_gamburger";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.bg_category));
                break;
            }
        }

        int drawableResourceId = holder.itemView
                .getContext()
                .getResources()
                .getIdentifier(picUrl, "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.categoryPic);

    }


    @Override
    public int getItemCount() {
        return categoryDomains.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;
        ImageView categoryPic;
        ConstraintLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryName);
            categoryPic = itemView.findViewById(R.id.categoryPic);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }


}

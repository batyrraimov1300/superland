package com.example.superland;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.superland.Adapter.CategoryAdapter;
import com.example.superland.Adapter.PopularAdapter;
import com.example.superland.Adapter.SliderAdapter;
import com.example.superland.Domain.CategoryDomain;
import com.example.superland.Domain.FoodDomain;
import com.example.superland.Interfaces.ItemClickListener;
import com.example.superland.databinding.FragmentMainBinding;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class MainFragment extends Fragment {

    private FragmentMainBinding binding;

    private RecyclerView.Adapter adapter, adapter2;


    SliderView sliderView;
    int[] images = {
            R.drawable.marketing_icon,
            R.drawable.marketing_icon,
            R.drawable.marketing_icon
    };

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewCategory();
        recyclerViewPopular();
        sliderView = binding.imageSlider;
        SliderAdapter sliderAdapter = new SliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext(),
                LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerViewPopularList = binding.recyclerViewPopular;
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        recyclerViewPopularList.setLayoutManager(linearLayoutManager);
        ArrayList<FoodDomain> foodlist = new ArrayList<>();
        foodlist.add(new FoodDomain("Пепперони", "pepperoni_one", "Состав: Пепперони, болгарский перец, \n" +
                "моцарелла, томатный соус. ", 460));
        foodlist.add(new FoodDomain("Сырная", "cheese_pizza", "", 460));
        foodlist.add(new FoodDomain("Пепперони", "pepperoni_one", "", 460));

        adapter2 = new PopularAdapter(foodlist);
        recyclerViewPopularList.setAdapter(adapter2);
    }

    private void recyclerViewCategory() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext(),
                LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerViewCategoryList = binding.recyclerView;
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("Аниматоры", "button_animators"));
        categoryList.add(new CategoryDomain("Торт", "button_cakes"));
        categoryList.add(new CategoryDomain("Пицца", "button_pizza"));
        categoryList.add(new CategoryDomain("Бургеры", "button_burgers"));
        adapter = new CategoryAdapter(new ClickListener(), categoryList);
        recyclerViewCategoryList.setAdapter(adapter);
    }

    public class ClickListener implements ItemClickListener<CategoryDomain> {

        @Override
        public void click(CategoryDomain item) {
            /*Выбирать куда хочешь перейти*/
            switch (item.getPic()) {
                case "button_animators": {
                    MainFragmentDirections.StartAnimatorsFragment action = MainFragmentDirections.startAnimatorsFragment();
                    action.setTestArg(item.getTitle());
                    NavHostFragment.findNavController(MainFragment.this).navigate(action);
                    break;
                }
                case "button_cakes": {
                    MainFragmentDirections.StartCakeFragment action = MainFragmentDirections.startCakeFragment();
                    action.setTestArg(item.getTitle());
                    NavHostFragment.findNavController(MainFragment.this).navigate((NavDirections) action);
                    break;

                }

                case "button_pizza": {
                    MainFragmentDirections.StartPizzaFragment action = MainFragmentDirections.startPizzaFragment();
                    action.setTestArg(item.getTitle());
                    NavHostFragment.findNavController(MainFragment.this).navigate((NavDirections) action);
                    break;

                }

                case "button_burgers": {
                    MainFragmentDirections.StartBurgerFragment action = MainFragmentDirections.startBurgerFragment();
                    action.setTestArg(item.getTitle());
                    NavHostFragment.findNavController(MainFragment.this).navigate((NavDirections) action);
                    break;
                }
            }
        }
    }
}
package com.example.superland.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.superland.Domain.FoodDomain;
import com.example.superland.Helper.ManagementCart;
import com.example.superland.R;

public class ShowDetailActivity extends AppCompatActivity {

    private Button add_to_basket;
    private TextView title_show_detail, text_description,text_price, order_number;
    private ImageView image_show_detail;
    private FoodDomain object;
    private int numberOrder = 1;
    private ManagementCart managementCart;

    private Button back_button;
    public ImageView basket_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        managementCart = new ManagementCart(this);

        basket_button = (ImageView) findViewById(R.id.backet_btn);
        basket_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowDetailActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });

        back_button = (Button) findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowDetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        initView();
        getBundle();
    }

    @SuppressLint("SetTextI18n")
    private void getBundle() {
        object = (FoodDomain) getIntent().getSerializableExtra("object");
        int drawableResourceId = this.getResources().getIdentifier(object.getPic(),
                "drawable",
                this.getPackageName());

        Glide.with(this)
                .load(drawableResourceId)
                .into(image_show_detail);
        title_show_detail.setText(object.getTitle());
        text_price.setText("Цена: " + object.getFee() + " ₽ ");
        text_description.setText(object.getDescription());
        add_to_basket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                object.setNumberInCard(numberOrder);
                managementCart.insertFood(object);
            }
        });

    }

    private void initView() {
        add_to_basket = findViewById(R.id.add_to_backet);
        title_show_detail = findViewById(R.id.title_show_detail);
        text_description = findViewById(R.id.text_description);
        text_price = findViewById(R.id.text_price);
        image_show_detail = findViewById(R.id.image_show_detail);
    }
}
package com.example.superland.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.superland.R;

public class CheckOut extends AppCompatActivity {
    private EditText user_name, user_number, user_address;
    private Button back_home;
    private Button order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        order = (Button) findViewById(R.id.order);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        back_home = (Button) findViewById(R.id.back_home);
        back_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CheckOut.this, CartActivity.class);
                startActivity(intent);
            }
        });

        init();
    }
    public void init(){
        user_name = findViewById(R.id.user_name);
        user_number = findViewById(R.id.user_number);
        user_address = findViewById(R.id.user_address);
    }

}
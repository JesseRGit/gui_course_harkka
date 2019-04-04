package com.example.harjoitustyo;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WeatherActivity extends AppCompatActivity {

    ConstraintLayout cl_weather_layout;
    String currentBackgroundColor = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        cl_weather_layout=findViewById(R.id.constraintLayout_weather);

        //Get intent extra
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            currentBackgroundColor = bundle.getString("current_background_color");
        }

        //Set background to previously found color code stored in extra
        cl_weather_layout.setBackgroundColor(Color.parseColor(currentBackgroundColor));

    }
}

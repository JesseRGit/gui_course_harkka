package com.example.harjoitustyo;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WeatherActivity extends AppCompatActivity {

    ConstraintLayout cl_weather_layout;
    String currentBackgroundColor = "", city = "", country = "", temperature = "", description = "";
    TextView tv_cityName, tv_weatherInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        cl_weather_layout = findViewById(R.id.constraintLayout_weather);
        tv_cityName = findViewById(R.id.textView_cityName);
        tv_weatherInfo = findViewById(R.id.textView_weather);

        // get intent extra
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            currentBackgroundColor = bundle.getString("current_background_color");
            city = bundle.getString("city");
            country = bundle.getString("country");
            temperature = bundle.getString("temperature");
            description = bundle.getString("description");
        }

        // set background to previously found color code stored in extra
        cl_weather_layout.setBackgroundColor(Color.parseColor(currentBackgroundColor));

        // fill the
        tv_cityName.setText(city + ", " + country);
        tv_weatherInfo.setText("Current temperature is " + temperature + " °C with " + description + ".");
    }
}


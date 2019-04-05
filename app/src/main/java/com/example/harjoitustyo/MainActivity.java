package com.example.harjoitustyo;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

//Lisää sään näyttäminen WeatherActivityyn, kts. läppärin kotlin esimerkki

public class MainActivity extends AppCompatActivity {

    public static String currentBackgroundColor = "#F5F5F5";

    //init UI components
    ImageButton btn_setBackground_blue, btn_setBackground_red, btn_setBackground_yellow, btn_setBackground_green, btn_setBackground_white;
    ConstraintLayout cl_mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find views
        cl_mainLayout=findViewById(R.id.constraintLayout_main);
        btn_setBackground_blue = findViewById(R.id.imageButton_blue_background);
        btn_setBackground_red = findViewById(R.id.imageButton_red_background);
        btn_setBackground_green = findViewById(R.id.imageButton_green_background);
        btn_setBackground_yellow = findViewById(R.id.imageButton_yellow_background);
        btn_setBackground_white = findViewById(R.id.imageButton_white_background);


        //init background color to white
        cl_mainLayout.setBackgroundColor(Color.parseColor(currentBackgroundColor));
        btn_setBackground_white.setBackgroundColor(Color.parseColor("#A9A9A9"));
        btn_setBackground_yellow.setBackgroundColor(Color.parseColor("#D3D3D3"));
        btn_setBackground_blue.setBackgroundColor(Color.parseColor("#D3D3D3"));
        btn_setBackground_red.setBackgroundColor(Color.parseColor("#D3D3D3"));
        btn_setBackground_green.setBackgroundColor(Color.parseColor("#D3D3D3"));

        //init setBackground buttons color
        btn_setBackground_white.setColorFilter(Color.parseColor("#F5F5F5"));
        btn_setBackground_yellow.setColorFilter(Color.parseColor("#F0E68C"));
        btn_setBackground_blue.setColorFilter(Color.parseColor("#6495ED"));
        btn_setBackground_red.setColorFilter(Color.parseColor("#F08080"));
        btn_setBackground_green.setColorFilter(Color.parseColor("#90EE90"));
    }

    // function to change background color to blue
    public void setBackground_blue (View V) {
        cl_mainLayout.setBackgroundColor(Color.parseColor("#6495ED"));
        btn_setBackground_white.setBackgroundColor(Color.parseColor("#D3D3D3"));
        btn_setBackground_yellow.setBackgroundColor(Color.parseColor("#D3D3D3"));
        btn_setBackground_blue.setBackgroundColor(Color.parseColor("#A9A9A9"));
        btn_setBackground_red.setBackgroundColor(Color.parseColor("#D3D3D3"));
        btn_setBackground_green.setBackgroundColor(Color.parseColor("#D3D3D3"));
        currentBackgroundColor = "#6495ED";
    }

    public void setBackground_white (View V) {
        cl_mainLayout.setBackgroundColor(Color.parseColor("#F5F5F5"));
        btn_setBackground_white.setBackgroundColor(Color.parseColor("#A9A9A9"));
        btn_setBackground_yellow.setBackgroundColor(Color.parseColor("#D3D3D3"));
        btn_setBackground_blue.setBackgroundColor(Color.parseColor("#D3D3D3"));
        btn_setBackground_red.setBackgroundColor(Color.parseColor("#D3D3D3"));
        btn_setBackground_green.setBackgroundColor(Color.parseColor("#D3D3D3"));
        currentBackgroundColor = "#F5F5F5";
    }

    public void setBackground_yellow (View V) {
        cl_mainLayout.setBackgroundColor(Color.parseColor("#F0E68C"));
        btn_setBackground_white.setBackgroundColor(Color.parseColor("#D3D3D3"));
        btn_setBackground_yellow.setBackgroundColor(Color.parseColor("#A9A9A9"));
        btn_setBackground_blue.setBackgroundColor(Color.parseColor("#D3D3D3"));
        btn_setBackground_red.setBackgroundColor(Color.parseColor("#D3D3D3"));
        btn_setBackground_green.setBackgroundColor(Color.parseColor("#D3D3D3"));
        currentBackgroundColor = "#F0E68C";
    }

    public void setBackground_green (View V) {
        cl_mainLayout.setBackgroundColor(Color.parseColor("#90EE90"));
        btn_setBackground_white.setBackgroundColor(Color.parseColor("#D3D3D3"));
        btn_setBackground_yellow.setBackgroundColor(Color.parseColor("#D3D3D3"));
        btn_setBackground_blue.setBackgroundColor(Color.parseColor("#D3D3D3"));
        btn_setBackground_red.setBackgroundColor(Color.parseColor("#D3D3D3"));
        btn_setBackground_green.setBackgroundColor(Color.parseColor("#A9A9A9"));
        currentBackgroundColor = "#90EE90";
    }


    // function to change background color to red
    public void setBackground_red (View V) {
        cl_mainLayout.setBackgroundColor(Color.parseColor("#F08080"));
        btn_setBackground_white.setBackgroundColor(Color.parseColor("#D3D3D3"));
        btn_setBackground_yellow.setBackgroundColor(Color.parseColor("#D3D3D3"));
        btn_setBackground_blue.setBackgroundColor(Color.parseColor("#D3D3D3"));
        btn_setBackground_red.setBackgroundColor(Color.parseColor("#A9A9A9"));
        btn_setBackground_green.setBackgroundColor(Color.parseColor("#D3D3D3"));
        currentBackgroundColor = "#F08080";
    }

    // intent to open WeatherActivity
    public void WeatherActivity(View view) {
        Intent intent = new Intent(this, WeatherActivity.class);

        //sent currentBackgroundColor as extra
        intent.putExtra("current_background_color", currentBackgroundColor);
        startActivity(intent);
    }

}

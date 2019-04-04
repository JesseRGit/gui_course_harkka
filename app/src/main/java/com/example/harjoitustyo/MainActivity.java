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

    public static String currentBackgroundColor = "#6495ED";

    //init UI components
    ImageButton btn_setBackground_blue, btn_setBackground_red;
    ConstraintLayout cl_mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find views
        cl_mainLayout=findViewById(R.id.constraintLayout_main);
        btn_setBackground_blue = findViewById(R.id.imageButton_blue_background);
        btn_setBackground_red = findViewById(R.id.imageButton_red_background);

        //init background color to blue
        cl_mainLayout.setBackgroundColor(Color.parseColor(currentBackgroundColor));
        btn_setBackground_blue.setBackgroundColor(Color.parseColor("#A9A9A9"));
        btn_setBackground_red.setBackgroundColor(Color.parseColor("#D3D3D3"));

        //init setBackground buttons color
        btn_setBackground_red.setColorFilter(Color.parseColor("#F08080"));
        btn_setBackground_blue.setColorFilter(Color.parseColor("#6495ED"));

    }

    // function to change background color to blue
    public void setBackground_blue (View V) {
        cl_mainLayout.setBackgroundColor(Color.parseColor("#6495ED"));
        btn_setBackground_blue.setBackgroundColor(Color.parseColor("#A9A9A9"));
        btn_setBackground_red.setBackgroundColor(Color.parseColor("#D3D3D3"));
        currentBackgroundColor = "#6495ED";
    }

    // function to change background color to red
    public void setBackground_red (View V) {
        cl_mainLayout.setBackgroundColor(Color.parseColor("#F08080"));
        btn_setBackground_blue.setBackgroundColor(Color.parseColor("#D3D3D3"));
        btn_setBackground_red.setBackgroundColor(Color.parseColor("#A9A9A9"));
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
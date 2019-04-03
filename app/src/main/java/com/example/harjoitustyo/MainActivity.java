package com.example.harjoitustyo;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

//Lisää sään näyttäminen WeatherActivityyn, kts. läppärin kotlin esimerkki

public class MainActivity extends AppCompatActivity {

    ImageButton btn_setBackground_blue, btn_setBackground_red;
    ConstraintLayout cl_mainLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cl_mainLayout=findViewById(R.id.constraintLayout_main);

        btn_setBackground_blue = findViewById(R.id.imageButton_blue_background);
        btn_setBackground_red = findViewById(R.id.imageButton_red_background);
    }

    public void setBackground_blue (View V) {
        cl_mainLayout.setBackgroundColor(Color.parseColor("#6495ED"));
    }

    public void setBackground_red (View V) {
        cl_mainLayout.setBackgroundColor(Color.parseColor("#F08080"));
    }

}

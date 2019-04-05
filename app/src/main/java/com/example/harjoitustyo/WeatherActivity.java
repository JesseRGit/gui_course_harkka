package com.example.harjoitustyo;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class WeatherActivity extends AppCompatActivity {

    ConstraintLayout cl_weather_layout;
    String currentBackgroundColor = "";
    TextView tv_weatherInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        cl_weather_layout=findViewById(R.id.constraintLayout_weather);
        tv_weatherInfo=findViewById(R.id.textView_weatherInfo);

        //Get intent extra
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            currentBackgroundColor = bundle.getString("current_background_color");
        }

        //Set background to previously found color code stored in extra
        cl_weather_layout.setBackgroundColor(Color.parseColor(currentBackgroundColor));

        //API CALL
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        //String url ="http://www.google.com";
        String url = "https://api.openweathermap.org/data/2.5/forecast?q=Tampere&appid=6c433438776b5be4ac86001dc88de74d&unites=metric";


        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        tv_weatherInfo.setText("Response is: "+ response.substring(0,500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tv_weatherInfo.setText("No data found...");
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

}

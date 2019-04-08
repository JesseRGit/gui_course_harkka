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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherActivity extends AppCompatActivity {

    ConstraintLayout cl_weather_layout;
    String currentBackgroundColor = "";
    TextView tv_cityName, tv_weatherInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        cl_weather_layout = findViewById(R.id.constraintLayout_weather);
        tv_cityName = findViewById(R.id.textView_cityName);
        tv_weatherInfo = findViewById(R.id.textView_weather);

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
        //String url = "https://api.openweathermap.org/data/2.5/forecast?q=Tampere&appid=6c433438776b5be4ac86001dc88de74d&unites=metric";
        String url = "https://api.openweathermap.org/data/2.5/weather?q=Tampere&units=metric&APPID=6c433438776b5be4ac86001dc88de74d";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Process the JSON
                        try {

                            String cityName = response.getString("name");

                            JSONObject sys = response.getJSONObject("sys");
                            String countryName = sys.getString("country");

                            JSONArray weatherArray = response.getJSONArray("weather");
                            JSONObject weatherItem = weatherArray.getJSONObject(0);
                            String description = weatherItem.getString("description");

                            JSONObject main = response.getJSONObject("main");
                            String temperature = main.getString("temp");

                            tv_cityName.setText(cityName + ", " + countryName);
                            tv_weatherInfo.setText("Current temperature is " + temperature + " °C with " + description + ".");


                        } catch (JSONException e) {

                            Toast.makeText(getApplicationContext(), "JSONException occurred", Toast.LENGTH_SHORT).show();
                            e.printStackTrace();

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Do something when error occurred
                        Toast.makeText(getApplicationContext(), "Error occurred", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        // Add JsonObjectRequest to the RequestQueue
        queue.add(jsonObjectRequest);
    }
}


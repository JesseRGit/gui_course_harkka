package com.example.harjoitustyo;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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

public class MainActivity extends AppCompatActivity {

    public static String currentBackgroundColor = "#F5F5F5";
    String city = "", temperature = "", description = "";

    TextView tv_msg;
    TextView tv_msg2;

    EditText et_searchField;

    //init UI components
    ImageButton btn_setBackground_blue, btn_setBackground_red, btn_setBackground_yellow, btn_setBackground_green, btn_setBackground_white;
    Button btn_search;
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
        et_searchField = findViewById(R.id.editText_searchField);
        tv_msg = findViewById(R.id.textView_msg);
        tv_msg2 = findViewById(R.id.textView_msg2);
        btn_search = findViewById(R.id.button_viewWeather);

        //init the right background button to be selected (at start it's white)
        cl_mainLayout.setBackgroundColor(Color.parseColor(currentBackgroundColor));
        btn_setBackground_white.setBackgroundColor(Color.parseColor("#D3D3D3"));
        btn_setBackground_yellow.setBackgroundColor(Color.parseColor("#D3D3D3"));
        btn_setBackground_blue.setBackgroundColor(Color.parseColor("#D3D3D3"));
        btn_setBackground_red.setBackgroundColor(Color.parseColor("#D3D3D3"));
        btn_setBackground_green.setBackgroundColor(Color.parseColor("#D3D3D3"));
        setRightBackgroundButtonSelected();

        //init setBackground buttons color
        btn_setBackground_white.setColorFilter(Color.parseColor("#F5F5F5"));
        btn_setBackground_yellow.setColorFilter(Color.parseColor("#F0E68C"));
        btn_setBackground_blue.setColorFilter(Color.parseColor("#6495ED"));
        btn_setBackground_red.setColorFilter(Color.parseColor("#F08080"));
        btn_setBackground_green.setColorFilter(Color.parseColor("#90EE90"));

        btn_search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                // get user input
                city = et_searchField.getText().toString();

                // if there's no user input use tampere
                if (city.length() <= 0) {
                    city = "tampere";
                }

                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&units=metric&APPID=6c433438776b5be4ac86001dc88de74d";

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

                                    //JSONObject sys = response.getJSONObject("sys");
                                    //String countryName = sys.getString("country");

                                    JSONArray weatherArray = response.getJSONArray("weather");
                                    JSONObject weatherItem = weatherArray.getJSONObject(0);
                                    String descriptionText = weatherItem.getString("description");

                                    JSONObject main = response.getJSONObject("main");
                                    String temperatureValue = main.getString("temp");

                                    city = cityName;
                                    temperature = temperatureValue;
                                    description = descriptionText;

                                    Intent intent = new Intent(getApplicationContext(), WeatherActivity.class);

                                    //sent currentBackgroundColor, city, temperature and description as extra
                                    intent.putExtra("current_background_color", currentBackgroundColor);
                                    intent.putExtra("city", city);
                                    intent.putExtra("temperature", temperature);
                                    intent.putExtra("description", description);
                                    startActivity(intent);
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
        });
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

    // function to change background color to white
    public void setBackground_white (View V) {
        cl_mainLayout.setBackgroundColor(Color.parseColor("#F5F5F5"));
        btn_setBackground_white.setBackgroundColor(Color.parseColor("#A9A9A9"));
        btn_setBackground_yellow.setBackgroundColor(Color.parseColor("#D3D3D3"));
        btn_setBackground_blue.setBackgroundColor(Color.parseColor("#D3D3D3"));
        btn_setBackground_red.setBackgroundColor(Color.parseColor("#D3D3D3"));
        btn_setBackground_green.setBackgroundColor(Color.parseColor("#D3D3D3"));
        currentBackgroundColor = "#F5F5F5";
    }

    // function to change background color to yellow
    public void setBackground_yellow (View V) {
        cl_mainLayout.setBackgroundColor(Color.parseColor("#F0E68C"));
        btn_setBackground_white.setBackgroundColor(Color.parseColor("#D3D3D3"));
        btn_setBackground_yellow.setBackgroundColor(Color.parseColor("#A9A9A9"));
        btn_setBackground_blue.setBackgroundColor(Color.parseColor("#D3D3D3"));
        btn_setBackground_red.setBackgroundColor(Color.parseColor("#D3D3D3"));
        btn_setBackground_green.setBackgroundColor(Color.parseColor("#D3D3D3"));
        currentBackgroundColor = "#F0E68C";
    }

    // function to change background color to green
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

    // function to set the right background button as selected
    public void setRightBackgroundButtonSelected () {
        if (currentBackgroundColor == "#F5F5F5") {
            btn_setBackground_white.setBackgroundColor(Color.parseColor("#A9A9A9"));
        } else if (currentBackgroundColor == "#F0E68C") {
            btn_setBackground_yellow.setBackgroundColor(Color.parseColor("#A9A9A9"));
        } else if (currentBackgroundColor == "#6495ED") {
            btn_setBackground_blue.setBackgroundColor(Color.parseColor("#A9A9A9"));
        } else if (currentBackgroundColor == "#90EE90") {
            btn_setBackground_green.setBackgroundColor(Color.parseColor("#A9A9A9"));
        } else
            btn_setBackground_red.setBackgroundColor(Color.parseColor("#A9A9A9"));
        }

}

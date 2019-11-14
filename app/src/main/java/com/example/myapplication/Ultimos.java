package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Ultimos extends AppCompatActivity {

    private static final String URL = "http://192.168.137.1:3000/nuevo-ticket";
    private TextView editText;
    private Button button, ultimo, Cultimos;



    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultimos);



        linearLayout = findViewById(R.id.fondoticket);
        editText = (TextView) findViewById(R.id.NumeroTicket);
        button = (Button)findViewById(R.id.BtnGenerar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Drawable f = getResources().getDrawable(R.drawable.fondot);
                linearLayout.setBackground(f);



                Toast.makeText(Ultimos.this, "Ultimo ticket", Toast.LENGTH_SHORT).show();
                StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        editText.setVisibility(View.VISIBLE);
                        editText.setText(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error", error.toString());
                    }
                });
                Volley.newRequestQueue(Ultimos.this).add(stringRequest);
            }
        });
    }
}

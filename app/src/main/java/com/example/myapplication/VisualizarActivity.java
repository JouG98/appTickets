package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VisualizarActivity extends AppCompatActivity {

    private static final String URL = "http://192.168.137.1:3000/nuevo-ticket";
    private TextView editText;
    private Button ultimo, Cultimos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);


        ultimo = (Button)findViewById(R.id.BtnVerUltimo);
        Cultimos = (Button)findViewById(R.id.BtnVer4);


        ultimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VisualizarActivity.this, Ultimos.class));
            }
        });

        Cultimos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VisualizarActivity.this, Ultimos4.class));
            }
        });

    }
}

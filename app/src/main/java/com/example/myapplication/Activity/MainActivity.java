package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {


    private CardView btnmenu;
    private CardView btnvisualizar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btnmenu=findViewById(R.id.Generar);
        btnvisualizar= findViewById(R.id.Visualizar);

        btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), GenerarActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        btnvisualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),VisualizarActivity.class);
                startActivityForResult(intent,0);
            }
        });

    }
}

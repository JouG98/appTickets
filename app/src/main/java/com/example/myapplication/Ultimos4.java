package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.opengl.EGLExt;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Ultimos4 extends AppCompatActivity {

    private static final String URL = "http://192.168.137.1:3000/publico";
    private TextView editText, cero, uno, dos , tres;
    private Button button, ultimo, Cultimos;
    String [] datosTi, datosEs, a;
    private ListView lista;
    ArrayAdapter info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultimos4);

        lista = (ListView)findViewById(R.id.ListDatos);
        cero = (TextView) findViewById(R.id.NumeroTicket0);
        uno = (TextView) findViewById(R.id.NumeroTicket1);
        dos = (TextView) findViewById(R.id.NumeroTicket2);
        tres = (TextView) findViewById(R.id.NumeroTicket3);
        editText = (TextView) findViewById(R.id.NumeroTicket);
        button = (Button)findViewById(R.id.BtnGenerar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Ultimos4.this, "hola", Toast.LENGTH_SHORT).show();
                StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray j = new JSONArray(response);
                            for( int i = 0; i <=j.length(); i ++){
                                JSONObject j2 = j.getJSONObject(i);

                                Log.e("Numero", String.valueOf(j2.getInt("numero")));
                                Log.e("Escritorio", j2.getString(("escritorio")));

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error", error.toString());
                    }
                });
                Volley.newRequestQueue(Ultimos4.this).add(stringRequest);
            }

        });
    }
}

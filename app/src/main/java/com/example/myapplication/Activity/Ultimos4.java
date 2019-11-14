package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.Adapter.AdapterTickets;
import com.example.myapplication.Model.Ticket;
import com.example.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Ultimos4 extends AppCompatActivity {

    private static final String URL = "http://192.168.137.1:3000/publico";

    private RecyclerView recyclerView;
    private AdapterTickets adapterTickets;
    private ArrayList<Ticket> ticketArrayList;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultimos4);

        recyclerView = (RecyclerView)findViewById(R.id.RecyclerTickets);
        ticketArrayList = new ArrayList<>();
        adapterTickets = new AdapterTickets(ticketArrayList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        progressDialog = new ProgressDialog(this);

        Ver();

    }

    private void Ver(){
        progressDialog.setCancelable(false);
        progressDialog.setMessage("CONSULTANDO!");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    progressDialog.dismiss();
                    JSONArray j = new JSONArray(response);
                    for( int i = 0; i <=j.length(); i ++){
                        JSONObject j2 = j.getJSONObject(i);
                        Ticket ticket = new Ticket();
                        ticket.setEscritorio(j2.getString(("escritorio")));
                        ticket.setNumero(String.valueOf(j2.getInt("numero")));
                        ticketArrayList.add(ticket);
                    }
                    recyclerView.setAdapter(adapterTickets);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Log.e("Error", error.toString());
            }
        });
        Volley.newRequestQueue(Ultimos4.this).add(stringRequest);
    }
}

package com.example.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.Ticket;
import com.example.myapplication.R;

import java.util.ArrayList;

public class AdapterTickets extends RecyclerView.Adapter<AdapterTickets.ViewHolder>{

    private ArrayList<Ticket> ticketArrayList;

    public AdapterTickets(ArrayList<Ticket> ticketArrayList) {
        this.ticketArrayList = ticketArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_tickets, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Ticket ticket = ticketArrayList.get(position);

        holder.ticket.setText(ticket.getNumero());
        holder.escritorio.setText(ticket.getEscritorio());


    }

    @Override
    public int getItemCount() {
        return ticketArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView ticket, escritorio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ticket = (TextView)itemView.findViewById(R.id.TicketNumeroL);
            escritorio = (TextView)itemView.findViewById(R.id.EscritorioNumeroL);
        }
    }

}

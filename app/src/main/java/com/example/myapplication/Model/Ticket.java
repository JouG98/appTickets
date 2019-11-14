package com.example.myapplication.Model;

public class Ticket {

    private String numero, escritorio;

    public Ticket() {
    }

    public Ticket(String numero, String escritorio) {
        this.numero = numero;
        this.escritorio = escritorio;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(String escritorio) {
        this.escritorio = escritorio;
    }
}

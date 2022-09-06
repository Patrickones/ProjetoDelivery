package com.example.projetodelivery;

public class Pedidos {
    private int id;
    private String statatusped;
    private String quantidade;
    private int id_clientes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatatusped() {
        return statatusped;
    }

    public void setStatatusped(String statatusped) {
        this.statatusped = statatusped;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public int getId_clientes() {
        return id_clientes;
    }

    public void setId_clientes(int id_clientes) {
        this.id_clientes = id_clientes;
    }

    @Override
    public String toString() {
        return "Pedidos{" +
                "id=" + id +
                ", statusped='" + statatusped + '\'' +
                ", quantidade='" + quantidade + '\'' +
                ", id_clientes='" + id_clientes + '\'' +
                '}';
    }
}


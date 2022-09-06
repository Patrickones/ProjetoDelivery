package com.example.projetodelivery;

public class Pedidos {
    private int id;
    private String statatusped;
    private String quantidade;
    private int id_pedidos;

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

    public int getId_pedidos() {
        return id_pedidos;
    }

    public void setId_pedidos(int id_pedidos) {
        this.id_pedidos = id_pedidos;
    }

    @Override
    public String toString() {
        return "Pedidos{" +
                "id=" + id +
                ", statusped='" + statatusped + '\'' +
                ", quantidade='" + quantidade + '\'' +
                '}';
    }
}


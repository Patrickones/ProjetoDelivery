package com.example.projetodelivery;

public class Produtos {
    private int id;
    private String tipo;
    private String preco_produtos;
    private int id_pedidos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPreco_produtos() {
        return preco_produtos;
    }

    public void setPreco_produtos(String preco_produtos) {
        this.preco_produtos = preco_produtos;
    }

    public int getId_pedidos() {
        return id_pedidos;
    }

    public void setId_pedidos(int id_pedidos) {
        this.id_pedidos = id_pedidos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", preco_produtos='" + preco_produtos + '\'' +
                '}';
    }
}

package com.example.projetodelivery;

public class ProdutosPed {
    private int id;
    private int id_produtos;
    private int id_pedidos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_produtos() {
        return id_produtos;
    }

    public void setId_produtos(int id_produtos) {
        this.id_produtos = id_produtos;
    }

    public int getId_pedidos() {
        return id_pedidos;
    }

    public void setId_pedidos(int id_pedidos) {
        this.id_pedidos = id_pedidos;
    }

    @Override
    public String toString() {
        return "ProdutosPed{" +
                "id=" + id +
                ", id_pedidos='" + id_pedidos + '\'' +
                ", id_produtos='" + id_produtos + '\'' +
                '}';
    }
}

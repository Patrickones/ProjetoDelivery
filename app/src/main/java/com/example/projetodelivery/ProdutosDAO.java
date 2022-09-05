package com.example.projetodelivery;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ProdutosDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public ProdutosDAO(Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(Produtos model) {
        ContentValues values = new ContentValues();
        values.put("tipo", model.getTipo());
        values.put("preco_produtos", model.getPreco_produtos());
        values.put("id_pedidos",model.getId_pedidos());

        // Retorna o id do registro inserido
        return banco.insert("produtos", null, values);
    }

    public ArrayList<Produtos> listar() {
        ArrayList<Produtos> lista = new ArrayList<>();
        Cursor cursor = banco.query("produtos", new String[]{"id", "tipo", "preco_produtos", "id_pedidos"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Produtos model = new Produtos();
            model.setId(cursor.getInt(0));
            model.setTipo(cursor.getString(1));
            model.setPreco_produtos(cursor.getString(2));
            model.setId_pedidos(cursor.getInt(3));

            lista.add(model);
        }

        return lista;
    }

    public Produtos ler(int id) {
        Produtos model = new Produtos();
        Cursor cursor = banco.query("produtos", new String[]{"id", "tipo", "preco_produtos", "id_pedidos"}, "id = ?", new String[]{String.valueOf(id)}, null, null, null);
        while (cursor.moveToNext()) {
            model.setId(cursor.getInt(0));
            model.setTipo(cursor.getString(1));
            model.setPreco_produtos(cursor.getString(2));
            model.setId_pedidos(cursor.getInt(3));
        }
        return model;
    }

    public long atualizar(Produtos model) {
        ContentValues values = new ContentValues();
        values.put("tipo", model.getTipo());
        values.put("preco_produtos", model.getPreco_produtos());
        values.put("id_pedidos",model.getId_pedidos());

        // Retorna o id do registro atualizado
        return banco.update("produtos", values, "id = ?", new String[]{String.valueOf(model.getId())});
    }

    public int excluir(Cliente model) {
        return banco.delete("produtos", "id = ?", new String[]{String.valueOf(model.getId())});
    }
}


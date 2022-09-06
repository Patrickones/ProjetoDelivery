package com.example.projetodelivery;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class PedidosDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public PedidosDAO(Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(Pedidos model) {
        ContentValues values = new ContentValues();
        values.put("statusped", model.getStatatusped());
        values.put("quantidade", model.getQuantidade());
        values.put("id_pedidos",model.getId_pedidos());

        // Retorna o id do registro inserido
        return banco.insert("pedidos", null, values);
    }

    public ArrayList<Pedidos> listar() {
        ArrayList<Pedidos> lista = new ArrayList<>();
        Cursor cursor = banco.query("pedidos", new String[]{"id", "statusped", "quantidade", "id_pedidos"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Pedidos model = new Pedidos();
            model.setId(cursor.getInt(0));
            model.setStatatusped(cursor.getString(1));
            model.setQuantidade(cursor.getString(2));
            model.setId_pedidos(cursor.getInt(3));

            lista.add(model);
        }

        return lista;
    }

    public Pedidos ler(int id) {
        Pedidos model = new Pedidos();
        Cursor cursor = banco.query("pedidos", new String[]{"id", "statusped", "quantidade", "id_pedidos"}, "id = ?", new String[]{String.valueOf(id)}, null, null, null);
        while (cursor.moveToNext()) {
            model.setId(cursor.getInt(0));
            model.setStatatusped(cursor.getString(1));
            model.setQuantidade(cursor.getString(2));
            model.setId_pedidos(cursor.getInt(3));
        }
        return model;
    }

    public long atualizar(Pedidos model) {
        ContentValues values = new ContentValues();
        values.put("statusped", model.getStatatusped());
        values.put("quantidade", model.getQuantidade());
        values.put("id_pedidos",model.getId_pedidos());

        // Retorna o id do registro atualizado
        return banco.update("pedidos", values, "id = ?", new String[]{String.valueOf(model.getId())});
    }

    public int excluir(Pedidos model) {
        return banco.delete("pedidos", "id = ?", new String[]{String.valueOf(model.getId())});
    }
}



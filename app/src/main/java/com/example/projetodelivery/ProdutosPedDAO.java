package com.example.projetodelivery;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ProdutosPedDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public ProdutosPedDAO(Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(ProdutosPed model) {
        ContentValues values = new ContentValues();
        values.put("id_pedidos",model.getId_pedidos());
        values.put("id_produtos",model.getId_produtos());

        // Retorna o id do registro inserido
        return banco.insert("produtosped", null, values);
    }

    public ArrayList<ProdutosPed> listar() {
        ArrayList<ProdutosPed> lista = new ArrayList<>();
        Cursor cursor = banco.query("produtosped", new String[]{"id", "id_pedidos","id_produtos"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            ProdutosPed model = new ProdutosPed();
            model.setId(cursor.getInt(0));
            model.setId_pedidos(cursor.getInt(1));
            model.setId_produtos(cursor.getInt(2));

            lista.add(model);
        }

        return lista;
    }

    public ProdutosPed ler(int id) {
        ProdutosPed model = new ProdutosPed();
        Cursor cursor = banco.query("produtosped", new String[]{"id", "id_pedidos", "id_produtos"}, "id = ?", new String[]{String.valueOf(id)}, null, null, null);
        while (cursor.moveToNext()) {
            model.setId(cursor.getInt(0));
            model.setId_pedidos(cursor.getInt(1));
            model.setId_produtos(cursor.getInt(2));
        }
        return model;
    }

    public long atualizar(ProdutosPed model) {
        ContentValues values = new ContentValues();
        values.put("id_pedidos", model.getId_pedidos());
        values.put("id_produtos",model.getId_produtos());

        // Retorna o id do registro atualizado
        return banco.update("produtosped", values, "id = ?", new String[]{String.valueOf(model.getId())});
    }

    public int excluir(Pedidos model) {
        return banco.delete("produtosped", "id = ?", new String[]{String.valueOf(model.getId())});
    }
}


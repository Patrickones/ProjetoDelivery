package com.example.projetodelivery;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class FornecedorDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public FornecedorDAO(Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(Fornecedor model) {
        ContentValues values = new ContentValues();
        values.put("nome", model.getNome());
        values.put("telefone", model.getTelefone());
        values.put("endereco",model.getEndereco());
        values.put("id_empresa",model.getId_empresa());
        ;

        // Retorna o id do registro inserido
        return banco.insert("fornecedor", null, values);
    }

    public ArrayList<Fornecedor> listar() {
        ArrayList<Fornecedor> lista = new ArrayList<>();
        Cursor cursor = banco.query("fornecedor", new String[]{"id", "nome", "telefone", "endereco", "id_empresa"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Fornecedor model = new Fornecedor();
            model.setId(cursor.getInt(0));
            model.setNome(cursor.getString(1));
            model.setTelefone(cursor.getString(2));
            model.setEndereco(cursor.getString(3));
            model.setId_empresa(cursor.getInt(4));

            lista.add(model);
        }

        return lista;
    }

    public Fornecedor ler(int id) {
        Fornecedor model = new Fornecedor();
        Cursor cursor = banco.query("fornecedor", new String[]{"id", "nome", "telefone", "endereco", "id_empresa"}, "id = ?", new String[]{String.valueOf(id)}, null, null, null);
        while (cursor.moveToNext()) {
            model.setId(cursor.getInt(0));
            model.setNome(cursor.getString(1));
            model.setTelefone(cursor.getString(2));
            model.setEndereco(cursor.getString(3));
            model.setId_empresa(cursor.getInt(4));
        }
        return model;
    }

    public long atualizar(Fornecedor model) {
        ContentValues values = new ContentValues();
        values.put("nome", model.getNome());
        values.put("telefone", model.getTelefone());
        values.put("endereco",model.getEndereco());
        values.put("id_empresa", model.getId_empresa());

        // Retorna o id do registro atualizado
        return banco.update("fornecedor", values, "id = ?", new String[]{String.valueOf(model.getId())});
    }

    public int excluir(Pedidos model) {
        return banco.delete("fornecedor", "id = ?", new String[]{String.valueOf(model.getId())});
    }
}

package com.example.projetodelivery;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class EmpresaDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public EmpresaDAO(Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(Empresa model) {
        ContentValues values = new ContentValues();
        values.put("nome", model.getNome());
        values.put("cnpj", model.getCnpj());
        values.put("telefone", model.getTelefone());
        values.put("endereco", model.getEndereco());
        values.put("id_pedidos",model.getId_pedidos());
        values.put("id_clientes",model.getId_clientes());

        // Retorna o id do registro inserido
        return banco.insert("Empresa", null, values);
    }

    public ArrayList<Empresa> listar() {
        ArrayList<Empresa> lista = new ArrayList<>();
        Cursor cursor = banco.query("empresa", new String[]{"id", "nome", "cnpj", "telefone", "endereco", "id_pedidos", "id_clientes"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Empresa model = new Empresa();
            model.setId(cursor.getInt(0));
            model.setNome(cursor.getString(1));
            model.setCnpj(cursor.getString(2));
            model.setTelefone(cursor.getString(3));
            model.setEndereco(cursor.getString(4));
            model.setId_pedidos(cursor.getInt(5));
            model.setId_clientes(cursor.getInt(6));
            lista.add(model);
        }

        return lista;
    }

    public Empresa ler(int id) {
        Empresa model = new Empresa();
        Cursor cursor = banco.query("Empresa", new String[]{"id", "nome", "cnpj", "telefone", "endereco", "id_pedidos", "id_clientes"}, "id = ?", new String[]{String.valueOf(id)}, null, null, null);
        while (cursor.moveToNext()) {
            model.setId(cursor.getInt(0));
            model.setNome(cursor.getString(1));
            model.setCnpj(cursor.getString(2));
            model.setTelefone(cursor.getString(3));
            model.setEndereco(cursor.getString(4));
            model.setId_pedidos(cursor.getInt(5));
            model.setId_clientes(cursor.getInt(6));
        }
        return model;
    }

    public long atualizar(Empresa model) {
        ContentValues values = new ContentValues();
        values.put("nome", model.getNome());
        values.put("cnpj", model.getCnpj());
        values.put("telefone", model.getTelefone());
        values.put("endereco",model.getEndereco());
        values.put("id_pedidos",model.getId_pedidos());
        values.put("id_clientes",model.getId_pedidos());

        // Retorna o id do registro atualizado
        return banco.update("Empresa", values, "id = ?", new String[]{String.valueOf(model.getId())});
    }

    public int excluir(Cliente model) {
        return banco.delete("Empresa", "id = ?", new String[]{String.valueOf(model.getId())});
    }
}



package com.example.projetodelivery;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexao extends SQLiteOpenHelper {

    private static final String name = "banco.db";
    private static final int version = 1;

    public Conexao(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE clientes (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome VARCHAR(255) NOT NULL," +
                "cpf VARCHAR (40)," +
                "telefone VARCHAR (40), " +
                "endereco VARCHAR (255), " +
                "id_pedidos INTEGER" +
                ")");

        db.execSQL("CREATE TABLE produtos (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "tipo VARCHAR (255), " +
                "preco_produtos VARCHAR (255), " +
                "id_pedidos INTEGER " +
                ")");

        db.execSQL("CREATE TABLE empresa (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome VARCAHR (255), " +
                "cnpj VARCHAR (40), " +
                "endereco VARCHAR (255), " +
                "telefone VARHCAR (40), " +
                "id_pedidos INTEGER, " +
                "id_clientes INTEGER " +
                ")");

        db.execSQL("CREATE TABLE produto_ped (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "id_pedidos INTEGER, " +
                "id_produtos INTEGER" +
                ")");

        db.execSQL("CREATE TABLE fornecedor ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome VARCHAR, " +
                "endereco VARCHAR, " +
                "telefone VARCHAR, " +
                "id_empresa INTEGER " +
                ")");

        db.execSQL("CREATE TABLE pedidos ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "statusped VARCHAR, " +
                "id_clientes INTEGER, " +
                "quantidade VARCHAR " +
                ")");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

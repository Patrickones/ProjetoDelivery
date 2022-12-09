package com.example.projetodelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    private EditText id_email;
    private EditText id_senha;
    private Button btn_entrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_entrar = (Button) findViewById(R.id.btn_entrar);
        btn_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id_email = (EditText) findViewById(R.id.id_email);
                id_senha = (EditText) findViewById(R.id.id_senha);
                 if (id_email.getText().toString().equals("email") && id_senha.getText().toString().equals("1234")){
                     setContentView(R.layout.activity_main);
                     getSupportActionBar().show();
                 }
            }
        });


    }

}
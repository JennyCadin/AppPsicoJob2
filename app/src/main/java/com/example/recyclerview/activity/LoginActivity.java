package com.example.recyclerview.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recyclerview.R;
import com.example.recyclerview.model.ItemList;


public class LoginActivity extends AppCompatActivity {

    private EditText txtIngresonombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        txtIngresonombre = (EditText)findViewById(R.id.txtIngresonombre);

        Button btnInsertar1 = findViewById(R.id.buttoningreso);
        Button btnInsertar = findViewById(R.id.button2);


        btnInsertar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,Bienvenido.class);
                intent.putExtra( "nombre",txtIngresonombre.getText().toString());

                startActivity(intent);
            }
        });

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,Formulario.class);
                startActivity(intent);
            }
        });



    }
}
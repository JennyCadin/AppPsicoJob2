package com.example.recyclerview.activity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.EditText;

import com.example.recyclerview.R;
import com.example.recyclerview.adaptador.RecyclerAdapter;
import com.example.recyclerview.model.ItemList;

import java.util.ArrayList;
import java.util.List;

public class Formulario extends AppCompatActivity {

    private EditText txtUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        txtUsuario = (EditText)findViewById(R.id.txtUsuario);

        Button btnInsertar = findViewById(R.id.btnInsertRegis);
        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Formulario.this,Bienvenido.class);
                intent.putExtra( "nombre",txtUsuario.getText().toString());

                startActivity(intent);
            }
        });
    }

}
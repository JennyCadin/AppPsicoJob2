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
import android.widget.TextView;

import com.example.recyclerview.R;
import com.example.recyclerview.adaptador.RecyclerAdapter;
import com.example.recyclerview.model.ItemList;

import java.util.ArrayList;
import java.util.List;

public class Bienvenido extends AppCompatActivity {

    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido);

        tv1 = (TextView) findViewById(R.id.tv1);
        String nombre = getIntent().getStringExtra("nombre");
        tv1.setText("Hola  "+ nombre+ " :D");

        Button btnInsertar = findViewById(R.id.button3);
        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bienvenido.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
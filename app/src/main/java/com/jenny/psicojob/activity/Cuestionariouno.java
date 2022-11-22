package com.jenny.psicojob.activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;

import com.jenny.psicojob.R;
import com.jenny.psicojob.adaptador.RecyclerAdapter;
import com.jenny.psicojob.model.ItemList;

import java.util.ArrayList;
import java.util.List;

public class Cuestionariouno extends AppCompatActivity {

    CheckBox c1,c2,c3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cuestionario_uno);

        c1= (CheckBox) findViewById(R.id.idChec1);
        c2= (CheckBox) findViewById(R.id.idChec2);
        c3= (CheckBox) findViewById(R.id.idChec3);

        Button btnInsertar = findViewById(R.id.buttonSgte);
        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cuestionariouno.this, Cuestionariodos.class);
                startActivity(intent);
            }
        });
    }

    public void onclick (View view){
        if (view.getId()==R.id.btn1) {
            validar();
        }

    }
    private void validar () {
        String cad="Seleccionado: \n";

        if (c1.isChecked()==true){
            cad+="Elegiste muy mala, dinos que debemos mejorar";
        }
        if (c2.isChecked()) {
            cad += "Elegiste buena, dinos que nos falta por mejorar";
        }
        if (c3.isChecked()) {
            cad += "Elegiste  muy buena, gracias";
        }

        Toast.makeText(getApplicationContext(), cad,Toast.LENGTH_SHORT).show();

    }
}
package com.jenny.psicojob.activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
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

public class Cuestionariodos extends AppCompatActivity {

    RadioButton r1, r2, r3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cuestionario_dos);

        r1 = (RadioButton) findViewById(R.id.idRadiouno);
        r2 = (RadioButton) findViewById(R.id.idRadiodos);
        r3 = (RadioButton) findViewById(R.id.idRadiotres);

        Button btnInsertar = findViewById(R.id.button5);
        Button btnInsertar1 = findViewById(R.id.buttonAnte);

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cuestionariodos.this, MainActivity2.class);
                startActivity(intent);


            }
        });


        btnInsertar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cuestionariodos.this, Cuestionariouno.class);
                startActivity(intent);


            }
        });

    }

    public void onclick(View view) {
        if (view.getId() == R.id.texopcionesdos) {
            validar();
        }

    }

    private void validar() {
        String cad = "Seleccionado: \n";

        if (r1.isChecked() == true) {
            cad += "La encontraste insuficiente, dinos qué le falta";
        }
        if (r2.isChecked()) {
            cad += "La encontraste buena ¿qué debemos mejorar?";
        }
        if (r3.isChecked()) {
            cad += "La encontraste muy buena, que bien¡¡";
        }

        Toast.makeText(getApplicationContext(), cad, Toast.LENGTH_SHORT).show();

    }
}

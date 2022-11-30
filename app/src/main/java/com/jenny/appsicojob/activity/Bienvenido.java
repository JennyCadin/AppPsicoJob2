package com.jenny.appsicojob.activity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.jenny.appsicojob.R;

public class Bienvenido extends AppCompatActivity {

    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido);

        tv1 = (TextView) findViewById(R.id.tv1);
        if(getIntent().hasExtra("nombre")){
            String nombre = getIntent().getStringExtra("nombre");
            tv1.setText("Hola  " + nombre + " :D");
        }

        Button btnInsertar1 = findViewById(R.id.button7);
        Button btnInsertar = findViewById(R.id.button3);
        Button btnCerrarSesion = findViewById(R.id.buttoncerrarsesion);

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bienvenido.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnInsertar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bienvenido.this, MapsActivity.class);
                startActivity(intent);


            }
        });

        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                finish();
            }
        });
    }
}
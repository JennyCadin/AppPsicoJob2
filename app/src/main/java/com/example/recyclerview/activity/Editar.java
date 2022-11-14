package com.example.recyclerview.activity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.recyclerview.R;


import androidx.appcompat.app.AppCompatActivity;

public class Editar extends AppCompatActivity {

    private EditText ed_nombre,ed_rut,ed_edad,ed_id,ed_telefono,ed_interes;
    private Button b_editar,b_eliminar,b_volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);


        ed_id = findViewById(R.id.txtId);
        ed_nombre = findViewById(R.id.txtUsuario);
        ed_rut = findViewById(R.id.txtRut);
        ed_edad = findViewById(R.id.txtEdad);
        ed_telefono = findViewById(R.id.txtTelefono);
        ed_interes = findViewById(R.id.txtInteres);

        b_editar = findViewById(R.id.btn_editar);
        b_eliminar = findViewById(R.id.btn_eliminar);
        b_volver = findViewById(R.id.btn_volver);

        Intent i = getIntent();

        String txtId = i.getStringExtra("id").toString();
        String txtUsuario = i.getStringExtra("nombre").toString();
        String txtRut = i.getStringExtra("rut").toString();
        String txtEdad = i.getStringExtra("edad").toString();
        String txtTelefono = i.getStringExtra("teléfono").toString();
        String txtInteres = i.getStringExtra("interés").toString();

        ed_id.setText(txtId);
        ed_nombre.setText(txtUsuario);
        ed_rut.setText(txtRut);
        ed_edad.setText(txtEdad);
        ed_telefono.setText(txtTelefono);
        ed_interes.setText(txtInteres);

        b_editar.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                editar();
            }
        });

        b_eliminar.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                eliminar();
            }
        });

        b_volver.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Intent i = new Intent(getApplicationContext(), Leer.class);
                startActivity(i);
            }
        });
    }

    public void eliminar()
    {
        try
        {
            String id = ed_id.getText().toString();

            SQLiteDatabase db = openOrCreateDatabase("BD_PSICOJOB", Context.MODE_PRIVATE,null);


            String sql = "delete from persona where id = ?";
            SQLiteStatement statement = db.compileStatement(sql);

            statement.bindString(1,id);
            statement.execute();
            Toast.makeText(this,"Datos eliminados de la base de datos.",Toast.LENGTH_LONG).show();

            ed_nombre.setText("");
            ed_rut.setText("");
            ed_edad.setText("");
            ed_telefono.setText("");
            ed_interes.setText("");
            ed_nombre.requestFocus();

        }
        catch (Exception ex)
        {
            Toast.makeText(this,"Error no se pudieron guardar los datos.",Toast.LENGTH_LONG).show();
        }
    }
    public void editar()
    {
        try
        {
            String nombre = ed_nombre.getText().toString();
            String rut = ed_rut.getText().toString();
            String edad = ed_edad.getText().toString();
            String telefono = ed_telefono.getText().toString();
            String interes = ed_interes.getText().toString();
            String id = ed_id.getText().toString();

            SQLiteDatabase db = openOrCreateDatabase("BD_PSICOBOH",Context.MODE_PRIVATE,null);

            String sql = "update persona set nombre = ?,rut=?,edad=?,telefono=?,interes=? where id= ?";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1,nombre);
            statement.bindString(2,rut);
            statement.bindString(3,edad);
            statement.bindString(4,telefono);
            statement.bindString(5,interes);
            statement.bindString(6,id);
            statement.execute();
            Toast.makeText(this,"Datos actualizados satisfactoriamente en la base de datos.",Toast.LENGTH_LONG).show();

            ed_nombre.setText("");
            ed_rut.setText("");
            ed_edad.setText("");
            ed_telefono.setText("");
            ed_interes.setText("");
            ed_nombre.requestFocus();
        }
        catch (Exception ex)
        {
            Toast.makeText(this,"Error no se pudieron guardar los datos.",Toast.LENGTH_LONG).show();
        }
    }
}
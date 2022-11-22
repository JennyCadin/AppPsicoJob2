package com.jenny.psicojob.activity;
import static com.jenny.psicojob.activity.Constants.NOMBRE_BASE_DATOS;

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

import com.jenny.psicojob.R;
import com.jenny.psicojob.adaptador.RecyclerAdapter;
import com.jenny.psicojob.model.ItemList;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;
import android.widget.Toast;

public class Formulario extends AppCompatActivity {

    private EditText txtUsuario;
    private EditText ed_nombre,ed_rut,ed_edad,ed_telefono,ed_interes;
    private Button b_agregar,b_ver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        txtUsuario = (EditText)findViewById(R.id.txtUsuario);
        ed_nombre = findViewById(R.id.txtUsuario);
        ed_rut = findViewById(R.id.txtRut);
        ed_edad = findViewById(R.id.txtEdad);
        ed_telefono = findViewById(R.id.txtTelefono);
        ed_interes = findViewById(R.id.txtInteres);

        b_agregar = findViewById(R.id.btnInsertRegis);
        b_ver= findViewById(R.id.button8);

        Button btnInsertar = findViewById(R.id.btnInsertRegis);
        Button btnInsertar2 = findViewById(R.id.button8);

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Formulario.this,Bienvenido.class);
                intent.putExtra( "nombre",txtUsuario.getText().toString());

                startActivity(intent);
            }
        });

        btnInsertar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Leer.class);
                startActivity(intent);


            }
        });
        b_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertar();
            }
        });

    }

    public void insertar()
    {
        try
        {
            String nombre = ed_nombre.getText().toString();
            String rut = ed_rut.getText().toString();
            String edad = ed_edad.getText().toString();
            String telefono = ed_telefono.getText().toString();
            String interes = ed_interes.getText().toString();

            SQLiteDatabase db = openOrCreateDatabase(NOMBRE_BASE_DATOS, Context.MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE IF NOT EXISTS persona(id INTEGER PRIMARY KEY AUTOINCREMENT,nombre VARCHAR,rut VARCHAR,edad VARCHAR,telefono VARCHAR,interes VARCHAR)");

            String sql = "insert into persona(nombre,rut,edad,telefono,interes)values(?,?,?,?,?)";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1,nombre);
            statement.bindString(2,rut);
            statement.bindString(3,edad);
            statement.bindString(4,telefono);
            statement.bindString(5,interes);

            statement.execute();
            Toast.makeText(this,"Datos agregados satisfactoriamente, felicitaciones.",Toast.LENGTH_LONG).show();

            ed_nombre.setText("");
            ed_rut.setText("");
            ed_edad.setText("");
            ed_telefono.setText("");
            ed_interes.setText("");
            ed_nombre.requestFocus();
        }
        catch (Exception ex)
        {
            Toast.makeText(this,"Error, no se guardaron los datos, intente nuevamente.",Toast.LENGTH_LONG).show();
        }
    }
}



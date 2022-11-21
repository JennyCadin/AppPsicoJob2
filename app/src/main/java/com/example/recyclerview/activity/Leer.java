package com.example.recyclerview.activity;

import static com.example.recyclerview.activity.Constants.NOMBRE_BASE_DATOS;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import com.example.recyclerview.R;

public class Leer extends AppCompatActivity {
    private ListView lst1;
    private ArrayList<String> arreglo = new ArrayList<String>();
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        try{
            SQLiteDatabase db = openOrCreateDatabase(NOMBRE_BASE_DATOS, Context.MODE_PRIVATE,null);
            lst1 = findViewById(R.id.lst1);
            final Cursor c = db.rawQuery("select * from persona",null);
            int id = c.getColumnIndex("id");
            int nombre = c.getColumnIndex("nombre");
            int rut = c.getColumnIndex("rut");
            int edad = c.getColumnIndex("edad");
            int telefono = c.getColumnIndex("telefono");
            int interes = c.getColumnIndex("interes");
            arreglo.clear();

            arrayAdapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,arreglo);

            lst1.setAdapter(arrayAdapter);

            final  ArrayList<Persona> lista = new ArrayList<Persona>();


            if(c.moveToFirst())
            {
                do{
                    Persona persona = new Persona();
                    persona.id = c.getString(id);
                    persona.nombre = c.getString(nombre);
                    persona.rut = c.getString(rut);
                    persona.edad = c.getString(edad);
                    persona.telefono = c.getString(telefono);
                    persona.interes = c.getString(interes);
                    lista.add(persona);

                    arreglo.add(c.getString(id) + " \t " + c.getString(nombre) + " \t "  + c.getString(rut) + " \t "  + c.getString(edad) + " \t "  + c.getString(telefono)+ " \t "  + c.getString(interes));

                } while(c.moveToNext());
                arrayAdapter.notifyDataSetChanged();
                lst1.invalidateViews();
            }

            lst1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, android.view.View view, int position, long l) {
                    Persona persona = lista.get(position);
                    Intent i = new Intent(getApplicationContext(), Editar.class);
                    i.putExtra("id",persona.id);
                    i.putExtra("nombre",persona.nombre);
                    i.putExtra("rut",persona.rut);
                    i.putExtra("edad",persona.edad);
                    i.putExtra("telefono",persona.telefono);
                    i.putExtra("interes",persona.interes);
                    startActivity(i);
                }
            });
        }
        catch (Exception e){
            Toast.makeText(this, "Ha ocurrido un error, intentalo nuevamente.", Toast.LENGTH_SHORT).show();
        }

    }
}


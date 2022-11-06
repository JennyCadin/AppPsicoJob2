package com.example.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import com.example.recyclerview.R;
import com.example.recyclerview.adaptador.RecyclerAdapter;
import com.example.recyclerview.model.ItemList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.RecyclerItemClick, SearchView.OnQueryTextListener {
    private RecyclerView rvLista;
    private SearchView svSearch;
    private RecyclerAdapter adapter;
    private List<ItemList> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initValues();
        initListener();


        Button btnInsertar = findViewById(R.id.button4);
        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Cuestionariouno.class);
                startActivity(intent);
            }
        });

    }



    private void initViews(){
        rvLista = findViewById(R.id.rvLista);
        svSearch = findViewById(R.id.svSearch);
    }

    private void initValues() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvLista.setLayoutManager(manager);

        items = getItems();
        adapter = new RecyclerAdapter(items, this);
        rvLista.setAdapter(adapter);
    }

    private void initListener() {
        svSearch.setOnQueryTextListener(this);
    }

    private List<ItemList> getItems() {
        List<ItemList> listaMenu = new ArrayList<>();

        ItemList detalleTemas = new ItemList("Arma tu curriculum",getString(R.string.descripcion_temas), getString(R.string.descripcion_larga), R.drawable.cv);
        listaMenu.add(detalleTemas);

        listaMenu.add(new ItemList("¿Qué es una entrevista psicolaboral?", "Rxxxxxxxx.","xsxsxsx", R.drawable.queesentrev));

        listaMenu.add(new ItemList("Tips para rendir una buena entrevista", "xxxxx","xsxsxsx", R.drawable.entrevista));
        listaMenu.add(new ItemList("¿Qué es Linkedin?", "XXXXXX.","xsxsxsx", R.drawable.linkedin));
        listaMenu.add(new ItemList("¿Qué es una entrevista por competencia? ", "xxxxxxx","xsxsxsx", R.drawable.competenciaentre));
        listaMenu.add(new ItemList("¿Cómo manejar la ansiedad y nerviosismo?", "xxxxx.","xsxsxsx", R.drawable.ansiedad));
        listaMenu.add(new ItemList("Tips para afrontar entrevista online", "xxxxxxxxxxx.", "xsxsxsx", R.drawable.entrevonline));
        listaMenu.add(new ItemList("Tips para negociar sueldo", "XXXXXXXXX.","xsxsxsx", R.drawable.sueldo));
        listaMenu.add(new ItemList("¿Qué debo cuidar antes de firmar un contrato?", "XXXXXXXXXXXXXXXXX.","xsxsxsx", R.drawable.contrato));
        listaMenu.add(new ItemList("¿Sirve aprender los test psicológicos?", "XXXXXXXX.","xsxsxsx", R.drawable.psicologico));
        listaMenu.add(new ItemList("Listado plataformas para postular a empleo", "En este apartado, te mostramos un listado de plataformas para postular a empleos, las más utilizadas.","Laborum.com, Trabajando.com, Computrabajo, GetonBoard, EmpleosPublicos, BNE, AiraVirtual.", R.drawable.plataformas));


        return listaMenu;
    }

    @Override
    public void itemClick(ItemList item) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("itemDetail", item);
        startActivity(intent);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.filter(newText);
        return false;

        }




    }


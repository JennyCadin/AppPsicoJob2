package com.jenny.psicojob.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.AsyncTask;
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
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jenny.psicojob.R;
import com.jenny.psicojob.adaptador.RecyclerAdapter;
import com.jenny.psicojob.model.ItemList;

import java.util.ArrayList;
import java.util.List;


public class MainActivity3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
    public void openProximity(View view) {
        startActivity(new Intent(MainActivity3.this,
                ProximityActivity.class));
    }
    public void openGyroscope(View view) {
        startActivity(new Intent(MainActivity3.this,
                GyroscopeActivity.class));
    }
    public void openRotationVector(View view) {
        startActivity(new Intent(MainActivity3.this,
                RotationVectorActivity.class));
    }
}
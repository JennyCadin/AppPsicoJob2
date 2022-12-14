package com.jenny.appsicojob.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.ProgressBar;
import android.widget.Toast;

import com.jenny.appsicojob.R;

public class MainActivity2 extends AppCompatActivity implements
        View.OnClickListener {
    Button button;
    Button button2;
    Button button3;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.buttonRegistro);
        button3 = (Button)findViewById(R.id.button3);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        Button btnInsertar = findViewById(R.id.button6);

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);


            }
        });
    }

    private void UnSegundo(){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){}
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                for(int i=1; i<=10; i++){
                    UnSegundo();
                }
                Toast.makeText(getBaseContext(), "Tarea larga finalizada", Toast.LENGTH_LONG).show();
                break;
            case R.id.buttonRegistro:
                Hilos();
                break;
            case R.id.button3:
                EjemploAsyncTask ejemploAsyncTask = new
                        EjemploAsyncTask();
                ejemploAsyncTask.execute();
                break;
            default:
                break;
        }
    }
    void Hilos(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1; i<=10; i++){
                    UnSegundo();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getBaseContext(), "Tarea larga finalizada", Toast.LENGTH_LONG).show();
                    }
                });
            }
        }).start();
    }
    private class EjemploAsyncTask extends
            AsyncTask<Void,Integer,Boolean> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setMax(100);
            progressBar.setProgress(0);
        }
        @Override
        protected Boolean doInBackground(Void... params) {
            for(int i=1; i<=10; i++){
                UnSegundo();
                publishProgress(i*10);
                if(isCancelled()){
                    break;
                }
            }
            return true;
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0].intValue());
        }
        @Override
        protected void onPostExecute(Boolean resultado) {
            //super.onPostExecute(aVoid);
            if(resultado){
                Toast.makeText(getBaseContext(), "Tarea larga finalizada en AsyncTask", Toast.LENGTH_LONG).show();
            }
        }
        @Override
        protected void onCancelled() {
            super.onCancelled();
            Toast.makeText(getBaseContext(), "Tarea larga ha sido cancelada", Toast.LENGTH_LONG).show();
        }
    }
}
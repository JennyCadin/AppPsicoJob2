package com.jenny.appsicojob.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jenny.appsicojob.R;


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
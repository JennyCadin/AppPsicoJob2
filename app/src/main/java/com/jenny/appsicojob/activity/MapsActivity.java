package com.jenny.appsicojob.activity;
import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

import com.jenny.appsicojob.R;

import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;


    public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {
        private static final String TAG = "Giroscopio";
        private SensorManager sensorManager;
        private Sensor gyroscopeSensor;
        private SensorEventListener gyroscopeSensorListener;
        private GoogleMap mMap;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_maps);
            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);

            inicializarGiroscopio();
        }

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera. In this case,
         * we just add a marker near Santiago, Chile
         *
         * If Google Play services is not installed on the device, the user will be prompted to install
         * it inside the SupportMapFragment. This method will only be triggered once the user has
         * installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;

            // Add a marker in Sydney and move the camera
            LatLng santiago = new LatLng(-33.4507869, -70.6528784);
            mMap.addMarker(new MarkerOptions()
                    .position(santiago)
                    .title("Oficina PsycoJob"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(santiago));


        }
        public void inicializarGiroscopio (){
            // Initialize sensor manager
            sensorManager =
                    (SensorManager) getSystemService(SENSOR_SERVICE);
            // Using gyroscope sensor
            gyroscopeSensor =
                    sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
            if(gyroscopeSensor == null) {
                Log.e(TAG, "Gyroscope sensor not available.");
                finish();
            }
            gyroscopeSensorListener = new SensorEventListener() {
                @Override
                public void onSensorChanged(SensorEvent sensorEvent) {
                    Toast.makeText(getApplicationContext(), "Valor es " + sensorEvent.values[2], Toast.LENGTH_LONG).show();

                    if(sensorEvent.values[2] > 0.5f) { // anticlockwise
                        if (mMap !=null){
                            MapStyleOptions mapStyleOptions = MapStyleOptions.loadRawResourceStyle(getApplicationContext(), R.raw.mapaoscuro);
                            mMap.setMapStyle(mapStyleOptions);
                        }


                    } else  { // clockwise
                        if (mMap !=null){
                            MapStyleOptions mapStyleOptions = MapStyleOptions.loadRawResourceStyle(getApplicationContext(), R.raw.mapaclaro);
                            mMap.setMapStyle(mapStyleOptions);
                        }

                    }
                }
                @Override
                public void onAccuracyChanged(Sensor sensor, int i) {
                }
            };

        }
        @Override
        protected void onResume() {
            super.onResume();
            if (sensorManager != null){

                sensorManager.registerListener(gyroscopeSensorListener,
                        gyroscopeSensor, SensorManager.SENSOR_DELAY_NORMAL);
            }

        }
        @Override
        protected void onPause() {
            super.onPause();
            if (sensorManager != null){
                sensorManager.unregisterListener(gyroscopeSensorListener);
            }

        }

    }





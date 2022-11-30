package com.jenny.appsicojob.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jenny.appsicojob.R;


public class LoginActivity extends AppCompatActivity {

    Button buttoningreso;
    EditText ingresonombre, email, password;


    private EditText txtIngresonombre;
    private EditText editEmail;
    private EditText editPassword;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        txtIngresonombre = (EditText)findViewById(R.id.txtIngresonombre);
        editEmail = (EditText)findViewById(R.id.editEmail);
        editPassword =(EditText)findViewById(R.id.editPassword);


        Button buttonIngreso = findViewById(R.id.buttoningreso);
        Button buttonRegistro = findViewById(R.id.buttonRegistro);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        buttonIngreso.setOnClickListener(view -> {
            String nombre = txtIngresonombre.getText().toString();
            String email = editEmail.getText().toString();
            String password = editPassword.getText().toString();

            txtIngresonombre.setText("");
            editEmail.setText("");
            editPassword.setText("");

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, task -> {
                        if (task.isSuccessful()) {

                            FirebaseUser userFirebase = mAuth.getCurrentUser();
                            mDatabase = FirebaseDatabase.getInstance().getReference();
                            User user = new User(nombre, email);

                            mDatabase.child("users").child(userFirebase.getUid()).setValue(user);


                        Intent intent = new Intent(LoginActivity.this, Bienvenido.class);
                        intent.putExtra("nombre", nombre);


                        startActivity(intent);

                    }
                        else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(this, "Datos ingresados incorrectamente, intente nuevamente", Toast.LENGTH_SHORT).show();
                        System.out.println("error app"+ task.getException());
                        }
                    });
        });

        buttonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,Formulario.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(LoginActivity.this, Bienvenido.class);

            startActivity(intent);
        }
    }
}
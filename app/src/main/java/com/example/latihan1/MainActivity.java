package com.example.latihan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Variable componen
    EditText txtUsername;
    EditText txtPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //koneksi var komponen ke layout ID
        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Action button
                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();


                if (username.equals("fakhry") && password.equals("fakhry")) {
                    Toast.makeText(MainActivity.this, "Login Berhasil", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, kalkulatorr.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Login Gagal", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}
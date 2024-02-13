package com.example.latihan1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class kalkulatorr extends AppCompatActivity {

    // Variable komponen
    EditText txtAngka1, txtAngka2;
    Button btnHitung;
    Spinner spinnerOperator;
    TextView txtHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulatorr);

        // Koneksi var komponen ke layout ID
        txtAngka1 = findViewById(R.id.txtangka1);
        txtAngka2 = findViewById(R.id.txtangka2);
        btnHitung = findViewById(R.id.Klikhasil);
        spinnerOperator = findViewById(R.id.sistemAritmatik);
        txtHasil = findViewById(R.id.hasilnya);

        // Set data operator pada Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.arrOperator,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOperator.setAdapter(adapter);

        // Set listener pada tombol hitung
        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungHasil();
            }
        });
    }

    private void hitungHasil() {
        // Ambil angka dari EditText
        String strAngka1 = txtAngka1.getText().toString();
        String strAngka2 = txtAngka2.getText().toString();

        // Proteksi jika angka1 atau angka2 kosong
        if (strAngka1.isEmpty() || strAngka2.isEmpty()) {
            Toast.makeText(this, "Masukkan kedua angka", Toast.LENGTH_SHORT).show();
            return;
        }

        double angka1 = Double.parseDouble(strAngka1);
        double angka2 = Double.parseDouble(strAngka2);

        // Ambil operator dari Spinner
        String operator = spinnerOperator.getSelectedItem().toString();

        // Proteksi jika pembagian dengan 0
        if (operator.equals("Bagi") && angka2 == 0) {
            Toast.makeText(this, "Pembagian dengan 0 tidak diizinkan", Toast.LENGTH_SHORT).show();
            return;
        }

        // Hitung hasil sesuai operator
        double hasil = 0;
        switch (operator) {
            case "Tambah":
                hasil = angka1 + angka2;
                break;
            case "Kurang":
                hasil = angka1 - angka2;
                break;
            case "Kali":
                hasil = angka1 * angka2;
                break;
            case "Bagi":
                hasil = angka1 / angka2;
                break;
        }

        // Tampilkan hasil di TextView
        txtHasil.setText("Hasil: " + hasil);
    }
}

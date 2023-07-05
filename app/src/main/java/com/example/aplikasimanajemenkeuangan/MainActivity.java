package com.example.aplikasimanajemenkeuangan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buttonpemasukan;
    Button buttonpengeluaran;
    Button buttonanggaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonpengeluaran = findViewById(R.id.button1);
        buttonpemasukan = findViewById(R.id.button2);
        buttonanggaran = findViewById(R.id.button);

        buttonpengeluaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah_ke_pengeluaran = new Intent(MainActivity.this,Pengeluaran.class);
                startActivity(pindah_ke_pengeluaran);
            }
        });

        buttonpemasukan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah_ke_pemasukan = new Intent(MainActivity.this,Pemasukan.class);
                startActivity(pindah_ke_pemasukan);
            }
        });

        buttonanggaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah_ke_anggaran = new Intent(MainActivity.this,Anggaran.class);
                startActivity(pindah_ke_anggaran);
            }
        });


    }

}
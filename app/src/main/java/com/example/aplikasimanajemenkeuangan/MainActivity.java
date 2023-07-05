package com.example.aplikasimanajemenkeuangan;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.aplikasimanajemenkeuangan.adaptersAndListeners.SQLiteAdapter;

public class MainActivity extends AppCompatActivity {
    Button buttonpemasukan;
    Button buttonpengeluaran;
    Button buttonanggaran;
    private SQLiteAdapter sqliteAdapter;
    private int totalJumlahPemasukan;
    private int totalJumlahPengeluaran;
    private int lastAddedAnggaran;

    private static final int REQUEST_CODE_PEMASUKAN = 1;
    private static final int REQUEST_CODE_PENGELUARAN = 2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sqliteAdapter = new SQLiteAdapter(MainActivity.this);
        TextView textViewPemasukan = findViewById(R.id.textViewPemasukan);
        TextView textViewPengeluaran = findViewById(R.id.textViewPengeluaran);
        TextView textViewAnggaran = findViewById(R.id.textViewAnggaran);

        updatePemasukanPengeluaranAnggaran();

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
    private void updatePemasukanPengeluaranAnggaran() {
        totalJumlahPemasukan = sqliteAdapter.getLastAddedPemasukanJumlah();
        totalJumlahPengeluaran = sqliteAdapter.getLastAddedPengeluaranJumlah();
        lastAddedAnggaran = sqliteAdapter.getLastAddedAnggaran();

        TextView textViewPemasukan = findViewById(R.id.textViewPemasukan);
        textViewPemasukan.setText("+ Rp. " + totalJumlahPemasukan);

        TextView textViewPengeluaran = findViewById(R.id.textViewPengeluaran);
        textViewPengeluaran.setText("- Rp. " + totalJumlahPengeluaran);

        TextView textViewAnggaran = findViewById(R.id.textViewAnggaran);
        int totalAnggaran = lastAddedAnggaran + totalJumlahPemasukan - totalJumlahPengeluaran;
        textViewAnggaran.setText("Rp. " + totalAnggaran);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null) {
            if (requestCode == REQUEST_CODE_PEMASUKAN) {
                int jumlahPemasukan = data.getIntExtra("jumlah_pemasukan", 0);
                totalJumlahPemasukan += jumlahPemasukan;
            } else if (requestCode == REQUEST_CODE_PENGELUARAN) {
                int jumlahPengeluaran = data.getIntExtra("jumlah_pengeluaran", 0);
                totalJumlahPengeluaran += jumlahPengeluaran;
            }

            int totalAnggaran = lastAddedAnggaran + totalJumlahPemasukan - totalJumlahPengeluaran;
            com.example.aplikasimanajemenkeuangan.model.Anggaran anggaran = new com.example.aplikasimanajemenkeuangan.model.Anggaran(lastAddedAnggaran, totalAnggaran);
            sqliteAdapter.updateAnggaran(anggaran);

            TextView textViewAnggaran = findViewById(R.id.textViewAnggaran);
            textViewAnggaran.setText("Rp. " + totalAnggaran);
        }
    }



}
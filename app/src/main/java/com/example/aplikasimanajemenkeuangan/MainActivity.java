package com.example.aplikasimanajemenkeuangan;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button buttonpemasukan;
    Button buttonpengeluaran;
    Button buttonanggaran;
    private static final int REQUEST_CODE_ANGGARAN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonpengeluaran = findViewById(R.id.button1);
        buttonpemasukan = findViewById(R.id.button2);
        buttonanggaran = findViewById(R.id.button);
        int lastAddedPemasukanJumlah = getIntent().getIntExtra("lastAddedPemasukanJumlah", 0);
        TextView textViewPemasukan = findViewById(R.id.textViewPemasukan);
        textViewPemasukan.setText("Last Pemasukan: " + lastAddedPemasukanJumlah);

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

        Intent intent = getIntent();
        int addedAnggaran = intent.getIntExtra("addedAnggaran", 0);

        TextView textViewAnggaran = findViewById(R.id.textViewAnggaran);
        textViewAnggaran.setText("Rp. " + addedAnggaran);






    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_ANGGARAN && resultCode == RESULT_OK) {
            int addedAnggaran = data.getIntExtra("addedAnggaran", 0);
            TextView textViewAnggaran = findViewById(R.id.textViewAnggaran);
            textViewAnggaran.setText("Rp. " + addedAnggaran);
        }
    }


}
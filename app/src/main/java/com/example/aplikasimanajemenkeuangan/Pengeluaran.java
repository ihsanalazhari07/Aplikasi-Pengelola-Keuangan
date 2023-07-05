package com.example.aplikasimanajemenkeuangan;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aplikasimanajemenkeuangan.adaptersAndListeners.SQLiteAdapter;

import java.util.Calendar;

public class Pengeluaran extends AppCompatActivity {
    Button detail_pengeluaran;
    private EditText tanggalPengeluaran;

    private int tahun, bulan, tanggal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengeluaran);

        //Membuat tampilan inputan kalender
        tanggalPengeluaran = findViewById(R.id.tanggalPengeluaran);
        tanggalPengeluaran.setShowSoftInputOnFocus(false);
        tanggalPengeluaran.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Calendar calendar = Calendar.getInstance();
            tahun = calendar.get(Calendar.YEAR);
            bulan = calendar.get(Calendar.MONTH);
            tanggal = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog;
            dialog = new DatePickerDialog(Pengeluaran.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    tahun = year;
                    bulan = month;
                    tanggal = dayOfMonth;

                    tanggalPengeluaran.setText(tanggal+"-"+bulan+"-"+tahun);
                }
            },tahun, bulan, tanggal);
            dialog.show();
        }
        });

        //Pindah ke activity pengeluaran
        detail_pengeluaran = findViewById(R.id.detailPengeluaran);

        detail_pengeluaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah_ke_detailPengeluaran = new Intent(Pengeluaran.this,Detail_Pengeluaran.class);
                startActivity(pindah_ke_detailPengeluaran);
            }
        });

        Button simpanPengeluaran = findViewById(R.id.simpanPengeluaran);
        simpanPengeluaran.setOnClickListener(new View.OnClickListener() {
            int incrementedIdPengeluaran = 1;

            @Override
            public void onClick(View v) {
                String kategoriPengeluaran = ((EditText) findViewById(R.id.kategoriPengeluaran)).getText().toString();
                String tanggalPengeluaranText = ((EditText) findViewById(R.id.tanggalPengeluaran)).getText().toString();
                int jumlahPengeluaran = Integer.parseInt(((EditText) findViewById(R.id.jumlahPengeluaran)).getText().toString());

                incrementedIdPengeluaran++;
                com.example.aplikasimanajemenkeuangan.model.Pengeluaran pengeluaran = new com.example.aplikasimanajemenkeuangan.model.Pengeluaran(incrementedIdPengeluaran, kategoriPengeluaran, tanggalPengeluaranText, jumlahPengeluaran);

                SQLiteAdapter sqliteAdapter = new SQLiteAdapter(Pengeluaran.this);
                boolean success = sqliteAdapter.addPengeluaran(pengeluaran);

                if (success) {
                    int lastAddedPengeluaran = sqliteAdapter.getLastAddedPengeluaranJumlah();
                    Toast.makeText(Pengeluaran.this, "Pengeluaran added successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Pengeluaran.this, MainActivity.class);
                    intent.putExtra("lastAddedPengeluaran", lastAddedPengeluaran);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(Pengeluaran.this, "Failed to add Pengeluaran", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
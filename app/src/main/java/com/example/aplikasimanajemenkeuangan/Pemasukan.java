package com.example.aplikasimanajemenkeuangan;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class Pemasukan extends AppCompatActivity {
    Button detail_pemasukan;
    private EditText tanggalPemasukan;

    private int tahun, bulan, tanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemasukan);
        tanggalPemasukan = findViewById(R.id.tanggalPemasukan);
        tanggalPemasukan.setShowSoftInputOnFocus(false);
        tanggalPemasukan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                tahun = calendar.get(Calendar.YEAR);
                bulan = calendar.get(Calendar.MONTH);
                tanggal = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog;
                dialog = new DatePickerDialog(Pemasukan.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tahun = year;
                        bulan = month;
                        tanggal = dayOfMonth;

                        tanggalPemasukan.setText(tanggal+"-"+bulan+"-"+tahun);
                    }
                },tahun, bulan, tanggal);
                dialog.show();
            }
        });

        detail_pemasukan = findViewById(R.id.detailPemasukan);

        detail_pemasukan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah_ke_detailPemasukan = new Intent(Pemasukan.this,Detail_Pemasukan.class);
                startActivity(pindah_ke_detailPemasukan);
            }
        });
    }
}
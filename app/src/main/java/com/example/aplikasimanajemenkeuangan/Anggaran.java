package com.example.aplikasimanajemenkeuangan;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class Anggaran extends AppCompatActivity {
    private EditText tanggalMulai, tanggalSelesai;

    private int tahun, bulan, tanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anggaran);

        //Kalender Anggaran Mulai
        tanggalMulai = findViewById(R.id.tanggalMulai);
        tanggalMulai.setShowSoftInputOnFocus(false);
        tanggalMulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                tahun = calendar.get(Calendar.YEAR);
                bulan = calendar.get(Calendar.MONTH);
                tanggal = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog;
                dialog = new DatePickerDialog(Anggaran.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tahun = year;
                        bulan = month;
                        tanggal = dayOfMonth;

                        tanggalMulai.setText(tanggal+"-"+bulan+"-"+tahun);
                    }
                },tahun, bulan, tanggal);
                dialog.show();
            }
        });

        //Kalender Anggaran Selesai
        tanggalSelesai = findViewById(R.id.tanggalSelesai);
        tanggalSelesai.setShowSoftInputOnFocus(false);
        tanggalSelesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                tahun = calendar.get(Calendar.YEAR);
                bulan = calendar.get(Calendar.MONTH);
                tanggal = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog;
                dialog = new DatePickerDialog(Anggaran.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tahun = year;
                        bulan = month;
                        tanggal = dayOfMonth;

                        tanggalSelesai.setText(tanggal+"-"+bulan+"-"+tahun);
                    }
                },tahun, bulan, tanggal);
                dialog.show();
            }
        });

    }
}
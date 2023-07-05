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

        // Simpan Button
        Button simpanButton = findViewById(R.id.simpanPengeluaran);
        simpanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the input values
                int jumlahAnggaran = Integer.parseInt(((EditText) findViewById(R.id.jumlahAnggaran)).getText().toString());
                String tanggalMulaiText = tanggalMulai.getText().toString();
                String tanggalSelesaiText = tanggalSelesai.getText().toString();

                // Create an Anggaran object
                com.example.aplikasimanajemenkeuangan.model.Anggaran anggaran = new com.example.aplikasimanajemenkeuangan.model.Anggaran(9, jumlahAnggaran, tanggalMulaiText, tanggalSelesaiText);


                // Add the Anggaran to the database
                SQLiteAdapter sqliteAdapter = new SQLiteAdapter(Anggaran.this);
                boolean success = sqliteAdapter.addAnggaran(anggaran);

                if (success) {
                    Toast.makeText(Anggaran.this, "Anggaran added successfully", Toast.LENGTH_SHORT).show();
                    int addedAnggaran = anggaran.getJumlah_anggaran(); // Retrieve the added jumlah_anggaran
                    Intent intent = new Intent(Anggaran.this, MainActivity.class);
                    intent.putExtra("addedAnggaran", addedAnggaran);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(Anggaran.this, "Failed to add Anggaran", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
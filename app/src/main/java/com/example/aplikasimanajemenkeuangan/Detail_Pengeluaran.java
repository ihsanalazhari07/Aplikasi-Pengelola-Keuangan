package com.example.aplikasimanajemenkeuangan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.aplikasimanajemenkeuangan.adaptersAndListeners.PengeluaranAdapter;
import com.example.aplikasimanajemenkeuangan.adaptersAndListeners.SQLiteAdapter;
import com.example.aplikasimanajemenkeuangan.model.Pengeluaran;

import java.util.List;

public class Detail_Pengeluaran extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pengeluaran);
        ListView listViewPengeluaran = findViewById(R.id.listViewPengeluaran);

        // Retrieve pemasukan items from the database
        SQLiteAdapter sqliteAdapter = new SQLiteAdapter(Detail_Pengeluaran.this);
        List<Pengeluaran> pengeluaranList = sqliteAdapter.getAllPengeluaran();

        // Create the adapter and set it on the ListView
        PengeluaranAdapter pengeluaranAdapter = new PengeluaranAdapter(Detail_Pengeluaran.this, pengeluaranList);
        listViewPengeluaran.setAdapter(pengeluaranAdapter);
    }
}
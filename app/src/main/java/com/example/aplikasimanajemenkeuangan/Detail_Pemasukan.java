package com.example.aplikasimanajemenkeuangan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.aplikasimanajemenkeuangan.adaptersAndListeners.PemasukanAdapter;
import com.example.aplikasimanajemenkeuangan.adaptersAndListeners.SQLiteAdapter;
import com.example.aplikasimanajemenkeuangan.model.Pemasukan;

import java.util.List;

public class Detail_Pemasukan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pemasukan);
        ListView listViewPemasukan = findViewById(R.id.listViewPemasukan);

        // Retrieve pemasukan items from the database
        SQLiteAdapter sqliteAdapter = new SQLiteAdapter(Detail_Pemasukan.this);
        List<Pemasukan> pemasukanList = sqliteAdapter.getAllPemasukan();

        // Create the adapter and set it on the ListView
        PemasukanAdapter pemasukanAdapter = new PemasukanAdapter(Detail_Pemasukan.this, pemasukanList);
        listViewPemasukan.setAdapter(pemasukanAdapter);
    }
}
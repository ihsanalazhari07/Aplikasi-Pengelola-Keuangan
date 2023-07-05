package com.example.aplikasimanajemenkeuangan.adaptersAndListeners;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.aplikasimanajemenkeuangan.R;
import com.example.aplikasimanajemenkeuangan.model.Pengeluaran;

import java.util.List;

public class PengeluaranAdapter extends ArrayAdapter<Pengeluaran> {

    private Context context;
    private List<Pengeluaran> pengeluaranList;

    public PengeluaranAdapter(Context context, List<Pengeluaran> pengeluaranList) {
        super(context, 0, pengeluaranList);
        this.context = context;
        this.pengeluaranList = pengeluaranList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_pengeluaran, parent, false);
        }

        Pengeluaran pengeluaran = getItem(position);

        TextView textViewIdPengeluaran = convertView.findViewById(R.id.textViewIdPengeluaran);
        TextView textViewKategoriPengeluaran = convertView.findViewById(R.id.textViewKategoriPengeluaran);
        TextView textViewTanggalPengeluaran = convertView.findViewById(R.id.textViewTanggalPengeluaran);
        TextView textViewJumlahPengeluaran = convertView.findViewById(R.id.textViewJumlahPengeluaran);

        textViewIdPengeluaran.setText("No. : " + String.valueOf(pengeluaran.getId_pengeluaran()));
        textViewKategoriPengeluaran.setText("Kategori : " + pengeluaran.getKategori_pengeluaran());
        textViewTanggalPengeluaran.setText("Tanggal : " + pengeluaran.getTanggal_pengeluaran());
        textViewJumlahPengeluaran.setText("Jumlah : " + String.valueOf(pengeluaran.getJumlah_pengeluaran()));

        return convertView;
    }

}


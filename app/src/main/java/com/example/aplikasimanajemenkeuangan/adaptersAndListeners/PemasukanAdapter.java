package com.example.aplikasimanajemenkeuangan.adaptersAndListeners;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.aplikasimanajemenkeuangan.R;
import com.example.aplikasimanajemenkeuangan.model.Pemasukan;

import java.util.List;

public class PemasukanAdapter extends ArrayAdapter<Pemasukan> {

    private Context context;
    private List<Pemasukan> pemasukanList;

    public PemasukanAdapter(Context context, List<Pemasukan> pemasukanList) {
        super(context, 0, pemasukanList);
        this.context = context;
        this.pemasukanList = pemasukanList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_pemasukan, parent, false);
        }

        Pemasukan pemasukan = getItem(position);

        TextView textViewIdPemasukan = convertView.findViewById(R.id.textViewIdPemasukan);
        TextView textViewKategoriPemasukan = convertView.findViewById(R.id.textViewKategoriPemasukan);
        TextView textViewTanggalPemasukan = convertView.findViewById(R.id.textViewTanggalPemasukan);
        TextView textViewJumlahPemasukan = convertView.findViewById(R.id.textViewJumlahPemasukan);

        textViewIdPemasukan.setText("Jumlah : " + String.valueOf(pemasukan.getId_pemasukan()));
        textViewKategoriPemasukan.setText("Kategori : " + pemasukan.getKategori_pemasukan());
        textViewTanggalPemasukan.setText("Tanggal : " + pemasukan.getTanggal_pemasukan());
        textViewJumlahPemasukan.setText("No. : " + String.valueOf(pemasukan.getJumlah_pemasukan()));

        return convertView;
    }

}


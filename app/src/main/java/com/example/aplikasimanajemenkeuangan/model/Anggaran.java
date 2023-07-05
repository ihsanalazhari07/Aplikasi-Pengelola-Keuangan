package com.example.aplikasimanajemenkeuangan.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Anggaran implements Parcelable {
    private int id_anggaran;
    private int jumlah_anggaran;
    private String tanggal_mulai;
    private String tanggal_selesai;

    public Anggaran(int id_anggaran, int jumlah_anggaran, String tanggal_mulai, String tanggal_selesai) {
        setId_anggaran(id_anggaran);
        setJumlah_anggaran(jumlah_anggaran);
        setTanggal_mulai(tanggal_mulai);
        setTanggal_selesai(tanggal_selesai);
    }

    protected Anggaran(Parcel in) {
        id_anggaran = in.readInt();
        jumlah_anggaran = in.readInt();
        tanggal_mulai = in.readString();
        tanggal_selesai = in.readString();
    }

    public static final Creator<Anggaran> CREATOR = new Creator<Anggaran>() {
        @Override
        public Anggaran createFromParcel(Parcel in) {
            return new Anggaran(in);
        }

        @Override
        public Anggaran[] newArray(int size) {
            return new Anggaran[size];
        }
    };

    public Anggaran(int lastAddedAnggaran, int totalAnggaran) {
    }



    public int getId_anggaran() {
        return id_anggaran;
    }

    public void setId_anggaran(int id_anggaran) {
        this.id_anggaran = id_anggaran;
    }

    public int getJumlah_anggaran() {
        return jumlah_anggaran;
    }

    public void setJumlah_anggaran(int jumlah_anggaran) {
        this.jumlah_anggaran = jumlah_anggaran;
    }

    public String getTanggal_mulai() {
        return tanggal_mulai;
    }

    public void setTanggal_mulai(String tanggal_mulai) {
        this.tanggal_mulai = tanggal_mulai;
    }

    public String getTanggal_selesai() {
        return tanggal_selesai;
    }

    public void setTanggal_selesai(String tanggal_selesai) {
        this.tanggal_selesai = tanggal_selesai;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id_anggaran);
        dest.writeInt(jumlah_anggaran);
        dest.writeString(tanggal_mulai);
        dest.writeString(tanggal_selesai);
    }
}


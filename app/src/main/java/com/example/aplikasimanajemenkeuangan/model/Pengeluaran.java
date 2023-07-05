package com.example.aplikasimanajemenkeuangan.model;

public class Pengeluaran {

    private int id_pengeluaran;

    private String kategori_pengeluaran;
    private String tanggal_pengeluaran;
    private int jumlah_pengeluaran;

    public Pengeluaran(int id_pengeluaran, String kategori_pemasukan, String tanggal_pengeluaran, int jumlah_pengeluaran) {
        setId_pengeluaran(id_pengeluaran);
        setKategori_pengeluaran(kategori_pengeluaran);
        setTanggal_pengeluaran(tanggal_pengeluaran);
        setJumlah_pengeluaran(jumlah_pengeluaran);
    }

    public void setId_pengeluaran(int id_pengeluaran) { this.id_pengeluaran = id_pengeluaran; }

    public void setKategori_pengeluaran(String kategori_pengeluaran) { this.kategori_pengeluaran = kategori_pengeluaran; }

    public void setTanggal_pengeluaran(String tanggal_pengeluaran) { this.tanggal_pengeluaran = tanggal_pengeluaran; }


    public void setJumlah_pengeluaran(int jumlah_pengeluaran) { this.jumlah_pengeluaran = jumlah_pengeluaran; }


    public int getId_pengeluaran() { return id_pengeluaran; }

    public String getKategori_pengeluaran() { return kategori_pengeluaran; }

    public String getTanggal_pengeluaran() { return tanggal_pengeluaran; }

    public int getJumlah_pengeluaran() { return jumlah_pengeluaran; }
}

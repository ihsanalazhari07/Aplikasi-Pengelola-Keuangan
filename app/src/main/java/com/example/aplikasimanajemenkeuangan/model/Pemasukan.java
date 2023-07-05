package com.example.aplikasimanajemenkeuangan.model;

public class Pemasukan {
    private int id_pemasukan;
    private String kategori_pemasukan;
    private String tanggal_pemasukan;
    private String keterangan_pemasukan;
    private int jumlah_pemasukan;

    public Pemasukan(int id_pemasukan, String nama_kategori, String tanggal_pemasukan, String keterangan_pemasukan, int jumlah_pemasukan) {
        setId_pemasukan(id_pemasukan);
        setKategori_pemasukan(nama_kategori);
        setTanggal_pemasukan(tanggal_pemasukan);
        setKeterangan_pemasukan(keterangan_pemasukan);
        setJumlah_pemasukan(jumlah_pemasukan);
    }

    public void setId_pemasukan(int id_pemasukan) { this.id_pemasukan = id_pemasukan; }

    public void setKategori_pemasukan(String kategori_pemasukan) { this.kategori_pemasukan = kategori_pemasukan; }

    public void setTanggal_pemasukan(String tanggal_pemasukan) { this.tanggal_pemasukan = tanggal_pemasukan; }

    public void setKeterangan_pemasukan(String keterangan_pemasukan) { this.keterangan_pemasukan = keterangan_pemasukan; }

    public void setJumlah_pemasukan(int jumlah_pemasukan) { this.jumlah_pemasukan = jumlah_pemasukan; }


    public int getId_pemasukan() { return id_pemasukan; }

    public String getKategori_pemasukan() { return kategori_pemasukan; }

    public String getTanggal_pemasukan() { return tanggal_pemasukan; }

    public String getKeterangan_pemasukan() { return keterangan_pemasukan; }

    public int getJumlah_pemasukan() { return jumlah_pemasukan; }
}

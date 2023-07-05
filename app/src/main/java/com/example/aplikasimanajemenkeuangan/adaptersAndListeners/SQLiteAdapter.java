package com.example.aplikasimanajemenkeuangan.adaptersAndListeners;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.aplikasimanajemenkeuangan.model.Anggaran;
import com.example.aplikasimanajemenkeuangan.model.Pemasukan;
import com.example.aplikasimanajemenkeuangan.model.Pengeluaran;

import java.util.ArrayList;
import java.util.List;

public class SQLiteAdapter extends SQLiteOpenHelper {
    public static final String ANGGARAN_TABLE = "tb_anggaran";
    public static final String PEMASUKAN_TABLE = "tb_pemasukan";
    public static final String PENGELUARAN_TABLE = "tb_pengeluaran";

    public static final String ID_ANGGARAN = "id_anggaran";
    public static final String JUMLAH_ANGGARAN = "jumlah_anggaran";
    public static final String TANGGAL_MULAI = "tanggal_mulai";
    public static final String TANGGAL_SELESAI = "tanggal_selesai";

    public static final String ID_PEMASUKAN = "id_pemasukan";
    public static final String KATEGORI_PEMASUKAN = "kategori_pemasukan";
    public static final String TANGGAL_PEMASUKAN = "tanggal_pemasukan";
    public static final String JUMLAH_PEMASUKAN = "jumlah_pemasukan";

    public static final String ID_PENGELUARAN = "id_pengeluaran";
    public static final String KATEGORI_PENGELUARAN = "kategori_pengeluaran";
    public static final String TANGGAL_PENGELUARAN = "tanggal_pengeluaran";

    public static final String JUMLAH_PENGELUARAN = "jumlah_pengeluaran";

    public SQLiteAdapter(Context context) {
        super(context, "db_manajemen_keuangan.db", null, 2);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createAnggaranTable = "CREATE TABLE " + ANGGARAN_TABLE + "(" +
                ID_ANGGARAN+" INTEGER PRIMARY KEY AUTOINCREMENT," +
                JUMLAH_ANGGARAN+" INTEGER(11) DEFAULT NULL," +
                TANGGAL_MULAI+" DATETIME DEFAULT NULL," +
                TANGGAL_SELESAI+" DATETIME DEFAULT NULL" +
                ");";
        String createPemasukanTable = "CREATE TABLE " + PEMASUKAN_TABLE + "(" +
                ID_PEMASUKAN+" INTEGER PRIMARY KEY AUTOINCREMENT," +
                KATEGORI_PEMASUKAN+" VARCHAR(20) DEFAULT NULL," +
                TANGGAL_PEMASUKAN+" DATETIME DEFAULT NULL," +
                JUMLAH_PEMASUKAN+" INTEGER(11) DEFAULT NULL" +
                ");";
        String createPengeluaranTable = "CREATE TABLE " + PENGELUARAN_TABLE + "(" +
                ID_PENGELUARAN+" INTEGER PRIMARY KEY AUTOINCREMENT," +
                KATEGORI_PENGELUARAN+" VARCHAR(20) DEFAULT NULL," +
                TANGGAL_PENGELUARAN+" DATETIME DEFAULT NULL," +
                JUMLAH_PENGELUARAN+" INTEGER(11) DEFAULT NULL" +
                ");";
        db.execSQL(createAnggaranTable);
        db.execSQL(createPemasukanTable);
        db.execSQL(createPengeluaranTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addAnggaran(Anggaran theAnggaran){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ID_ANGGARAN, theAnggaran.getId_anggaran());
        cv.put(JUMLAH_ANGGARAN,theAnggaran.getJumlah_anggaran());
        cv.put(TANGGAL_MULAI,theAnggaran.getTanggal_mulai());
        cv.put(TANGGAL_SELESAI,theAnggaran.getTanggal_selesai());

        long insert = db.insert(ANGGARAN_TABLE, null, cv);
        return insert != -1;
    }
    public boolean updateAnggaran(Anggaran theAnggaran) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ID_ANGGARAN, theAnggaran.getId_anggaran());
        cv.put(JUMLAH_ANGGARAN, theAnggaran.getJumlah_anggaran());
        cv.put(TANGGAL_MULAI, theAnggaran.getTanggal_mulai());
        cv.put(TANGGAL_SELESAI, theAnggaran.getTanggal_selesai());

        String whereClause = ID_ANGGARAN + " = ?";
        String[] whereArgs = {String.valueOf(theAnggaran.getId_anggaran())};

        int rowsAffected = db.update(ANGGARAN_TABLE, cv, whereClause, whereArgs);
        return rowsAffected > 0;
    }
    public boolean addPemasukan(Pemasukan thePemasukan) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KATEGORI_PEMASUKAN, thePemasukan.getKategori_pemasukan());
        cv.put(TANGGAL_PEMASUKAN, thePemasukan.getTanggal_pemasukan());
        cv.put(JUMLAH_PEMASUKAN, thePemasukan.getJumlah_pemasukan());

        long insert = db.insert(PEMASUKAN_TABLE, null, cv);
        return insert != -1;
    }

    public boolean addPengeluaran(Pengeluaran thePengeluaran) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KATEGORI_PENGELUARAN, thePengeluaran.getKategori_pengeluaran());
        cv.put(TANGGAL_PENGELUARAN, thePengeluaran.getTanggal_pengeluaran());
        cv.put(JUMLAH_PENGELUARAN, thePengeluaran.getJumlah_pengeluaran());

        long insert = db.insert(PENGELUARAN_TABLE, null, cv);
        return insert != -1;
    }
    public int getLastAddedPemasukanJumlah() {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT SUM(" + JUMLAH_PEMASUKAN + ") FROM " + PEMASUKAN_TABLE;

        Cursor cursor = db.rawQuery(query, null);

        int totalJumlahPemasukan = 0;
        if (cursor.moveToFirst()) {
            totalJumlahPemasukan = cursor.getInt(0);
        }

        cursor.close();
        return totalJumlahPemasukan;
    }


    public int getLastAddedPengeluaranJumlah() {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT SUM(" + JUMLAH_PENGELUARAN + ") FROM " + PENGELUARAN_TABLE;

        Cursor cursor = db.rawQuery(query, null);

        int totalJumlahPengeluaran = 0;
        if (cursor.moveToFirst()) {
            totalJumlahPengeluaran = cursor.getInt(0);
        }

        cursor.close();
        return totalJumlahPengeluaran;
    }




    public int getLatestAnggaranJumlah() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " + JUMLAH_ANGGARAN + " FROM " + ANGGARAN_TABLE +
                " ORDER BY " + ID_ANGGARAN + " DESC LIMIT 1";
        Cursor cursor = db.rawQuery(query, null);

        int jumlahAnggaran = 0;
        if (cursor.moveToFirst()) {
            int jumlahAnggaranIndex = cursor.getColumnIndexOrThrow(JUMLAH_ANGGARAN);
            jumlahAnggaran = cursor.getInt(jumlahAnggaranIndex);
        }

        cursor.close();
        return jumlahAnggaran;
    }

    public int getLastAddedAnggaran() {
        SQLiteDatabase db = this.getReadableDatabase();
        int lastAddedAnggaran = 0;

        String query = "SELECT " + JUMLAH_ANGGARAN + " FROM " + ANGGARAN_TABLE +
                " ORDER BY " + ID_ANGGARAN + " DESC LIMIT 1";

        Cursor cursor = db.rawQuery(query, null);
        if (cursor != null && cursor.moveToFirst()) {
            lastAddedAnggaran = cursor.getInt(0);
            cursor.close();
        }

        return lastAddedAnggaran;
    }

    public List<Pemasukan> getAllPemasukan() {
        List<Pemasukan> pemasukanList = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(PEMASUKAN_TABLE, null, null, null, null, null, null);

        int idIndex = cursor.getColumnIndex(ID_PEMASUKAN);
        int jumlahIndex = cursor.getColumnIndex(JUMLAH_PEMASUKAN);

        while (cursor.moveToNext()) {
            int id = (idIndex != -1) ? cursor.getInt(idIndex) : 0;
            int jumlahPemasukan = (jumlahIndex != -1) ? cursor.getInt(jumlahIndex) : 0;

            String tanggalPemasukan;
            try {
                tanggalPemasukan = cursor.getString(cursor.getColumnIndexOrThrow(TANGGAL_PEMASUKAN));
            } catch (IllegalArgumentException e) {
                tanggalPemasukan = "";
            }

            String kategoriPemasukan;
            try {
                kategoriPemasukan = cursor.getString(cursor.getColumnIndexOrThrow(KATEGORI_PEMASUKAN));
            } catch (IllegalArgumentException e) {
                kategoriPemasukan = "";
            }

            Pemasukan pemasukan = new Pemasukan(id, kategoriPemasukan, tanggalPemasukan, jumlahPemasukan);
            pemasukanList.add(pemasukan);
        }

        cursor.close();
        return pemasukanList;
    }

    public List<Pengeluaran> getAllPengeluaran() {
        List<Pengeluaran> pengeluaranList = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(PENGELUARAN_TABLE, null, null, null, null, null, null);

        int idIndex = cursor.getColumnIndex(ID_PENGELUARAN);
        int jumlahIndex = cursor.getColumnIndex(JUMLAH_PENGELUARAN);

        while (cursor.moveToNext()) {
            int id = (idIndex != -1) ? cursor.getInt(idIndex) : 0;
            int jumlahPengeluaran = (jumlahIndex != -1) ? cursor.getInt(jumlahIndex) : 0;

            String tanggalPengeluaran;
            try {
                tanggalPengeluaran = cursor.getString(cursor.getColumnIndexOrThrow(TANGGAL_PENGELUARAN));
            } catch (IllegalArgumentException e) {
                tanggalPengeluaran = "";
            }

            String kategoriPengeluaran;
            try {
                kategoriPengeluaran = cursor.getString(cursor.getColumnIndexOrThrow(KATEGORI_PENGELUARAN));
            } catch (IllegalArgumentException e) {
                kategoriPengeluaran = "";
            }

            Pengeluaran pengeluaran = new Pengeluaran(id, kategoriPengeluaran, tanggalPengeluaran, jumlahPengeluaran);
            pengeluaranList.add(pengeluaran);
        }




        cursor.close();
        return pengeluaranList;
    }














}

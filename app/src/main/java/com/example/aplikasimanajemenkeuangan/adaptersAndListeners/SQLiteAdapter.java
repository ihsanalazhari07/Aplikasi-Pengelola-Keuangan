package com.example.aplikasimanajemenkeuangan.adaptersAndListeners;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.aplikasimanajemenkeuangan.model.Anggaran;
import com.example.aplikasimanajemenkeuangan.model.Pemasukan;
import com.example.aplikasimanajemenkeuangan.model.Pengeluaran;

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
    public static final String KETERANGAN_PEMASUKAN = "keterangan_pemasukan";
    public static final String JUMLAH_PEMASUKAN = "jumlah_pemasukan";

    public static final String ID_PENGELUARAN = "id_pengeluaran";
    public static final String KATEGORI_PENGELUARAN = "kategori_pengeluaran";
    public static final String TANGGAL_PENGELUARAN = "tanggal_pengeluaran";
    public static final String KETERANGAN_PENGELUARAN = "keterangan_pengeluaran";
    public static final String JUMLAH_PENGELUARAN = "jumlah_pengeluaran";

    public SQLiteAdapter(Context context) {
        super(context, "db_manajemen_keuangan.db", null, 1);
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
                KETERANGAN_PEMASUKAN+" VARCHAR(50) DEFAULT NULL," +
                JUMLAH_PEMASUKAN+" INTEGER(11) DEFAULT NULL" +
                ");";
        String createPengeluaranTable = "CREATE TABLE " + PENGELUARAN_TABLE + "(" +
                ID_PENGELUARAN+" INTEGER PRIMARY KEY AUTOINCREMENT," +
                KATEGORI_PENGELUARAN+" VARCHAR(20) DEFAULT NULL," +
                TANGGAL_PENGELUARAN+" DATETIME DEFAULT NULL," +
                KETERANGAN_PENGELUARAN+" VARCHAR(50) DEFAULT NULL," +
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
        cv.put(ID_ANGGARAN,theAnggaran.getId_anggaran());
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
        cv.put(ID_PEMASUKAN, thePemasukan.getId_pemasukan());
        cv.put(KATEGORI_PEMASUKAN, thePemasukan.getKategori_pemasukan());
        cv.put(TANGGAL_PEMASUKAN, thePemasukan.getTanggal_pemasukan());
        cv.put(KETERANGAN_PEMASUKAN, thePemasukan.getKeterangan_pemasukan());
        cv.put(JUMLAH_PEMASUKAN, thePemasukan.getJumlah_pemasukan());

        long insert = db.insert(PEMASUKAN_TABLE, null, cv);
        return insert != -1;
    }

    public boolean addPengeluaran(Pengeluaran thePengeluaran) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ID_PENGELUARAN, thePengeluaran.getId_pengeluaran());
        cv.put(KATEGORI_PENGELUARAN, thePengeluaran.getKategori_pengeluaran());
        cv.put(TANGGAL_PENGELUARAN, thePengeluaran.getTanggal_pengeluaran());
        cv.put(KETERANGAN_PENGELUARAN, thePengeluaran.getKeterangan_pengeluaran());
        cv.put(JUMLAH_PENGELUARAN, thePengeluaran.getJumlah_pengeluaran());

        long insert = db.insert(PEMASUKAN_TABLE, null, cv);
        return insert != -1;
    }


}

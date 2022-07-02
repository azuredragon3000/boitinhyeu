package com.myapp.lovetest_azuredragon3000.common;


import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.myapp.lovetest_azuredragon3000.boiphuongdong.model.PhuongDong;
import com.myapp.lovetest_azuredragon3000.boiphuongtay.data.PhuongTay;
import com.myapp.lovetest_azuredragon3000.congiap12.model.ModelCungMang;
import com.myapp.lovetest_azuredragon3000.ngontinh.model.ModelDanhNgon;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTuViManager2 extends SQLiteOpenHelper {

    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static final String DB_PATH = "/data/data/com.myapp.lovetest_azuredragon3000/databases/";
    public static final String DATABASE_NAME = "datatonghop.db";

    private static final String TABLE_CUNG_MANG = "tbl_cung_mang";
    private static final String NAM_SINH = "namsinh";
    private static final String AM_LICH = "amlich";
    private static final String GIOI_TINH = "gioitinh";
    private static final String MANG = "mang";
    private static final String CUNG = "cung";
    private static final String HANH = "hanh";

    private static final String TABLE_BOI_PHUONG_DONG = "boi_phuong_dong";
    private static final String TABLE_BOI_PHUONG_TAY = "boi_phuong_tay";
    private static final String TABLE_NGAY_LE = "nitificationDate";
    private static final String TABLE_LE_HOI = "vhv_le_hoi_viet_nam";
    private static final String TABLE_DANH_NGON = "danhngon";

    private static volatile DatabaseTuViManager2 INSTANCE;

    private DatabaseTuViManager2(Context context) {
        super(context, DATABASE_NAME, null, 2);
        this.mContext = context;

        // check exists database
        File database = context.getDatabasePath(DATABASE_NAME);
        if (false == database.exists()) {
            this.getReadableDatabase();
            // coppy
            if (coppyDatabase(context)) {
                Log.d("tuViTronDoi", "TuViManager2: coppy success");
            } else {
                Log.d("tuViTronDoi", "TuViManager2: coppy fail");
            }
        }
    }

    public static DatabaseTuViManager2 getInstance(Application app) {
        if (INSTANCE == null) {
            synchronized (DatabaseTuViManager2.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DatabaseTuViManager2(app);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void openDatabase() {
        String dbPath = mContext.getDatabasePath(DATABASE_NAME).getPath();
        if (mDatabase != null && mDatabase.isOpen()) {
            return;
        }
        mDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void closeDatabase() {
        if (mDatabase != null) {
            mDatabase.close();
        }
    }

    private boolean coppyDatabase(Context context) {
        try {
            InputStream inputStream = context.getAssets().open(DATABASE_NAME);
            String outFileName = DB_PATH + DATABASE_NAME;
            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[] buff = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buff)) > 0) {
                outputStream.write(buff, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public List<ModelCungMang> getCungMang() {
        List<ModelCungMang> list = new ArrayList<>();
        openDatabase();

        String strQuery = "SELECT * FROM " + TABLE_CUNG_MANG;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(strQuery, null);
        if (cursor.moveToFirst()) {
            do {
                ModelCungMang modelCungMang = new ModelCungMang(cursor.getInt(1), cursor.getString(2),
                        cursor.getInt(3), cursor.getString(4), cursor.getString(5),
                        cursor.getString(6));
                list.add(modelCungMang);
            } while (cursor.moveToNext());
        }
        cursor.close();

        closeDatabase();
        return list;
    }

    public PhuongDong getBoiPhuongDong(String id) {
        openDatabase();
        PhuongDong phuongDong = null;

        String strQuery = "SELECT * FROM " + TABLE_BOI_PHUONG_DONG + " WHERE id = ?";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(strQuery, new String[]{id});
        if (cursor.moveToFirst()) {
            do {
                phuongDong = new PhuongDong(cursor.getString(1), cursor.getString(2));
            } while (cursor.moveToNext());
        }
        cursor.close();
        closeDatabase();
        return phuongDong;
    }

    public PhuongTay getBoiPhuongTay(String id) {
        openDatabase();
        PhuongTay phuongTay = null;
        String strQuery = "SELECT * FROM " + TABLE_BOI_PHUONG_TAY + " WHERE id = ?";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(strQuery, new String[]{id});
        if (cursor.moveToFirst()) {
            do {
                phuongTay = new PhuongTay(cursor.getInt(0), cursor.getString(2));
            }while (cursor.moveToNext());
        }
        cursor.close();
        closeDatabase();
        return phuongTay;
    }

    public List<ModelDanhNgon> getDanhNgon() {
        List<ModelDanhNgon> list = new ArrayList<>();
        openDatabase();
        String strQuery = "SELECT * FROM " + TABLE_DANH_NGON;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(strQuery, null);
        if (cursor.moveToFirst()){
            do {
                list.add(new ModelDanhNgon(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
            }while (cursor.moveToNext());
        }
        cursor.close();
        closeDatabase();
        return list;
    }

}

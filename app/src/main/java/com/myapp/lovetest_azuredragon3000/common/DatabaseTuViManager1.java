package com.myapp.lovetest_azuredragon3000.common;


import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import com.myapp.lovetest_azuredragon3000.congiap12.model.TuVi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTuViManager1 extends SQLiteOpenHelper {

    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static final String DB_PATH = "/data/data/com.myapp.lovetest_azuredragon3000/databases/";
    public static final String DATABASE_NAME = "tuvitrondoi.sqlite";

    private static final String TABLE_NAM_SINH = "td_tuoi";
    private static final String TUOI_NAME = "td_tuoi_name";
    private static final String CONGIAP_ID = "td_congiap_id";

    private static final String TABLE_NOI_DUNG = "td_tuoi_noidung";
    private static final String TUOI_ID = "td_tuoi_id";
    private static final String NAME = "td_name";
    private static final String MALE = "td_male";
    private static final String INTRO = "td_intro";

    private static volatile DatabaseTuViManager1 INSTANCE;


    private DatabaseTuViManager1(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.mContext = context;

        // check exists database
        File database = context.getDatabasePath(DATABASE_NAME);
        if (false == database.exists()) {
            this.getReadableDatabase();
            // coppy
            if (coppyDatabase(context)) {
                Log.d("tuViTronDoi", "TuViManager: coppy success");
            } else {
                Log.d("tuViTronDoi", "TuViManager: coppy fail");
            }
        }
    }

    public static DatabaseTuViManager1 getInstance(Application app) {
        if (INSTANCE == null) {
            synchronized (DatabaseTuViManager1.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DatabaseTuViManager1(app);
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

    public List<TuVi> getNamSinh(String idConGiap) {
        List<TuVi> list = new ArrayList<>();
        openDatabase();

        String strQuery = "SELECT * FROM " + TABLE_NAM_SINH + " WHERE " + CONGIAP_ID + " = ?";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(strQuery, new String[]{idConGiap});
        if (cursor.moveToFirst()) {
            do {
                list.add(new TuVi(cursor.getString(0), cursor.getString(1)));
            } while (cursor.moveToNext());
        }

        cursor.close();
        closeDatabase();

        return list;
    }

    public TuVi getTuVi(String tuoiId, String male) {
        TuVi tuVi = null;
        openDatabase();
        String strQuery = "SELECT * FROM " + TABLE_NOI_DUNG + " WHERE " + TUOI_ID + " = ? AND " + MALE + " = ?";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(strQuery, new String[] {tuoiId, male});
        if (cursor.moveToFirst()) {
            do {
                tuVi = new TuVi(cursor.getString(3), cursor.getString(5), cursor.getString(2));
            }while (cursor.moveToNext());
        }
        cursor.close();
        closeDatabase();
        return tuVi;
    }
}

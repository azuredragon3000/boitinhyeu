package com.myapp.lovetest_azuredragon3000.common;

import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.myapp.lovetest_azuredragon3000.truyentinhyeu.model.ModelTruyenTinhYeu;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTruyenTinhYeu extends SQLiteOpenHelper {
    private static final String TABLE_NAM_SINH = "Product";
    private static final String ID = "id";
    private Context mContext;
    private SQLiteDatabase mDatabase;
    private static volatile DatabaseTruyenTinhYeu INSTANCE;
    public static final String DB_PATH = "/data/data/com.myapp.lovetest_azuredragon3000/databases/";
    public static final String DATABASE_NAME = "truyentinhyeu.db";

    private DatabaseTruyenTinhYeu(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.mContext = context;

        this.getReadableDatabase();
        // coppy
        if (coppyDatabase(context)) {
            Log.d("truyentinhyeu", "truyentinhyeu: coppy success");
        } else {
            Log.d("truyentinhyeu", "truyentinhyeu: coppy fail");
        }
    }

    public static DatabaseTruyenTinhYeu getInstance(Application app){
        if (INSTANCE == null) {
            synchronized (DatabaseTruyenTinhYeu.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DatabaseTruyenTinhYeu(app);
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

    public ModelTruyenTinhYeu getContent(int item) {
        ModelTruyenTinhYeu ret = null;
        openDatabase();

        String s_item = item+"";
        String strQuery = "SELECT * FROM " + TABLE_NAM_SINH + " WHERE " + ID + " = ?";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(strQuery, new String[]{s_item});

        if (cursor.moveToFirst()) {
            do {
                ret = new ModelTruyenTinhYeu(cursor.getString(1),cursor.getString(2));
            } while (cursor.moveToNext());
        }

        cursor.close();
        closeDatabase();

        return ret;
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

    public String[] getListTitle() {
        openDatabase();
        List<String> list  = new ArrayList<>();
        String strQuery = "SELECT * FROM " + TABLE_NAM_SINH;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(strQuery, null);

        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        String[] ret = FunctionCommon.convertToArrayString(list);
        return ret;
    }
}

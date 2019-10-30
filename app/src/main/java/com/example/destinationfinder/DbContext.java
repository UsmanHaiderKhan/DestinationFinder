package com.example.destinationfinder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbContext extends SQLiteOpenHelper {
    private static final String dbname = "userinfo.db";
    private static final int version = 1;
    public DbContext(Context context) {
        super(context, dbname, null, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE user(_id INTEGER PRIMARY KEY,name TEXT,email TEXT,password TEXT,phoneNo NUMERIC,fulladdress TEXT)";
        db.execSQL(sql);
    }

    public boolean insertData(String name, String email, String password, String phoneNo, String fulladdress) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("email", email);
        values.put("password", password);
        values.put("phoneNo", phoneNo);
        values.put("fulladdress", fulladdress);
        long ins = db.insert("user", null, values);
        if (ins == -1) return false;
        else return true;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
        onCreate(db);

    }

    public Boolean checkemail(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where email=?", new String[]{email});
        if (cursor.getCount() > 0) return false;
        else return true;
    }

    //Login Function
    public Boolean Login(String email, String password, String phone) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where email=? and password=? and phoneNo=? ", new String[]{email, password, phone});
        if (cursor.getCount() > 0) return true;
        else return false;
    }

}

package com.example.destinationfinder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbContext extends SQLiteOpenHelper {
    private static final String dbname = "destinationfinder.db";
    private static final int version = 1;

    public DbContext(Context context) {
        super(context, dbname, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE users(_id INTEGER PRIMARY KEY, name TEXT,email TEXT,password TEXT,phone_No TEXT,fulladdress TEXT)");

    }

    public boolean insertData(String name, String email, String password, String phone_No, String fulladdress) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("email", email);
        values.put("password", password);
        values.put("phone_No", phone_No);
        values.put("fulladdress", fulladdress);

        long ins = db.insert("users", null, values);
        if (ins == -1) return false;
        else return true;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");

    }

    public Boolean checkemail(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email=?", new String[]{email});
        if (cursor.getCount() > 0) return false;
        else return true;
    }

    //Login Function
    public Boolean Login(String email, String password, String phone) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email=? and password=? and phone_No=? ", new String[]{email, password, phone});
        if (cursor.getCount() > 0) return true;
        else return false;
    }

}

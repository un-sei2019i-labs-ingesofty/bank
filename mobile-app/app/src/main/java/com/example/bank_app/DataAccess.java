package com.example.bank_app;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class DataAccess extends SQLiteOpenHelper {
    public DataAccess( Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table cuenta(usuario text primary key,contraseña text)");
        //db.execSQL("insert into cuenta(ususario, contraseña) values('default','1234');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

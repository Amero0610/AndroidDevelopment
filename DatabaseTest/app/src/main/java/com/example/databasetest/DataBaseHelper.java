package com.example.databasetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.security.PrivateKey;

public class DataBaseHelper  extends SQLiteOpenHelper {
    private Context context;
    private String name;
    private int version;
    private String createTable = "create table Student ("+
            "student_id integer primary key,"+
            "student_name text,"+
            "student_major text,"+
            "student_class integer )";


    DataBaseHelper(Context context,String name, int version){
        super(context,name,null,version);
        this.context = context;
        this.name = name;
        this.version = version;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);
        Toast.makeText(context,"Create successful",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

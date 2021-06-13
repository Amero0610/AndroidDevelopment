package com.example.mysqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private String name;
    private int version;
    MyDatabaseHelper(Context context , String name , int version){
        super(context,name,null,version);
        this.context = context;
        this.name = name;
        this.version = version;
    }
    private String createBook = "create table Book ( "+"id integer primary key autoincrement," +"author text,"+
            "price real," +
            "pages integer,"+
            "name text)";
    private String createCategory = "create table Category ("+
            "id integer primary key autoincrement,"+
            "category_name text,"+
            "categroy_code integer)";
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(createBook);
        sqLiteDatabase.execSQL(createCategory);
        Toast.makeText(context,"Create Successfully",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Book");
        sqLiteDatabase.execSQL("drop table if exists Category");
        onCreate(sqLiteDatabase);
    }
}

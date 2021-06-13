package com.example.mysqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mysqlite.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);
        activityMainBinding.textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(this,"BookStore.db",2);
        activityMainBinding.createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDatabaseHelper.getWritableDatabase();
            }
        });
        activityMainBinding.insertDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // First  Data
                SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("name", "The Da Vinci Code");
                contentValues.put("author","Dan Brown");
                contentValues.put("pages",450);
                contentValues.put("price",16.96);
                sqLiteDatabase.insert("Book",null,contentValues);
                //  Second Data
                ContentValues contentValues1 = new ContentValues();
                contentValues1.put("name", "The Lost Symbol");
                contentValues1.put("author","Dan Brown");
                contentValues1.put("pages",510);
                contentValues1.put("price",19.95);
                sqLiteDatabase.insert("Book",null,contentValues1);
                Toast.makeText(MainActivity.this,"Insert Successfully",Toast.LENGTH_SHORT).show();
            }
        });
        activityMainBinding.updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("price",30);
                String[] temp = new String[]{"The Da Vinci Code"};
                sqLiteDatabase.update("Book",contentValues,"name = ?",temp);
                Toast.makeText(MainActivity.this,"Update Successfully",Toast.LENGTH_SHORT).show();
            }
        });
        activityMainBinding.deleteDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
                String[] temp = new String[]{"500"};
                sqLiteDatabase.delete("Book","pages > ?",temp);
                Toast.makeText(MainActivity.this,"Delete Data Successfully",Toast.LENGTH_SHORT).show();
            }
        });
        activityMainBinding.selectDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
                String[] tempcol = new String[]{"price"};
                String[] tempselection = new String[]{"30"};
                Cursor cursor = sqLiteDatabase.query("Book", null  , null, null, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        float price = cursor.getFloat(cursor.getColumnIndex("price"));
                        //Toast toast  = Toast.makeText(MainActivity.this, name + author + pages + price, Toast.LENGTH_SHORT);
                        //toast.setGravity(Gravity.TOP,0,0);
                        //toast.show();
                        // activityMainBinding.textView.setText(name+" "+author+" "+pages+" "+price);
                        activityMainBinding.textView.append(name+" "+author+" "+pages+" "+price+ "\n");
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
        });
    }
}
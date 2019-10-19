package com.example.labor3project;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    private DatabaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String name, String password , String date, String hobby) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.COLUMN_NAME, name);
        contentValue.put(DatabaseHelper.COLUMN_PASSWORD, password);
        contentValue.put(DatabaseHelper.COLUMN_DATE, date);
        contentValue.put(DatabaseHelper.COLUMN_HOBBY, hobby);
        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor get() {
        String[] columns = new String[] { DatabaseHelper._ID, DatabaseHelper.COLUMN_NAME, DatabaseHelper.COLUMN_PASSWORD,
                DatabaseHelper.COLUMN_DATE,DatabaseHelper.COLUMN_HOBBY };
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);

        return cursor;
    }

    public int update(long _id, String name, String password ,String date ,String hobby) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COLUMN_NAME, name);
        contentValues.put(DatabaseHelper.COLUMN_PASSWORD, password);
        contentValues.put(DatabaseHelper.COLUMN_DATE, date);
        contentValues.put(DatabaseHelper.COLUMN_HOBBY, hobby);
        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper._ID + "=" + _id, null);
    }
}

package com.example.labor3project;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    // Table Name
    public static final String TABLE_NAME = "Users";

    // Table columns
    public static final String _ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_HOBBY = "hobby";
    // Database Information
    static final String DB_NAME = "USERS.DB";
    // database version
    static final int DB_VERSION = 1;

    // Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME + " TEXT NOT NULL, " + COLUMN_PASSWORD +
            " TEXT NOT NULL, "+ COLUMN_DATE + " TEXT NOT NULL,"+ COLUMN_HOBBY + " TEXT NOT NULL);";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertdata(String name, String password , String date) {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.COLUMN_NAME, name);
        contentValue.put(DatabaseHelper.COLUMN_PASSWORD, password);
        contentValue.put(DatabaseHelper.COLUMN_DATE, date);
        long result = db.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
        if(result == -1){
            return false;
        }else{
            return true;
        }

    }
    public boolean inserthobby(String hobby) {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.COLUMN_HOBBY, hobby);
        long result = db.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
        if(result == -1){
            return false;
        }else{
            return true;
        }

    }
    public boolean update(long _id, String name, String password ,String date ,String hobby) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COLUMN_NAME, name);
        contentValues.put(DatabaseHelper.COLUMN_PASSWORD, password);
        contentValues.put(DatabaseHelper.COLUMN_DATE, date);
        contentValues.put(DatabaseHelper.COLUMN_HOBBY, hobby);
      //  int i = db.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper._ID + " = " + _id, null);
        return true;
    }
    public Cursor getAllHobbies(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor res= db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public void delete(long _id) {
      //  db.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper._ID + "=" + _id, null);
    }
}
package pmd.di.ubi.pt.wdce;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, "Login.db", null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(email text primary key, user text, password text, score intiger)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
    }

    //inserir
    public boolean insert (String email, String user, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("user", user);
        contentValues.put("password", password);
        contentValues.put("score", 0);
        long ins = db.insert("user", null, contentValues);
        if(ins == -1)
            return false;
        else
            return true;
    }

    //check if mail exists
    public boolean chkemail (String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email=?", new String[]{email});
        if(cursor.getCount()>0)
            return false;
        else
            return true;
    }

    //check if user exists
    public boolean chkuser (String user){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where user=?", new String[]{user});
        if(cursor.getCount()>0)
            return false;
        else
            return true;
    }

    //check password
    public boolean chkpass (String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where password=?", new String[]{password});
        if(cursor.getCount()>0)
            return false;
        else
            return true;
    }


    //check the user and password
    public boolean match (String user, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where user=? and password=?", new String[]{user, password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    /*
    public boolean addpoints (String user, int points){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where user=?", new String[]{user});
        if(cursor.getCount()>0) {
            db.rawQuery("")
            return true;
        }
        else
            return false;
    }*/

}

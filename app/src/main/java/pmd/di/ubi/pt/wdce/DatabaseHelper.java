package pmd.di.ubi.pt.wdce;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, "Login.db", null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table userTable(email text primary key, user text, password text, score int, level int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists userTable");
    }

    //inserir na user
    public boolean insert (String email, String user, String password, int score, int level){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("user", user);
        contentValues.put("password", password);
        contentValues.put("score", score);
        contentValues.put("level", level);
        long ins = db.insert("userTable", null, contentValues);
        if(ins == -1)
            return false;
        else
            return true;
    }

    //check if mail exists
    public boolean chkemail (String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM userTable WHERE email=?", new String[]{email});
        if(cursor.getCount()>0)
            return false;
        else
            return true;
    }

    //check if user exists
    public boolean chkuser (String user){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM userTable WHERE user=?", new String[]{user});
        if(cursor.getCount()>0)
            return false;
        else
            return true;
    }

    //check password
    public boolean chkpass (String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM userTable WHERE password=?", new String[]{password});
        if(cursor.getCount()>0)
            return false;
        else
            return true;
    }


    //check the user and password
    public boolean match (String user, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM userTable WHERE user=? AND password=?", new String[]{user, password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public void addpoints (String user, int add){
        SQLiteDatabase db = this.getWritableDatabase();
        SQLiteDatabase db2 = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT score FROM userTable WHERE user='"+user+"';",null);

        int oldScore =Integer.parseInt(cursor.getString(0));
        int newScore = oldScore + add;

        db2.rawQuery("UPDATE userTable SET score="+newScore+" WHERE user='"+user+"';",null);

    }

    public void chklevel(String user, int points){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT level FROM userTable WHERE user='"+user+"';",null);
        if(points > 1000){
            SQLiteDatabase db2 = this.getWritableDatabase();
            int levelup = Integer.parseInt(cursor.getString(0))+1;
            db2.rawQuery("UPDATE userTable SET level="+levelup+" WHERE user='"+user+"';",null);
        }
    }


    public Cursor getTopPlayers(){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT user FROM userTable ORDER BY level DESC, score DESC;", null);

        return cursor;
    }

    public Cursor getScoreUser (String user){

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT score FROM userTable WHERE user='"+user+"';", null);

        return cursor;
    }

    public Cursor getLevelUser (String user){

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT level FROM userTable WHERE user='"+user+"';", null);

        return  cursor;
    }


}
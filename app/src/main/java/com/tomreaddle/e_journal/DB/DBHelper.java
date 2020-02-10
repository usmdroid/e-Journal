package com.tomreaddle.e_journal.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.tomreaddle.e_journal.Models.model_profiles;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "list_profiles";
    public static final String TABLE_PROFILE = "profiles";
    public static final String ID_PROFILE = "_id";
    public static final String PICTURE_URL = "picture_url";
    public static final String NAME_PROFILE = "name";
    public static final String SCHOOL_PROFILE = "school";
    public static final String CLASS_PROFILE = "class_num";
    public static final String TOKEN_PROFILE = "token";

    private final Context mContext;
    SQLiteDatabase db;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_PROFILE + "(" + ID_PROFILE + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PICTURE_URL + " TEXT,"
                + NAME_PROFILE + " TEXT,"
                + SCHOOL_PROFILE + " TEXT,"
                + CLASS_PROFILE + " TEXT,"
                + TOKEN_PROFILE+ " TEXT" +")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long profile_enter(model_profiles model){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(PICTURE_URL , model.getPicture_URL());
        cv.put(NAME_PROFILE , model.getName());
        cv.put(SCHOOL_PROFILE , model.getSchool());
        cv.put(CLASS_PROFILE , model.getClass_num());
        cv.put(TOKEN_PROFILE , model.getClass_num());

        long notes = db.insert(TABLE_PROFILE , null , cv);
        db.close();
        return notes;

    }

     public List<model_profiles> profile_list(){
        List<model_profiles> list = new ArrayList<model_profiles>();
        SQLiteDatabase db = this.getReadableDatabase();
        String s = "select * from " + TABLE_PROFILE ;
         Cursor cursor = db.rawQuery(s , null);

         if(cursor.moveToLast()) {
             do {
                 list.add(new model_profiles(
                         cursor.getInt(cursor.getColumnIndex(ID_PROFILE)) ,
                         cursor.getString(cursor.getColumnIndex(PICTURE_URL)) ,
                         cursor.getString(cursor.getColumnIndex(NAME_PROFILE)) ,
                         cursor.getString(cursor.getColumnIndex(SCHOOL_PROFILE)) ,
                         cursor.getString(cursor.getColumnIndex(CLASS_PROFILE)) ,
                         cursor.getString(cursor.getColumnIndex(TOKEN_PROFILE)))
                 );
             } while (cursor.moveToPrevious());
         }
         db.close();
         return list;
    }

    public  long delete(int id){
        SQLiteDatabase db = this.getWritableDatabase();

        long delete = db.delete(TABLE_PROFILE , ID_PROFILE + " =?" , new String[]{String.valueOf(id)});
        db.close();
        return delete;
    }

}

package com.example.mcs_final_2301874866;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class FavoriteDB {
    Context ctx;
    DBHelper dbHelper;
    int id1;
    String word;
    String definition;
    String type;
    String imageurl;


    public FavoriteDB(Context context){
        this.ctx = context;
        dbHelper = new DBHelper(ctx);
    }


    public boolean InsertFavorite(Dictianory new_dictionary) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(dbHelper.COLUMN_DICTIONARY_NAME, new_dictionary.getWord());
        cv.put(dbHelper.COLUMN_DICTIONARY_DEFINITION, new_dictionary.getDefinition());
        cv.put(dbHelper.COLUMN_DICTIONARY_TYPE, new_dictionary.getType());
        cv.put(dbHelper.COLUMN_DICTIONARY_IMAGEURL, new_dictionary.getImageurl());

        long insert =  sqLiteDatabase.insert(dbHelper.TABLE_FaVORITE, null, cv);

        return insert != -1;
    }

    public boolean checkIfEmpty(){
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        String get_products_query = "SELECT * FROM " + dbHelper.TABLE_FAVORITE;
        Cursor cursor = sqLiteDatabase.rawQuery(get_products_query, null);

        if(cursor.getCount() == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public ArrayList<Dictianory> getAllDictionary(){
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        String get_products_query = "SELECT * FROM " + dbHelper.TABLE_FAVORITE;
        Cursor cursor = sqLiteDatabase.rawQuery(get_products_query, null);

        ArrayList<Dictianory> diksi = new ArrayList<Dictianory>();

        if(cursor.moveToFirst() == true){
            do{
                //extract datanya
                String productName = cursor.getString(1);
                int minPlayer = cursor.getInt(2);
                int maxPlayer = cursor.getInt(3);
                int price = cursor.getInt(4);
                Double latitude = cursor.getDouble(5);
                Double longitude = cursor.getDouble(6);
                Log.i("TAG", "getAllProducts: " + price);

                diksi.add(new Dictianory(word, definition, type, imageurl));

            }while(cursor.moveToNext());
        }
        return diksi;
    }

    public int getFavoriteId(int favoriteid){
        getFavoriteCode(favoriteid);
        return id1;
    }

    public String getFavoriteWord(int favoriteid) {
        getFavoriteCode(favoriteid);
        return word;
    }

    public String getFavoriteDefinition(int favoriteid) {
        getFavoriteCode(favoriteid);
        return definition;
    }

    public String getFavoriteType(int favoriteid) {
        getFavoriteCode(favoriteid);
        return type;
    }

    public String getFavoriteImageURL(int favoriteid) {
        getFavoriteCode(favoriteid);
        return imageurl;
    }


    public void getFavoriteCode(int favoriteid){
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        String get_products_query = "SELECT * FROM " + dbHelper.TABLE_FAVORITE + " WHERE "+ dbHelper.COLUMN_FAVORITE_ID + "=" + favoriteid;
        Cursor cursor = sqLiteDatabase.rawQuery(get_products_query, null);
        cursor.moveToFirst();

        Dictianory diksi = new Dictianory();

        id1 = cursor.getInt(0);
        word = cursor.getString(1);
        definition = cursor.getString(2);
        type = cursor.getString(3);
        imageurl = cursor.getString(4);

        Log.i("check", "getUser: " + word);

        cursor.close();
        sqLiteDatabase.close();
    }

    public void deleteTransaction(int id){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM " + dbHelper.TABLE_FAVORITE + " WHERE " + dbHelper.COLUMN_FAVORITE_ID + " = " + (id + 1));
    }

}

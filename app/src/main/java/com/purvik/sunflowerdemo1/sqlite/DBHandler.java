package com.purvik.sunflowerdemo1.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.purvik.sunflowerdemo1.singleton.SingleItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Purvik Rana on 10-10-2018.
 */
public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "AppDemo1";

    // Contacts table name
    private static final String TABLE_ITEM_DETAIL = "listitems";

    private static final String ITEM_ID = "item_id";
    private static final String ITEM = "item";

    public DBHandler(Context contex) {
        super(contex, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ITEMS__TABLE = "CREATE TABLE " + TABLE_ITEM_DETAIL + "("
                + ITEM_ID + " INTEGER PRIMARY KEY,"
                + ITEM + " INTEGER " + ")";

        db.execSQL(CREATE_ITEMS__TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEM_DETAIL);

        // Create tables again
        onCreate(db);

    }

    public void addNewItem(SingleItem newItem) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(ITEM, newItem.getItem());


        // Inserting Row
        db.insert(TABLE_ITEM_DETAIL, null, values);
        db.close(); // Closing database connection
    }

    public List<SingleItem> getAllItemList() {


        List<SingleItem> studentList = new ArrayList<SingleItem>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ITEM_DETAIL + " ORDER BY " + ITEM + " ASC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                SingleItem singleItem = new SingleItem();
                singleItem.setItem_id(Integer.parseInt(cursor.getString(0)));
                singleItem.setItem(Integer.parseInt(cursor.getString(1)));

                // Adding contact to list
                studentList.add(singleItem);

            } while (cursor.moveToNext());
        }

        // return contact list
        return studentList;
    }

}

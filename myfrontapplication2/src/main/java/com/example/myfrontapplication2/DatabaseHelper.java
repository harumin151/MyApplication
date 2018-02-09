package com.example.myfrontapplication2;

/**
 * Created by Panda on 2018/01/25.
 */

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DatabaseHelper extends SQLiteOpenHelper {

    /* データベース名 */
    private final static String DB_NAME = "androidgteamdb";
    /* データベースのバージョン */
    private final static int DB_VER = 1;
    public DatabaseHelper(ImageListViewActivity context) {
        super(context, DB_NAME,null,DB_VER);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "";
        sql +="create table ContactinformationTable (";
        sql +="No integer primary key autoincrement";
        sql +=",Name text not null";
        sql +=",location text";
        sql +=",memo text";
        sql +=",picture blob";
        sql +=")";
        sqLiteDatabase.execSQL(sql);    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

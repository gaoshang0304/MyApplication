package com.junchao.frametest.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 本地数据库帮助类
 *
 * @author gjc
 * @version ;;
 * @since 2018-03-06
 */

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    public static final String CREATE_GOODS = "create table goods()";
    private Context mContext;

    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

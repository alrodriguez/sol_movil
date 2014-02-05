package com.carvajal.adminpos.helpers;

import com.carvajal.adminpos.models.User;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminPOSDbHelper extends SQLiteOpenHelper {
	
	// If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ADMIN_POS.db";

    public AdminPOSDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(User.SQL_CREATE_ENTRIES);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(User.SQL_DELETE_ENTRIES);
        onCreate(db);

	}
	
	@Override
	public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}

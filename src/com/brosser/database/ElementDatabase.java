package com.brosser.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ElementDatabase extends SQLiteOpenHelper {

	/* The name of the database file on the file system*/
	private static final String DATABASE_NAME = "PeriodicTable";
	/* The version of the database that this class understands*/
	private static final int DATABASE_VERSION = 1;
	/* The context, needed to load SQL from string resources*/
	private final Context mContext;
	
	public ElementDatabase(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		this.mContext = context;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onCreate(SQLiteDatabase database) {
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}

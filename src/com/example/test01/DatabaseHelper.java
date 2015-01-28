package com.example.test01;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
	private static final String DATABASE_NAME = "mydata.db";
	private static final int DATABASE_VERSION = 2;
	private static final String TABLE_NAME = "location_table";
	private static final String ID = "id";
	private static final String START = "start_location";
	private static final String END = "end_location";

	DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO 自動生成されたコンストラクター・スタブ
	}



	@Override

	public void onCreate(SQLiteDatabase arg0) {
		// TODO 自動生成されたメソッド・スタブ

		String query = "create table " + TABLE_NAME + "("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ START +" TEXT," +
				END + " TEXT)";
		arg0.execSQL(query);

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO 自動生成されたメソッド・スタブ

		arg0.execSQL("drop table if exsits " + TABLE_NAME);
		onCreate(arg0);

	}

}

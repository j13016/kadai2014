package com.example.test01;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;

public class DatabaseActivity extends Activity{

	static SQLiteDatabase mydb;
	Button btn = null;

	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}




}

package com.example.test01;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Click extends Activity{

	Button btn,btn2,btn3 = null;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.root2_main);

		btn3 = (Button)findViewById(R.id.button3);
		btn3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				Intent intent = new Intent(Click.this,MainActivity.class);
				startActivity(intent);
			}
		});
		Toast.makeText(this, "経路取得画面に移動しました", Toast.LENGTH_SHORT).show();

		btn2 = (Button)findViewById(R.id.push);
		btn2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO 自動生成されたメソッド・スタブ
				add();

			}
		});
	}
	private void add(){
		EditText editText = (EditText)findViewById(R.id.editText1);
		EditText editText2 = (EditText)findViewById(R.id.editText2);
		DatabaseHelper dbHelper = new DatabaseHelper(this);
		SQLiteDatabase db = dbHelper.getWritableDatabase();

		String START = editText.getText().toString();
		String END = editText2.getText().toString();
		ContentValues values = new ContentValues();
		values.put("start_location", START);
		values.put("end_location", END);

		//INSERT
		long rowID =db.insert("location_table","",values);
		editText.setText("");
		editText2.setText("");
		if(rowID == -1){
			db.close();
			throw new SQLException("Failed to insert row");
		}db.close();
	}


	public void View() {
		DatabaseHelper hlpr = new DatabaseHelper(getApplicationContext());
		hlpr.getWritableDatabase();
		EditText editText = (EditText)findViewById(R.id.editText1);

		SQLiteDatabase mydb = null;
		try{
			Cursor cr =mydb.rawQuery("select * From bbs Order By id desc",null);
					cr.moveToFirst();
			if(cr.getCount() > 0){
				Integer[] data = new Integer[cr.getCount()];
				ArrayAdapter<String>adapter = new ArrayAdapter<String>
					(this,android.R.layout.simple_list_item_1);

				for(int cnt = 0;cnt < cr.getCount();cnt++){
					data[cnt] = cr.getInt(0);
					adapter.add("ID:" + cr.getString(0)+",\nSTART:" +cr.getString(1)+",\nEND:"+cr.getString(2));
					cr.moveToNext();
					//TextView.setAdapter(adapter);
				}

			} //else editText.setAdapter(null);
		}finally {
			mydb.close();
		}
	}

}


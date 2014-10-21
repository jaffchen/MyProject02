package com.example.myproject02.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class ProductDBHelper extends SQLiteOpenHelper {

	final static String DB_NAME = "FoodProduct";
	final static int DB_VERSION = 1;
	
	public ProductDBHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("Create table Product (" +
				"ID integer Primary Key AUTOINCREMENT, " +
				"Type varchar(50)," +
				"Name varchar(50), " +
				"Desc varchar(400), " +
				"Price1 integer, " +
				"Price2 integer, " +
				"Qty integer, " +
				"ImagePath String ) " );
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}

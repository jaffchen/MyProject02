package com.example.myproject02.data;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;


public class ProductDAODBImpl implements ProductDAO
{
	Context context;
	public ProductDAODBImpl(Context context)
	{
		this.context = context;
	}
	
	@Override
	public void add(Product p) 
	{
		ProductDBHelper helper = new ProductDBHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        
        db.execSQL("Insert into Product " +
       	"(Type, Name, Desc, Price1, Price2, Qty, ImagePath) " +
      	"values (" +
       	"'" + p.Type + "', '" + p.Name + "', '" + p.Desc + "', '" + p.Price1 + "', '" + p.Price2 + "', '" + p.Qty + "', '" + p.ImagePath + " ')");
        db.close();
	}

	@Override
	public Product[] getAll_A() {
		// TODO Auto-generated method stub
		ArrayList<Product> list = new ArrayList();
		ProductDBHelper helper = new ProductDBHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * From Product where Type = 'A' ", null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast())
        {
        	list.add(new Product(cursor.getInt(0), 
        			cursor.getString(1),
        			cursor.getString(2),
        			cursor.getString(3),
        			cursor.getInt(4),
        			cursor.getInt(5),
        			cursor.getInt(6),
        			cursor.getString(7)
        			));
        	cursor.moveToNext();
        }
        db.close();
        
        Product[] rtValue = new Product[list.size()];
        list.toArray(rtValue);
        return rtValue;
	}

	@Override
	public Product[] getAll_B() {
		// TODO Auto-generated method stub
		ArrayList<Product> list = new ArrayList();
		ProductDBHelper helper = new ProductDBHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * From Product where Type = 'B' ", null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast())
        {
        	list.add(new Product(cursor.getInt(0), 
        			cursor.getString(1),
        			cursor.getString(2),
        			cursor.getString(3),
        			cursor.getInt(4),
        			cursor.getInt(5),
        			cursor.getInt(6),
        			cursor.getString(7)
        			));
        	cursor.moveToNext();
        }
        db.close();
        
        Product[] rtValue = new Product[list.size()];
        list.toArray(rtValue);
        return rtValue;
	}

	@Override
	public Product[] getAll_C() {
		// TODO Auto-generated method stub
		ArrayList<Product> list = new ArrayList();
		ProductDBHelper helper = new ProductDBHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * From Product where Type = 'C' ", null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast())
        {
        	list.add(new Product(cursor.getInt(0), 
        			cursor.getString(1),
        			cursor.getString(2),
        			cursor.getString(3),
        			cursor.getInt(4),
        			cursor.getInt(5),
        			cursor.getInt(6),
        			cursor.getString(7)
        			));
        	cursor.moveToNext();
        }
        db.close();
        
        Product[] rtValue = new Product[list.size()];
        list.toArray(rtValue);
        return rtValue;
	}	
	
	@Override
	public Product getProduct(int ID) 
	{
		ProductDBHelper helper = new ProductDBHelper(context);
	    SQLiteDatabase db = helper.getReadableDatabase();
	    Cursor cursor = db.rawQuery("Select * From Product where ID=" + ID, null);
	    cursor.moveToFirst();
	    Product p = new Product(cursor.getInt(0), 
    			cursor.getString(1),
    			cursor.getString(2),
    			cursor.getString(3),
    			cursor.getInt(4),
    			cursor.getInt(5),
    			cursor.getInt(6),
    			cursor.getString(7));
	    db.close();
	    return p;
		}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		ProductDBHelper helper = new ProductDBHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("delete from Product");
        db.close();
	}

}

package com.example.myproject02;

import com.example.myproject02.data.*;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

	public class FirAty extends Activity {

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_fir_aty);
	        MyTest();
	        
	        ProductDAO dao = new ProductDAODBImpl(this);
	        Button btn1 = (Button) findViewById(R.id.button1);
	        Button btn2 = (Button) findViewById(R.id.button2);
	        Button btn3 = (Button) findViewById(R.id.button3);
	        
	        btn1.setOnClickListener(ListenerFirst);
	        btn2.setOnClickListener(ListenerFirst);
	        btn3.setOnClickListener(ListenerFirst);
	    }

	    
	    void MyTest()
	    {
	        ProductDAO dao = new ProductDAODBImpl(this);
	        dao.removeAll();
	        dao.add(new Product(0, "A", "脆皮雞排", "很好吃", 45, 0, 0, ""));
	        dao.add(new Product(0, "A", "脆皮雞排(無骨)", "很好吃", 50, 0, 0, ""));
	        dao.add(new Product(0, "A", "脆皮雞翅", "很好吃", 20, 0, 0, ""));
	        dao.add(new Product(0, "B", "脆皮鮮魷", "非常很好吃", 50, 0, 0, ""));
	        dao.add(new Product(0, "B", "脆皮魷魚塊", "非常很好吃", 50, 0, 0, ""));
	        dao.add(new Product(0, "B", "脆皮魷魚塊", "非常很好吃", 50, 0, 0, ""));
	        dao.add(new Product(0, "B", "馬加駱起司條", "非常很好吃", 30, 0, 0, ""));
	        dao.add(new Product(0, "B", "脆皮馬鈴薯", "非常很好吃", 30, 0, 0, ""));
	        dao.add(new Product(0, "B", "脆皮地瓜條", "非常很好吃", 20, 0, 0, ""));
	        dao.add(new Product(0, "B", "脆皮甜不辣", "非常很好吃", 20, 0, 0, ""));
	        dao.add(new Product(0, "B", "脆皮百頁豆腐", "非常很好吃", 20, 0, 0, ""));
	        dao.add(new Product(0, "B", "脆皮花枝丸", "非常很好吃", 20, 0, 0, ""));
	        dao.add(new Product(0, "B", "脆皮米腸", "非常很好吃", 20, 0, 0, ""));
	        dao.add(new Product(0, "C", "可口可樂", "好喝", 20, 10, 0, ""));
	        dao.add(new Product(0, "C", "可口可樂zero",  "好喝", 20, 10, 0, ""));
	        dao.add(new Product(0, "C", "雪碧",  "好喝", 20, 10, 0, ""));
	        dao.add(new Product(0, "C", "雀巢檸檬茶",  "好喝", 20, 10, 0, ""));
	        dao.add(new Product(0, "C", "芬垟桶子", "好喝", 20, 10, 0, ""));
	
	    }
	    
	    private Button.OnClickListener ListenerFirst = new Button.OnClickListener()
	    {
	        @Override
	        public void onClick(View v)
	        {
	        	Intent intent;
	        	switch (v.getId())
	        	{
	        		case R.id.button1 :
	        			intent = new Intent(FirAty.this, SecAty_A.class);
	        			startActivity(intent);
	        			break;
	        		case R.id.button2 :
	        			intent = new Intent(FirAty.this, SecAty_B.class);
	        			startActivity(intent);
	        			break;
	        		case R.id.button3 :
	        			intent = new Intent(FirAty.this, SecAty_B.class);
	        			startActivity(intent);
	        			break;
	        	}
	        }
	    };
	    
	    
	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.fir_aty, menu);
	        return true;
	    }


	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        // Handle action bar item clicks here. The action bar will
	        // automatically handle clicks on the Home/Up button, so long
	        // as you specify a parent activity in AndroidManifest.xml.
	        int id = item.getItemId();
	        if (id == R.id.action_settings) {
	            return true;
	        }
	        return super.onOptionsItemSelected(item);
	    }
	}

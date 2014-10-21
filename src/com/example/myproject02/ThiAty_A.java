package com.example.myproject02;

import com.example.myproject02.data.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ThiAty_A extends Activity 
{
	
	TextView tv1, tv2, tv3, tv4, tyImagePath;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_thi_aty_a);
		
		Intent it = getIntent();
		int ID = it.getIntExtra("ID", 0);
	    ProductDAO dao = new ProductDAODBImpl(this);
	    Product p = dao.getProduct(ID);
	    
	    tv1 = (TextView) findViewById(R.id.textView1);
	    tv2 = (TextView) findViewById(R.id.textView2);
	    tv3 = (TextView) findViewById(R.id.textView3);
	    tv4 = (TextView) findViewById(R.id.textView4);
	    //tvImagePath = (TextView) findViewById(R.id.textView3);
	    
	    switch(p.Type)
	    {
	    	case "A" :
	    		tv1.setText("雞肉系列：" + p.Name);
	    		break;
	    	case "B" :
	    		tv1.setText("點心系列：" + p.Name);
	    		break;
	    	case "C" :
	    		tv1.setText("飲料系列：" + p.Name);
	    		break;
	    }
	    tv2.setText(p.Desc);
	    tv3.setText("定  價：" + Integer.toString(p.Price1));
	    tv4.setText("優惠折價：" + Integer.toString(p.Price2)); 
	    //tvImagePath.setText(p.ImagePath);

        Button btn1 = (Button) findViewById(R.id.button1);        
        btn1.setOnClickListener(ListenerFirst);

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
        			finish();
        			break;
        	}
        }
    };
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.thi_aty_a, menu);
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

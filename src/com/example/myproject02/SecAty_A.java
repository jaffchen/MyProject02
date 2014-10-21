package com.example.myproject02;

import com.example.myproject02.data.*;

//1021
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.ImageView;

//1021

import java.util.Locale;


import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SecAty_A extends Activity implements ActionBar.TabListener 
{
	/**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v13.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;
	Product[] prd_data1;
	Product[] prd_data2;
	Product[] prd_data3;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_aty_a);

        // Set up the action bar.
        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.

        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        // When swiping between different sections, select the corresponding
        // tab. We can also use ActionBar.Tab#select() to do this if we have
        // a reference to the Tab.
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener()
        {
            @Override
            public void onPageSelected(int position)
            {
                actionBar.setSelectedNavigationItem(position);
            }
        });

        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++)
        {
            // Create a tab with text corresponding to the page title defined by
            // the adapter. Also specify this Activity object, which implements
            // the TabListener interface, as the callback (listener) for when
            // this tab is selected.
            actionBar.addTab(
                    actionBar.newTab()
                    .setText(mSectionsPagerAdapter.getPageTitle(i))
                    .setTabListener(this));
        }
    }  


    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sec_aty_a, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) 
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) 
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction)
    {
        // When the given tab is selected, switch to the corresponding page in
        // the ViewPager.
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction)
    {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) 
    {
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter
    {
        public SectionsPagerAdapter(FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public Fragment getItem(int position)
        {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            //return PlaceholderFragment.newInstance(position + 1);
            switch(position)
            {
            	case 0:
            		return Fragment1.newInstance(0);
            	case 1:
            		return Fragment2.newInstance(0);
            	case 2:
            		return Fragment3.newInstance(0);  
            	case 3:
            		return Fragment1.newInstance(0);  
            	default:
            		return Fragment1.newInstance(0);   
            }
        }

        @Override
        public int getCount() 
        {
        	// Show 3 total pages.
        	return 3;
        }

        @Override
        public CharSequence getPageTitle(int position)
        {
        	Locale l = Locale.getDefault();

        	switch (position)
        	{
        		case 0:
        			return "雞肉系列";
        		case 1:
        			return "點心系列";
        		case 2:
        			return "飲料系列";
        		case 3:
        			return "購物車";
        	}
        	return null;
        }
    }

    /**
     ** A placeholder fragment containing a simple view.
     **/
    public static class Fragment1 extends Fragment
    {
    	private int flag;
    	HashMap<Integer, String> hashMap = new HashMap<Integer, String>();  
    	
    	static Product[] data;

    	private static final String ARG_SECTION_NUMBER = "section_number";

    	public static Fragment1 newInstance(int sectionNumber)
    	{
    		Fragment1 fragment = new Fragment1();
    		Bundle args = new Bundle();
    		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
    		fragment.setArguments(args);
    		return fragment;
    	}

    	public Fragment1() 
    	{
    	}

    	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
    	{
    		View rootView = inflater.inflate(R.layout.fragment_sec_aty_a_01, container, false);
    	
    		ProductDAO dao = new ProductDAODBImpl(rootView.getContext());
    		data = dao.getAll_A();
    		ListView lv = (ListView)rootView.findViewById(R.id.listView1);
	
    		ListAdapter adapter = new ListAdapter(this.getActivity(), data);
    		lv.setAdapter(adapter);
    		return rootView;
    	}

// 1021        


    	
// 1021    	
    	
    	class ListAdapter extends BaseAdapter
    	{
    		Product[] data;
    		Activity act;
    		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();  
    		
    		private LayoutInflater inflater = null;  		
    		public ListAdapter(Activity a, Product[] data)
    		{
    			this.act = a;
    			this.data = data;
    			inflater = (LayoutInflater) act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    		}
    	
    		@Override
    		public int getCount()
    		{
    			// TODO Auto-generated method stub
    			return data.length;
    		}

    		@Override
    		public Object getItem(int arg0) 
    		{
    			// TODO Auto-generated method stub
    			return null;
    		}

    		@Override
    		public long getItemId(int position)
    		{
    			// TODO Auto-generated method stub
    			return position;
    		}

    		@Override
    		public View getView(final int position, View convertView, ViewGroup parent)
    		{
    			// 1021     
    			ViewHolder holder = null;
    			if (convertView == null)
    			{
    				holder=new ViewHolder();  
    				//可以理解为從vlist獲取view  之後把view返回给ListView
    				convertView = inflater.inflate(R.layout.listitem, null);
    				holder.name = (TextView)convertView.findViewById(R.id.tvName);
    				holder.text = (TextView)convertView.findViewById(R.id.tvText);
    				holder.btn1 = (Button)convertView.findViewById(R.id.button1);
    				holder.btn2 = (Button)convertView.findViewById(R.id.button2);
    				convertView.setTag(holder);				
    			}
    			else 
    			{				
    				holder = (ViewHolder)convertView.getTag();
    			}		
    			
    			holder.name.setText(data[position].Name);
    			holder.text.setText("價格" + Integer.toString(data[position].Price1)  + ", 數量" + Integer.toString(data[position].Qty) + " 小計" + Integer.toString(data[position].Qty));

    			//给Button添加單擊事件  添加Button之後ListView將失去焦點  需要的直接把Button的焦點去掉
    			holder.btn1.setOnClickListener(new View.OnClickListener()
    			{
    				@Override
    				public void onClick(View v)
    				{
    					data[position].Qty = data[position].Qty + 1;
    					hashMap.put(position, Integer.toString(data[position].Qty)); 
    					Toast.makeText(getActivity(), Integer.toString(data[position].Qty), Toast.LENGTH_SHORT).show();
    				}
    			});

    			holder.btn2.setOnClickListener(new View.OnClickListener()
    			{
    				@Override
    				public void onClick(View v)
    				{
    					if (data[position].Qty > 0)
    					{	
    					   data[position].Qty = data[position].Qty - 1;
    					   Toast.makeText(getActivity(), Integer.toString(data[position].Qty), Toast.LENGTH_SHORT).show();
    					   hashMap.put(position, Integer.toString(data[position].Qty)); 
    					}
    				}
    			});


    			holder.text.setOnClickListener(new View.OnClickListener()
    			{
    				@Override
    				public void onClick(View v)
    				{
    					Intent it = new Intent(getActivity(), ThiAty_A.class);
    					it.putExtra("ID", data[position].ID);
    					startActivity(it);
    				}
    			});
    			
    			holder.name.setOnClickListener(new View.OnClickListener()
    			{
    				@Override
    				public void onClick(View v)
    				{
    					Intent it = new Intent(getActivity(), ThiAty_A.class);
    					it.putExtra("ID", data[position].ID);
    					startActivity(it);
    				}
    			});    			
    			
    			return convertView;

    		}
  		
    		public final class ViewHolder
    		{
    			public TextView name;
    			public TextView text;
    			public Button btn1;
    			public Button btn2;
    		}
    	}
    }
    
  //========================================================================================
    
    public static class Fragment2 extends Fragment
    {
    	static Product[] data;

    	private static final String ARG_SECTION_NUMBER = "section_number";

    	public static Fragment2 newInstance(int sectionNumber)
    	{
    		Fragment2 fragment = new Fragment2();
    		Bundle args = new Bundle();
    		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
    		fragment.setArguments(args);
    		return fragment;
    	}

    	public Fragment2() 
    	{
    	}

    	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
    	{
    		View rootView = inflater.inflate(R.layout.fragment_sec_aty_a_02, container, false);
    	
    		ProductDAO dao = new ProductDAODBImpl(rootView.getContext());
    		data = dao.getAll_B();
    		ListView lv = (ListView)rootView.findViewById(R.id.listView1);
    		ListAdapter adapter = new ListAdapter(this.getActivity(), data);
    		lv.setAdapter(adapter);
    		return rootView;
    	}


    	class ListAdapter extends BaseAdapter
    	{

    		Product[] data;
    		Activity act;
    		private LayoutInflater inflater = null;
    		public ListAdapter(Activity a, Product[] data)
    		{
    			this.act = a;
    			this.data = data;
    			inflater = (LayoutInflater) act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    		}
    	
    		@Override
    		public int getCount() 
    		{
    			// TODO Auto-generated method stub
    			return data.length;
    		}

    		@Override
    		public Object getItem(int arg0) 
    		{
    			// TODO Auto-generated method stub
    			return null;
    		}

    		@Override
    		public long getItemId(int position) 
    		{
    			// TODO Auto-generated method stub
    			return position;
    		}

    		@Override
    		public View getView(final int position, View arg1, ViewGroup arg2)
    		{
    			View v = inflater.inflate(R.layout.listitem, null);
    			TextView tvName = (TextView) v.findViewById(R.id.tvName);
    			tvName.setText(data[position].Name);
    			TextView tvText = (TextView) v.findViewById(R.id.tvText);
    			tvText.setText("價格" + Integer.toString(data[position].Price1)  + ", 數量" + Integer.toString(data[position].Qty) + " 小計" + Integer.toString(data[position].Qty));
    			return v;
    		}	
    	}
    }

    public static class Fragment3 extends Fragment
    {
    	static Product[] data;

    	private static final String ARG_SECTION_NUMBER = "section_number";

    	public static Fragment3 newInstance(int sectionNumber)
    	{
    		Fragment3 fragment = new Fragment3();
    		Bundle args = new Bundle();
    		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
    		fragment.setArguments(args);
    		return fragment;
    	}

    	public Fragment3() 
    	{
    	}

    	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
    	{
    		View rootView = inflater.inflate(R.layout.fragment_sec_aty_a_03, container, false);
    	
    		ProductDAO dao = new ProductDAODBImpl(rootView.getContext());
    		data = dao.getAll_C();
    		ListView lv = (ListView)rootView.findViewById(R.id.listView1);
    		ListAdapter adapter = new ListAdapter(this.getActivity(), data);
        
    		lv.setAdapter(adapter);

    		return rootView;
    	}


    	class ListAdapter extends BaseAdapter
    	{
    		Product[] data;
    		Activity act;
    		private LayoutInflater inflater = null;
    		public ListAdapter(Activity a, Product[] data)
    		{
    			this.act = a;
    			this.data = data;
    			inflater = (LayoutInflater) act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    		}
    	
    		@Override
    		public int getCount() 
    		{
    			// TODO Auto-generated method stub
    			return data.length;
    		}

    		@Override
    		public Object getItem(int arg0) 
    		{
    			// TODO Auto-generated method stub
    			return null;
    		}

    		@Override
    		public long getItemId(int position) 
    		{
    			// TODO Auto-generated method stub
    			return position;
    		}

    		@Override
    		public View getView(final int position, View arg1, ViewGroup arg2) 
    		{
    			View v = inflater.inflate(R.layout.listitem, null);
    			TextView tvName = (TextView) v.findViewById(R.id.tvName);
    			tvName.setText(data[position].Name);
    			TextView tvText = (TextView) v.findViewById(R.id.tvText);
    			tvText.setText("價格" + Integer.toString(data[position].Price1)  + ", 數量" + Integer.toString(data[position].Qty) + " 小計" + Integer.toString(data[position].Qty));
    			return v;
    		}	
    	}
    }
}

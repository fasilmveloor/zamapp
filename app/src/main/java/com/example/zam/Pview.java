package com.example.zam;

import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Pview extends Activity {
	ListView pvdb;
	String ppname="";
	String pnamearray[];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_pview);
		
		pvdb=(ListView)findViewById(R.id.plistViewsview);
		
		SQLiteDatabase sqdb=openOrCreateDatabase("PHYSICAL_EDUCATION", SQLiteDatabase.CREATE_IF_NECESSARY, null);
		sqdb.setVersion(1);
		sqdb.setLocale(Locale.getDefault());
		
		String tab="create table if not exists registration(admission text primary key,sname text,sclass text,syear text,scontact text,age text,itemone text,ite2 text,ite3 text,ite4 text)";
		sqdb.execSQL(tab);
		
		String w="select * from registration";
		Cursor cu=sqdb.rawQuery(w, null);
		
		if(cu.getCount()>0)
		{
			cu.moveToFirst();
			do{
				ppname =ppname+cu.getString(1)+"   "+cu.getString(0)+",";
				
			}
			while(cu.moveToNext());
		}
		
		pnamearray = ppname.split(",");
		
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,pnamearray);
		pvdb.setAdapter(arrayAdapter);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pview, menu);
		return true;
	}

}

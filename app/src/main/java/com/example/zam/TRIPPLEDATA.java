package com.example.zam;

import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TRIPPLEDATA extends Activity {
	
	ListView tda;
	String tpoint="";
	String[]twinnerarray;
	String[]tpwinnerarray;
	String twinner="";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_trippledat);
		
		tda=(ListView)findViewById(R.id.tdview);
		
		SQLiteDatabase sdb=openOrCreateDatabase("PHYSICAL_EDUCATION", SQLiteDatabase.CREATE_IF_NECESSARY, null);
		sdb.setVersion(1);
		sdb.setLocale(Locale.getDefault());
		
		String tab="create table if not exists tripplejump(tadmission text,tpoints text)";
		sdb.execSQL(tab);
		
		
		
		String w="select * from tripplejump";
		Cursor cu=sdb.rawQuery(w, null);
		
		
		if(cu.getCount()>0)
		{
			cu.moveToFirst();
			do{
				twinner =twinner+cu.getString(0)+"\n"+cu.getString(1)+",";
				tpoint=tpoint+cu.getString(0)+",";
				
			}
			while(cu.moveToNext());
		}
		
		twinnerarray = twinner.split(",");
		tpwinnerarray = tpoint.split(",");
		
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,twinnerarray);
		tda.setAdapter(arrayAdapter);
		
		tda.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
				Intent i=new Intent(getApplicationContext(),TJDETAILS.class);
				String h=tpwinnerarray[arg2].toString();
				
				i.putExtra("x", h);
				startActivity(i);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.trippledat, menu);
		return true;
	}

}

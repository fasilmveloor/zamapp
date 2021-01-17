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

public class Sview extends Activity {
	
	ListView vdb;
	String pname="";
	String[]namearray;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_sview);
		
		vdb=(ListView)findViewById(R.id.list);
		
		SQLiteDatabase sqdb=openOrCreateDatabase("PHYSICAL_EDUCATION", SQLiteDatabase.CREATE_IF_NECESSARY, null);
		sqdb.setVersion(1);
		sqdb.setLocale(Locale.getDefault());
		
		String tab="create table if not exists sqoata_registration(admission text primary key,sname text,sclass text,mainevent text,scontact text,adtype text,age text,guardian text)";
		sqdb.execSQL(tab);
		
		String w="select * from sqoata_registration";
		Cursor cu=sqdb.rawQuery(w, null);
		
		if(cu.getCount()>0)
		{
			cu.moveToFirst();
			do{
				pname =pname+cu.getString(1)+"   "+cu.getString(0)+"///";
				
			}
			while(cu.moveToNext());
			sqdb.close();
		}
		
		namearray = pname.split("///");
		
		ArrayAdapter<String> adp = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,namearray);
		vdb.setAdapter(adp);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sview, menu);
		return true;
	}

}

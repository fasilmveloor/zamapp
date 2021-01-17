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

public class LONGDATA extends Activity {
	
	ListView lda;
	String lpoint="";
	String[]lwinnerarray;
	String[]lpwinnerarray;
	String lwinner="";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_longdat);
		
		lda=(ListView)findViewById(R.id.ldview);
		
		SQLiteDatabase sdb=openOrCreateDatabase("PHYSICAL_EDUCATION", SQLiteDatabase.CREATE_IF_NECESSARY, null);
		sdb.setVersion(1);
		sdb.setLocale(Locale.getDefault());
		
		String ta="create table if not exists longjump(ladmission text,lpoints text)";
		sdb.execSQL(ta);
		
		String w="select * from longjump";
		Cursor cu=sdb.rawQuery(w, null);
		
		
		if(cu.getCount()>0)
		{
			cu.moveToFirst();
			do{
				lwinner =lwinner+cu.getString(0)+"\n"+cu.getString(1)+",";
				lpoint=lpoint+cu.getString(0)+",";
				
			}
			while(cu.moveToNext());
		}
		
		lwinnerarray = lwinner.split(",");
		lpwinnerarray = lpoint.split(",");
		
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,lwinnerarray);
		lda.setAdapter(arrayAdapter);
		
		lda.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
				Intent i=new Intent(getApplicationContext(),LONGDETAILS.class);
				String h=lpwinnerarray[arg2].toString();
				
				i.putExtra("x", h);
				startActivity(i);
				
			}
		});
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.longdat, menu);
		return true;
	}

}

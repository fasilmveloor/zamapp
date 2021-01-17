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

public class DATA extends Activity {
	
	ListView da;
	String point="";
	String[]winnerarray;
	String[]pwinnerarray;
	String winner="";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_dat);
		
		da=(ListView)findViewById(R.id.dview);
		
		SQLiteDatabase sdb=openOrCreateDatabase("PHYSICAL_EDUCATION", SQLiteDatabase.CREATE_IF_NECESSARY, null);
		sdb.setVersion(1);
		sdb.setLocale(Locale.getDefault());
		
		String ta="create table if not exists highjump(admission text,points text)";
		sdb.execSQL(ta);
		
		String w="select * from highjump";
		Cursor cu=sdb.rawQuery(w, null);
		
		
		if(cu.getCount()>0)
		{
			cu.moveToFirst();
			do{
				winner =winner+cu.getString(0)+"\n"+cu.getString(1)+",";
				point=point+cu.getString(0)+",";
				
			}
			while(cu.moveToNext());
		}
		
		winnerarray = winner.split(",");
		pwinnerarray = point.split(",");
		
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,winnerarray);
		da.setAdapter(arrayAdapter);
		
		da.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
				Intent i=new Intent(getApplicationContext(),Dataindetails.class);
				String h=pwinnerarray[arg2].toString();
				
				i.putExtra("x", h);
				startActivity(i);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dat, menu);
		return true;
	}

}

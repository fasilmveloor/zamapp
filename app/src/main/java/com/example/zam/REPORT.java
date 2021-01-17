package com.example.zam;

import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class REPORT extends Activity {
	
	ListView f1;
	ImageView m1;
	String fw="";
	String[]fwinner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_report);
		
		f1=(ListView)findViewById(R.id.twxit);
		//m1=(ImageView)findViewById(R.id.twxit);
		
		SQLiteDatabase sqdb=openOrCreateDatabase("PHYSICAL_EDUCATION", SQLiteDatabase.CREATE_IF_NECESSARY, null);
		sqdb.setVersion(1);
		sqdb.setLocale(Locale.getDefault());
		
		String tab="create table if not exists winners(wadmission text,winame text,witem text  primary key)";
		sqdb.execSQL(tab);
		
		String w="select * from winners";
		Cursor cu=sqdb.rawQuery(w, null);
		
		
		if(cu.getCount()>0)
		{
			cu.moveToFirst();
			do{
				fw =fw+cu.getString(1)+"\n"+cu.getString(0)+"    "+cu.getString(2)+",";
				
				
			}
			while(cu.moveToNext());
		}
		
		fwinner = fw.split(",");
		
		
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,fwinner);
		f1.setAdapter(arrayAdapter);
		
		/*m1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				REPORT.this.finish();
				
			}
		});*/
		
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.report, menu);
		return true;
	}

}

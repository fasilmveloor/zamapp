package com.example.zam;

import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

public class VIEWDB extends Activity {
	
	Spinner sp;
	ListView lst;
	String itelists="";
	String ite;
	ImageView img;
	String itemarray[];
	
	String[] itemssel={"BOXING","HIGH JUMP","LONG JUMP","TRPLE JUMP"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_viewdb);
		
		sp=(Spinner)findViewById(R.id.itemslist);
		lst=(ListView)findViewById(R.id.regdetails);
		img=(ImageView)findViewById(R.id.show);
		
		ArrayAdapter<String> adpi=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,itemssel);
		sp.setAdapter(adpi);
		
		sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				
				ite=itemssel[arg2].toString();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		img.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				SQLiteDatabase sqdb=openOrCreateDatabase("PHYSICAL_EDUCATION", SQLiteDatabase.CREATE_IF_NECESSARY, null);
				sqdb.setVersion(1);
				sqdb.setLocale(Locale.getDefault());
				
				String tab="create table if not exists registration(admission text primary key,sname text,sclass text,syear text,scontact text,age text,itemone text,ite2 text,ite3 text,ite4 text)";
				sqdb.execSQL(tab);
				
				String w="select * from registration where itemone='"+ite+"' or ite2='"+ite+"' or ite3='"+ite+"' or ite4='"+ite+"' ";
				Cursor cu=sqdb.rawQuery(w, null);
				
				if(cu.getCount()>0)
				{
					cu.moveToFirst();
					do{
						itelists =itelists+cu.getString(1)+",";
						
					}
					while(cu.moveToNext());
				}
				
				itemssel = itelists.split(",");
				
				ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,itemssel);
				lst.setAdapter(arrayAdapter);
				
				
				
				
				
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.viewdb, menu);
		return true;
	}

}

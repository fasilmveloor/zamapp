package com.example.zam;

import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TJDETAILS extends Activity {
	
	TextView tt1,tt2,tt3;
	ImageView tins;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_tjdetails);
		
		
		tt1=(TextView)findViewById(R.id.ttextView1);
		tt2=(TextView)findViewById(R.id.ttextView2);
		tt3=(TextView)findViewById(R.id.ttextView3);
		tins=(ImageView)findViewById(R.id.treportbtn);
		
		
		Intent h=getIntent();
		String k=h.getStringExtra("x");
		
		SQLiteDatabase sqdb=openOrCreateDatabase("PHYSICAL_EDUCATION", SQLiteDatabase.CREATE_IF_NECESSARY, null);
		sqdb.setVersion(1);
		sqdb.setLocale(Locale.getDefault());
		
		String tab="create table if not exists registration(admission text primary key,sname text,sclass text,syear text,scontact text,age text,itemone text,ite2 text,ite3 text,ite4 text)";
		sqdb.execSQL(tab);
		
		String z="select * from registration where admission='"+k+"' ";
		
		Cursor cu=sqdb.rawQuery(z, null);
		
		while(cu.moveToNext())
			
		{
			
			//call=cu.getString(4);
			tt1.setText(cu.getString(1));
			tt2.setText(cu.getString(0));
			tt3.setText(cu.getString(5));
			
			//Toast.makeText(getApplicationContext(), cu.getString(0), Toast.LENGTH_LONG).show();
		}
		
		
		sqdb.close();
		
		tins.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String twn,twit,tadd;
				
				twn=tt1.getText().toString();
				twit="tripple jump";
				tadd=tt2.getText().toString();
				
				SQLiteDatabase sqdb=openOrCreateDatabase("PHYSICAL_EDUCATION", SQLiteDatabase.CREATE_IF_NECESSARY, null);
				sqdb.setVersion(1);
				sqdb.setLocale(Locale.getDefault());
				try
				{
					String tab="create table if not exists winners(wadmission text,winame text,witem text primary key)";
					sqdb.execSQL(tab);
					
					ContentValues cnn=new ContentValues();
					
					
					cnn.put("wadmission",tadd);
					cnn.put("winame",twn);
					cnn.put("witem", twit);
					
					sqdb.insert("winners", null, cnn);
					sqdb.close();
				}
				catch (Exception e) 
				 {
							// TODO: handle exception
				    		Toast.makeText(getApplicationContext(), "if"+e.getMessage(), Toast.LENGTH_SHORT).show(); 
				    		return;
				}
				Toast.makeText(getApplicationContext(), "insert"+tadd+twn+twit, Toast.LENGTH_SHORT).show();
				
				
				
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tjdetail, menu);
		return true;
	}

}

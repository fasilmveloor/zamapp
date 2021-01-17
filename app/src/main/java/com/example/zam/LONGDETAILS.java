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

public class LONGDETAILS extends Activity {
	
	
	TextView lt1,lt2,lt3;
	ImageView lins;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_longdetails);
		
		lt1=(TextView)findViewById(R.id.ltextView1);
		lt2=(TextView)findViewById(R.id.ltextView2);
		lt3=(TextView)findViewById(R.id.ltextView3);
		lins=(ImageView)findViewById(R.id.lreportbtn);
		
		
		Intent h=getIntent();
		String k=h.getStringExtra("x");
		
		SQLiteDatabase sqdb=openOrCreateDatabase("PHYSICAL_EDUCATION", SQLiteDatabase.CREATE_IF_NECESSARY, null);
		sqdb.setVersion(1);
		sqdb.setLocale(Locale.getDefault());
		
		String ta="create table if not exists longjump(ladmission text,lpoints text)";
		sqdb.execSQL(ta);
		
		String z="select * from registration where admission='"+k+"' ";
		
		Cursor cu=sqdb.rawQuery(z, null);
		
		while(cu.moveToNext())
			
		{
			
			//call=cu.getString(4);
			lt1.setText(cu.getString(1));
			lt2.setText(cu.getString(0));
			lt3.setText(cu.getString(5));
			
			//Toast.makeText(getApplicationContext(), cu.getString(0), Toast.LENGTH_LONG).show();
		}
		
		
		sqdb.close();
		
		lins.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String lwn,lwit,ladd;
				
				lwn=lt1.getText().toString();
				lwit="long jump";
				ladd=lt2.getText().toString();
				
				SQLiteDatabase sqdb=openOrCreateDatabase("PHYSICAL_EDUCATION", SQLiteDatabase.CREATE_IF_NECESSARY, null);
				sqdb.setVersion(1);
				sqdb.setLocale(Locale.getDefault());
				try
				{
					String tab="create table if not exists winners(wadmission text,winame text,witem text  primary key)";
					sqdb.execSQL(tab);
					
					ContentValues cnn=new ContentValues();
					
					
					cnn.put("wadmission", ladd);
					cnn.put("winame", lwn);
					cnn.put("witem", lwit);
					
					sqdb.insert("winners", null, cnn);
					sqdb.close();
				}
				catch (Exception e) 
				 {
							// TODO: handle exception
				    		Toast.makeText(getApplicationContext(), "if"+e.getMessage(), Toast.LENGTH_SHORT).show(); 
				    		return;
				}
				Toast.makeText(getApplicationContext(), "insert"+ladd+lwn+lwit, Toast.LENGTH_SHORT).show();
				
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.longdetail, menu);
		return true;
	}

}

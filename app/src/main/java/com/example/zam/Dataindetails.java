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

public class Dataindetails extends Activity {
	
	TextView t1,t2,t3;
	ImageView ins;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_dataindetails);
		
		t1=(TextView)findViewById(R.id.textView1);
		t2=(TextView)findViewById(R.id.textView2);
		t3=(TextView)findViewById(R.id.textView3);
		ins=(ImageView)findViewById(R.id.reportbtn);
		
		
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
			t1.setText(cu.getString(1));
			t2.setText(cu.getString(0));
			t3.setText(cu.getString(5));
			
			//Toast.makeText(getApplicationContext(), cu.getString(0), Toast.LENGTH_LONG).show();
		}
		
		
		sqdb.close();
		
		ins.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String wn,wit,add;
				
				wn=t1.getText().toString();
				wit="high jump";
				add=t2.getText().toString();
				
				SQLiteDatabase sqdb=openOrCreateDatabase("PHYSICAL_EDUCATION", SQLiteDatabase.CREATE_IF_NECESSARY, null);
				sqdb.setVersion(1);
				sqdb.setLocale(Locale.getDefault());
				try
				{
					String tab="create table if not exists winners(wadmission text,winame text,witem text  primary key)";
					sqdb.execSQL(tab);
					
					ContentValues cnn=new ContentValues();
					
					
					cnn.put("wadmission", add);
					cnn.put("winame", wn);
					cnn.put("witem", wit);
					
					sqdb.insert("winners", null, cnn);
					sqdb.close();
				}
				catch (Exception e) 
				 {
							// TODO: handle exception
				    		Toast.makeText(getApplicationContext(), "if"+e.getMessage(), Toast.LENGTH_SHORT).show(); 
				    		return;
				}
				Toast.makeText(getApplicationContext(), "insert"+add+wn+wit, Toast.LENGTH_SHORT).show();
				
				
				
				
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dataindetails, menu);
		return true;
	}

}

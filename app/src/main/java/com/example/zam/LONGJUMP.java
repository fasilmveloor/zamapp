package com.example.zam;

import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class LONGJUMP extends Activity {
	
	ImageButton lsu,lwi,lss;
	EditText ladni,ljp; 
	String ladmissionno="";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_longjump);
		
		lsu=(ImageButton)findViewById(R.id.lsubmit);
		lwi=(ImageButton)findViewById(R.id.lwinner);
		ladni=(EditText)findViewById(R.id.ladnu);
		ljp=(EditText)findViewById(R.id.lpoint);
		lss=(ImageButton)findViewById(R.id.lprize);
		
		
		lsu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String lfadni,lfjp;
				lfadni=ladni.getText().toString();
				lfjp=ljp.getText().toString();
				
				if(lfadni.equals("")||lfjp.equals(""))
				{
					Toast.makeText(LONGJUMP.this, "PLEASE FILL ALL THE FIELDS", Toast.LENGTH_LONG).show();
				}
				else
				{
					SQLiteDatabase sqdb=openOrCreateDatabase("PHYSICAL_EDUCATION", SQLiteDatabase.CREATE_IF_NECESSARY, null);
					sqdb.setVersion(1);
					sqdb.setLocale(Locale.getDefault());
					
					
					try
					{
					String tab="create table if not exists longjump(ladmission text,lpoints text)";
					sqdb.execSQL(tab);
					
					
					
					ContentValues cnn=new ContentValues();
					
					
					cnn.put("ladmission", lfadni);
					cnn.put("lpoints", lfjp);
					
					
					
					
					
					//inserting into database
					
					sqdb.insert("longjump", null, cnn);
					sqdb.close();
					}
					catch (Exception e) 
					 {
								// TODO: handle exception
					    		Toast.makeText(getApplicationContext(), "if"+e.getMessage(), Toast.LENGTH_SHORT).show(); 
					    		return;
					}
					Toast.makeText(getApplicationContext(), "insert", Toast.LENGTH_SHORT).show();
					ladni.setText("");
					ljp.setText("");
					
				}
				
			}
		});
		
		lwi.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String lfadni,lfjp;
				lfadni=ladni.getText().toString();
				lfjp=ljp.getText().toString();
				
			
				if(lfadni.equals("")||lfjp.equals(""))
				{
					Toast.makeText(LONGJUMP.this, "PLEASE FILL ALL THE FIELDS", Toast.LENGTH_LONG).show();
				}
				else
				{
					SQLiteDatabase sdb=openOrCreateDatabase("PHYSICAL_EDUCATION", SQLiteDatabase.CREATE_IF_NECESSARY, null);
					sdb.setVersion(1);
					sdb.setLocale(Locale.getDefault());
					try
					{
						
						String tab="create table if not exists longjump(ladmission text,lpoints text)";
						sdb.execSQL(tab);
						
						
						
						ContentValues cnn=new ContentValues();
						
						
						cnn.put("ladmission", lfadni);
						cnn.put("lpoints", lfjp);
						
						String [] a={lfadni};
						sdb.update("longjump", cnn, "ladmission=?", a);
						sdb.close();
					}
					catch(Exception e)
					{
						// TODO: handle exception
			    		Toast.makeText(getApplicationContext(), "if"+e.getMessage(), Toast.LENGTH_SHORT).show(); 
			    		return;
					}
					Toast.makeText(getApplicationContext(), "done", Toast.LENGTH_SHORT).show();
					ladni.setText("");
					ljp.setText("");
				}
				
			}
		});
		
		lss.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i=new Intent(getApplicationContext(),LONGDATA.class);
				startActivity(i);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.longjum, menu);
		return true;
	}

}

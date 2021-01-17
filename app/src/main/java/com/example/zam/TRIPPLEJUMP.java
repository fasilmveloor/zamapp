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

public class TRIPPLEJUMP extends Activity {
	
	ImageButton tsu,twi,tss;
	EditText tadni,tjp; 
	String tadmissionno="";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_tripplejump);
		
		
		tsu=(ImageButton)findViewById(R.id.tsubmit);
		twi=(ImageButton)findViewById(R.id.twinner);
		tadni=(EditText)findViewById(R.id.tadnu);
		tjp=(EditText)findViewById(R.id.tpoint);
		tss=(ImageButton)findViewById(R.id.tprize);
		
		tsu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String tfadni,tfjp;
				tfadni=tadni.getText().toString();
				tfjp=tjp.getText().toString();
				
				if(tfadni.equals("")||tfjp.equals(""))
				{
					Toast.makeText(TRIPPLEJUMP.this, "PLEASE FILL ALL THE FIELDS", Toast.LENGTH_LONG).show();
				}
				else
				{
					SQLiteDatabase sqdb=openOrCreateDatabase("PHYSICAL_EDUCATION", SQLiteDatabase.CREATE_IF_NECESSARY, null);
					sqdb.setVersion(1);
					sqdb.setLocale(Locale.getDefault());
					
					
					try
					{
					String tab="create table if not exists tripplejump(tadmission text,tpoints text)";
					sqdb.execSQL(tab);
					
					
					
					ContentValues cnn=new ContentValues();
					
					
					cnn.put("tadmission", tfadni);
					cnn.put("tpoints", tfjp);
					
					
					
					
					
					//inserting into database
					
					sqdb.insert("tripplejump", null, cnn);
					sqdb.close();
					}
					catch (Exception e) 
					 {
								// TODO: handle exception
					    		Toast.makeText(getApplicationContext(), "if"+e.getMessage(), Toast.LENGTH_SHORT).show(); 
					    		return;
					}
					Toast.makeText(getApplicationContext(), "insert", Toast.LENGTH_SHORT).show();
					tadni.setText("");
					tjp.setText("");
					
				}
				
			}
		});
		
		twi.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String tfadni,tfjp;
				tfadni=tadni.getText().toString();
				tfjp=tjp.getText().toString();
				
			
				if(tfadni.equals("")||tfjp.equals(""))
				{
					Toast.makeText(TRIPPLEJUMP.this, "PLEASE FILL ALL THE FIELDS", Toast.LENGTH_LONG).show();
				}
				else
				{
					SQLiteDatabase sdb=openOrCreateDatabase("PHYSICAL_EDUCATION", SQLiteDatabase.CREATE_IF_NECESSARY, null);
					sdb.setVersion(1);
					sdb.setLocale(Locale.getDefault());
					try
					{
						
						String tab="create table if not exists tripplejump(tadmission text,tpoints text)";
						sdb.execSQL(tab);
						
						ContentValues cnn=new ContentValues();
						
						
						cnn.put("tadmission", tfadni);
						cnn.put("tpoints", tfjp);
						
						String [] a={tfadni};
						sdb.update("tripplejump", cnn, "tadmission=?", a);
						sdb.close();
					}
					catch(Exception e)
					{
						// TODO: handle exception
			    		Toast.makeText(getApplicationContext(), "if"+e.getMessage(), Toast.LENGTH_SHORT).show(); 
			    		return;
					}
					Toast.makeText(getApplicationContext(), "done", Toast.LENGTH_SHORT).show();
					tadni.setText("");
					tjp.setText("");
				}
				
				
				
				
			}
		});
		
		tss.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(),TRIPPLEDATA.class);
				startActivity(i);
				
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tripplejum, menu);
		return true;
	}

}

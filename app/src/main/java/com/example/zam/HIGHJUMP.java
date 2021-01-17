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

public class HIGHJUMP extends Activity {
	
	ImageButton su,wi,ss;
	EditText adni,jp; 
	String admissionno="";
	//float x,y;
	//ListView tw;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_highjump);
		
		su=(ImageButton)findViewById(R.id.submit);
		wi=(ImageButton)findViewById(R.id.winner);
		adni=(EditText)findViewById(R.id.adnu);
		jp=(EditText)findViewById(R.id.point);
		ss=(ImageButton)findViewById(R.id.prize);
		//tw=(ListView)findViewById(R.id.listView1);
		
		

		
		
		
		
		
		
		su.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String fadni,fjp;
				fadni=adni.getText().toString();
				fjp=jp.getText().toString();
				
				if(fadni.equals("")||fjp.equals(""))
				{
					Toast.makeText(HIGHJUMP.this, "PLEASE FILL ALL THE FIELDS", Toast.LENGTH_LONG).show();
				}
				else
				{
					SQLiteDatabase sqdb=openOrCreateDatabase("PHYSICAL_EDUCATION", SQLiteDatabase.CREATE_IF_NECESSARY, null);
					sqdb.setVersion(1);
					sqdb.setLocale(Locale.getDefault());
					
					
					try
					{
					String tab="create table if not exists highjump(admission text,points text)";
					sqdb.execSQL(tab);
					
					
					
					ContentValues cnn=new ContentValues();
					
					
					cnn.put("admission", fadni);
					cnn.put("points", fjp);
					
					
					
					
					
					//inserting into database
					
					sqdb.insert("highjump", null, cnn);
					sqdb.close();
					}
					catch (Exception e) 
					 {
								// TODO: handle exception
					    		Toast.makeText(getApplicationContext(), "if"+e.getMessage(), Toast.LENGTH_SHORT).show(); 
					    		return;
					}
					Toast.makeText(getApplicationContext(), "insert", Toast.LENGTH_SHORT).show();
					adni.setText("");
					jp.setText("");
					
				}
				
			}
		});
		wi.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String fadni,fjp;
				fadni=adni.getText().toString();
				fjp=jp.getText().toString();
				
			
				if(fadni.equals("")||fjp.equals(""))
				{
					Toast.makeText(HIGHJUMP.this, "PLEASE FILL ALL THE FIELDS", Toast.LENGTH_LONG).show();
				}
				else
				{
					SQLiteDatabase sdb=openOrCreateDatabase("PHYSICAL_EDUCATION", SQLiteDatabase.CREATE_IF_NECESSARY, null);
					sdb.setVersion(1);
					sdb.setLocale(Locale.getDefault());
					try
					{
						
						String tab="create table if not exists highjump(admission text,points text)";
						sdb.execSQL(tab);
						
						ContentValues cnn=new ContentValues();
						
						
						cnn.put("admission", fadni);
						cnn.put("points", fjp);
						
						String [] a={fadni};
						sdb.update("highjump", cnn, "admission=?", a);
						sdb.close();
					}
					catch(Exception e)
					{
						// TODO: handle exception
			    		Toast.makeText(getApplicationContext(), "if"+e.getMessage(), Toast.LENGTH_SHORT).show(); 
			    		return;
					}
					Toast.makeText(getApplicationContext(), "done", Toast.LENGTH_SHORT).show();
					adni.setText("");
					jp.setText("");
				}
				
				
				
				
			}
		});
		
		ss.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(),DATA.class);
				startActivity(i);
				
				
			}
		});
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.highjum, menu);
		return true;
	}

}

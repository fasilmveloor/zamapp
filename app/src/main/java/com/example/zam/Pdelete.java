package com.example.zam;

import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Pdelete extends Activity {
	
	EditText pdelad;
	ImageView pdeletee;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_pdelete);
		
		pdelad=(EditText)findViewById(R.id.pdd);
		pdeletee=(ImageView)findViewById(R.id.pddd);
		
		pdeletee.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String adminum;
				adminum=pdelad.getText().toString();
				
				if(adminum.equals(""))
				{
					Toast.makeText(getApplicationContext(), "PLEASE PROVIDE ADMISSION NUMBER", Toast.LENGTH_SHORT).show();
				}
				
				else
				{
				SQLiteDatabase sqdb=openOrCreateDatabase("PHYSICAL_EDUCATION", SQLiteDatabase.CREATE_IF_NECESSARY, null);
				sqdb.setVersion(1);
				sqdb.setLocale(Locale.getDefault());
				
				
				try
				{
				String tab="create table if not exists registration(admission text primary key,sname text,sclass text,syear text,scontact text,age text,itemone text,ite2 text,ite3 text,ite4 text)";
				sqdb.execSQL(tab);
				String [] a={adminum};
				sqdb.delete("registration",  "admission=?", a);
				sqdb.close();
				}
				catch (Exception e) 
				 {
							// TODO: handle exception
				    		Toast.makeText(getApplicationContext(), "if"+e.getMessage(), Toast.LENGTH_SHORT).show(); 
				    		return;
				}
				Intent i=new Intent(getApplicationContext(),Pdeleted.class);
				startActivity(i);
				Pdelete.this.finish();
				Toast.makeText(getApplicationContext(), "deleted", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pdelete, menu);
		return true;
	}

}

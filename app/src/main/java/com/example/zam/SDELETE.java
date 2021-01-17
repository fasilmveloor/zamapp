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

public class SDELETE extends Activity {
	
	EditText delad;
	ImageView deletee;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_sdelete);
		delad=(EditText)findViewById(R.id.dd);
		deletee=(ImageView)findViewById(R.id.ddd);
		
		deletee.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String adminum;
				adminum=delad.getText().toString();
				
				if(adminum.equals(""))
				{
					Toast.makeText(getApplicationContext(), "PLEASE PROVIDE ADDMISSION NO", Toast.LENGTH_SHORT).show();
				}
				else
				{
				
				SQLiteDatabase sqdb=openOrCreateDatabase("PHYSICAL_EDUCATION", SQLiteDatabase.CREATE_IF_NECESSARY, null);
				sqdb.setVersion(1);
				sqdb.setLocale(Locale.getDefault());
				
				
				try
				{
				String tab="create table if not exists sqoata_registration(admission text primary key,sname text,sclass text,mainevent text,scontact text,adtype text,age text,guardian text)";
				sqdb.execSQL(tab);
				String [] a={adminum};
				sqdb.delete("sqoata_registration",  "admission=?", a);
				sqdb.close();
				}
				catch (Exception e) 
				 {
							// TODO: handle exception
				    		Toast.makeText(getApplicationContext(), "if"+e.getMessage(), Toast.LENGTH_SHORT).show(); 
				    		return;
				}
				Intent i=new Intent(getApplicationContext(),DELETED.class);
				startActivity(i);
				SDELETE.this.finish();
				Toast.makeText(getApplicationContext(), "deleted", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sdelete, menu);
		return true;
	}

}

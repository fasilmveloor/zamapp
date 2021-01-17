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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class Pfillup extends Activity {
	
	EditText pn,pan,pae,pmn;
	Spinner s4,s5;
	CheckBox hi,bo,tr,lo;
	String pasty,pCOOURSEE;
	ImageView psub,pb,pupt;
	
	String[] pcourses={"BCA","BSC","BA ENGLISH","BBA","BCOM"};
	String[] yr={"FIRST","SECOND","FINAL"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_pfillup);
		
		pn=(EditText)findViewById(R.id.pNAME);
		pan=(EditText)findViewById(R.id.padno);
		pae=(EditText)findViewById(R.id.pAGE);
		pmn=(EditText)findViewById(R.id.con);
		
		s4=(Spinner)findViewById(R.id.pADTYPE);
		s5=(Spinner)findViewById(R.id.pcourse);
		
		psub=(ImageView)findViewById(R.id.psave);
		pb=(ImageView)findViewById(R.id.pimageView1);
		pupt=(ImageView)findViewById(R.id.pimageView2);
		
		hi=(CheckBox)findViewById(R.id.hj);
		bo=(CheckBox)findViewById(R.id.boxx);
		tr=(CheckBox)findViewById(R.id.tj);
		lo=(CheckBox)findViewById(R.id.lj);
		
		
		psub.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String admi,fname,course,years,contact,hijmp,lngjmp,kbox,tripjmp,ages;
				admi=pan.getText().toString();
				fname=pn.getText().toString();
				ages=pae.getText().toString();
				course=s5.toString();
				years=s4.toString();
				contact=pmn.getText().toString();
				tripjmp=tr.getText().toString();
				hijmp=hi.getText().toString();
				lngjmp=lo.getText().toString();	
				kbox=bo.getText().toString();
				if(admi.equals("")||fname.equals("")||ages.equals("")||contact.equals("")||course.equals(""))
				{
					Toast.makeText(Pfillup.this, "PLEASE FILL ALL THE FIELDS", Toast.LENGTH_LONG).show();
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
						
						
						
						ContentValues cnn=new ContentValues();
						
						
						cnn.put("admission", admi);
						cnn.put("sname", fname);
						cnn.put("age", ages);
						cnn.put("sclass", course);
						cnn.put("syear", years);
						cnn.put("scontact", contact);
						if(hi.isChecked())
						{
							cnn.put("itemone", hijmp);	
						}
						if(bo.isChecked())
						{
							cnn.put("ite2", kbox);
						}
						if(tr.isChecked())
						{
							cnn.put("ite3", tripjmp);
						}
						if(lo.isChecked())
						{
							cnn.put("ite4", lngjmp);
						}
						
						
						
						//inserting into database
						
						sqdb.insert("registration", null, cnn);
						sqdb.close();
					}
					catch (Exception e) 
					 {
								// TODO: handle exception
					    		Toast.makeText(getApplicationContext(), "if"+e.getMessage(), Toast.LENGTH_SHORT).show(); 
					    		return;
					}
					Intent i=new Intent(getApplicationContext(),Psubsucc.class);
					startActivity(i);
					Toast.makeText(getApplicationContext(), "insert", Toast.LENGTH_SHORT).show();
					pn.setText("");
					pan.setText("");
					pae.setText("");
					pmn.setText("");
					
				}
				
				
				
			}
		});
		
		
		
		
		//adapter declaration
		
		
		ArrayAdapter<String> adp2=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,yr);
		s4.setAdapter(adp2);
		
		ArrayAdapter<String> adp3=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,pcourses);
		s5.setAdapter(adp3);
		
		//declaring click listener
		
		s4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				
				pasty=yr[arg2].toString();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		s5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				
				pCOOURSEE=pcourses[arg2].toString();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		pupt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String admi,fname,course,years,contact,hijmp,lngjmp,kbox,tripjmp,ages;
				admi=pan.getText().toString();
				fname=pn.getText().toString();
				ages=pae.getText().toString();
				course=s5.toString();
				years=s4.toString();
				contact=pmn.getText().toString();
				tripjmp=tr.getText().toString();
				hijmp=hi.getText().toString();
				lngjmp=lo.getText().toString();	
				kbox=bo.getText().toString();
				if(admi.equals(""))
				{
					Toast.makeText(Pfillup.this, "PROVIDE ADNO", Toast.LENGTH_LONG).show();
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
						
						
						
						ContentValues cnn=new ContentValues();
						
						
						cnn.put("admission", admi);
						cnn.put("sname", fname);
						cnn.put("age", ages);
						cnn.put("sclass", course);
						cnn.put("syear", years);
						cnn.put("scontact", contact);
						if(hi.isChecked())
						{
							cnn.put("itemone", hijmp);	
						}
						if(bo.isChecked())
						{
							cnn.put("ite2", kbox);
						}
						if(tr.isChecked())
						{
							cnn.put("ite3", tripjmp);
						}
						if(lo.isChecked())
						{
							cnn.put("ite4", lngjmp);
						}
						
						
						
						//inserting into database
						String [] a={admi};
						sqdb.update("registration", cnn, "admission=?", a);
						sqdb.close();
					}
					catch (Exception e) 
					 {
								// TODO: handle exception
					    		Toast.makeText(getApplicationContext(), "if"+e.getMessage(), Toast.LENGTH_SHORT).show(); 
					    		return;
					}
					Intent i=new Intent(getApplicationContext(),Pupdatesuccess.class);
					startActivity(i);
					Toast.makeText(getApplicationContext(), "updated", Toast.LENGTH_SHORT).show();
					pn.setText("");
					pan.setText("");
					pae.setText("");
					pmn.setText("");
				}
				
				
				
				
				
			}
		});
		pb.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(),Pregistermenu.class);
				startActivity(i);
				Pfillup.this.finish();
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pfillup, menu);
		return true;
	}

}

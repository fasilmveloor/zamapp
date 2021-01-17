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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class Fillup extends Activity {
	
	EditText n,an,ae,gn,mn;
	Spinner s1,s2,s3;
	String mmai,asty,COOURSEE;
	ImageView sub,b,upt;
	
	String[] mainitems={"LONG JUMP","KHO-KHO","TRIPPLE JUMP","TWIKWONDOW"};
	String[] courses={"BCA","BSC","BA ENGLISH","BBA","BCOM"};
	String[] adtype={"SP","SSP"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_fillup);
		
		n=(EditText)findViewById(R.id.NAME);
		an=(EditText)findViewById(R.id.adno);
		ae=(EditText)findViewById(R.id.AGE);
		gn=(EditText)findViewById(R.id.parent);
		mn=(EditText)findViewById(R.id.con);
		
		s1=(Spinner)findViewById(R.id.ADTYPE);
		s2=(Spinner)findViewById(R.id.course);
		s3=(Spinner)findViewById(R.id.sitem);
		
		sub=(ImageView)findViewById(R.id.save);
		b=(ImageView)findViewById(R.id.imageView1);
		upt=(ImageView)findViewById(R.id.imageView2);
		
		
		//adapter declaration
		
		ArrayAdapter<String> adp1=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,mainitems);
		s1.setAdapter(adp1);
		
		ArrayAdapter<String> adp2=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,adtype);
		s2.setAdapter(adp2);
		
		ArrayAdapter<String> adp3=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,courses);
		s3.setAdapter(adp3);
		
		//declaring click listener
		
		s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				
				asty=adtype[arg2].toString();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				
				COOURSEE=courses[arg2].toString();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		

		s3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				
				mmai=mainitems[arg2].toString();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		sub.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String admi,fname,course,mitem,contact,atype,ages,gname;
				admi=an.getText().toString();
				fname=n.getText().toString();
				course=COOURSEE.toString();
				mitem=mmai.toString();
				contact=mn.getText().toString();
				gname=gn.getText().toString();
				ages=ae.getText().toString();
				atype=asty.toString();
				
				if(atype.equals("")||mitem.equals("")||admi.equals("")||fname.equals("")||course.equals("")||ages.equals("")||gname.equals(""))
				{
					Toast.makeText(Fillup.this, "PLEASE FILL ALL THE FIELDS", Toast.LENGTH_LONG).show();
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
					
					
					
					ContentValues cnn=new ContentValues();
					
					
					cnn.put("admission", admi);
					cnn.put("sname", fname);
					cnn.put("sclass", course);
					cnn.put("mainevent", mitem);
					cnn.put("scontact", contact);
					cnn.put("adtype", atype);
					cnn.put("age", ages);
					cnn.put("guardian", gname);
					
					
					
					
					//inserting into database
					
					sqdb.insert("sqoata_registration", null, cnn);
					sqdb.close();
					}
					catch (Exception e) 
					 {
								// TODO: handle exception
					    		Toast.makeText(getApplicationContext(), "if"+e.getMessage(), Toast.LENGTH_SHORT).show(); 
					    		return;
					}
					Intent i=new Intent(getApplicationContext(),Fillsuccess.class);
					startActivity(i);
					Toast.makeText(getApplicationContext(), "insert", Toast.LENGTH_SHORT).show();
					n.setText("");
					an.setText("");
					ae.setText("");
					gn.setText("");
					mn.setText("");
					
				}
				
			}
		});
		
		upt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String admi,fname,course,mitem,contact,atype,ages,gname;
				admi=an.getText().toString();
				fname=n.getText().toString();
				course=COOURSEE.toString();
				mitem=mmai.toString();
				contact=mn.getText().toString();
				gname=gn.getText().toString();
				ages=ae.getText().toString();
				atype=asty.toString();
				
				if(admi.equals(""))
				{
					Toast.makeText(Fillup.this, "PROVIDE ADNO", Toast.LENGTH_LONG).show();
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
					
					
					
					ContentValues cnn=new ContentValues();
					
					
					cnn.put("admission", admi);
					cnn.put("sname", fname);
					cnn.put("sclass", course);
					cnn.put("mainevent", mitem);
					cnn.put("scontact", contact);
					cnn.put("adtype", atype);
					cnn.put("age", ages);
					cnn.put("guardian", gname);
					
					
					
					
					//inserting into database
					
					String [] a={admi};
					sqdb.update("sqoata_registration", cnn, "admission=?", a);
					sqdb.close();
					}
					catch (Exception e) 
					 {
								// TODO: handle exception
					    		Toast.makeText(getApplicationContext(), "if"+e.getMessage(), Toast.LENGTH_SHORT).show(); 
					    		return;
					}
					Intent i=new Intent(getApplicationContext(),UPSUCCESS.class);
					startActivity(i);
					Toast.makeText(getApplicationContext(), "updated", Toast.LENGTH_SHORT).show();
					n.setText("");
					an.setText("");
					ae.setText("");
					gn.setText("");
					mn.setText("");
					
				}
				
				
			}
		});
		
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(),Sregistermenu.class);
				startActivity(i);
				Fillup.this.finish();
				
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fillup, menu);
		return true;
	}

}

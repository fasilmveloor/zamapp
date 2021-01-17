package com.example.zam;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class MNHOME extends Activity {
	
	ImageView hij,lnj,trj,bka;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_mnhome);
		
		hij=(ImageView)findViewById(R.id.hijmp);
		lnj=(ImageView)findViewById(R.id.lngjmp);
		trj=(ImageView)findViewById(R.id.trjmp);
		bka=(ImageView)findViewById(R.id.baka);
		
		hij.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i=new Intent(getApplicationContext(),HIGHJUMP.class);
				startActivity(i);
				
			}
		});
		lnj.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i=new Intent(getApplicationContext(),LONGJUMP.class);
				startActivity(i);
				
			}
		});
		trj.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i=new Intent(getApplicationContext(),TRIPPLEJUMP.class);
				startActivity(i);
				
			}
		});
		bka.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(),Manager_menu.class);
				startActivity(i);
				finish();
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mnhome, menu);
		return true;
	}

}

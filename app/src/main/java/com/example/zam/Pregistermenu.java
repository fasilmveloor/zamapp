package com.example.zam;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class Pregistermenu extends Activity {
	
	ImageView pfl,pdl,pvw,pbak;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_pregistermenu);
		
		pfl=(ImageView)findViewById(R.id.pfill);
        pdl=(ImageView)findViewById(R.id.pdel);
        pvw=(ImageView)findViewById(R.id.pview);
        pbak=(ImageView)findViewById(R.id.pbac);
        
        pfl.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i=new Intent(getApplicationContext(),Pfillup.class);
				startActivity(i);
				
			}
		});
        pdl.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(),Pdelete.class);
				startActivity(i);
				
			}
		});
        pvw.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(),Pview.class);
				startActivity(i);
				
			}
		});
        pbak.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i=new Intent(getApplicationContext(),REGISTER.class);
				startActivity(i);
				Pregistermenu.this.finish();
				
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pregistermenu, menu);
		return true;
	}
	

}

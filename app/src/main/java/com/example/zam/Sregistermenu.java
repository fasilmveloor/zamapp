package com.example.zam;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class Sregistermenu extends Activity {
	
	ImageView fl,dl,vw,bak;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_sregistermenu);
		
		fl=(ImageView)findViewById(R.id.fill);
        dl=(ImageView)findViewById(R.id.del);
        vw=(ImageView)findViewById(R.id.view);
        bak=(ImageView)findViewById(R.id.bac);
        
        
        fl.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i=new Intent(getApplicationContext(),Fillup.class);
				startActivity(i);
				Sregistermenu.this.finish();
				
			}
		});
        dl.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i=new Intent(getApplicationContext(),SDELETE.class);
				startActivity(i);
				Sregistermenu.this.finish();
				
			}
		});
        vw.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i=new Intent(getApplicationContext(),Sview.class);
				startActivity(i);
				
			}
		});
        bak.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i=new Intent(getApplicationContext(),REGISTER.class);
				startActivity(i);
				Sregistermenu.this.finish();
				
				
			}
		});
        
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sregistermenu, menu);
		return true;
	}

}

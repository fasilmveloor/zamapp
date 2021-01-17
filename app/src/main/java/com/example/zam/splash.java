package com.example.zam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

public class splash extends Activity {
	
	private boolean backbtnpress;
	private static final int duration=3000;
	private Handler myhandler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		
		
		setContentView(R.layout.splashscreen);
		
		myhandler=new Handler();
		myhandler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				finish();
				if(!backbtnpress)
				{
					Intent inte=new Intent(splash.this,MainActivity.class);
					splash.this.startActivity(inte);
				}
				
			}
		}, duration);
	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		backbtnpress=true;
		super.onBackPressed();
	}

}

package com.example.zam;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class Pupdatesuccess extends Activity {
	ImageView pupd,pbaak;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_pupdatesuccess);
		
		
		pbaak=(ImageView)findViewById(R.id.pokk);
		pbaak.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i=new Intent(getApplicationContext(),Pfillup.class);
				startActivity(i);
				
				Pupdatesuccess.this.finish();
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pupdatesuccess, menu);
		return true;
	}

}

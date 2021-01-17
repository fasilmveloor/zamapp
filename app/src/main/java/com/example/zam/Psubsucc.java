package com.example.zam;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class Psubsucc extends Activity {
	ImageView psu,pk;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_psubsucc);
		
		
		pk=(ImageView)findViewById(R.id.pok);
		pk.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				
				Intent i=new Intent(getApplicationContext(),Pfillup.class);
				startActivity(i);
				
				Psubsucc.this.finish();
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.psubsucc, menu);
		return true;
	}

}

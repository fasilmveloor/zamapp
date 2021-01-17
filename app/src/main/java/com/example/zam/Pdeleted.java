package com.example.zam;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class Pdeleted extends Activity {
	
	ImageView pdee;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pdeleted);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		pdee=(ImageView)findViewById(R.id.pdeleteed);
		
		pdee.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Pdeleted.this.finish();
				
			}
		});
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pdeleted, menu);
		return true;
	}

}

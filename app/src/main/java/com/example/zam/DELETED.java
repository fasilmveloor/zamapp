package com.example.zam;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class DELETED extends Activity {

	ImageView dee;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_deleted);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dee=(ImageView)findViewById(R.id.deleteed);
		
		dee.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				DELETED.this.finish();
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.deleted, menu);
		return true;
	}

}

package com.example.zam;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class MainActivity extends Activity {

	ImageView re,em,ts,au;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        re=(ImageView)findViewById(R.id.register);
        em=(ImageView)findViewById(R.id.manage);
        ts=(ImageView)findViewById(R.id.tools);
        au=(ImageView)findViewById(R.id.imageView1);
        re.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i=new Intent(getApplicationContext(),REGISTER.class);
				startActivity(i);
				
			}
		});
        em.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				

				Intent i=new Intent(getApplicationContext(),Manager_menu.class);
				startActivity(i);
				
				
			}
		});
        ts.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				

				Intent is=new Intent(getApplicationContext(),TOOLS.class);
				startActivity(is);
				
				
			}
		});
        
        au.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent is=new Intent(getApplicationContext(),REPORT.class);
				startActivity(is);
				
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

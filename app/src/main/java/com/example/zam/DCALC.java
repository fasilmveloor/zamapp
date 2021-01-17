package com.example.zam;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class DCALC extends Activity {
	
	EditText le,wi;
	ImageView ds;
	TextView er;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_dcalc);
		
		le=(EditText)findViewById(R.id.LEN);
		wi=(EditText)findViewById(R.id.WID);
		ds=(ImageView)findViewById(R.id.dsub);
		er=(TextView)findViewById(R.id.textView1);
		er.setEnabled(false);
		
		
		
		
		ds.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
					double result=0;
					float num1,num2,ftr;
					num1=Float.valueOf(le.getText().toString());
					num2=Float.valueOf(wi.getText().toString());
					ftr=(num1*num1)+(num2*num2);
					result=Math.sqrt(ftr);
					String str=String.valueOf(result);
					//Toast.makeText(DCALC.this,str, Toast.LENGTH_LONG).show();
					er.setText(str);
					er.setEnabled(true);
				
				
				
				
				
				le.setText("");
				wi.setText("");
			}
				
				
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dcalc, menu);
		return true;
	}

}

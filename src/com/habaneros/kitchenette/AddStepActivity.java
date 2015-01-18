package com.habaneros.kitchenette;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class AddStepActivity extends Activity {
	
	private Integer stepNum = 0;
	private boolean done = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_step);
	}
	
	public void goToNextStep() {
		stepNum++;
		TextView t = (TextView) findViewById(R.id.stepNumber);
		t.setText(String.valueOf(stepNum));
	}
	
	public void finish() {
		done = true;
		
	}


}

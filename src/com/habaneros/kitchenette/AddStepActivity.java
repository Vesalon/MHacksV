package com.habaneros.kitchenette;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AddStepActivity extends Activity {
	
	private Integer stepNum = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_step);
	}
	
	public void toNextStep(View view) {
		stepNum++;
		TextView t = (TextView) findViewById(R.id.stepNumber);
		t.setText("Step " + String.valueOf(stepNum)+ ".");
		
		EditText e = (EditText) findViewById(R.id.recipeStep);
		e.setText("");
	}
	
	public void finishRecipe(View view) {
		Intent i = new Intent(this, BeginCookingActivity.class);
		//should actually go to an intermediate screen which lists time and crap
		startActivity(i);
		
	}

}

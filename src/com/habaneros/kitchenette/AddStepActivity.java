package com.habaneros.kitchenette;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AddStepActivity extends Activity {
	
	private Integer stepNum = 1;
	String recname;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_step);
		Intent i = new Intent();
		recname = i.getCharArrayExtra("recname").toString();
	}
	
	public void toNextStep(View view) {
		Recipe r = new Recipe(MainActivity.getName(), recname);
		r.addStep(((EditText) findViewById(R.id.recipeStep)).getText().toString());
		stepNum++;
		TextView t = (TextView) findViewById(R.id.stepNumber);
		t.setText("Step " + String.valueOf(stepNum)+ ".");
		
		
		EditText e = (EditText) findViewById(R.id.recipeStep);
		e.setText("");
	}
	
	//get numbers for text box
	
	public void finishRecipe(View view) {
		Intent i = new Intent(this, BeginCookingActivity.class);
		//should actually go to an intermediate screen which lists time and crap
		startActivity(i);
		
	}

}

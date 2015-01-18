package com.habaneros.kitchenette;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class CreateRecipeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_recipe);
	}
	
	public void toAddStep(View view) {
		Intent i = new Intent(this, AddStepActivity.class);
		startActivity(i);
	}


}

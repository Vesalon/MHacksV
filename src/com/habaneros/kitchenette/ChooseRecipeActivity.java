package com.habaneros.kitchenette;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ChooseRecipeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_recipe);
	}
	//Note that this class is for choosing a recipe from the list of recipes in
	//our list or from other users' recipes

}

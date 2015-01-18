package com.habaneros.kitchenette;
import com.microsoft.windowsazure.mobileservices.*;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ChooseRecipeTypeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_recipe_type);
		RecipeList.populate();
		ourDropdown();
	}

	//Note that this class is for choosing between our recipes or making their own recipe

	public void ourDropdown() {
		String[] spinnerArr1 = new String[RecipeList.getListSize()];
		for(int i = 0; i < RecipeList.getListSize(); i++) {
			spinnerArr1[i] = RecipeList.get(i).getName();
		}
		Spinner spinner = (Spinner) findViewById(R.id.ourDropdown);
		// Create an ArrayAdapter using the string array and a default spinner
		// layout
		 ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this,
		            android.R.layout.simple_spinner_item, spinnerArr1);
		        spinner.setAdapter(adapter);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
	}
	
//	public void userDropdown() {
//		//for now assume no DB
//	}
	
	
	public void toCreateRecipe(View view) {
        Intent intent = new Intent(this, CreateRecipeActivity.class);
        startActivity(intent);
    }	
}

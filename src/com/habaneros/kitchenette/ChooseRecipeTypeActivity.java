package com.habaneros.kitchenette;
import com.microsoft.windowsazure.mobileservices.*;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class ChooseRecipeTypeActivity extends Activity implements OnItemSelectedListener {

	Recipe recipeChoice;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_recipe_type);
		Typeface type = Typeface.createFromAsset(getAssets(),"fonts/Yesteryear-Regular.ttf");
		TextView title1 = (TextView) findViewById(R.id.chooseRecipeType);
		title1.setTypeface(type);
		TextView title2 = (TextView) findViewById(R.id.createRecipeType);
		title2.setTypeface(type);
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
		spinner.setOnItemSelectedListener(this);
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
	
	public void toBeginCooking(View view) {
		Intent intent = new Intent(this, BeginCookingActivity.class);
		intent.putExtra("com.habaneros.Kitchenette.recname", RecipeList.indexOf(recipeChoice));
        startActivity(intent);
	}
	
	
	public void toCreateRecipe(View view) {
		Intent intent = new Intent(this, CreateRecipeActivity.class);
        startActivity(intent);
    }

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int pos,
			long id) {
		// TODO Auto-generated method stub
		recipeChoice = RecipeList.get(pos);
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}	
}

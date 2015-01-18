package com.habaneros.kitchenette;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private static String name = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Typeface type = Typeface.createFromAsset(getAssets(),"fonts/Yesteryear-Regular.ttf");
		TextView title = (TextView) findViewById(R.id.main_title);
		title.setTypeface(type);
	}
	
	public void toLogin(View view) {
		if (getName().equals("")) {
			Intent i = new Intent(this, LoginActivity.class);
			startActivity(i);
		} else {
			Intent i = new Intent(this, ChooseRecipeTypeActivity.class);
			startActivity(i);
		}
	}
	
	public static void setName(String inputName) {
		name = inputName;
	}

	public static String getName() {
		return name;
	}

}

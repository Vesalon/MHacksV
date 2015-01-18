package com.habaneros.kitchenette;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		Typeface type = Typeface.createFromAsset(getAssets(),"fonts/Yesteryear-Regular.ttf");
		TextView title = (TextView) findViewById(R.id.login_welcome);
		title.setTypeface(type);
	}
	
    public void toMainScreen(View view) {
    	String nameInput = ((EditText) findViewById(R.id.usernameInput)).getText().toString();
    	if(nameInput.equals(" ")) {
    		String err = "Please enter a name!";
    		Toast.makeText(getBaseContext(), err, Toast.LENGTH_SHORT).show();
    	}
    	else {
	        MainActivity.setName(nameInput);
    		Intent intent = new Intent(this, ChooseRecipeTypeActivity.class);
	        startActivity(intent);
	        
    	}
    }	

}

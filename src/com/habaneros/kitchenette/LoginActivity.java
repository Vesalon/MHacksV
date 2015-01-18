package com.habaneros.kitchenette;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	}
	
    public void toMainScreen(View view) {
    	EditText name = (EditText) findViewById(R.id.loginButton);
    	if(name == null) {
    		String err = "Please enter a name!";
    		Toast.makeText(getBaseContext(), err, Toast.LENGTH_SHORT).show();
    	}
    	else {
    		MainActivity.name = name.toString();
	        Intent intent = new Intent(this, ChooseRecipeTypeActivity.class);
	        startActivity(intent);
	        
    	}
    }	

}
